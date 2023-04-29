<template>
    <div style="background-color: #ffffe270;border-radius: 20px;padding-top: 10px;">
        <el-steps :active="1" finish-status="success" align-center>
            <el-step title="基本信息" />
            <el-step title="选择标签" />
            <el-step title="完成" />
        </el-steps>
    </div>
    <div style="width: 40vw;margin: 10px auto;">
        <el-card style="border-radius: 20px;">
            <h1 style="margin-bottom: 10px;">请选择你的标签</h1>
            <el-row>
                <el-col style="text-align: left;" :span="24">
                    <h4 style="margin-bottom: 10px;margin-left: 30px;">学历</h4>
                </el-col>
                <el-col v-for="tag in tags1" :key="tag" :span="8">
                    <el-checkbox-button v-model="tag.isSelected" style="margin-bottom: 10px;">
                        {{ tag.tname }}
                    </el-checkbox-button>
                </el-col>
                <el-col style="text-align: left;" :span="24">
                    <h4 style="margin-bottom: 10px;margin-left: 30px;">性格</h4>
                </el-col>
                <el-col v-for="tag in tags2" :key="tag" :span="8">
                    <el-checkbox-button v-model="tag.isSelected" style="margin-bottom: 10px;">
                        {{ tag.tname }}
                    </el-checkbox-button>
                </el-col>
            </el-row>
            <el-button type="success" @click="nextPage" style="width: 80px;">
                确认
            </el-button>
        </el-card>
    </div>
</template>

<script lang="ts">
import { toRefs, reactive } from 'vue'
import router from '@/router'
import { tagEmits, type FormInstance, type FormRules } from 'element-plus'
import { defineComponent } from 'vue'
import { RouterView } from 'vue-router'
import type { Tag } from '@/common'
import { getLocalStorage } from '@/common'
import axios from 'axios'

export default defineComponent({
    setup() {
        const tags1 = reactive([
            {
                isSelected: false,
                tname: "小学"
            },
            {
                isSelected: false,
                tname: "初中"
            },
            {
                isSelected: false,
                tname: "高中"
            },
            {
                isSelected: false,
                tname: "大学"
            },
            {
                isSelected: false,
                tname: "硕士"
            },
            {
                isSelected: false,
                tname: "博士"
            },
        ])
        const tags2 = reactive(
            [
                {
                    isSelected: false,
                    tname: "外向"
                },
                {
                    isSelected: false,
                    tname: "开朗"
                },
                {
                    isSelected: false,
                    tname: "沉稳"
                },
                {
                    isSelected: false,
                    tname: "乐观"
                },
                {
                    isSelected: false,
                    tname: "内向"
                },
                {
                    isSelected: false,
                    tname: "严谨"
                },
                {
                    isSelected: false,
                    tname: "悲观"
                },
                {
                    isSelected: false,
                    tname: "孤僻"
                },
                {
                    isSelected: false,
                    tname: "热情"
                },
                {
                    isSelected: false,
                    tname: "活泼"
                },
                {
                    isSelected: false,
                    tname: "冷静"
                },
                {
                    isSelected: false,
                    tname: "冲动"
                },
                {
                    isSelected: false,
                    tname: "多疑"
                },
                {
                    isSelected: false,
                    tname: "偏激"
                },
                {
                    isSelected: false,
                    tname: "严肃"
                },
                {
                    isSelected: false,
                    tname: "不安分"
                },
                {
                    isSelected: false,
                    tname: "谦虚"
                }
                ,
                {
                    isSelected: false,
                    tname: "敏感"
                },
                {
                    isSelected: false,
                    tname: "善解人意"
                },
                {
                    isSelected: false,
                    tname: "博爱"
                },
                {
                    isSelected: false,
                    tname: "友善"
                }
            ]
        )
        // const data = reactive({
        //     tags: new Array<Tag>()
        // })
        // axios.get("tag/getAllTags")
        //     .then((response) => {
        //         for(let tag of response.data)
        //         {
        //             data.tags.push({tname: tag.tname, isSelected: false})
        //         }
        //     })
        const nextPage = () => {
            let user = getLocalStorage("user")
            router.push("/register/step3")
            // for (let tag of data.tags) {
            //     if (tag.isSelected) {
            //         user.prefGenres.push(tag.tname)
            //     }
            // }
            // axios.post("user/register", user)
            //     .then((response) => {
            //         let user = response.data
            //         if (user.uid == 0) alert("注册失败")
            //         else router.push("/register/step3")
            //     })
        }
        return {
            nextPage,
            tags1,
            tags2,
            // ...toRefs(data)
        };
    },
    components: { RouterView }
})

</script>