package com.xzj.slump.service;

import com.xzj.slump.entity.Topic;
import com.xzj.slump.util.Result;

public interface TopicService {
    Result getTopics(String classId,int first,int end);
    Result post(Topic topic);
}
