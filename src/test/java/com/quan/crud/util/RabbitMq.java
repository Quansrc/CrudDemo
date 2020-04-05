package com.quan.crud.util;

import com.quan.crud.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author : xiaoquan
 * create at:  2020/4/5  1:07 上午
 * @description: 消息队列amqp
 */

@SpringBootTest
public class RabbitMq {

    @Autowired
    RabbitTemplate rabbitTemplate;  //使用RabbitTemplate,这提供了接收/发送等等方法

//    点对点传播
    @Test
    public void sendDirectMsg(){
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "test message, hello!";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String,Object> map=new HashMap<>();
        map.put("messageId",messageId);
        map.put("messageData",messageData);
        map.put("createTime",createTime);
        //将消息携带绑定键值：TestDirectRouting 发送到交换机TestDirectExchange
        //对象被默认序列化以后发送出去
        rabbitTemplate.convertAndSend("quan", "quan", new User());

    }

    //接收数据
    @Test
    public void receive(){
        Object o = rabbitTemplate.receive("quan");
        System.out.println(o.getClass());
        System.out.println(o);
    }

    //广播
    @Test
    public void fanout(){
        rabbitTemplate.convertAndSend("quan.fanout","",new User());
    }

    @Test
    public void receiveFanout(){
        Object o =rabbitTemplate.receive("quan.fanout");
        System.out.println(o.getClass());
        System.out.println(o);
    }

}