package com.matthew.seckillstage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserLoginController {

    @RequestMapping("/login")
    public String loginPage() {
        return "login";
    }

    @RequestMapping("/do_login")
    public String login() {
        return "login";
    }
}
