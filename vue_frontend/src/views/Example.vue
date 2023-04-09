<template>
  <div id="big_box">
    <el-row>
      <el-col v-for="(o, index) in 20" :key="o" :span="20">
        <el-card id="wenzhang">
          <div style="height: 200px;">
            <img src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"
              class="image" style="height: 100%;" />
          </div>

          <div style="padding: 1px ">
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
  height: 300px;
}
</style>
