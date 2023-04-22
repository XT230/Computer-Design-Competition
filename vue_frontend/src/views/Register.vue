<template>
    <div class="common-layout" id="homepage_box">
        <el-container direction="vertical">
            <el-header>
                <h2 id="website_title">心理健康服务平台</h2>
            </el-header>
            <el-container id="down_box">
                <el-main style="overflow:hidden;height:calc(100vh - 60px);text-align: center;">
                    <RouterView>

                    </RouterView>
                </el-main>
            </el-container>
        </el-container>
    </div>
</template>

<script lang="ts">
import { ref, reactive, onMounted } from 'vue'
import router from '@/router'
import type { FormInstance, FormRules } from 'element-plus'
import { defineComponent } from 'vue'
import { RouterView } from 'vue-router'

export default defineComponent({
    setup() {
        onMounted(() => {
            router.push('/register/step1')
        })
        return {
            RouterView
        }
    }
})

</script>

<style scoped>
.el-header {
    background-image: linear-gradient(90deg, #37a9f9 18%, #7340f9 80%);
    color: #333;
    line-height: 60px;
}

#homepage_box {
    width: 100%;
    height: 100vh
}

#down_box {
    height: 100%;
    background-image: linear-gradient(to left bottom, #f985c7, #fd87b5, #fd8ba5, #f99098, #f3968e, #f39e83, #efa87a, #e7b274, #dac46d, #c2d773, #9dea89, #5ffbb0);

}

#website_title {
    padding-left: 20px;
    font-size: 30px;
    font-weight: 700;
    color: #fff;
    float: left;
}

.step {
    background-color: #eff0f400;
}
</style>
