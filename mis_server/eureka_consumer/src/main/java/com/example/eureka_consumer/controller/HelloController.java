package com.example.eureka_consumer.controller;

import com.example.eureka_consumer.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*feign 相对与ribbon的好处在与，它让用户感受不到你是在请求另一个微服务的方法
*
* ribbon:是可以直观的看到你是通过Http在请求另一个服务的方法
*  1、首先需要在main的类中添加：
*   @Bean
    @LoadBalanced //客户端负载均衡
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    2、在controller中使用
    @Autowired
    private RestTemplate restTemplate;
    ResponseEntity<User> responseEntity = restTemplate.exchange("http://microapp:8088/user", HttpMethod.POST, requestEntity,User.class );
* */

@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    /*进行自己的service层方法的调用*/
    @RequestMapping("/test/{fallback}")
    public String hello(@PathVariable("fallback") String fallback){
        String res=helloService.hello(fallback);
        return "调用服务结果为"+res;
    }
}
