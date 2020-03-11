package com.quan.crud.mapper.user;

import com.quan.crud.entity.User;
import com.quan.crud.mapper.MyBatisBaseDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


/**
 * UserMapper继承基类
 */
@Repository
public interface UserMapper extends MyBatisBaseDao<User, Integer> {
    //根据名称查询用户信息
    User getUserByName(@Param("name") String name);
    //新增用户
    int addUser(@Param("user") User user);
}