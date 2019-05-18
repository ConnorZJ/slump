<template>
  <el-tabs class="board" v-model="activeName" @tab-click="handleClick">
    <el-tab-pane label="用户管理" name="first">
      <el-form :model="form" ref="form" class="user-form" label-width="80px">
        <el-input type="hidden" v-model="form.id"></el-input>
        <el-form-item label="用户名">
          <el-input v-if="isUpdate" v-model="form.username"></el-input>
          <div v-else class="update">{{form.username}}</div>
        </el-form-item>
        <el-form-item label="昵称">
          <el-input v-if="isUpdate" v-model="form.nickname"></el-input>
          <div v-else class="update">{{form.nickname}}</div>
        </el-form-item>
        <el-form-item label="邮箱">
          <el-input v-if="isUpdate" v-model="form.email"></el-input>
          <div v-else class="update">{{form.email}}</div>
        </el-form-item>
        <el-form-item label="自我介绍">
          <el-input v-if="isUpdate" type="textarea" v-model="form.introduction"></el-input>
          <div v-else class="update">{{this.form.introduction}}</div>
        </el-form-item>
        <el-form-item label="签名">
          <el-input v-if="isUpdate" type="textarea" v-model="form.signature"></el-input>
          <div v-else class="update">{{form.signature}}</div>
        </el-form-item>
        <el-form-item v-if="isUpdate">
          <el-button type="primary" @click="onSubmit">确认修改</el-button>
          <el-button @click="onCancle">取消</el-button>
        </el-form-item>
        <el-form-item v-else>
          <el-button type="primary" @click="onUpdate">修改个人信息</el-button>
        </el-form-item>
      </el-form>
    </el-tab-pane>
    <el-tab-pane label="帖子管理" name="third">帖子管理</el-tab-pane>
  </el-tabs>
</template>
<script>
import axios from "axios";
export default {
  name: "profile",
  data() {
    return {
      activeName: "first",
      form: {
        id: "",
        username: "",
        nickname: "",
        email: "",
        introduction: "",
        signature: ""
      },
      readonly: true,
      isUpdate: false,
      userId: ""
    };
  },
  created() {
    this.userId = this.$route.query.id;
    this.username = this.$route.query.username;
  },
  mounted() {
    this.getProfile();
  },
  methods: {
    handleClick(tab, event) {},
    getProfile() {
      if (this.username) {
        axios.get(`/api/user/username/${this.username}`).then(res => {
          if ((res.data.code = "200")) {
            let user = res.data.data;
            this.form.id = user.id;
            this.form.username = user.username;
            this.form.nickname = user.nickname;
            this.form.email = user.email;
            this.form.introduction = user.introduction;
            this.form.signature = user.signature;
          }
        });
      } else {
        axios.get(`/api/user/id/${this.userId}`).then(res => {
          if ((res.data.code = "200")) {
            let user = res.data.data;
            this.form.id = user.id;
            this.form.username = user.username;
            this.form.nickname = user.nickname;
            this.form.email = user.email;
            this.form.introduction = user.introduction;
            this.form.signature = user.signature;
          }
        });
      }
    },
    onSubmit() {
      axios.post("/api/user/updateProfile", this.form).then(res => {
        if (res.data.code == "200") {
          let user = res.data.data;
          this.form.id = user.id;
          this.form.username = user.username;
          this.form.nickname = user.nickname;
          this.form.email = user.email;
          this.form.introduction = user.introduction;
          this.form.signature = user.signature;
        } else if ((res.data.code = "-1")) {
          alert("修改失败");
        }
      });
      this.isUpdate = false;
    },
    onUpdate() {
      this.isUpdate = true;
    },
    onCancle() {
      this.isUpdate = false;
    }
  }
};
</script>
<style>
.board {
  width: 1200px;
  margin: 0 auto;
}
.user-form {
  width: 800px;
  margin: 0 auto;
}
.update {
  word-wrap: break-word;
  word-break: break-all;
  overflow: hidden;
  text-align: left;
}
</style>
