<template>
  <div class="reply-content">
    <h2 class="topic-title">{{topic.title}}</h2>
    <div class="comment-box">
      <div v-for="reply in replys" :key="reply.id" class="comment">
        <router-link :to="{path:'/profile',query:{username:reply.username}}">
          <img style="width:120px;height:120px" src="/static/clazz/java.jpg" class="image">
        </router-link>
        <div class="info">
          <router-link
            class="user-id"
            :to="{path:'/profile',query:{username:reply.username}}"
          >{{reply.username}}</router-link>
          <div class="time">
            <span>{{reply.lastModified}}</span>
            <span style="marginLeft:8px;">#{{reply.rank}}</span>
          </div>
          <div v-if="currentUser.mnger==true" class="delete-btn">
            <a href="javascript:;" @click="deleteComment(reply.id)">删除</a>
          </div>
          <div class="content">{{reply.body}}</div>
        </div>
        <div></div>
      </div>
    </div>
    <div class="topic-reply">
      <div v-if="currentUser">
        <div class="current-user">
          <router-link :to="{path:'/profile',query:{id:currentUser.id}}">
            <img style="width:80px;height:80px" src="/static/clazz/java.jpg" class="image">
          </router-link>
        </div>
        <div class="user-comment">
          <el-input
            style="width:1100px"
            class="replyText"
            type="textarea"
            :rows="3"
            placeholder="此处输入评论"
            v-model="replyText"
          ></el-input>
        </div>
        <div style="marginTop:10px;">
          <el-button ref="comment" type="primary" @click="comment()">评论</el-button>
        </div>
      </div>
      <div v-else>
        <router-link to="/login">当前未登录，点此登录</router-link>
      </div>
    </div>
  </div>
</template>
<script>
import axios from "axios";
export default {
  name: "topic",
  data() {
    return {
      topicId: null,
      replys: [],
      topic: this.topic,
      replyText: "",
      currentUser: undefined
    };
  },
  created() {
    this.topic = this.$route.query.topic;
    this.topicId = this.topic.id;
    this.currentUser = JSON.parse(localStorage.getItem("userInfo"));
  },
  mounted() {
    this.getReplys();
  },
  methods: {
    successAlert() {
      this.$message({
        message: "评论成功",
        type: "success",
        center: true
      });
    },
    deleteAlert() {
      this.$message({
        message: "删除成功",
        type: "success",
        center: true
      });
    },
    getTopic() {
      axios.get();
    },
    getReplys() {
      axios.get(`/api/reply/${this.topicId}`).then(res => {
        this.replys = res.data.data;
        console.log(this.replys);
      });
    },
    comment() {
      let comment = this.replyText;
      axios
        .post(`/api/reply/comment`, {
          topicId: this.topicId,
          body: comment,
          username: this.currentUser.username
        })
        .then(res => {
          this.getReplys();
          this.successAlert();
        });
      this.replyText = "";
    },
    deleteComment(replyId) {
      console.log(123);
      axios.delete(`/api/reply/${replyId}`).then(res => {
        if (res.data.code == "204") {
          this.getReplys();
          this.deleteAlert();
        }
      });
    }
  }
};
</script>
<style>
.time1 {
  text-align: center;
  align-self: center;
  padding-right: 20px;
}
.comment-box {
  border: 1px solid #e0e0e0;
  width: 1200px;
  margin: 0 auto;
}
.content {
  width: 1000px;
  word-wrap: break-word;
  word-break: break-all;
  overflow: hidden;
  text-align: left;
  margin-top: 30px;
}
.reply-content {
  width: 1200px;
  margin: 0 auto;
}
.comment {
  display: flex;
  flex-direction: row;
  border-bottom: 1px solid #e0e0e0;
  padding: 20px;
  justify-content: space-between;
}
.comment > .info {
  padding: 0 20px;
}
.user-id {
  float: left;
  text-decoration: none;
  color: black;
  font-weight: bold;
}
.user-id:hover {
  color: #4183c4;
}
.time {
  color: rgb(153, 153, 153);
  font-size: 14px;
  float: left;
  margin-left: 16px;
}
.replyText {
  width: 1200px;
}
.topic-title {
}
.topic-reply {
  margin-top: 30px;
}
.current-user {
  float: left;
}
.delete-btn {
  float: right;
  top: 20px;
}
</style>
