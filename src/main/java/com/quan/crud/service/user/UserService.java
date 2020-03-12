package com.quan.crud.service.user;

import com.quan.crud.entity.User;
import com.quan.crud.util.JsonWrite;

import javax.servlet.http.HttpSession;

public interface UserService {
    //更具用户名查询用户信息
    JsonWrite getUserByName(User user, HttpSession session);
//    新增用户
    JsonWrite addUser(User user);
//    删除用户
    JsonWrite deleteUser(int id);
//    修改用户信息
    JsonWrite updateUser(User user);
}
