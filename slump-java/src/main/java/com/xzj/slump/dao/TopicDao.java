package com.xzj.slump.dao;

import com.xzj.slump.entity.Topic;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TopicDao {
    List getTopics(@Param("classId") String classId, @Param("first") int first, @Param("end") int end);

    int post(Topic topic);

    Topic getTopicByTopicId(@Param("topicId") String topicId);

}
