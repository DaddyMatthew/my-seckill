package com.matthew.seckillstage.controller;

import com.matthew.seckillstage.common.Result;
import com.matthew.seckillstage.entities.vo.LoginVo;
import com.matthew.seckillstage.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@RequestMapping("/login")
@Slf4j
public class LoginController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/to_login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/do_login")
    @ResponseBody
    public Result<String> login(HttpServletResponse response, @Valid LoginVo loginVo) {
        log.info("### login info: {}", loginVo);
        String token = userService.login(response, loginVo);
        return Result.success(token);
    }
}
