package com.quan.crud.service.user.impl;

import cn.hutool.core.util.PageUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.quan.crud.dto.LayuiPageResult;
import com.quan.crud.dto.PageHelper;
import com.quan.crud.entity.User;
import com.quan.crud.mapper.user.UserMapper;
import com.quan.crud.service.user.UserService;
import com.quan.crud.util.JsonWrite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public JsonWrite getUserByName(User user, HttpSession session) {
        //获取验证码
        String vercode = (String) session.getAttribute("vcode");
        User dbuser = userMapper.getUserByName(user.getName());
        if (vercode != session.getAttribute("vcode")) {
            return JsonWrite.FAILED("验证码错误，请重新输入！");
        }
        if (dbuser != null) {
            /*
            Hutools
            MD5加密
            String md5Hex1 = DigestUtil.md5Hex(testStr);
            //Junit单元测试
            //Assert.assertEquals("5393554e94bf0eb6436f240a4fd71282", md5Hex1);
             */
            if (dbuser.getPassword().equals(DigestUtil.md5Hex(user.getPassword()))) {
                session.setAttribute("user",dbuser);
                return JsonWrite.SUCCESS("登陆成功！");
            } else {
                return JsonWrite.FAILED("密码错误，请重新输入！");
            }
        } else {
            return JsonWrite.FAILED("用户名错误或该用户不存在！");
        }

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public JsonWrite addUser(User user) {
        System.out.println(user.toString());
        user.setPassword(DigestUtil.md5Hex(user.getPassword()));
        System.out.println(user.toString());
        userMapper.addUser(user);
        return JsonWrite.SUCCESS("创建成功！");
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public JsonWrite deleteUser(int id) {
        userMapper.deleteUserById(id);
        return JsonWrite.SUCCESS("删除成功！");
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public JsonWrite updateUser(User user) {
        userMapper.updateUser(user);
        return JsonWrite.SUCCESS("修改成功！");
    }

    @Override
    public LayuiPageResult getAllUserPage(PageHelper pageHelper) {
        int[] startEnd = PageUtil.transToStartEnd(pageHelper.getPage(), pageHelper.getLimit());//[0, 10]
        List<User> models = userMapper.getAllUserPage(startEnd[0], pageHelper.getLimit(), null);
        int total = userMapper.selectUserCount();
        LayuiPageResult layuiPageResult = new LayuiPageResult(0, "查询成功", total, models);
        return layuiPageResult;
    }
}
