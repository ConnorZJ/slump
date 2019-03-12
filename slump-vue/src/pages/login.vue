<template>
  <el-form
    :model="loginForm"
    status-icon
    :rules="loginRules"
    ref="loginForm"
    label-width="100px"
    class="loginForm"
  >
    <el-form-item label="账号" prop="username">
      <el-input type="username" v-model="loginForm.username" autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item label="密码" prop="password">
      <el-input type="password" v-model="loginForm.password" autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="submitForm('loginForm')">提交</el-button>
      <el-button @click="resetForm('loginForm')">重置</el-button>
    </el-form-item>
  </el-form>
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
      loginRules: {
        username: [{ required: true, message: "请输入账号", trigger: "blur" }],
        password: [{ required: true, message: "请输入密码", trigger: "blur" }]
      }
    };
  },
  methods: {
    submitForm(formName) {
      axios.post("/api/user/login", this.loginForm).then(res => {
        if (res.data.code == "200") {
          this.$router.push({ path: "/home" });
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

<style scoped>
</style>
