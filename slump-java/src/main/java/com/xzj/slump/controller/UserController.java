package com.xzj.slump.controller;

import com.xzj.slump.entity.User;
import com.xzj.slump.service.UserService;
import com.xzj.slump.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
            return new Result(res.getMessage(), Result.Code.OK);
        } else {
            return new Result(res.getMessage(), Result.Code.ERROR);
        }
    }
}
