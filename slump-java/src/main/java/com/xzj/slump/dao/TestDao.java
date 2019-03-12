package com.xzj.slump.dao;

import com.xzj.slump.entity.Test;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TestDao {

    Test getName(int id);

}
