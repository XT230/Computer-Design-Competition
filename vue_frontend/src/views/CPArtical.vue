<template>
  <div id="big_box">
    <el-row style="width: 100%;">
      <el-col v-for="article in articles" :span="20">
        <el-card id="wenzhang">
          <div style="height: 200px;">
            <img src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"
              class="image" style="height: 100%;" />
          </div>

          <div style="padding: 1px ">
            <span>{{ article.title }}</span>
            <div class="bottom">
              <el-button text class="button">Operating</el-button>
            </div>
          </div>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>
  
<script lang="js">
import axios from 'axios'
import { defineComponent, onBeforeMount, onMounted } from 'vue'
import { reactive, toRefs } from "vue";
axios.defaults.baseURL = 'http://114.116.22.152:8088/api/'
export default defineComponent({
  setup() {
    const title = "这是标题"
    const main_part = "这是正文"
    const author = "这是作者"
    const data = reactive({
      articles: []
    })
    axios.get("article/getAll")
      .then((response) => {
        for (let article of response.data) {
          data.articles.push(article)
        }
        console.log(data.articles)
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


#user {
  margin-bottom: 20px;
  height: 400px;
}

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

#wenzhang {
  margin-top: 10px;
  margin-bottom: 10px;
  height: 300px;
}
</style>
  