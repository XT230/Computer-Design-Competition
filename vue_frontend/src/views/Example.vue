<template>
  <div style="padding-left: 20px;padding-right: 20px; padding-top: 20px;">
    <el-row :gutter="12" justify='space-between'>
      <el-col v-for="(o, index) in 8" :key="o" :span="6">
        <el-card id="wenzhang" >
          <img src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"
            class="image"  style="width: 100%;"/>
          <div style="padding: 1px">
            <span>Yummy hamburger</span>
            <div class="bottom">
              <time class="time">{{ currentDate }}</time>
              <el-button text class="button">Operating</el-button>
            </div>
          </div>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script lang="ts" setup>

import { ref } from 'vue'

const currentDate = ref(new Date())

</script>

<style scoped>
.time {
  font-size: 12px;
  color: #999;
}

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


#wenzhang {
  margin-top: 10px;
  margin-bottom: 10px;
  height: 400px;
}
</style>
