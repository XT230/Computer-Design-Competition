<template>
    <div style="background-color: #ffffe270;border-radius: 20px;padding-top: 10px;">
        <el-steps :active="2" finish-status="success" align-center>
            <el-step title="基本信息" />
            <el-step title="选择标签" />
            <el-step title="完成" />
        </el-steps>
    </div>
    <div style="width: 50vw;margin: 10px auto;">
        <el-card style="border-radius: 20px;">

            <el-result icon="success" title="您已经成功注册" sub-title="请单击下方按钮登录">
                <template #extra>
                    <el-button type="success" @click="toLogin" style="width: 80px;">去登录</el-button>
                </template>
            </el-result>
        </el-card>
    </div>
</template>

<script lang="ts">
import { ref, reactive } from 'vue'
import router from '@/router'
import type { FormInstance, FormRules } from 'element-plus'
import { defineComponent } from 'vue'


export default defineComponent({
    setup() {
        function toLogin() {
            router.push("/")
        }
        return {
            toLogin
        }
    }
})

</script>