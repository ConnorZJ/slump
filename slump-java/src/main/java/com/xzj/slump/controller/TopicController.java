package com.xzj.slump.controller;

import com.xzj.slump.entity.Topic;
import com.xzj.slump.service.TopicService;
import com.xzj.slump.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topic")
public class TopicController {
    @Autowired
    private TopicService topicService;

    @GetMapping("/{classId}")
    public Result getTopic(@PathVariable("classId") String classId) {
        return topicService.getTopics(classId, 0, 10);
    }

    @RequestMapping(value = "post", method = RequestMethod.POST)
    public Result post(@RequestBody Topic topic) {
        return topicService.post(topic);
    }
}
