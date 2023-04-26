<template>
    <div id="big_box" style="text-align: center;border-radius: 20px;">
        <el-row style="width: 60%; padding-top: 10px;">
            <el-col span="8">
                <el-avatar :size="150" :src="userAvatar"></el-avatar>
            </el-col>
            <el-col span="16">
                <h1 style="padding:70px 20px;">{{ userID }}</h1>
            </el-col>
        </el-row>
        <el-row justify="space-evenly" style="width: 100%;">
            <el-col span="3" style="width: 30%;border-radius: 10px;">
                <div style="background-color: rgb(240,240,240);border-radius: 10px;margin-bottom: 10px;text-align: center;">
                    <h1 style="padding:40px 0;"><img src="../assets/credit-level.svg" style="width:2em" />积分:</h1>
                </div>
            </el-col>
            <el-col span="3" style="width: 30%;">
                <div style="background-color: rgb(240,240,240);border-radius: 10px;margin-bottom: 10px;text-align: center;">
                    <h1 style="padding:40px 0;"><img src="../assets/school.svg" style="width:2em" />大学:</h1>
                </div>
            </el-col>
        </el-row>
    </div>
    <div id="big_box2" style="text-align: center;">
        <el-row style="width:100%" justify="center">
            <el-col v-for="(o, index) in 10" :key="o" :span="24">
                <el-card class="tiezi" shadow="hover" style="border-radius: 20px;">
                    <h3>帖子</h3>
                    <div style="width: 185px;">
                        <img src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"
                            class="image" />
                    </div>
                </el-card>
            </el-col>
        </el-row>
    </div>
</template>

<script lang="ts">
import { defineComponent } from 'vue'
import { computed, ref } from 'vue'
export default defineComponent({
    data() {
        return {
            userAvatar: 'https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png',
            userID: "大家好我是说的道理",
            userSchool: "东北大学秦皇岛分校",
            userEdu: "本科",

        }
    }
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
</style>