package com.xzj.slump.service.impl;

import com.xzj.slump.dao.UserDao;
import com.xzj.slump.entity.User;
import com.xzj.slump.service.UserService;
import com.xzj.slump.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Result<User> login(User user) {
        User resUser = userDao.queryUserByNamePass(user.getUsername(),user.getPassword());
        if(resUser!= null)
            return new Result<User>(resUser,"ok", Result.Code.OK);
        else
            return new Result<>(resUser,"账号或密码错误", Result.Code.ERROR);
    }
}
