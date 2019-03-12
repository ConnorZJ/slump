package com.xzj.slump.service;

import com.xzj.slump.entity.User;
import com.xzj.slump.util.Result;

public interface UserService {
    //使用账号+密码登录
    Result<User> login(User user);
}
