package com.xzj.slump.dao;

import com.xzj.slump.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDao {
    //使用账户名和密码查询用户
    User queryUserByNamePass(@Param("username") String username, @Param("password") String password);

    //根据id查询用户
    User queryById(@Param("id") String id);

    //根据username查询用户
    User queryByUsername(@Param("username") String username);

    //修改个人信息
    int updateProfile(User user);

    int regist(User user);
}
