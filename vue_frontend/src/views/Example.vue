<template>
  <div id="big_box">
    <el-row>
      <el-col v-for="(o, index) in 20" :key="o" :span="20">
        <el-card id="wenzhang" @click="jumpToAritical">
          <div style="height: 200px;">
            <img src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"
              class="image" style="height: 100%;" />
          </div>

          <div style="padding: 1px ">
            <span>Yummy hamburger</span>
            <div class="bottom">
            </div>
          </div>
        </el-card>
      </el-col>
    </el-row>
  </div>
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
  setup() {

    const jumpToAritical = () => {
      router.push('/mainpage/ReadArtical')
    }
    return {

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

.time {
  font-size: 12px;
  color: #999;
}

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


#wenzhang {
  margin-top: 10px;
  margin-bottom: 10px;
  height: 300px;
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