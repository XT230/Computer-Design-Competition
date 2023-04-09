<template>
  <div id="big_box">
    <el-row >
      <el-col v-for="(o, index) in 11" :key="o" :span="20">
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
#big_box {
  width: 70%;
  height: 100%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  margin-left: auto;
  margin-right: auto;
  padding-left: 20px;
  padding-right: 20px;
  padding-top: 20px;
}
.el-card {
  margin-top: 10px;
  margin-bottom: 10px;
  height: 150px;
}
</style>
