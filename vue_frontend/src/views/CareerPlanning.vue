<template>
  <el-menu class="el-menu-demo" mode="horizontal" background-color="rgba(255, 255, 255, 0)" router>
    <el-menu-item index="/mainpage/CareerPlanning/CPArtical">推荐文章</el-menu-item>
    <el-sub-menu index="2">
      <template #title>推荐答主</template>
      <el-menu-item index="/mainpage/CareerPlanning/CPUser">高中</el-menu-item>
      <el-menu-item index="/mainpage/CareerPlanning/CPUser">大学</el-menu-item>
      <el-menu-item index="/mainpage/CareerPlanning/CPUser">硕士</el-menu-item>
    </el-sub-menu>
  </el-menu>
  <div style="padding-left: 20px;padding-right: 20px; padding-top: 20px;">
    <RouterView />
  </div>
</template>

<script lang="ts" >
import { ref } from 'vue'
import { RouterLink, RouterView } from 'vue-router'
import { defineComponent } from 'vue'
import router from '../router/index.js'
import Vue from 'vue'
export default defineComponent({
  mounted() {
    router.push('/mainpage/CareerPlanning/CPArtical')
  }
})
</script>

<style scoped >
.el-menu-demo {
  background-image: linear-gradient(90deg, #ffffff7f 10%, #ffffff00 90%);
}

.el-menu--horizontal {
  border-bottom: solid 0px;
}
</style>
