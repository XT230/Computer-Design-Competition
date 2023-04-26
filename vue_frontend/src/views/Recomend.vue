
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
    <div id="recomend_artical_box" style="text-align: center;">
      <el-card v-for="item in ariticle" :key="item" id="tuijianwenzhang" @click="jumpToAriticle"
        style="border-radius: 20px;">
        <img :src="item.img" class="image" style="width: 100%;" />
        <div>
          <span>{{ item.title }}</span>
          <br>
          <p style="color: darkgray; font-size: small;">{{ item.contain }}</p>
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
    const ariticle = [
      {
        title: '「已读不回」和「无人点赞」真的让我很焦虑',
        img: 'https://ossimg.xinli001.com/20230416/14e0d4e117df3518c8efcb518d5e6752.jpeg?x-oss-process=image/quality,Q_80',
        contain: '这种线上社交焦虑和线下社交焦虑的本质都是一样的，即对他人评价的过度在意。'
      },
      {
        title: '抵触别人的礼物：我们内心的真正困惑是什么？',
        img: 'https://p8.itc.cn/q_70/images01/20211126/bede10b34f7546c28add55fbe1675607.jpeg',
        contain: '在人际交往的圈中，送礼成为非常困难的事情',
      },
      {
        img: 'https://ossimg.xinli001.com/20230406/24d50463b9f39fe1392d30779f5da275.jpeg?x-oss-process=image/quality,Q_80',
        title: '你为何总是产生被遗弃感？',
        contain: '在我们依恋某个人的时候，就会害怕遗弃感。',
      },
      {
        img: 'https://ossimg.xinli001.com/20230321/43889a8577b59e640eca9d68a20d782b.jpeg?x-oss-process=image/quality,Q_80',
        title: '怎样与易怒的人相处？',
        contain: '我们身边总是会有一些比较易怒的人，那么对于这样的人，我们可以从多个方面来应对它。',
      },
      {
        img: 'https://ossimg.xinli001.com/20230317/63c0fe9ecc8870d7dd8b82fd9ea1c1d1.jpeg?x-oss-process=image/quality,Q_80',
        title: '总容易被别人影响？教你即刻建立边界感',
        contain: '悬崖的边界很清楚，所以我们不会靠的太近，但是水的边界比较模糊，所以经常会淹死人。',
      }, {
        img: 'https://ossimg.xinli001.com/20230317/1416cba3e08d90abcb3936236f7f490a.jpeg?x-oss-process=image/quality,Q_80',
        title: '明白这一件事，你的人际关系将越来越好',
        contain: '我们常常会把幸福挡在门外，是因为在内心深处，我们认为自己不值得拥有。',
      }, {
        img: 'https://ossimg.xinli001.com/20230318/306652b8d6e14235bfdaba30de56e182.png?x-oss-process=image/quality,Q_80',
        title: '我值得被更好的对待吗？',
        contain: '在人际交往的时候，我们可以学习如何与别人更好的相处。',
      },
      {
        img: 'https://ossimg.xinli001.com/20230313/b4d8512880759307e6ba147661c3c3ae.png?x-oss-process=image/quality,Q_80',
        title: '3个迹象表明可能是时候与朋友断绝来往了',
        contain: '如果你觉得一段友谊正在变质，甚至怀疑这段关系已经影响到你的心理健康，你就可以通过以下三种方式来验证你的猜测。',
      }, {
        img: 'https://ossimg.xinli001.com/20230313/f2193c58db16551ae85734afffb350ca.png?x-oss-process=image/quality,Q_80',
        title: '一个人断绝社交10年，会变成什么样？',
        contain: '当你尝试着打开自己去接纳他人的时候，也是你的社交的开始。',
      }, {
        img: 'https://ossimg.xinli001.com/20230202/05631b0465cd305c638a274a64104429.jpeg?x-oss-process=image/quality,Q_80',
        title: '为什么我总是格外敏感：“感同身受”真的存在吗？',
        contain: '共情能力是一种在人际交往中至关重要的能力，它让我们可以感知并且理解他人的处境。',
      }, {
        img: 'https://ossimg.xinli001.com/20230202/90c2c79b862c4e8842163a5530deb545.jpeg?x-oss-process=image/quality,Q_80',
        title: '从社恐到抑郁，我靠这件事治愈了自己',
        contain: '埋在心底的创伤，以另一种方式，决定着长大后的每一个选择。',
      }, {
        img: 'https://ossimg.xinli001.com/20230120/b8402fe2ab0a1d6de9fee81c81dd395a.png?x-oss-process=image/quality,Q_80',
        title: '不是好朋友之间才讲八卦，八卦创造好朋友',
        contain: '不是好朋友之间才讲八卦，而是八卦创造好朋友。',
      }, {
        img: 'https://ossimg.xinli001.com/20230122/8b9f6cec9f31029215feb5889f31867d.jpeg?x-oss-process=image/quality,Q_80',
        title: '春节里的困惑：我不喜欢社交，是我有问题吗？',
        contain: '找到自己的社交模式，发现独特的社交天赋。',
      },

    ];
    const jumpToAriticle = () => {
      router.push('/mainpage/ReadArtical')
    }
    return {
      jumpToAriticle,
      ariticle
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