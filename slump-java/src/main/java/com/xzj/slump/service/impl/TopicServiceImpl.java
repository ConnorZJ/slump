package com.xzj.slump.service.impl;

import com.xzj.slump.dao.ReplyDao;
import com.xzj.slump.dao.TopicDao;
import com.xzj.slump.entity.Reply;
import com.xzj.slump.entity.Topic;
import com.xzj.slump.service.TopicService;
import com.xzj.slump.util.MyUtils;
import com.xzj.slump.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicDao topicDao;

    @Autowired
    private ReplyDao replyDao;

    @Override
    public Result getTopics(String classId, int first, int end) {
        List topics = topicDao.getTopics(classId, first, end);
        System.out.println(topics);
        if (topics == null) {
            return new Result(topics, "error", Result.Code.ERROR);
        } else if (topics.isEmpty()) {
            return new Result(topics, "ok", Result.Code.OK_EMPTY);
        } else {
            return new Result(topics, "ok", Result.Code.OK);
        }

    }

    @Override
    public Result post(Topic topic) {
        topic.setId(MyUtils.getUUID());
        int post = topicDao.post(topic);
        Reply reply = new Reply();
        reply.setId(MyUtils.getUUID());
        reply.setTopicId(topic.getId());
        reply.setBody(topic.getBody());
        reply.setUsername(topic.getCreateBy());
        int i = replyDao.replyComment(reply);
        if (post != 0 && i != 0) {
            Topic getTopic = topicDao.getTopicByTopicId(topic.getId());
            return new Result(getTopic, "ok", Result.Code.OK);
        } else {
            return new Result("error", Result.Code.ERROR);
        }
    }
}
