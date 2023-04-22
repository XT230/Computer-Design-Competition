<template>
    <div id="big_box">
        <div id="title">
            <h1>{{ article.title }}</h1>
            <h6>{{ authorName }}</h6>
        </div>
        <div>
            <div id="main_part" v-html="article.content">
            </div>
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
        axios.get("article/getArticleByAid?aid=" + route.query.aid)
            .then((response) => {
                data.article = response.data
                axios.get("user/getUserByUid?uid=" + data.article.uid)
                    .then((response) => {
                        data.authorName = response.data.username
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
    border-radius: 10px;
    margin-top: 5px;
}
</style>