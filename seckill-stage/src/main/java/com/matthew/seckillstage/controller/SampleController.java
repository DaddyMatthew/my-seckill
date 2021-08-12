package com.matthew.seckillstage.controller;

import com.matthew.seckillstage.common.redis.KPUser;
import com.matthew.seckillstage.common.redis.RedisService;
import com.matthew.seckillstage.entities.dto.OrderEntity;
import com.matthew.seckillstage.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/demo")
public class SampleController {

    @Autowired
    private IOrderService orderService;
    @Autowired
    private RedisService redisService;

    @RequestMapping("/thymeleaf")
    public String thymeleaf(Model model) {
        model.addAttribute("name", "matthew");
        return "hello";
    }

    @RequestMapping("/doGet")
    @ResponseBody
    public OrderEntity doGet(Model model) {
        OrderEntity order = orderService.queryOrder(1);
        return order;
    }

    @RequestMapping("/doAdd")
    @ResponseBody
    public OrderEntity doAdd() {
        orderService.addOrder(null);
        return null;
    }

    @RequestMapping("/doRedisSet")
    public String doRedisSet(Model model) {
        boolean value = redisService.set("key_1", "value_1");
        model.addAttribute("name", value);
        return "hello";
    }

    @RequestMapping("/doRedisGet")
    public String doRedisGet(Model model) {
        String value = redisService.get("key_1", String.class);
        model.addAttribute("name", value);
        return "hello";
    }

    @RequestMapping("/doRedisSetByPrefix")
    @ResponseBody
    public String doRedisSetByPrefix() {
        OrderEntity order = orderService.queryOrder(1);
        redisService.set(KPUser.getById, order.getId() + "", order);
        return "success";
    }
}
