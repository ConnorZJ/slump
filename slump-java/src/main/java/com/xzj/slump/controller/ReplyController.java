package com.xzj.slump.controller;

import com.xzj.slump.entity.Reply;
import com.xzj.slump.service.ReplyService;
import com.xzj.slump.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reply")
public class ReplyController {
    @Autowired
    private ReplyService replyService;

    @GetMapping("/{topicId}")
    public Result getReply(@PathVariable("topicId") String topicId) {
        return replyService.getReplyByTopicId(topicId);
    }

    @RequestMapping(value = "comment", method = RequestMethod.POST)
    public Result replyComment(@RequestBody Reply reply) {
        System.out.println("replyController -- " + reply);
        Result result = replyService.replyComment(reply);
        return result;
    }

    @DeleteMapping("/{replyId}")
    public Result deleteReply(@PathVariable("replyId") String replyId) {
        System.out.println("controller---" + replyId);
        Result result = replyService.deleteReply(replyId);
        System.out.println(result);
        return result;
    }
}
