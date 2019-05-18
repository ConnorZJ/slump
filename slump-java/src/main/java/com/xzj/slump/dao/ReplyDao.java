package com.xzj.slump.dao;

import com.xzj.slump.entity.Reply;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReplyDao {
    List getReplyByTopicId(@Param("topicId") String topicId);

    int replyComment(Reply reply);

    int deleteReply(@Param("replyId") String replyId);
}
