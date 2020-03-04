package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegLoginController {

    @RequestMapping("/login_p")
    public String login(){
        return "redirect:index.html";
    }
}
