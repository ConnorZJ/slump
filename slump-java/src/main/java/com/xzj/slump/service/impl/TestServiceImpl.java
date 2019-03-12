package com.xzj.slump.service.impl;

import com.xzj.slump.dao.TestDao;
import com.xzj.slump.entity.Test;
import com.xzj.slump.service.TestService;
import com.xzj.slump.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDao testMapper;

    @Override
    public Result<Test> getName(int id) {
        Test tester = testMapper.getName(id);
        if(tester == null){
            return Result.error(tester,"查无此人");
        }
        return Result.ok(tester);
    }
}
