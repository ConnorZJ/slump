<template>
  <el-row class="board">
    <el-col :span="8" v-for="(classes,index) in clazz" :key="index">
      <div class="board-container">
        <div class="board-img">
          <router-link :to="{path:'/clazz',query:{classId:classes.id}}">
            <img style="float:left;width:120px;height:120px;" :src="classes.imgUrl" class="image">
          </router-link>
        </div>
        <div>
          <div class="title-data">
            <router-link :to="{path:'/clazz',query:{classId:classes.id}}">{{classes.name}}</router-link>
          </div>
          <div class="number-data">帖子数：{{classes.topicCount}}</div>
          <div class="intro-data">{{classes.intro}}</div>
        </div>
      </div>
    </el-col>
  </el-row>
</template>
<script>
import axios from "axios";
export default {
  name: "home",
  data() {
    return {
      clazz: {}
    };
  },
  mounted() {
    this.getClasses();
  },
  methods: {
    getClasses() {
      axios.get("/api/class/get").then(res => {
        if (res.data.code == "200") {
          this.clazz = res.data.data;
        }
      });
    }
  }
};
</script>
<style>
.board {
  width: 1200px;
  margin: 0 auto;
}
.board-container {
  margin: 10px 10px;
}
.board-img {
  display: inline;
}
</style>

