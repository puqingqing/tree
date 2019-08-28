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
    @HystrixCommand(fallbackMethod="helloFallbackMethod") /*调用方式失败后调用helloFallbackMethod*/
    public String hello(@PathVariable("fallback") String fallback){
        if("1".equals(fallback)){
            throw new RuntimeException("...");
        }
        return "hello";
}

    public String helloFallbackMethod(String fallback){
        return "熔断器：fallback 参数值为:"+fallback;
    }

}
