<template>
  <div>
    <el-menu class="el-menu-demo" mode="horizontal" background-color="rgba(255, 255, 255, 0)"
      style="border-radius:20px 0 0 0" router>
      <el-menu-item index="/mainpage/CareerPlanning/CPArtical">推荐文章</el-menu-item>
      <el-menu-item index="/mainpage/CareerPlanning/CPUser">推荐答主</el-menu-item>
    </el-menu>
    <div
      style="color: black; padding-bottom: 5px; background-image: linear-gradient(90deg, #ffffff7f 40%, #ffffff00 60%);border-radius:0 0 0 20px;padding-left: 20px; "
      id="select">
      <el-input v-model="input" placeholder="Please input" class="input-with-select" style="width: 40%;">
        <template #prepend>
          <el-button :icon="Search" />
        </template>
      </el-input>
      <el-cascader v-model="value" :options="options" :props="props" @change="handleChange" />
    </div>
  </div>
  <div style="padding-left: 20px;padding-right: 20px;">
    <!-- <el-scrollbar style="height: calc(100vh - 117.6px - 32px );"> -->
    <el-scrollbar style="height: calc(100vh - 80px - 57.6px - 37px );">
      <RouterView />
    </el-scrollbar>

  </div>
</template>

<script lang="ts" >
import { ref } from 'vue'
import { RouterLink, RouterView } from 'vue-router'
import { Search } from '@element-plus/icons-vue'
import { defineComponent } from 'vue'
import router from '../router/index.js'
import Vue from 'vue'
export default defineComponent({
  setup() {
    const value = ref('')
    const input = ref('')
    const props = {
      expandTrigger: 'hover' as const,
    }
    const handleChange = (value: any) => {
      console.log(value)
    }
    const options = [
      {
        value: '人际交往',
        label: '人际交往',
      },
      {
        value: '学业压力',
        label: '学业压力',
        children: [
          {
            value: '高中',
            label: '高中',
            children: [
              {
                value: '语文',
                label: '语文',
              },
              {
                value: '数学',
                label: '数学',
              },
              {
                value: '英语',
                label: '英语',
              },
              {
                value: '物理',
                label: '物理',
              },
              {
                value: '化学',
                label: '化学',
              },
              {
                value: '地理',
                label: '地理',
              },
              {
                value: '生物',
                label: '生物',
              }, {
                value: '历史',
                label: '历史',
              },
              {
                value: '政治',
                label: '政治',
              },
            ],
          },
          {
            value: '初中',
            label: '初中',
            children: [
              {
                value: '语文',
                label: '语文',
              },
              {
                value: '数学',
                label: '数学',
              },
              {
                value: '英语',
                label: '英语',
              },
              {
                value: '物理',
                label: '物理',
              },
              {
                value: '化学',
                label: '化学',
              },
              {
                value: '地理',
                label: '地理',
              },
              {
                value: '生物',
                label: '生物',
              }, {
                value: '历史',
                label: '历史',
              },
              {
                value: '政治',
                label: '政治',
              },
            ],
          },
          {
            value: '小学',
            label: '小学',
            children: [
              {
                value: '语文',
                label: '语文',
              },
              {
                value: '数学',
                label: '数学',
              },
              {
                value: '英语',
                label: '英语',
              },
            ],
          },
        ],
      },

    ]
    return {
      options,
      props,
      value,
      handleChange,
      Search,
      input,
    }
  }
})
</script>

<style scoped >
.el-menu-demo {
  background-image: linear-gradient(90deg, #ffffff7f 40%, #ffffff00 60%);
}

.el-menu--horizontal {
  border-bottom: solid 0px;
}

.el-menu--popup {
  padding: 0px;
}

.input-with-select .el-input-group__prepend {
  background-color: var(--el-fill-color-blank);
}

.input-with-select .el-input-group__append {
  background-color: var(--el-fill-color-blank);
  padding: 0 0;
}
</style>
