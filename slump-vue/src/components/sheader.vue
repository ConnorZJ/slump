<template>
  <div>
    <header id="header">
      <nav id="inner">
        <router-link to="/home" exact>
          <img id="logo" src="/static/slump.png" alt="logo">
        </router-link>
        <router-link to="/home">全部</router-link>
        <router-link to="/news">头条</router-link>
        <router-link to="/shares">分享</router-link>
        <router-link to="/questions">问答</router-link>
      </nav>
      <div id="userBar">
        <div v-if="user">
          <router-link class="username" :to="{path:'/profile', query:{ id: user.id }}">{{user.username}}</router-link>
          <a href="#" @click="logOut">退出</a>
        </div>
        <div v-else>
          <router-link to="/signup">注册</router-link>
          <router-link to="/login">登录</router-link>
        </div>
      </div>
    </header>
  </div>
</template>
<script>
export default {
  name: "sheader",
  data() {
    return {
      user: undefined
    };
  },
  mounted() {
    this.user = JSON.parse(localStorage.getItem("userInfo"));
      console.log(this.user);
  },
  methods: {
    isLogin() {
      this.user = JSON.parse(localStorage.getItem("userInfo"));
      console.log(this.user);
    },
    logOut() {
      localStorage.removeItem("userInfo");
      this.user = undefined;
    }
  }
};
</script>
<style>
#header {
  position: relative;
  height: 50px;
  top: 0;
  background-color: #fff;
  padding: 10px 60px 0px 60px;
  box-shadow: 0 0 1px rgba(0, 0, 0, 0.25);
  z-index: 2;
}

#header a {
  display: inline-block;
  position: relative;
  margin: 0 10px;
  text-decoration: none;
  color: #34495e;
}

#header a:hover,
#header a.router-link-active {
  color: #20a0ff;
}

#inner {
  width: 380px;
  height: 40px;
  line-height: 40px;
  float: left;
  left: 0px;
}

#inner a:first-child:hover,
#inner a:first-child.router-link-active {
  border-bottom: 0px;
}

#inner a {
  float: left;
}

#userBar {
  width: 150px;
  height: 40px;
  line-height: 40px;
  float: right;
  right: 0px;
}

#userBar a {
  float: right;
}
.username{
  right: 150px;
}

#logo {
  vertical-align: middle;
  margin-right: 6px;
  width: 115px;
  height: 38px;
}

#footer {
  position: relative;
  height: 80px;
  background-color: #324057;
  color: #a4aebd;
  width: 100%;
  bottom: 0px;
}
body {
  margin: 0;
}

#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>
