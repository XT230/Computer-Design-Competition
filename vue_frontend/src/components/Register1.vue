<template>
    <div style="background-color: #ffffe270;border-radius: 20px;padding-top: 10px;">
        <el-steps :active="0" finish-status="success" align-center>
            <el-step title="基本信息" />
            <el-step title="选择标签" />
            <el-step title="完成" />
        </el-steps>
    </div>
    <div style="width: 40vw;margin: 10px auto;">
        <el-card style="border-radius: 20px;">
            <el-form ref=" ruleFormRef" :model="ruleForm" :rules="rules" label-width="120px" class="demo-ruleForm"
                size=default status-icon>
                <el-form-item label="用户名" prop="name">
                    <el-input v-model="ruleForm.name" />
                </el-form-item>
                <el-form-item label="电子邮箱" prop="email">
                    <el-input v-model="ruleForm.email" />
                </el-form-item>
                <el-form-item label="学校" prop="school">
                    <el-select-v2 v-model="ruleForm.school" placeholder='--请选择--' :options="ruleForm.schools" />
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
                <el-button type="success" @click="submitForm(ruleFormRef)" style="width: 80px;">
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
import axios from 'axios'
import type { School } from '@/common'
import { setLocalStorage } from '@/common'

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
            schools: new Array<School>()
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
            setLocalStorage('user', {
                username: ruleForm.email,
                nickname: ruleForm.name,
                userPhone: '',
                password: ruleForm.pass,
                sid: 1,
                did: 1,
                first: true,
                prefGenres: new Array<string>()
            })
            router.push('/register/step2')

        };
        axios.get("school/getAllSchools")
            .then((response) => {
                let data = response.data;
                for (let school of data) {
                    ruleForm.schools.push({
                        value: school.sid,
                        label: school.sname
                    })
                }
            })
        return {
            ruleFormRef,
            ruleForm,
            rules,
            submitForm,
        };
    },
    components: { RouterView }
})

</script>