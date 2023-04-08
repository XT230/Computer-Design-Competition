<template>
  <div style="margin-bottom: 10px;">
    <el-button round size="large">初中</el-button>
    <el-button round size="large">高中</el-button>
    <el-button round size="large">大学</el-button>
  </div>
  <el-row justify='space-between'>
    <el-col v-for="(o, index) in 8" :key="o" :span="5" >
      <el-card  id="user" >
        <img src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"
          class="image" style="width: 100%;"/>
        <div >
          <h3>用户名</h3>
          <div class="bottom">
            <p>个人简介</p>
            <el-button text class="button" >进入TA的主页</el-button>
          </div>
        </div>
      </el-card>
    </el-col>
  </el-row>
</template>

<script lang="ts" setup>
import { ref } from 'vue'

</script>

<style>

.bottom {
  margin-top: 13px;
  line-height: 12px;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.button {
  padding: 0;
  min-height: auto;
}

.image {
  width: 100%;
  display: block;
}

#user {
  margin-bottom: 20px;
  height: 400px;
}


</style>
