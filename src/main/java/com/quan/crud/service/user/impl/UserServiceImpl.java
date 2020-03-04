package com.quan.crud.service.user.impl;

import com.quan.crud.entity.User;
import com.quan.crud.mapper.user.UserMapper;
import com.quan.crud.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public String getUserByName(User user, HttpSession session) {
        //获取验证码
        String vercode = (String) session.getAttribute("vcode");
        User dbuser = userMapper.getUserByName(user.getName());
        if (dbuser!=null ){
            if(dbuser.getPassword()==user.getPassword()){

            }else{
                return "密码错误！";
            }
        }else{
            return "用户不存在！";
        }
        return "登陆成功!";
    }
}
