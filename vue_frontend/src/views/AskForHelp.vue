<template>
  <div id="big_box">
    <el-row style="width: 100%;">
      <el-col v-for="(article, index) in articles" :span="20">
        <el-card shadow="hover" @click="jumpToAritical(article.aid)">
          <h3>{{ article.title }}</h3>
          <div v-html="article.content"></div>
        </el-card>
      </el-col>
    </el-row>
  </div>
  <el-affix :offset="60" position="bottom" style="position: absolute; right: 5%; bottom: 10%;">
    <div style="border-radius:30px;background-color: white; width: 60px; height: 60px;" @click="drawer = true">
      <svg t="1681884570963" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg"
        p-id="2619" width="50" height="50" style="padding-left: 5px;padding-top: 5px;">
        <path
          d="M127.32 674A418.8 418.8 0 1 0 94.5 511.5 416.31 416.31 0 0 0 127.32 674zM512 134c208.15 0 377.5 169.35 377.5 377.5S720.15 889 512 889 134.5 719.65 134.5 511.5 303.85 134 512 134z"
          fill="#068BFA" p-id="2620"></path>
        <path
          d="M532 531.5h161a20 20 0 0 0 0-40H532v-161a20 20 0 0 0-40 0v161H331a20 20 0 0 0 0 40h161v161a20 20 0 0 0 40 0z"
          fill="#068BFA" p-id="2621"></path>
      </svg>
    </div>
  </el-affix>
  <el-drawer v-model="drawer" title="帖子发表" :direction="direction" size="70%">
    <input style="width: 100%;height: 40px; margin-bottom: 10px; border-radius: 3px;" value=请键入标题>
    <div style="border: 1px solid #ccc;height: 70%;">
      <Toolbar style="border-bottom: 1px solid #ccc" :editor="editorRef" :defaultConfig="toolbarConfig" :mode="mode" />
      <Editor style="height: 80%; overflow-y: hidden;" v-model="valueHtml" :defaultConfig="editorConfig" :mode="mode"
        @onCreated="handleCreated" />
    </div>
    <div>
      <span style="float: left; margin-top: 10px;color: black;">标签：</span>
      <div v-for="tag in tags" style="float: left;margin-top: 10px;">
        <el-checkbox-button style="margin-bottom: 10px;">
          {{ tag }}
        </el-checkbox-button>
      </div>
    </div>
    <el-button @click="publish" type="primary" style="float: right; margin-top: 10px;">发布</el-button>
  </el-drawer>
</template>

<script lang="ts">
import axios from 'axios'
import { ref } from 'vue'
import { ElMessageBox } from 'element-plus'
import '@wangeditor/editor/dist/css/style.css'
import { defineComponent } from 'vue'
import { onBeforeUnmount, shallowRef, onMounted } from 'vue'
import { Editor, Toolbar } from '@wangeditor/editor-for-vue'
import router from '../router/index.js'
import { reactive, toRefs } from "vue";
import type { Article } from '@/common'
import { httpURL } from '@/common'
axios.defaults.baseURL = httpURL;
export default defineComponent({
  components: { Editor, Toolbar },
  setup() {
    const drawer = ref(false)
    const direction = ref('btt')
    const editorRef = shallowRef()
    const valueHtml = ref('')
    const toolbarConfig = {}
    const tags = ['校园', '生活', '学习', '娱乐', '其他']
    const editorConfig = { placeholder: '请输入内容...' }
    const data = reactive({
      articles: new Array<Article>
    })
    onMounted(() => {
      setTimeout(() => {
        valueHtml.value = ''
      }, 1500)
      axios.get("article/getArticlesByType?type=2")
        .then((response) => {
          for (let article of response.data) {
            data.articles.push(article)
          }
          console.log(data.articles)
        })
        .catch((error) => {
          console.log(error)
        })
    })
    onBeforeUnmount(() => {
      const editor = editorRef.value
      if (editor == null) return
      editor.destroy()
    })
    const handleCreated = (editor: any) => {
      editorRef.value = editor // 记录 editor 实例，重要！
    }
    const jumpToAritical = (aid: number) => {
      router.push({
        path: '/mainpage/ReadArtical',
        query: {
          aid: aid
        }
      })
    }
    function publish() {
      console.log(editorRef.value.getHtml());
    }
    return {
      drawer,
      mode: 'default',
      direction,
      editorRef,
      valueHtml,
      toolbarConfig,
      editorConfig,
      handleCreated,
      jumpToAritical,
      publish,
      ...toRefs(data),
      tags
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
  padding-left: 20px;
  padding-right: 20px;
  padding-top: 20px;
}

.el-card {
  margin-top: 10px;
  margin-bottom: 10px;
  height: 150px;
}

#editor—wrapper {
  border: 1px solid #ccc;
  z-index: 100;
  /* 按需定义 */
}

#toolbar-container {
  border-bottom: 1px solid #ccc;
}
</style>

<link href="https://unpkg.com/@wangeditor/editor@latest/dist/css/style.css" rel="stylesheet">