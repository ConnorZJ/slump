<template>
  <div class="create-form">
    <el-form ref="form" :model="form" label-width="80px">
      <el-form-item label="标题">
        <el-input v-model="form.title"></el-input>
      </el-form-item>
      <el-form-item label="内容">
        <el-input type="textarea" v-model="form.body"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">发布</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
import axios from "axios";
export default {
  name: "create",
  data() {
    return {
      form: {
        title: "",
        body: ""
      }
    };
  },
  methods: {
    onSubmit() {
      let classId = this.$route.query.classId;
      let currentUser = JSON.parse(localStorage.getItem("userInfo"));
      if (!currentUser) {
        this.$router.push({ path: "/login" });
      }
      axios
        .post(`/api/topic/post`, {
          classId: this.$route.query.classId,
          title: this.form.title,
          body: this.form.body,
          createBy: currentUser.username,
          replyBy: currentUser.username
        })
        .then(res => {
          if ((res.data.code = "200")) {
            this.$router.push({
              path: "/topic",
              query: { topic: res.data.data }
            });
          }
        });
    }
  }
};
</script>
<style>
.create-form {
  width: 1000px;
  margin: 50px auto;
}
</style>
