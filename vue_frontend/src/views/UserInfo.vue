<template>
    <div id="big_box">
        <el-row justify="space-evenly" style="width: 100%; padding-top: 10px;">
            <el-col span="3">
                <el-avatar :size="150" :src="userAvatar"></el-avatar>
            </el-col>
            <el-col span="3">
                <h1 style="padding:70px 0;">{{ userID }}</h1>
            </el-col>
        </el-row>
        <el-row justify="space-evenly" style="width: 100%;">
            <el-col span="3" style="width: 30%;border-radius: 10px;">
                <div style="background-color: rgb(240,240,240);border-radius: 10px;margin-bottom: 10px;">

                    <h1 style="padding:40px 0;">积分</h1>
                </div>
            </el-col>
            <el-col span="3" style="width: 30%;">
                <div style="background-color: rgb(240,240,240);border-radius: 10px;margin-bottom: 10px;">
                    <h1 style="padding:40px 0;">大学</h1>
                </div>
            </el-col>
            <el-col span="3" style="width: 30%;">
                <div style="background-color: rgb(240,240,240);border-radius: 10px;margin-bottom: 10px;">
                    <h1 style="padding:40px 0;">我的消息</h1>

                </div>
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
</style>
