<template>
    <div id="recomend_user_box">
        <el-card v-for="item in 40" :key="item" id="recommend_user">
            <img src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"
                class="image" style="width: 100%;" />
            <div>
                <span>Yummy hamburger</span>
                <div class="bottom">
                    <el-button text class="button" @click.native="jumpToUserMainPage()">进入他的主页</el-button>
                </div>
            </div>
        </el-card>
    </div>
</template>
  
<script lang="ts">
import { RouterLink, RouterView } from 'vue-router'
import { defineComponent } from 'vue'
import router from '../router/index.js'
import Vue from 'vue'

export default defineComponent({
    data() {
        return {
            jumpToUserMainPage() {
                router.push('/mainpage/UserMainPage')
            },
        }
    },
})
</script>
  
<style scoped>
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

.image {
    width: 100%;
    display: block;
}

#user {
    margin-bottom: 20px;
    height: 400px;
}

#recommend_user{
    margin-bottom: 20px;
    width: 250px;
    height: 300px;
    float: left;
    margin-right: 20px;
}

#recomend_user_box {
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
  