<template>
  <div style="padding-left: 20px;padding-right: 20px; padding-top: 20px;">
    <el-row :gutter="12">
      <el-col v-for="(o, index) in 11" :key="o" :span="8">
        <el-card shadow="hover">
          <h3>标题🍉</h3>
          <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Quos sapiente tempora architecto debitis dolores
            deserunt, numquam tempore nam amet, aliquam recusandae tenetur consectetur. Explicabo autem dignissimos vitae
            eos architecto nulla!</p>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script lang="ts" setup>

</script>

<style scoped>
.el-card {
  margin-top: 10px;
  margin-bottom: 10px;
  height: 150px;
}
</style>
