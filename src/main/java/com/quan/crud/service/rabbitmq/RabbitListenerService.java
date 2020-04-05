package com.quan.crud.service.rabbitmq;

import com.quan.crud.entity.User;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author : xiaoquan
 * create at:  2020/4/5  1:55 下午
 * @description: RabbitListener
 */
@Service
public class RabbitListenerService {

    @RabbitListener(queues = "quan")
    public void receive(User user){
        System.out.println(user.toString());
        System.out.println("收到消息");
    }

    //接收消体
    @RabbitListener(queues = "quan.fanout")
    public void receive02(Message message){
        System.out.println(message.getBody());
        System.out.println(message.getMessageProperties());
    }

}