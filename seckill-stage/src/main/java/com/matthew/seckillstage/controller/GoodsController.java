package com.matthew.seckillstage.controller;

import com.matthew.seckillstage.entities.dto.UserEntity;
import com.matthew.seckillstage.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/goods")
@Slf4j
public class GoodsController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/to_list")
//    @ResponseBody
    public String list(Model model, UserEntity user) {

        return "goods_list";
    }
}
