package com.example.provider.controller;

import com.example.provider.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class consumer {

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void consumerMessage(String message){
        System.out.println("处理的消息是"+message);
    }
}
