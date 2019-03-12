package com.xzj.slump.controller;

import com.xzj.slump.entity.Test;
import com.xzj.slump.service.TestService;
import com.xzj.slump.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    @Autowired
    private TestService testService;

    @RequestMapping("/hello")
    public Result getHello() {
        Result<Test> res = testService.getName(1);
        if(res.getCode()==200)
            return res;
        else
            return res;
    }

}
