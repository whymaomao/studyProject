package com.study.service;

import com.study.bean.Hr;
import com.study.bean.MsgContent;
import com.study.bean.SysMsg;
import com.study.common.HrUtils;
import com.study.mapper.SysMsgMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SysMsgService {

    @Autowired
    SysMsgMapper sysMsgMapper;
    @Autowired
    HrService hrService;

    public List<SysMsg> getSysMsgByPage(int page, int size){
        int start = (page - 1)*size;
        return sysMsgMapper.getSysMsgByPage(start, size, HrUtils.getCurrentHr().getId());
    }

    public boolean markRead(Long flag) {
        if(flag != -1) {
            return sysMsgMapper.markRead(flag, HrUtils.getCurrentHr().getId()) == 1;
        }
        sysMsgMapper.markRead(flag, HrUtils.getCurrentHr().getId());
        return true;
    }

    public boolean sendMsg(MsgContent msg){
        sysMsgMapper.sendMsg(msg);
        List<Hr> allHr = hrService.getAllHr();
        int result = sysMsgMapper.addMsg2AllHr(allHr, msg.getId());
        return result == allHr.size();
    }
}
