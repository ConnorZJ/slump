<template>
  <div id="board">
    <el-row>
      <el-col :span="18">
        <div v-if="topics.length != 0">
          <div class="list-group grid-content bg-purple-dark">
            <div class="list-group-item" v-for="(topic,index) in topics" :key="index">
              <div class="post_info">
                <img class="author" src="/static/clazz/java.jpg">
                <!-- <span class="board">{{post.board}}</span> -->
                <router-link :to="{path:'/topic', query: { topic: topic }}">{{topic.title}}</router-link>
              </div>
              <div>
                <div class="count-block">
                  <div class="count count-click">
                    <p class="num">{{topic.hits}}</p>
                    <p class="txt">点击</p>
                  </div>
                  <div class="count">
                    <p class="num">{{topic.replyCount}}</p>
                    <p class="txt">回复</p>
                  </div>
                </div>
              </div>
              <div class="last_com">
                <span class="last_time">{{topic.replyTime}}</span>
              </div>
            </div>
          </div>
          <el-button class="post" type="primary" @click="post" plain>发新帖</el-button>
        </div>

        <!-- <div v-else class="no_post">还没有文章信息，点此发布新帖子</div> -->
        <router-link v-else :to="{path:'/create',query:{classId:classId}}">还没有文章信息，点此发布新帖子</router-link>
      </el-col>
    </el-row>
  </div>
</template>
<script>
import axios from "axios";
export default {
  name: "clazz",
  data() {
    return {
      topics: [],
      classId: null
    };
  },
  mounted() {
    this.getTopics();
  },
  methods: {
    getTopics() {
      this.classId = this.$route.query.classId;
      axios.get(`/api/topic/${this.classId}`).then(res => {
        if ((res.data.code = "200")) {
          this.topics = res.data.data;
        }
      });
    },
    post(){
      this.$router.push({path:'/create',query:{classId:this.classId}});
    }
  }
};
</script>
<style>
#board .el-col-17 {
  border-top: 3px solid #e9e9e9;
  background-color: #fff;
}

#board .el-col-17 .no_post {
  height: 63px;
  line-height: 63px;
}

.post_info {
  float: left;
  padding: 10px;
  width: 690px;
  overflow: hidden;
  height: 42px;
  margin-left: 350px;
}

#board .post_info img {
  width: 42px;
  height: 42px;
  border-radius: 3px;
}

#board .post_info > span,
#board .post_info > a {
  position: relative;
  top: -16px;
}

#board .post_info .count {
  display: inline-block;
  width: 70px;
  text-align: center;
}

#board .post_info .count .comment_count {
  color: #9e78c0;
  font-size: 14px;
}

#board .post_info .count .view_count {
  font-size: 10px;
  color: #b4b4b4;
}

#board .post_info .board {
  font-size: 12px;
  background-color: #e5e5e5;
  color: #999;
  padding: 2px 4px;
  border-radius: 3px;
}

#board .post_info > a {
  position: relative;
  display: inline-block;
  color: #222;
  font-size: 16px;
  top: -11px;
  width: 532px;
  overflow: hidden;
  text-decoration: none;
  text-align: left;
  font-weight: bold;
}

#board .post_info > a:hover {
  text-decoration: underline;
}

#board .post_info > a:visited {
  color: #222;
}

#board .last_com {
  height: 42px;
  width: 126px;
  padding: 10px;
  float: right;
}

#board .last_com img {
  height: 18px;
  width: 18px;
  float: right;
  margin-top: 12px;
  border-radius: 3px;
}

#board .last_com span {
  position: relative;
  margin-right: 5px;
  top: 12px;
  min-width: 50px;
  display: inline-block;
  white-space: nowrap;
  font-size: 11px;
  color: #778087;
}
.count {
  float: left;
  font-size: 14px;
  color: #888;
}
.txt {
  margin-top: -8px;
}
.count-click {
  margin-right: 20px;
}
.post{
  position: fixed;
  top: 70px;
  right: 350px;
}
</style>

