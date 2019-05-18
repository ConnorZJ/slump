package com.xzj.slump.controller;

import com.xzj.slump.entity.Clazz;
import com.xzj.slump.service.ClassService;
import com.xzj.slump.util.Result;
import org.apache.ibatis.type.JdbcType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/class")
public class ClassController {

    @Autowired
    private ClassService classService;

    @RequestMapping(value="/get",method= RequestMethod.GET)
    public Result getClasses(){
        Result<Clazz> classes = classService.getClasses();
        return classes;
    }

}
