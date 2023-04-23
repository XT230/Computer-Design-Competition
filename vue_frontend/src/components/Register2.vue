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
                    <el-checkbox-button style="margin-bottom: 10px;">
                        {{ tag }}
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
import { ref, reactive } from 'vue'
import router from '@/router'
import type { FormInstance, FormRules } from 'element-plus'
import { defineComponent } from 'vue'
import { RouterView } from 'vue-router'

export default defineComponent({
    setup() {
        const tags = ['向晚大魔王', '向晚大魔王', '向晚大魔王', '向晚大魔王', '向晚大魔王', '向晚大魔王', '向晚大魔王', '向晚大魔王', '向晚大魔王',];
        const nextPage = () => {
            router.push('/register/step3')
        }
        return {
            tags,
            nextPage
        };
    },
    components: { RouterView }
})

</script>