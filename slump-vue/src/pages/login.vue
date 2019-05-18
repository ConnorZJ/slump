<template>
  <div id="login">
    <el-form :model="loginForm" :rules="rules" ref="loginForm">
      <el-form-item prop="name">
        <el-input type="text" v-model="loginForm.username" placeholder="用户名"></el-input>
      </el-form-item>
      <el-form-item prop="password">
        <el-input type="password" v-model="loginForm.password" placeholder="密码"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" style="width:300px;" @click="submitForm('loginForm')">登录</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import axios from "axios";
export default {
  name: "login",
  data() {
    return {
      loginForm: {
        username: "",
        password: ""
      },
      rules: {
        username: [
          {
            required: true,
            message: "请输入用户名",
            trigger: "blur"
          },
          {
            min: 3,
            max: 15,
            message: "长度在 3 到 15 个字符",
            trigger: "blur"
          }
        ],
        password: [
          {
            required: true,
            message: "请输入用户名",
            trigger: "blur"
          },
          {
            min: 6,
            max: 15,
            message: "长度在 6 到 15 个字符",
            trigger: "blur"
          }
        ]
      }
    };
  },
  methods: {
    submitForm(formName) {
      axios.post("/api/user/login", this.loginForm).then(res => {
        if (res.data.code == "200") {
          localStorage.setItem("userInfo",JSON.stringify(res.data.data));
          this.$router.push({ path: "/home" });
          window.location.reload()
        } else if ((res.data.code = "-1")) {
          alert("账号或密码错误");
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    }
  }
};
</script>

<style>
#login {
  background-color: #fff;
  min-height: 408px;
  padding-top: 100px;
  margin-bottom: -20px;
}
#login .el-form {
  width: 300px;
  margin: 0px auto;
}
</style>
