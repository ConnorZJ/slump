package com.xzj.slump.dao;

import com.xzj.slump.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDao {
    //使用账户名和密码查询用户
    User queryUserByNamePass(@Param("username") String username, @Param("password") String password);
}
