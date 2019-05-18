package com.xzj.slump.service.impl;

import com.xzj.slump.dao.ReplyDao;
import com.xzj.slump.entity.Reply;
import com.xzj.slump.service.ReplyService;
import com.xzj.slump.util.MyUtils;
import com.xzj.slump.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService {
    @Autowired
    private ReplyDao replyDao;

    @Override
    public Result getReplyByTopicId(String topicId) {
        List replys = replyDao.getReplyByTopicId(topicId);
        Result res = null;
        if (replys == null) {
            return res.error(replys, "error");
        } else if (replys.isEmpty()) {
            return res.okEmpty(replys);
        } else {
            return res.ok(replys);
        }
    }

    @Override
    public Result replyComment(Reply reply) {
        reply.setId(MyUtils.getUUID());
        System.out.println("replyService -- " + reply);
        int i = replyDao.replyComment(reply);
        if (i != 0) {
            return getReplyByTopicId(reply.getTopicId());
        } else {
            return new Result("error", Result.Code.ERROR);
        }
    }

    @Override
    public Result deleteReply(String replyId) {
        int i = replyDao.deleteReply(replyId);
        if (i != 0) {
            return new Result("ok", Result.Code.DELETE);
        } else {
            return new Result("error", Result.Code.ERROR);
        }
    }
}
