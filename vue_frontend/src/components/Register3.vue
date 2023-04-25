<template>
    <div style="background-color: #ffffe270;">
        <el-steps :active="2" finish-status="success" align-center>
            <el-step title="基本信息" />
            <el-step title="选择标签" />
            <el-step title="完成" />
        </el-steps>
    </div>
    <div style="width: 50vw;margin: 10px auto;">
        <el-card>
            <el-result icon="success" title="您已经成功注册" sub-title="请单击下方按钮登录">
                <template #extra>
                    <el-button type="primary" @click="toLogin">去登录</el-button>
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
        function toLogin()
        {
            router.push("/")
        }
        return {
            toLogin
        }
    }
})

</script>