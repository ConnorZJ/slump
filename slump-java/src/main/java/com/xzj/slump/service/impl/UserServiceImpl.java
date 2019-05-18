package com.xzj.slump.service.impl;

import com.xzj.slump.dao.UserDao;
import com.xzj.slump.entity.User;
import com.xzj.slump.service.UserService;
import com.xzj.slump.util.MyUtils;
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

    @Override
    public Result<User> getUserById(String id) {
        User user = userDao.queryById(id);
        if(user!=null){
            return new Result<User>(user,"OK", Result.Code.OK);
        }else {
            return new Result<>(user,"查无此人",Result.Code.OK_EMPTY);
        }
    }

    @Override
    public Result<User> queryByUsername(String username) {
        User user = userDao.queryByUsername(username);
        if(user!=null){
            return new Result<User>(user,"OK", Result.Code.OK);
        }else {
            return new Result<>(user,"查无此人",Result.Code.OK_EMPTY);
        }
    }

    @Override
    public Result<User> updateProfile(User user) {
        int update = userDao.updateProfile(user);
        System.out.println("service----" +user);
        if(update==0){
            return new Result("修改失败", Result.Code.ERROR);
        }
        System.out.println("update Success");
        User updatedUser = userDao.queryById(user.getId());
        return new Result<>(updatedUser,"OK", Result.Code.OK);
    }

    @Override
    public Result regist(User user) {
        User user1 = userDao.queryByUsername(user.getUsername());
        if(user1!=null){
            return new Result("用户已存在", Result.Code.OK_EXIST);
        }
        user.setId(MyUtils.getUUID());
        int regist = userDao.regist(user);
        if(regist!=0){
            return new Result("ok", Result.Code.OK);
        }
        return new Result("error", Result.Code.ERROR);
    }
}
