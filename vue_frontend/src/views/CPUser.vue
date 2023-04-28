<template>
    <div id="recomend_user_box">
        <!-- <el-card v-for="item in user" :key="item" id="recommend_user">
            <img :src="item.avatar" class="image" style="width: 100%;border-radius: 20px;" />
            <div>
                <span>{{ item.username }}</span>
                <div class="bottom">
                    <el-button text class="button" @click.native="jumpToUserMainPage()">进入他的主页</el-button>
                </div>
            </div>
        </el-card> -->

        <el-card id="recommend_user">
            <img src="../tmp/2.jpg" class="image" style="width: 100%;border-radius: 20px;" />
            <div>
                <span>张皓月</span>
                <div class="bottom">
                    <el-button text class="button" @click.native="jumpToUserMainPage()">进入他的主页</el-button>
                </div>
            </div>
        </el-card>
        <el-card id="recommend_user">
            <img src="../tmp/7.jpg" class="image" style="width: 100%;border-radius: 20px;" />
            <div>
                <span>孙诺文</span>
                <div class="bottom">
                    <el-button text class="button" @click.native="jumpToUserMainPage()">进入他的主页</el-button>
                </div>
            </div>
        </el-card>
        <el-card id="recommend_user">
            <img src="../tmp/4.jpg" class="image" style="width: 100%;border-radius: 20px;" />
            <div>
                <span>邓宇哲</span>
                <div class="bottom">
                    <el-button text class="button" @click.native="jumpToUserMainPage()">进入他的主页</el-button>
                </div>
            </div>
        </el-card>
        <el-card id="recommend_user">
            <img src="../tmp/5.jpg" class="image" style="width: 100%;border-radius: 20px;" />
            <div>
                <span>韩思成</span>
                <div class="bottom">
                    <el-button text class="button" @click.native="jumpToUserMainPage()">进入他的主页</el-button>
                </div>
            </div>
        </el-card>
        <el-card id="recommend_user">
            <img src="../tmp/6.jpg" class="image" style="width: 100%;border-radius: 20px;" />
            <div>
                <span>董泽宇</span>
                <div class="bottom">
                    <el-button text class="button" @click.native="jumpToUserMainPage()">进入他的主页</el-button>
                </div>
            </div>
        </el-card>
        <el-card id="recommend_user">
            <img src="../tmp/8.jpg" class="image" style="width: 100%;border-radius: 20px;" />
            <div>
                <span>刘蕊</span>
                <div class="bottom">
                    <el-button text class="button" @click.native="jumpToUserMainPage()">进入他的主页</el-button>
                </div>
            </div>
        </el-card>
        <el-card id="recommend_user">
            <img src="../tmp/9.png" class="image" style="width: 100%;border-radius: 20px;" />
            <div>
                <span>徐涛</span>
                <div class="bottom">
                    <el-button text class="button" @click.native="jumpToUserMainPage()">进入他的主页</el-button>
                </div>
            </div>
        </el-card>
        <el-card id="recommend_user">
            <img src="../tmp/10.jpg" class="image" style="width: 100%;border-radius: 20px;" />
            <div>
                <span>于洋</span>
                <div class="bottom">
                    <el-button text class="button" @click.native="jumpToUserMainPage()">进入他的主页</el-button>
                </div>
            </div>
        </el-card>
        <el-card id="recommend_user">
            <img src="../tmp/11.jpg" class="image" style="width: 100%;border-radius: 20px;" />
            <div>
                <span>席艳</span>
                <div class="bottom">
                    <el-button text class="button" @click.native="jumpToUserMainPage()">进入他的主页</el-button>
                </div>
            </div>
        </el-card>
        <el-card id="recommend_user">
            <img src="../tmp/3.png" class="image" style="width: 100%;border-radius: 20px;" />
            <div>
                <span>向晚</span>
                <div class="bottom">
                    <el-button text class="button" @click.native="jumpToUserMainPage()">进入他的主页</el-button>
                </div>
            </div>
        </el-card>
        <el-card id="recommend_user">
            <img src="../tmp/1.jpg" class="image" style="width: 100%;border-radius: 20px;" />
            <div>
                <span>张淑睿</span>
                <div class="bottom">
                    <el-button text class="button" @click.native="jumpToUserMainPage()">进入他的主页</el-button>
                </div>
            </div>
        </el-card>
        <el-card id="recommend_user">
            <img src="../tmp/12.jpg" class="image" style="width: 100%;border-radius: 20px;" />
            <div>
                <span>李瑞</span>
                <div class="bottom">
                    <el-button text class="button" @click.native="jumpToUserMainPage()">进入他的主页</el-button>
                </div>
            </div>
        </el-card>
        <el-card id="recommend_user">
            <img src="../tmp/13.jpg" class="image" style="width: 100%;border-radius: 20px;" />
            <div>
                <span>杨帆</span>
                <div class="bottom">
                    <el-button text class="button" @click.native="jumpToUserMainPage()">进入他的主页</el-button>
                </div>
            </div>
        </el-card>
        <el-card id="recommend_user">
            <img src="../tmp/14.jpg" class="image" style="width: 100%;border-radius: 20px;" />
            <div>
                <span>吴红玉</span>
                <div class="bottom">
                    <el-button text class="button" @click.native="jumpToUserMainPage()">进入他的主页</el-button>
                </div>
            </div>
        </el-card>
        <el-card id="recommend_user">
            <img src="../tmp/15.jpg" class="image" style="width: 100%;border-radius: 20px;" />
            <div>
                <span>蒋旭东</span>
                <div class="bottom">
                    <el-button text class="button" @click.native="jumpToUserMainPage()">进入他的主页</el-button>
                </div>
            </div>
        </el-card>
        <el-card id="recommend_user">
            <img src="../tmp/16.jpg" class="image" style="width: 100%;border-radius: 20px;" />
            <div>
                <span>李红晶</span>
                <div class="bottom">
                    <el-button text class="button" @click.native="jumpToUserMainPage()">进入他的主页</el-button>
                </div>
            </div>
        </el-card>
        <el-card id="recommend_user">
            <img src="../tmp/17.jpg" class="image" style="width: 100%;border-radius: 20px;" />
            <div>
                <span>尹诗蓉</span>
                <div class="bottom">
                    <el-button text class="button" @click.native="jumpToUserMainPage()">进入他的主页</el-button>
                </div>
            </div>
        </el-card>
        <el-card id="recommend_user">
            <img src="../tmp/18.jpg" class="image" style="width: 100%;border-radius: 20px;" />
            <div>
                <span>陈淑珍</span>
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
import require from 'axios'
import Vue from 'vue'

export default defineComponent({
    setup() {
        const jumpToUserMainPage = () => {
            router.push('/mainpage/UserMainPage')
        }
        const user = [
            {
                avatar: require('../tmp/1.png'),
                username: 'wanan',
            }
        ]
        return {
            jumpToUserMainPage,
            user,

        }
    }
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

#recommend_user {
    margin-bottom: 20px;
    width: 250px;
    height: 300px;
    float: left;
    margin-right: 20px;
    border-radius: 20px;
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
  