package com.xzj.slump.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Reply {
    // id标识
    private String id;
    // 帖子id
    private String topicId;
    // 回复内容
    private String body;
    // 回复者id
    private String username;
    // 最后修改时间
    private Date lastModified;
    // 回复时间
    private Date createTime;
    // 楼层数
    private int rank;
    //是否删除
    private boolean delete;
    // 是否有回复
    private boolean havaReply;
    // 父id
    private String parentId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getCreateTime() {
        return createTime;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getLastModified() {
        return lastModified;
    }
}
