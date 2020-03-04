package com.study.controller;

import com.study.bean.Hr;
import com.study.bean.MsgContent;
import com.study.bean.RespBean;
import com.study.bean.SysMsg;
import com.study.service.HrService;
import com.study.service.SysMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    SysMsgService sysMsgService;
    @Autowired
    HrService hrService;

    @RequestMapping(value = "/sysmsgs", method = RequestMethod.GET)
    public List<SysMsg> getSysMsgs(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam( value = "size", defaultValue = "10") Integer size){
        return sysMsgService.getSysMsgByPage(page, size);
    }

    @RequestMapping(value = "/markread", method = RequestMethod.PUT)
    public RespBean markRead(Long flag) {
        if (sysMsgService.markRead(flag)) {
            if (flag == -1) {
                return RespBean.ok("mutiple");
            }else{
                return RespBean.ok("single");
            }
        }else{
            if (flag == -1) {
                return RespBean.ok("mutiple");
            }else{
                return RespBean.ok("single");
            }
        }
    }

    @RequestMapping(value = "/hrs", method=RequestMethod.GET)
    public List<Hr> getAllHr() { return hrService.getAllHrExceptAdmin(); }

    @RequestMapping(value = "/nf", method=RequestMethod.POST)
    public RespBean sendNF(MsgContent msg){
        if(sysMsgService.sendMsg(msg))
            return RespBean.ok("send successfully");
        else return RespBean.error("send faliure");
    }



}

