package com.xzj.slump.service;

import com.xzj.slump.entity.Test;
import com.xzj.slump.util.Result;
import org.springframework.stereotype.Service;

@Service
public interface TestService {

    Result<Test> getName(int id);

}
