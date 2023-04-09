<template>
    <div style="padding-left: 20px;padding-right: 20px; padding-top: 20px;">
        <el-row style="margin-bottom: 10px;">
            <el-col :span="4">
                <div>
                    <img :src="userAvatar" class="image" style="width: 150px;" />
                </div>
            </el-col>
            <el-col :span="16">
                <div style="color: white;">
                    <h3>{{ userID }}</h3>
                    <p>学校：{{ userSchool }}</p>
                    <p>学历：{{ userEdu }}</p>
                </div>
            </el-col>
        </el-row>
        <hr>
        <div id="big_box">
            <el-row>
                <el-col v-for="(o, index) in 10" :key="o" :span="20">
                    <el-card class="tiezi" shadow="hover">
                        <h3>帖子</h3>
                        <div style="width: 185px;">
                            <img src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"
                                class="image" />
                        </div>
                    </el-card>
                </el-col>
            </el-row>
        </div>
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
    width: 70%;
    height: 100%;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
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
</style>