
<template>
  <div style="padding-left: 20px;padding-right: 20px; padding-top: 20px;">
    <el-carousel :interval="4000" type="card" height="300px">
      <el-carousel-item v-for="item in 6" :key="item">
        <h3 text="2xl" justify="center">{{ item }}</h3>
      </el-carousel-item>
    </el-carousel>
    <!-- <el-row justify='space-between'>
      <el-col v-for="(o, index) in 5" :key="o" :span="5">
        <el-card id="tuijianwenzhang">
          <img src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"
            class="image" style="width: 100%;" />
          <div>
            <span>Yummy hamburger</span>
            <div class="bottom">
              <time class="time">{{ currentDate }}</time>
              <el-button text class="button">Operating</el-button>
            </div>
          </div>
        </el-card>
      </el-col>
          </el-row> -->
    <div id="recomend_artical_box">
      <el-card v-for="item in 40" :key="item" id="tuijianwenzhang" @click="jumpToAriticle">
        <img src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"
          class="image" style="width: 100%;" />
        <div>
          <span>Yummy hamburger</span>
        </div>
      </el-card>
    </div>
  </div>
</template>


<script lang="ts" >
import { ref } from 'vue'
import { defineComponent } from 'vue'
import router from '../router/index.js'

export default defineComponent({
  setup() {
    const jumpToAriticle = () => {
      router.push('/mainpage/ReadArtical')
    }
    return {
      jumpToAriticle
    }
  }
})
const currentDate = ref(new Date())

</script>

<style scoped>
.el-carousel__item h3 {
  color: #475669;
  opacity: 0.75;
  line-height: 200px;
  margin: 0;
  text-align: center;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n + 1) {
  background-color: #d3dce6;
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

#tuijianwenzhang>.image {
  width: 100%;
  display: block;
}

#tuijianwenzhang {
  margin-bottom: 20px;
  width: 250px;
  height: 300px;
  float: left;
  margin-right: 20px;
}

#tuijianwenzhang>img {
  width: 100%;
  display: block;
}

#recomend_artical_box {
  width: 90%;
  height: 100%;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  margin-left: auto;
  margin-right: auto;
  padding-left: 20px;
  padding-right: 20px;
  padding-top: 20px;
}
</style>