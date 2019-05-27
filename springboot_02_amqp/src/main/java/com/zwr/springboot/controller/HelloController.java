package com.zwr.springboot.controller;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    AmqpAdmin amqpAdmin;


    @ResponseBody
    @GetMapping("/hello")
    public String hello() {
        for (int i = 0; i < 10; i++) {
            //对象被默认序列化以后发送出去
            rabbitTemplate.convertAndSend("amqpadmin.exchanges", "zwr", i+"");
        }
        return "发送了信息";
    }
}
