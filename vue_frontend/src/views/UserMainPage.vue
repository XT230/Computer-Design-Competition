<template>
    <el-row style="margin-bottom: 10px;">
        <el-col :span="4">
            <div>
                <img :src="userAvatar" class="image" style="width: 150px;" />
            </div>
        </el-col>
        <el-col :span="16">
            <div>
                <h3>{{ userID }}</h3>
                <p>学校：{{ userSchool }}</p>
                <p>学历：{{ userEdu }}</p>
            </div>
        </el-col>
    </el-row>
    <hr>
    <div id="big_box">
    <el-row>
      <el-col v-for="(o, index) in 10" :key="o" :span="20">
        <el-card class="tiezi" shadow="hover">
          <h3>帖子</h3>
          <img src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"
            class="image" />
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script lang="ts">
import { defineComponent } from 'vue'
import { computed, ref } from 'vue'
export default defineComponent({
    data() {
        return {
            userAvatar: 'https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png',
            userID: "大家好我是说的道理",
            userSchool: "东北大学秦皇岛分校",
            userEdu: "本科",

        }
    }
})
</script>

<style></style>