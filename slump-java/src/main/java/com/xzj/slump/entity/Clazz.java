package com.xzj.slump.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Clazz {
    // id标识
    private String id;
    // 版块名
    private String name;
    // 版块介绍
    private String intro;
    // 版块版规
    private String rule;
    // 帖子数
    private int topicCount;
    // 回复数
    private int replyCount;
    // 最后回复者id
    private String lastTopicId;
    // 地址链接
    private String url;
    // 版块主题图片地址
    private String imgUrl;
    // 是否启用
    private boolean enabled;
    // 创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    // 创建者
    private String createBy;
}
