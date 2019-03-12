<template>
  <el-row class="board">
    <el-col :span="8" v-for="(classes,index) in clazz" :key="index">
      <div class="board-container">
        <div class="board-img">
          <a href="#">
            <img style="float:left;width:120px;height:120px;" :src="classes.imgUrl" class="image">
          </a>
        </div>
        <div>
          <div class="title-data">
            <a href="#">{{classes.name}}</a>
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
        console.log(res);
        if (res.data.code == "200") {
          this.clazz = res.data.data;
        }
        console.log(this.clazz);
      });
    }
  }
};
</script>
<style>
.board {
  width: 1200px;
  margin: 20px auto;
}
.board-container {
  margin: 10px 10px;
}
.board-img {
  display: inline;
}
</style>

