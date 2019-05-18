<template>
  <div id="signup">
    <el-form :model="signForm" :rules="rules" ref="signForm">
      <el-form-item prop="name">
        <el-input type="text" v-model="signForm.name" placeholder="用户名"></el-input>
      </el-form-item>
      <el-form-item prop="email">
        <el-input type="email" v-model="signForm.email" placeholder="邮箱"></el-input>
      </el-form-item>
      <el-form-item prop="password">
        <el-input type="password" v-model="signForm.password" placeholder="密码"></el-input>
      </el-form-item>
      <el-form-item prop="checkPass">
        <el-input type="password" v-model="signForm.checkPass" placeholder="确认密码"></el-input>
      </el-form-item>
      <el-form-item prop="description">
        <el-input
          type="textarea"
          v-model="signForm.description"
          :autosize="{ minRows: 2, maxRows: 4}"
          placeholder="个人简介"
        ></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" style="width:300px;" @click="handleSign('signForm')">注册</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
import axios from "axios";
export default {
  name: "signup",
  data() {
    var validatePass = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请输入密码"));
      } else {
        if (this.signForm.checkPass !== "") {
          this.$refs.signForm.validateField("checkPass");
        }
        callback();
      }
    };
    var validatePass2 = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请再次输入密码"));
      } else if (value !== this.signForm.password) {
        callback(new Error("两次输入密码不一致!"));
      } else {
        callback();
      }
    };
    return {
      signForm: {
        name: "",
        email: "",
        password: "",
        checkPass: "",
        description: ""
      },
      rules: {
        name: [
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
        email: [
          {
            required: true,
            message: "请输入邮箱地址",
            trigger: "blur"
          },
          {
            type: "email",
            message: "请输入正确的邮箱地址",
            trigger: "blur"
          }
        ],
        password: [
          {
            validator: validatePass,
            trigger: "blur"
          },
          {
            min: 8,
            max: 15,
            message: "长度在 8 到 15 个字符",
            trigger: "blur"
          }
        ],
        checkPass: [
          {
            validator: validatePass2,
            trigger: "blur"
          }
        ]
      }
    };
  },
  methods: {
    open5() {
      this.$message({
        showClose: true,
        message: "恭喜你，你已成功注册"
      });
    },
    open6() {
      this.$message({
        showClose: true,
        message: "注册失败，用户已存在",
        type: "warning"
      });
    },
    open7() {
      this.$message({
        showClose: true,
        message: "注册失败，遇到未知问题",
        type: "error"
      });
    },
    handleSign(formName) {
      let _this = this;
      _this.$refs[formName].validate(function(vaild) {
        if (vaild) {
          _this.signup(formName);
        } else {
          console.log("error submit!!");
          return false;
        }
      });
    },
    signup() {
      let _this = this;
      axios
        .post(`/api/user/signup`, {
          username: _this.signForm.name,
          password: _this.signForm.password,
          email: _this.signForm.email,
          introduction: _this.signForm.description
        })
        .then(res => {
          if (res.data.code == 200) {
            _this.open5();
            _this.$router.push({ path: "/login" });
          } else if (res.data.code == 102) {
            _this.open6();
          } else if (res.data.code == -1) {
            _this.open7();
          }
        });
    }
  }
};
</script>
<style>
#signup {
  background-color: #fff;
  min-height: 408px;
  padding-top: 100px;
  margin-bottom: -20px;
}
#signup .el-form {
  width: 300px;
  margin: 0px auto;
}

#signup textarea {
  font-family: inherit;
}
</style>
