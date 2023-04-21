<template>
    <el-descriptions class="margin-top" title="我的信息" :column="1" size="large" border>
        <el-descriptions-item>
            <template #label>
                <div class="cell-item">
                    <el-icon :style="iconStyle">
                        <user />
                    </el-icon>
                    昵称
                </div>
            </template>
            {{ userID }}
        </el-descriptions-item>
        <el-descriptions-item>
            <template #label>
                <div class="cell-item">
                    <el-icon :style="iconStyle">
                        <iphone />
                    </el-icon>
                    电话
                </div>
            </template>
            {{ userPhone }}
        </el-descriptions-item>

        <el-descriptions-item>
            <template #label>
                <div class="cell-item">
                    <el-icon :style="iconStyle">
                        <tickets />
                    </el-icon>
                    学校
                </div>
            </template>
            {{ userSchool }}
        </el-descriptions-item>
        <el-descriptions-item>
            <template #label>
                <div class="cell-item">
                    <el-icon :style="iconStyle">
                        <office-building />
                    </el-icon>
                    邮箱
                </div>
            </template>
            {{ userMail }}
        </el-descriptions-item><el-descriptions-item>
            <template #label>
                <div class="cell-item">
                    <el-icon :style="iconStyle">
                        <office-building />
                    </el-icon>
                    学历
                </div>
            </template>
            <el-tag>{{userEdu}}</el-tag>
        </el-descriptions-item>
    </el-descriptions>
</template>

<script lang="ts">
import { computed, ref } from 'vue'
import { getSessionStorage } from '@/common'
import {
    Iphone,
    Location,
    OfficeBuilding,
    Tickets,
    User,
} from '@element-plus/icons-vue'

const size = ref('')

import { defineComponent } from 'vue'
export default defineComponent({
    data() {
        return {
            userAvatar: 'https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png',
            userID: getSessionStorage("user").nickname,
            userSchool: getSessionStorage("user").sname,
            userPhone: getSessionStorage("user").userPhone,
            userMail: getSessionStorage("user").username,
            userEdu: getSessionStorage("user").dname,
            iconStyle: computed(() => {
                const marginMap = {
                    large: '8px',
                    default: '6px',
                    small: '4px',
                }
                return {
                    marginRight: marginMap.default,
                }
            }),
            blockMargin: computed(() => {
                const marginMap = {
                    large: '32px',
                    default: '28px',
                    small: '24px',
                }
                return {
                    marginTop: marginMap.default,
                }
            })
        }
    }
})
</script>

<style scoped>
.el-descriptions {
    margin-top: 20px;
}

.cell-item {
    display: flex;
    align-items: center;
}

.margin-top {
    margin-top: 20px;
}
</style>
