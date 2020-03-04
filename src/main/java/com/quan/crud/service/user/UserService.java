package com.quan.crud.service.user;

import com.quan.crud.entity.User;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public interface UserService {
    //更具用户名查询用户信息
    public String getUserByName(User user, HttpSession session);
}
