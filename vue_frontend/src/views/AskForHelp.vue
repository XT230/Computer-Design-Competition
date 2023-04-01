<template>
  <el-row :gutter="10">
    <el-col v-for="(o, index) in 11" :key="o" :span="8">
      <el-card shadow="hover">
        <h3>标题🍉</h3>
        <p>🍉家人们，救命，谁懂啊。前几天我闺蜜把我的用的黄瓜给吃掉了，好下头啊</p>
      </el-card>
    </el-col>
  </el-row>
</template>

<script lang="ts" setup>

</script>

<style scoped>
.el-card {
  margin-bottom: 10px;
  height: 100px;
}
</style>
