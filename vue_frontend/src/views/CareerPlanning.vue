<template>
  <div>
    <el-menu class="el-menu-demo" mode="horizontal" background-color="rgba(255, 255, 255, 0)" router>
      <el-menu-item index="/mainpage/CareerPlanning/CPArtical">推荐文章</el-menu-item>
      <el-menu-item index="/mainpage/CareerPlanning/CPUser">推荐答主</el-menu-item>
    </el-menu>
    <div style="color: black; background-image: linear-gradient(90deg, #ffffff7f 40%, #ffffff00 60%);" id="select">
      筛选：
      <el-select v-model="value" class="m-2" placeholder="Select">
        <el-option v-for="item in options" :key="item.value" :label="item.label" :value="item.value" />
      </el-select>
    </div>

  </div>
  <div style="padding-left: 20px;padding-right: 20px;">
    <el-scrollbar style="height: calc(100vh - 117.6px - 32px);">
      <RouterView />
    </el-scrollbar>

  </div>
</template>

<script lang="ts" >
import { ref } from 'vue'
import { RouterLink, RouterView } from 'vue-router'
import { defineComponent } from 'vue'
import router from '../router/index.js'
import Vue from 'vue'
export default defineComponent({
  data() {
    return {
      value: '',
      options: [{
        value: 'op1',
        label: '高中'
      }, {
        value: 'op2',
        label: '大学'
      }, {
        value: 'op3',
        label: '硕士'
      }]
    }
  },
})
</script>

<style scoped >
.el-menu-demo {
  background-image: linear-gradient(90deg, #ffffff7f 40%, #ffffff00 60%);
}

.el-menu--horizontal {
  border-bottom: solid 0px;
}

.el-menu--popup {
  padding: 0px;
}

#select{
  
}
</style>
