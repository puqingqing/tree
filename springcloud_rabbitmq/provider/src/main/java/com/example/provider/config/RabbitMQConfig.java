package com.example.provider.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public final static String QUEUE_NAME = "springCloud-queue";   //消息队列的名称
    public final static String EXCHANGE_NAME = "springCloud-exchange";  //交换机的名称
    public final static String ROUTING_KEY = "springCloud-key";     //路由的key(相当于是那个接口)

    //创建队列

    @Bean
    public Queue queue(){
        return  new Queue(QUEUE_NAME);
    }

    //创建一个topic类型的交换机
    @Bean
    public TopicExchange topicExchange(){
        return  new TopicExchange(EXCHANGE_NAME);
    }

    //使用路由的key将queue绑定到exchange交换机上(相当于这个消息队列只能在这个交换机上进行输出，并且在指定的端口中进行)
    @Bean
    public Binding binding(Queue queue,TopicExchange topicExchange){

        return BindingBuilder.bind(queue).to(topicExchange).with(ROUTING_KEY);
    }

    //与队列的服务器建立连接
    @Bean
    public ConnectionFactory connectionFactory(){
        CachingConnectionFactory connectionFactory=new CachingConnectionFactory(5672);
        connectionFactory.setUsername("pqq");
        connectionFactory.setPassword("123456");
        return connectionFactory;
    }

    //创建rabbitTemplate的实列
    @Bean
   public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory){
        return  new RabbitTemplate(connectionFactory);
   }



}
