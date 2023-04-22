<template>
    <div style="background-color: #ffffe270;">
        <el-steps :active="0" finish-status="success" align-center>
            <el-step title="基本信息" />
            <el-step title="选择标签" />
            <el-step title="完成" />
        </el-steps>
    </div>
    <div style="width: 50vw;margin: 10px auto;">
        <el-card>
            <el-form ref=" ruleFormRef" :model="ruleForm" :rules="rules" label-width="120px" class="demo-ruleForm"
                size=default status-icon>
                <el-form-item label="用户名" prop="name">
                    <el-input v-model="ruleForm.name" />
                </el-form-item>
                <el-form-item label="电子邮箱" prop="email">
                    <el-input v-model="ruleForm.email" />
                </el-form-item>
                <el-form-item label="学校" prop="school">
                    <el-select-v2 v-model="ruleForm.school" placeholder='--请选择--' :options="school" />
                </el-form-item>
                <el-form-item label="生日" required>
                    <el-form-item prop="date1">
                        <el-date-picker v-model="ruleForm.date" type="date" placeholder="Pick a date" style="width: 100%" />
                    </el-form-item>
                </el-form-item>
                <el-form-item label="密码" prop="pass">
                    <el-input v-model="ruleForm.pass" type="password" autocomplete="off" />
                </el-form-item>
                <el-form-item label="确认密码" prop="checkPass">
                    <el-input v-model="ruleForm.checkPass" type="password" autocomplete="off" />
                </el-form-item>
                <el-button type="primary" @click="submitForm(ruleFormRef)">
                    注册
                </el-button>
            </el-form>
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
        const ruleFormRef = ref<FormInstance>();
        const ruleForm = reactive({
            name: "",
            email: "",
            school: "",
            date: "",
            pass: "",
            checkPass: "",
        });
        const rules = reactive<FormRules>({
            name: [
                { required: true, message: "请输入用户名", trigger: "blur" },
                { min: 3, max: 20, message: "长度在2到20个字符之间", trigger: "blur" },
            ],
            email: [
                {
                    required: true,
                    message: "请输入电子邮箱",
                    trigger: "blur",
                },
            ],
            school: [
                {
                    required: true,
                    message: "请选择学校",
                    trigger: "blur",
                },
            ],
            date: [
                {
                    type: "date",
                    required: true,
                    message: "Please pick a date",
                    trigger: "change",
                },
            ],
            pass: [
                {
                    required: true,
                    message: "请输入密码",
                    trigger: "blur",
                },
            ],
            checkPass: [
                {
                    required: true,
                    message: "请再次输入密码",
                    trigger: "blur",
                },
                {
                    validator: (rule, value, callback) => {
                        if (value === "") {
                            callback(new Error("请再次输入密码"));
                        }
                        else if (value !== ruleForm.pass) {
                            callback(new Error("两次输入密码不一致!"));
                        }
                        else {
                            callback();
                        }
                    },
                    trigger: "blur",
                },
            ],
        });
        const submitForm = async (formEl: FormInstance | undefined) => {

            router.push('/register/setp2')

        };
        const school = Array.from({ length: 10000 }).map((_, idx) => ({
            value: `${idx + 1}`,
            label: `${idx + 1}`,
        }));
        return {
            ruleFormRef,
            ruleForm,
            rules,
            submitForm,
            school,
        };
    },
    components: { RouterView }
})

</script>