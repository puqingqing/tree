package com.example.eureka_client1.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    /*web的映射路径*/
    @RequestMapping("/hello/{fallback}")
    /*熔断器的命令，当该方法失败后或抛异常的时候，调用那个方法*/
    @HystrixCommand(fallbackMethod="error") /*调用方式失败后调用helloFallbackMethod*/
    public String hello(@PathVariable("fallback") String fallback){
        if("1".equals(fallback)){
            throw new RuntimeException("...");
        }
        return "hello";
}

    public String error(){
        return "服务器异常";
    }


    @RequestMapping("/user")
    @HystrixCommand(fallbackMethod = "error")
    public String  get(){

        return "恭喜您微服务搭建成功";
    }

    @RequestMapping("/dream")
    @HystrixCommand(fallbackMethod = "error")
    public String dream(){
         double i= 1/0;
         return "恭喜您成功了1";
    }

}
