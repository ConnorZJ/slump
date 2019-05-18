package com.xzj.slump.service;

import com.xzj.slump.entity.Reply;
import com.xzj.slump.util.Result;

public interface ReplyService {
    Result getReplyByTopicId(String topicId);

    Result replyComment(Reply reply);

    Result deleteReply(String replyId);
}
