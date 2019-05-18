package com.xzj.slump.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Topic {
    private String id;
    private String classId;
    private String title;
    private String body;
    private String createBy;
    private Date createTime;
    private String replyBy;
    private Date replyTime;
    private int hits;
    private int replyCount;
    private boolean enabled;
    private String imgUrl;
    private boolean closed;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getCreateTime() {
        return this.createTime;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getReplyTime() {
        return this.replyTime;
    }
}
