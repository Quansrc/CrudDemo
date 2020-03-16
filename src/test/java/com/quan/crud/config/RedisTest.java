package com.quan.crud.config;

import cn.hutool.core.util.PageUtil;
import com.quan.crud.entity.User;
import com.quan.crud.mapper.user.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.List;

@SpringBootTest
public class RedisTest {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private UserMapper userMapper;

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

    @Test
    public void test1(){
        int limit = 4;
        int[] startEnd = PageUtil.transToStartEnd(2, limit);//[0, 10]
        List<User> models = userMapper.getAllUserPage(startEnd[0], limit, null);
        System.out.println(startEnd[0]+"-------"+ startEnd[1]);
        System.out.println(models.toArray());
    }
}
