package com.example.provider.controller;

import com.example.provider.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class proderController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping("/send")
    public String sendMessage(){
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                LocalDateTime time = LocalDateTime.now();
                System.out.println("send message: " + time.toString());
                rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.ROUTING_KEY, time.toString());
            }
        }).start();

        return  "ok";
    }
}
