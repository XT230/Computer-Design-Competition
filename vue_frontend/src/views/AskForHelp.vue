<template>
  <div id="big_box">
    <el-row>
      <el-col v-for="(o, index) in 11" :key="o" :span="20">
        <el-card shadow="hover" @click="jumpToAritical">
          <h3>标题🍉</h3>
          <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Quos sapiente tempora architecto debitis dolores
            deserunt, numquam tempore nam amet, aliquam recusandae tenetur consectetur. Explicabo autem dignissimos vitae
            eos architecto nulla!</p>
        </el-card>
      </el-col>
    </el-row>
  </div>
  <el-affix :offset="120" position="bottom" style="position: relative; left: 30px;">
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
    <div style="border: 1px solid #ccc">
      <Toolbar style="border-bottom: 1px solid #ccc" :editor="editorRef" :defaultConfig="toolbarConfig" :mode="mode" />
      <Editor style="height: 300px; overflow-y: hidden;" v-model="valueHtml" :defaultConfig="editorConfig" :mode="mode"
        @onCreated="handleCreated" />
    </div>
    <el-button type="primary" style="float: right; margin-top: 10px;">发布</el-button>
  </el-drawer>
</template>

<script lang="ts">
import { ref } from 'vue'
import { ElMessageBox } from 'element-plus'
import '@wangeditor/editor/dist/css/style.css'
import { defineComponent } from 'vue'
import { onBeforeUnmount, shallowRef, onMounted } from 'vue'
import { Editor, Toolbar } from '@wangeditor/editor-for-vue'
import router from '../router/index.js'
export default defineComponent({
  components: { Editor, Toolbar },
  setup() {
    const drawer = ref(false)
    const direction = ref('btt')
    const editorRef = shallowRef()
    const valueHtml = ref('<p>hello</p>')
    const toolbarConfig = {}
    const editorConfig = { placeholder: '请输入内容...' }
    onMounted(() => {
      setTimeout(() => {
        valueHtml.value = '请输入内容...'
      }, 1500)
    })
    onBeforeUnmount(() => {
      const editor = editorRef.value
      if (editor == null) return
      editor.destroy()
    })
    const handleCreated = (editor: any) => {
      editorRef.value = editor // 记录 editor 实例，重要！
    }
    const jumpToAritical = () => {
      router.push('/mainpage/ReadArtical')
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
      jumpToAritical
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