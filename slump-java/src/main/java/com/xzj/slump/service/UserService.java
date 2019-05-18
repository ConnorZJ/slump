package com.xzj.slump.service;

import com.xzj.slump.entity.User;
import com.xzj.slump.util.Result;

public interface UserService {
    //使用账号+密码登录
    Result<User> login(User user);

    //根据用户id查询用户
    Result<User> getUserById(String id);

    //根据username查询用户
    Result<User> queryByUsername(String username);

    //修改个人信息
    Result<User> updateProfile(User user);

    Result regist(User user);
}
