package com.xzj.slump.service.impl;

import com.xzj.slump.dao.ClassDao;
import com.xzj.slump.entity.Clazz;
import com.xzj.slump.service.ClassService;
import com.xzj.slump.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    private ClassDao classDao;

    @Override
    public Result<Clazz> getClasses() {
        List<Clazz> res = classDao.getClasses();
        if(res!=null){
            return new Result(res,"ok", Result.Code.OK);
        } else
            return new Result(res,"error", Result.Code.ERROR);
    }
}
