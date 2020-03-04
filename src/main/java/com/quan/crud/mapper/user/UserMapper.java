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
    public User getUserByName(@Param("name") String name);
}