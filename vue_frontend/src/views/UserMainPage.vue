<template>
    <div id="big_box" style="text-align: center;border-radius: 20px;">
        <el-row style="width: 70%; padding-top: 10px; padding-bottom: 10px;">
            <el-col span="1">
                <img src="../tmp/8.jpg" class="image" style="width: 150px; border-radius: 50%;">
            </el-col>
            <el-col span="6" style=" width: 65%;">
                <div style="text-align: left;padding-left: 10px;">
                    <p style="padding-top: 10px; padding-left: 10px;font-size: 30px;">{{ userID }}</p>
                    <p style="color: gray;">高一总分只有400分，高三发现学习的方法。努力一年最终高考成绩640分被山东大学录取。擅长英语和数学快速提分。</p>
                </div>
            </el-col>
        </el-row>
        <el-row justify="space-evenly" style="width: 100%;">
            <el-col span="5" style="width: 40%;border-radius: 10px;">
                <div id="boxt">
                    <div style="padding:30px 0;">
                        <p>
                            <img src="../assets/credit-level.svg" style="width:2em ;" />
                        <h1>积分:122</h1>
                        </p>
                    </div>
                </div>
            </el-col>
            <el-col span="5" style="width: 40%;">
                <div id="boxt">
                    <div style="padding:30px 0;">
                        <p>
                            <img src="../assets/school.svg" style="width:2em ;" />
                        <h1>学校:山东大学</h1>
                        </p>
                    </div>
                </div>
            </el-col>
        </el-row>
    </div>
    <div id="big_box2" style="text-align: center;">
        <el-row style="width:100%" justify="center">
            <el-col :span="24">
                <el-card class="tiezi" shadow="hover" style="border-radius: 20px;" @click="jumpToAritical">
                    <h3>英语提分</h3>
                    <el-row>
                        <el-col :span="7">
                            <img src="../tmp/artical1.jpg" class="image" />
                        </el-col>
                        <el-col :span="17">
                            <p style="text-align:left;color: gray; padding-left: 10px;">
                                本人起初英语五十分，后来快速提升到了110分最后高考135，经过高三一年我不断的实验、尝试。我发现英语用对方法提分真的不难! !
                                !开始我以为英语靠的是多年的积累。但是考试中其实是有“套路”可循的!所以只要你按我说的做，短期提分是可以实现的!单词。如果你问我英语提分中最重要、最关键的是什么图那我一定会说单词。现在很多同学有一个误区，就觉得:单词不就是背嘛，有什么重要的，有什么难的?但是就是这最简单的单词很多人都坚持...
                            </p>

                        </el-col>
                    </el-row>
                </el-card>
            </el-col>
            <el-col :span="24">
                <el-card class="tiezi" shadow="hover" style="border-radius: 20px; " @click="jumpToAritical">
                    <h3>如何对待考试焦虑</h3>
                    <el-row>
                        <el-col :span="7">
                            <img src="../tmp/artical2.jpg" class="image" />
                        </el-col>
                        <el-col :span="17">
                            <p style="text-align:left;color: gray; padding-left: 10px;">
                                写备忘录/写日记
                                我一直都有写日记的习惯，平常写日记多数是以反思为主基本上每天都要复盘看今天哪些地方做得好，哪些地方还有提升空间。这是一个帮助稳定状态消化情绪非常好的方法，这个适合情绪平稳期，不适合焦虑期。
                                高考倒计时最后二十天，我没有交手机，每天放学回寝室后坚持写备忘录，在那种节骨眼上人是处于极度高压的状态，任何一点小事情都会非常影响自信，所以当时我做的事情就是每天都记录下我的进步我的成就，不管多小我都要找出...
                            </p>
                        </el-col>
                    </el-row>
                </el-card>
            </el-col>
        </el-row>
    </div>
    <el-affix :offset="60" position="bottom" style="position: absolute; right: 5%; bottom: 10%;">
        <div style="border-radius:30px;background-color: white; width: 60px; height: 60px;" @click="ToDialog">
            <img src="../assets/message.svg" style="width: 60px; height: 40px;padding-top: 10px;padding-left: 0px;" />
        </div>
    </el-affix>
</template>

<script lang="ts">
import { defineComponent } from 'vue'
import router from '../router/index.js'
import { computed, ref } from 'vue'
export default defineComponent({
    setup() {
        const userAvatar = 'https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png'
        const userID = "刘蕊"
        const userSchool = "东北大学秦皇岛分校"
        const userEdu = "本科"
        const ToDialog = () => {
            router.push('/mainpage/dialog')
        }
        const jumpToAritical = (aid: number) => {
            router.push({
                path: '/mainpage/ReadArtical',
                query: {
                    aid: aid
                }
            })
        }
        return {
            userAvatar,
            userID,
            userSchool,
            userEdu,
            ToDialog,
            jumpToAritical
        }
    }

    // data() {
    //     return {
    //         userAvatar: 'https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png',
    //         userID: "刘蕊",
    //         userSchool: "东北大学秦皇岛分校",
    //         userEdu: "本科",

    //     }
    // }
})
</script>

<style scoped>
#big_box {
    width: 50%;
    height: 100%;
    display: flex;
    background-color: white;
    color: black;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    border-radius: 10px;
    margin-top: 10px;
    margin-left: auto;
    margin-right: auto;
}

.tiezi {
    margin-top: 10px;
    margin-bottom: 10px;
    height: 250px;
}

div>img {
    width: 100%;
    display: block;
}

#big_box2 {
    width: 50%;
    height: 100%;
    display: flex;
    color: black;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    border-radius: 10px;
    margin-top: 10px;
    margin-left: auto;
    margin-right: auto;
}

#boxt {
    background-image: linear-gradient(225deg, #37a8f969 18%, #3441d237 80%);
    border-radius: 10px;
    margin-bottom: 10px;
    text-align: center;
}
</style>