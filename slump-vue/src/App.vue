<template>
  <div>
    <SHeader/>
    <div id="app">
      <router-view />
    </div>
  </div>
</template>

<script>
import SHeader from "@/components/sheader";
export default {
  name: "App",
  components: { SHeader },
};
</script>

<style>
</style>
