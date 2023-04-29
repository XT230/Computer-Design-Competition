<template>
  <div id="big_box">
    <el-row style="width: 100%;">
      <el-col v-for="(article, index) in articles" :span="20">
        <el-card shadow="hover" @click="jumpToAFHContain(article.aid)" style="border-radius: 20px;">
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
    const articles = [
      {
        title: '当我开始努力了，我身边的朋友会不会消失？',
        content: '我现在是个浑浑噩噩度日,每天不知道自己想做什么,也不知道自己想要什么的人,现在我的朋友们也和我一样,对未来很迷茫,可是有一天,如果我突然想清楚了自己想要做什么,并且为之努力,很努力很努力,我担心,我和我的这些朋友,会不会没有办法经常聊天,会不会对生活的观念不同.会不会不再是朋友',
        aid: 1,
      },
      {
        title: '如何改变“我不行”的潜意识核心信念？',
        content: '我每次遇到事情都会退缩，我本意也不想放弃和退缩，但是每次一遇到要做点什么事脑海就会把它想的很困难，即是是很容易的事情，我也会把它想的很难，自己不行，自己完不成，总是控制不住自己这样想，简而言之就是没自信，怎么能克服这个问题，谁能解答一下',
        aid: 2,
      }
      ,
      {
        title: '如很清楚读书的重要性，为什么不想去学校？',
        content: '我是很清楚读书的重要性的，但在某些时候我就忘记了，满脑子都是不想上学，别人告诉我读书很重要我也无法接受，感觉很痛苦，是凌迟。我一般都是回学校之前说不想读书的，那个时候我作业没写完还要补；或者是被老师批评了，觉得自己很失败，很难过烦躁，谁再也不想读书了。我原本以为自己是因为作业没写完的罪恶感和补作业时的烦躁导致自己不想回学校，但好像又不是，我平时一些时候也会没写完作业，但我会选择在路上补完或者回学校再补，而不是不去学校。有两次是作业没写完，再加上父母在催我去上学，然后不想去，一直拖着，过了一会还是回去上学了；有一次是被老师批评了，再加上拖堂，赶不上公交了，我很崩溃很讨厌老师学校，又不想去。最后一次差不多也是作业没写完，在拼命补作业，爸妈在催，然后不想坐公交回学校，然后突然崩溃了，这次就休学了。当然休学不是因为这个。',
        aid: 2,
      },
      {
        title: '高二，感觉状态很糟糕，分班后一直闷闷不乐，怎么办？',
        content: '原本高一还挺正常的，自从高二重新分班以后，我似乎就一直闷闷不乐，很矛盾：,自我封闭不想和生人交往，但是又多愁善感，害怕被孤立；,明白想要保持好成绩就得多花时间学习，但就是不想努力，力不从心，讨厌被迫功利；,看到好友不断进步，甚至超过自己时，内心非常受打击，日渐颓废，振作不起来，越来越自卑；,想要专心学习，但是和原生家庭的矛盾总是烦扰我的内心，每次家庭有关的事出现在我脑海中，我就“万念俱灰”，父母的期望让我压力很大，难以缓解，我也想坦然,对暂时的失利，但是我做不到，我害怕被责备。（我对家庭的厌恶一直驱散不开，只是期望高三少回家，远离家庭）,回过神来感觉自己已经忘记了努力的方式，忘记了关于自己的很多事情，甚至会惊讶自己像变了个人似的，变得迟钝和懒惰，很迷茫。我觉得难过，但是我发泄不了。,很快就要到高三了，我的学习状态和心态还是很混乱，请问我该怎么克服这些问题？',
        aid: 2,
      },
      {
        title: '我不知道一个男生为什么要这么做，不达目的不罢休？',
        content: '一开始是互有好感。他故意用我的号带女生（号应该是他买的），我忍不住骂了他，他就好几天没回消息。但还是坚持不懈带女号，后来一系列操作（比如发自己去外地了的朋友圈）也是想引我去找他。最后我揭穿了他，他就把我拉黑了。后来他还是坚持不懈用类似的方式引我上钩，如果没有达成目的（可能是确认恋爱关系）就把我拉黑了。过了一段时间，他换个方式，用朋友微信加我。我揭穿是他，他就约我跟他朋友见面，目的可能是想让我相信这个人不是他。如果不成功他又会换一个人。我猜想他是不是在用欲擒故纵。目前为止有5个人，他用别人微信扮演5种性格试图让我相信不是他。（脾气时好时坏）但是第二个很奇怪，他跟我透露是他，来接我的却是他朋友，所以还没进电影院我就走了。他进了我在的群里，我估计是他很多朋友在这个群所以他知道。但是我加他，他就不理睬我。他还让很多人去看我游戏主页，我有种被监视的感觉。我既好奇又害怕，不明白他想干什么。',
        aid: 2,
      },
      {
        title: '经常神经异常，继续学习心理学科知识有什么好处？',
        content: '曾经精神异常，过的摇摇欲坠,再后来学习心理学知识改善自己并且参加自考学了心理健康教育专业，过7门了,做营业员的工作，月入6000,本来憧憬自考本科毕业后再考研进入理想的高校，因为不知道何时学习对我来说并不困难了，可这些憧憬缺被生活磨灭了,我一边感叹人类文明的伟大一边憎恶着世界,毕业接近两年了,从到处表现自己是好人的善男信女到冷漠的遵守规则玩家,意识到世界残酷并只能依靠自己后，惊叹愤怒到平静,父母亲人朋友同事公司社会，从任性敏感的玻璃心到终于和睦相处，和气生财,更多时候感到的是悲哀,是的，人类社会比自然界、过去时代也好太多,可是，当我看到精神或身体出现意外与疾病人遭遇的时候,见到的是有限的善意,我想自私。健康，钱，物质，快乐就好。,但这些真的对吗,讽刺的是我在考试还写：要建立正确，普通，宽广，成熟，科学，客观的世界观,可是全面终身学习观告诉我不对,应该学习吗，如果学要学哪些知识呢？',
        aid: 2,
      },
      {
        title: '为什么我对普通朋友关系的女性就可以侃侃而谈大大方方',
        content: '我对普通朋友关系的女性就可以侃侃而谈大大方方比如同事一起玩游戏的女型朋友，但是一但我想更进一步时候我就会畏手畏脚，没有话题。我和一起玩游戏的女性朋友说我的这个情况后她们都说我和她们怎么聊天的，意思就是我不是不会聊。只是唉也不知道怎么说。',
        aid: 2,
      },
      {
        title: '孩子喜欢随意拿别人东西，怎么改掉孩子的坏习惯？',
        content: '丸子10周岁又两个月，父母离异所以两边跑，孩子最近看到同学好看的文具会顺回家，然后被发现后会撒谎不承认，甚至编理由骗过大人。昨天交谈后，还说拿人家东西的时候心里不会紧张。就是看到喜欢的会忍不住想拿。孩子很聪明平时很不专注学习，遇到问题会编造各种理由，想知道她为何会如此。拿同学的文具不止一次，每次都保证是最后一次。她告诉我就是喜欢，看到喜欢的就想拿，从小到大孩子都比较好动，很难像大多数女孩子那样安安静静，8周岁后?️一些改善，专业机构测评没有多动症，这样是导致学习与日常各项事宜不专注的诱因吗？性格方面还是活泼开朗，就是说话不老实，有时候是为了让你开心，有时候是逃避责任。不想孩子一直这样不诚实，又不懂怎么办好。很苦恼',
        aid: 2,
      },
    ]

    // const data = reactive({
    //   articles: new Array<Article>
    // })
    onMounted(() => {
      setTimeout(() => {
        valueHtml.value = ''
      }, 1500)
      // axios.get("article/getArticlesByType?type=2")
      //   .then((response) => {
      //     for (let article of response.data) {
      //       data.articles.push(article)
      //     }
      //     console.log(data.articles)
      //   })
      //   .catch((error) => {
      //     console.log(error)
      //   })
    })
    onBeforeUnmount(() => {
      const editor = editorRef.value
      if (editor == null) return
      editor.destroy()
    })
    const handleCreated = (editor: any) => {
      editorRef.value = editor // 记录 editor 实例，重要！
    }
    const jumpToAFHContain = (aid: number) => {
      router.push('/mainpage/AFHContain')
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
      jumpToAFHContain,
      publish,
      // ...toRefs(data),
      articles,
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