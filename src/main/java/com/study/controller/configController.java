package com.study.controller;

import com.study.bean.Hr;
import com.study.bean.Menu;
import com.study.common.HrUtils;
import com.study.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/config")
public class configController {

    @Autowired
    MenuService menuService;

    @RequestMapping("/sysmenu")
    public List<Menu> sysmenu(){
        return menuService.getMenusByHrId();
    }

    @RequestMapping("/hr")
    public Hr currentUser(){
        return HrUtils.getCurrentHr();
    }
}
