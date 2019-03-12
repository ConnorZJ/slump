package com.xzj.slump.dao;

import com.xzj.slump.entity.Clazz;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassDao {
    List<Clazz> getClasses();
}
