package com.quan.crud.config;

import com.quan.crud.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
public class RedisTest {
    @Autowired
    private RedisTemplate redisTemplate;


    @Test
    public void redisTest(){
        User user =new User();
        user.setName("Quan");
        user.setPassword("123");
        ValueOperations<String,User> valueOperations = redisTemplate.opsForValue();
        valueOperations.set("user",user);
        Boolean exits = redisTemplate.hasKey("user");
        System.out.println(exits);
        User getUser = (User) redisTemplate.opsForValue().get("user");
        System.out.println(getUser.toString());
    }
}
