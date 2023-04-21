<template>
  <div class="common-layout" id="homepage_box">
    <el-container  direction="vertical">
      <el-header>
        <h2 id="website_title">心理健康服务平台</h2>
        <div id="user_info">
          <el-dropdown>
            <span class="el-dropdown-link">
              <h3>{{ userID }}</h3>
              <div id="user_avatar">
                <el-avatar :size="50" :src="userAvatar" />
              </div>
            </span>
            <template #dropdown>
              <el-dropdown-menu>
                <el-dropdown-item @click.native="jumpToUserInfo()">个人中心</el-dropdown-item>
                <el-dropdown-item @click.native="jumpToFavorites()">我的收藏</el-dropdown-item>
                <!-- <el-dropdown-item>关注</el-dropdown-item> -->
                <el-dropdown-item divided>退出登录</el-dropdown-item>
              </el-dropdown-menu>
            </template>
          </el-dropdown>
        </div>
      </el-header>

      <el-container id="down_box">
        <el-aside width="200px" style="background-color: rgba(255, 255, 255, 0.5);">
          <el-menu default-active="/mainpage/Recomend" class="el-menu-vertical-demo" ref="menu" router background-color="rgba(255, 255, 255, 0)">
            <el-menu-item index="/mainpage/Recomend">
              <template #title>
                <el-icon>
                  <!-- <location /> -->
                </el-icon>
                <span>首页</span>
              </template>
            </el-menu-item>
            <el-sub-menu index="2" >
              <template #title>
                <el-icon>
                  <!-- <location /> -->
                </el-icon>
                <span>交往难题</span>
              </template>
              <el-menu-item-group title="解决校园霸凌">
                <el-menu-item index="/mainpage/AIChat">AI 咨询</el-menu-item>
                <el-menu-item index="/mainpage/Example">真实事例</el-menu-item>
              </el-menu-item-group>
              <el-menu-item-group title="同学、师生关系">
                <el-menu-item index="/mainpage/AskForHelp">求助帖</el-menu-item>
                <el-menu-item index="/mainpage/PraiseWall">夸夸墙</el-menu-item>
              </el-menu-item-group>
            </el-sub-menu>
            <el-sub-menu index="3">
              <template #title>
                <el-icon>
                  <!-- <location /> -->
                </el-icon>
                <span>学业谜思</span>
              </template>
              <el-menu-item index="/mainpage/CareerPlanning" @click.native="jumpToAriticle()">规划答疑</el-menu-item>
            </el-sub-menu>

          </el-menu>
        </el-aside>
        <el-main style="overflow:hidden">
          <el-scrollbar style="height: calc(100vh - 60px);">
            <router-view>

            </router-view>
          </el-scrollbar>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>


<script lang="ts">
import { RouterLink, RouterView } from 'vue-router'
import { defineComponent } from 'vue'
import { getSessionStorage } from '@/common'
import router from '../router/index.js'
import Vue from 'vue'

export default defineComponent({
  data() {
    return {
      userAvatar: 'https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png',
      userID: getSessionStorage("user").nickname,
      jumpToUserInfo() {
        router.push('/mainpage/UserInfo')
      },
      jumpToFavorites() {
        router.push('/mainpage/Favorites')
      },
      jumpToAriticle() {
        router.push('/mainpage/CareerPlanning/CPArtical')
      }
    }
  },
  mounted() {
    (this.$refs.menu as any & {validate:Function} ).open('2');
    (this.$refs.menu as any & {validate:Function} ).open('3');
    router.push('/mainpage/Recomend')
  }
})
</script>

<style scoped>

body {
    height: 100%;
}
#homepage_box {
    height: 100vh;
}
#user_info {
  float: right;
  padding-top: 5px;
}

#user_avatar {
  padding-left: 10px;

}

#homepage_box {
  width: 100%;
  height: 100%;
}


.el-header {
  background-image: linear-gradient(90deg, #37a9f9 18%, #7340f9 80%);
  color: #333;
  line-height: 60px;
}

.el-main {
  background-color: #f2f2f200;
  color: #ffffff00;
  padding:0px;
}

.el-dropdown-link {
  cursor: pointer;
  color: #fff;
  display: flex;
  align-items: center;
}

.el-dropdown {
  width: 100;
}

#website_title {
  padding-left: 20px;
  font-size: 30px;
  font-weight: 700;
  color: #fff;
  float: left;
}

#down_box {
  height: 100%;
  background-image: linear-gradient(to left bottom, #f985c7, #fd87b5, #fd8ba5, #f99098, #f3968e, #f39e83, #efa87a, #e7b274, #dac46d, #c2d773, #9dea89, #5ffbb0);

}
.el-menu
{
  border-right: solid 0px;
}
</style>