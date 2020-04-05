package com.quan.crud.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : xiaoquan
 * create at:  2020/4/5  1:22 上午
 * @description: direct
 */

@Configuration
public class DirectRabbitMqConfig {
    //点对点
    //队列 起名：TestDirectQueue
    @Bean
    public Queue TestDirectQueue() {
        return new Queue("quan", true);  //true 是否持久
    }

    //Direct交换机 起名：TestDirectExchange
    @Bean
    DirectExchange TestDirectExchange() {
        return new DirectExchange("quan");
    }

    //绑定  将队列和交换机绑定, 并设置用于匹配键：TestDirectRouting
    @Bean
    Binding bindingDirect() {
        return BindingBuilder.bind(TestDirectQueue()).to(TestDirectExchange()).with("quan");
    }

    //    -------------------------
//    广播
    @Bean
    public Queue fanoutQuene() {
        return new Queue("quan.fanout", true);
    }

    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("quan.fanout");
    }

    @Bean
    Binding bindingFanoutA() {
        return BindingBuilder.bind(fanoutQuene()).to(fanoutExchange());
    }
    @Bean
    Binding bindingFanoutB() {
        return BindingBuilder.bind(TestDirectQueue()).to(fanoutExchange());
    }
}