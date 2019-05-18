package com.xzj.slump.controller;

import com.xzj.slump.entity.User;
import com.xzj.slump.service.UserService;
import com.xzj.slump.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //使用账号密码登录
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(@RequestBody User user) {
        System.out.println(user);
        Result<User> res = userService.login(user);
        if (res.getCode() == 200) {
            return new Result(res.getData(), res.getMessage(), Result.Code.OK);
        } else {
            return new Result(res.getMessage(), Result.Code.ERROR);
        }
    }

    //修改个人信息
    @RequestMapping(value = "/updateProfile", method = RequestMethod.POST)
    public Result updateProfile(@RequestBody User user) {
        System.out.println(user);
        Result<User> res = userService.updateProfile(user);
        System.out.println("updateProfile -- " + res);
        if (res.getCode() == 200) {
            return new Result(res.getData(), res.getMessage(), Result.Code.OK);
        } else {
            return new Result(res.getMessage(), Result.Code.ERROR);
        }
    }

    //使用id查询用户
    @GetMapping("id/{userId}")
    public Result getUserById(@PathVariable("userId") String userId) {
        Result<User> user = userService.getUserById(userId);
        return user;
    }

    //使用username查询用户
    @GetMapping("username/{username}")
    public Result getUserByUsername(@PathVariable("username") String username) {
        Result<User> user = userService.queryByUsername(username);
        return user;
    }

    @RequestMapping(value = "signup", method = RequestMethod.POST)
    public Result regist(@RequestBody User user) {
        return userService.regist(user);
    }
}
