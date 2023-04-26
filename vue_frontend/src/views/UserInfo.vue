<template>
    <div id="big_box" style="text-align: center; border-radius: 20px;">
        <el-row style="width: 60%; padding-top: 10px;">
            <el-col span="8">
                <img src="../tmp/头像.jpeg" class="image" style="height: 150px; border-radius: 50%;">
            </el-col>
            <el-col span="16">
                <h1 style="padding:70px 20px;">{{ userID }}</h1>
            </el-col>
        </el-row>
        <el-row justify="space-evenly" style="width: 100%;">
            <el-col span="3" style="width: 30%;border-radius: 10px;">
                <div style="background-color: rgb(245,245,245);border-radius: 10px;margin-bottom: 10px;text-align: center;">
                    <div style="padding:30px 0;">
                        <p>
                            <img src="../assets/credit-level.svg" style="width:2em ;" />
                        <h1>积分:78</h1>
                        </p>

                    </div>
                </div>
            </el-col>
            <el-col span="3" style="width: 30%;">
                <div style="background-color: rgb(245,245,245);border-radius: 10px;margin-bottom: 10px;text-align: center;">
                    <div style="padding:30px 0;">
                        <p>
                            <img src="../assets/school.svg" style="width:2em ;" />
                        <h1>学校:东北大学秦皇岛分校</h1>
                        </p>

                    </div>
                </div>
            </el-col>
            <el-col span="3" style="width: 30%;">
                <div style="background-color: rgb(245,245,245);border-radius: 10px;margin-bottom: 10px;text-align: center;">
                    <div style="padding:30px 0;">
                        <p>
                            <img src="../assets/message.svg" style="width:2em ;" />
                        <h1>消息:1</h1>
                        </p>

                    </div>
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
import { computed, ref } from 'vue'
import { getSessionStorage } from '@/common'
import {
    Iphone,
    Location,
    OfficeBuilding,
    Tickets,
    User,
} from '@element-plus/icons-vue'

const size = ref('')

import { defineComponent } from 'vue'
export default defineComponent({
    data() {
        return {
            userAvatar: 'https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png',
            userID: getSessionStorage("user").nickname,
            userSchool: getSessionStorage("user").sname,
            userPhone: getSessionStorage("user").userPhone,
            userMail: getSessionStorage("user").username,
            userEdu: getSessionStorage("user").dname,
            iconStyle: computed(() => {
                const marginMap = {
                    large: '8px',
                    default: '6px',
                    small: '4px',
                }
                return {
                    marginRight: marginMap.default,
                }
            }),
            blockMargin: computed(() => {
                const marginMap = {
                    large: '32px',
                    default: '28px',
                    small: '24px',
                }
                return {
                    marginTop: marginMap.default,
                }
            })
        }
    }
})
</script>

<style scoped>
#big_box {
    width: 70%;
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

#big_box2 {
    width: 70%;
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

div>img {
    width: 100%;
    display: block;
}

.tiezi {
    margin-top: 10px;
    margin-bottom: 10px;
    height: 245px;
}
</style>
