package com.xzj.slump.entity;

import lombok.Data;

@Data
public class User {
    //id
    private String id;
    //用户名
    private String username;
    //昵称
    private String nickname;
    //密码
    private String password;
    //邮箱
    private String email;
    //头像地址
    private String headUrl;
    //自我介绍
    private String introduction;
    //个性签名
    private String signature;
    //发帖数
    private int topicCount;
    //回复数
    private int replyCount;
    //精品贴数
    private int bestTopicCount;
    //是否为管理员
    private boolean mnger;
}
