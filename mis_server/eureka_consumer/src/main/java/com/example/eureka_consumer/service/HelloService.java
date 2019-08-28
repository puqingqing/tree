package com.example.eureka_consumer.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/*feign的负载均衡 cloud-client是微服务的应用名称*/
@FeignClient("cloud-client")
public interface HelloService {

    /*需要映射的方法是那个*/
    @RequestMapping("/hello/{fallback}")
    public String hello(@PathVariable("fallback") String fallback);

}
