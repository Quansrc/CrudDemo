package com.quan.crud.service.user.impl;

import com.quan.crud.entity.User;
import com.quan.crud.mapper.user.UserMapper;
import com.quan.crud.service.user.UserService;
import com.quan.crud.util.JsonWrite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public JsonWrite getUserByName(User user, HttpSession session) {
        //获取验证码
        String vercode = (String) session.getAttribute("vcode");
        User dbuser = userMapper.getUserByName(user.getName());
        if (vercode!=session.getAttribute("vcode")){
            return JsonWrite.FAILED("验证码错误，请重新输入！");
        }
        if (dbuser!=null){
            if (dbuser.getPassword().equals(user.getPassword())){
                return JsonWrite.SUCCESS("登陆成功！");
            }else {
                return JsonWrite.FAILED("密码错误，请重新输入！");
            }
        }else{
            return JsonWrite.FAILED("用户名错误或该用户不存在！");
        }

    }
}
