<template>
    <div id="big_box">
        <div id="title" style="width: 70%; text-align: center;">
            <p style="font-size: 40px; padding-top: 10px; font-family: '楷体','楷体_GB2312';">{{ article.title }}</p>
            <div style="padding-top: 5px;width: 200px; margin: 10px auto; text-align: center;">
                <el-row style="width:100%;">
                    <el-col :span="24">
                        <img src="../tmp/头像.jpeg" class="image" style="height: 60px;border-radius: 50%; " />
                    </el-col>
                    <el-col :span="24">
                        <p style=" ">{{ authorName }}</p>
                    </el-col>
                </el-row>
            </div>
        </div>
        <hr style="width: 90%; margin-top: 10px; margin-bottom: 20px; border: 1px solid rgb(226 226 226); " />
        <div v-html="article.content" style="padding: 10px 100px;"></div>
    </div>
    <div id="big_box2" style="text-align:center;">
        <div style="text-align: left; margin-left: 10px;">
            <p style="font-size: 20px;">评论</p>
        </div>

        <hr style="width: 90%; margin: 20px 20px; border: 1px solid rgb(226 226 226); " />
        <el-row style="width:100%" justify="center">
            <el-col v-for="(o, index) in 10" :key="o" :span="22">
                <el-row style="width: 100%;">
                    <el-col :span="2">
                        <img src="../tmp/头像.jpeg" class="image" style="height: 40px; float: left;border-radius: 50%;" />
                    </el-col>
                    <el-col :span="21">
                        <p style="font-size: 18px;float: left;">用户名</p>
                    </el-col>
                    <p style="margin-left: 60px; padding-right: 60px;text-align:left;">
                        向晚最强向晚最强向晚最强向晚最强向晚最强向晚最强向晚最强向晚最强向晚最强向晚最强向晚最强向晚最强向晚最强
                    </p>
                </el-row>
                <hr style="width: 90%; margin-top: 10px; margin-bottom: 20px; border: 1px solid rgb(226 226 226); " />
            </el-col>
        </el-row>
        <div style="display:flex; justify-content:center; align-items:center;margin-bottom: 50px;">
            <el-input v-model="textarea1" autosize type="textarea" placeholder="发表你的评论" style="width: 70%;" />
            <el-button type="primary" style="float: right; margin-right: 20px; width: 60px;">提交</el-button>
        </div>

    </div>
</template>

<script lang="ts">
import axios from 'axios'
import { defineComponent } from 'vue'
import { useRoute } from 'vue-router'
import { httpURL } from '@/common'
import { reactive, toRefs } from "vue";
import { Article } from '@/common'
import { ref } from 'vue'
axios.defaults.baseURL = httpURL
export default defineComponent({
    setup() {
        const title = "这是标题"
        const main_part = "这是正文"
        const author = "这是作者"
        const route = useRoute()
        const data = reactive({
            article: new Article(),
            authorName: ''
        })
        const textarea1 = ref('')
        axios.get("article/getArticleByAid?aid=" + route.query.aid)
            .then((response) => {
                data.article = response.data
                axios.get("user/getUserByUid?uid=" + data.article.uid)
                    .then((response) => {
                        data.authorName = response.data.nickname
                    })
                    .catch((error) => {
                        console.log(error)
                    })
            })
            .catch((error) => {
                console.log(error)
            })
        return {
            title,
            main_part,
            author,
            textarea1,
            ...toRefs(data)
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
    background-color: white;
    color: black;
    border-radius: 20px;
    margin-top: 5px;
}

#big_box2 {
    width: 70%;
    height: 100%;
    display: flex;
    background-color: white;
    color: black;
    flex-direction: column;
    border-radius: 20px;
    margin-top: 10px;
    margin-left: auto;
    margin-right: auto;
}
</style>