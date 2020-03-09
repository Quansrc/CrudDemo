package com.quan.crud.service.user;

import com.quan.crud.entity.User;
import com.quan.crud.util.JsonWrite;

import javax.servlet.http.HttpSession;

public interface UserService {
    //更具用户名查询用户信息
    public JsonWrite getUserByName(User user, HttpSession session);
}
