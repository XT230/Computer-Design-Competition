<template>
    <div style="background-color: #ffffe270;">
        <el-steps :active="1" finish-status="success" align-center>
            <el-step title="基本信息" />
            <el-step title="选择标签" />
            <el-step title="完成" />
        </el-steps>
    </div>
    <div style="width: 40vw;margin: 10px auto;">
        <el-card>
            <h1 style="margin-bottom: 10px;">请选择你的标签</h1>
            <el-row>
                <el-col v-for="tag in tags" :key="tag" :span="8">
                    <el-checkbox-button v-model="tag.isSelected" style="margin-bottom: 10px;">
                        {{ tag.tname }}
                    </el-checkbox-button>
                </el-col>
            </el-row>
            <el-button type="primary" @click="nextPage">
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
        const data = reactive({
            tags: new Array<Tag>()
        })
        axios.get("tag/getAllTags")
            .then((response) => {
                for(let tag of response.data)
                {
                    data.tags.push({tname: tag.tname, isSelected: false})
                }
            })
        const nextPage = () => {
            let user = getLocalStorage("user")
            for(let tag of data.tags)
            {
                if(tag.isSelected)
                {
                    user.prefGenres.push(tag.tname)
                }
            }
            axios.post("user/register", user)
                .then((response) => {
                    let user = response.data
                    if(user.uid == 0)alert("注册失败")
                    else router.push("/register/step3")
                })
        }
        return {
            nextPage,
            ...toRefs(data)
        };
    },
    components: { RouterView }
})

</script>