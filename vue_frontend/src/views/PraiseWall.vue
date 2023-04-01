<template>
  <div id="big_box">
    <el-row>
      <el-col v-for="(o, index) in 10" :key="o" :span="20">
        <el-card class="tiezi" shadow="hover">
          <h3>我来夸他</h3>
          <img src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"
            class="image" />
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script lang="ts" setup>
import { ref } from 'vue'
const input = ref('')

</script>

<style>
.image {
  width: 20%;
  display: block;
}

#big_box {
  width: 70%;
  height: 100%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  margin-left: auto;
  margin-right: auto;
}
.tiezi{
  margin-bottom: 10px;
  height: 250px;
}
/* .el-card {
  margin-bottom: 10px;
  height: 100px;
} */
</style>
