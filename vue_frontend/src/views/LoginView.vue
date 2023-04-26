<template>
    <div class="wrapper">
        <div>
            <el-card id="intro">
                <div v-for="o in 4" :key="o" class="text item">对品台的一些介绍</div>
            </el-card>
        </div>
        <div class="container">
            <div class="drop">
                <div class="content">
                    <h2>账号登录</h2>
                    <form>
                        <div class="inputBox">
                            <img src="../assets/username.svg" style="width:1.5em;margin-left: 8px;" />
                            <i class="fa fa-user-o"></i>
                            <input type="text" v-model="user.username" placeholder="用户名">
                        </div>
                        <div class="inputBox">
                            <img src="../assets/password.svg" style="width:1.5em;margin-left: 8px;" />
                            <i class="fa fa-lock"></i>
                            <input type="password" v-model="user.password" placeholder="密码">
                        </div>
                        <div class="inputBox">
                            <input type="button" value="登录" @click="login">
                        </div>
                    </form>
                </div>
            </div>
            <a href="#" class="btns">忘记密码</a>
            <a href="#" class="btns signup">注册</a>
        </div>
    </div>
</template>

<script lang="ts">
import { reactive, toRefs } from 'vue'
import { useRouter } from 'vue-router'
import { setSessionStorage } from '@/common'
import axios from 'axios'
import { httpURL } from '@/common'
axios.defaults.baseURL = httpURL;

export default
    {
        setup() {
            const router = useRouter();
            const state = reactive({
                user: {
                    username: '',
                    password: ''
                }
            })
            function login() {
                if (state.user.username == '') {
                    alert('账号不能为空！');
                    return;
                }
                if (state.user.password == '') {
                    alert('密码不能为空！');
                    return;
                }
                axios.post('user/login', state.user)
                    .then((response) => {
                        let user = response.data;
                        if (user != '') {
                            axios.get("user/getSnameBySid?sid=" + user.sid)
                                .then((response) => {
                                    user.sname = response.data.sname;
                                    setSessionStorage('user', user);
                                })
                                .catch((error) => {
                                    console.log(error);
                                })
                            axios.get("user/getDnameByDid?did=" + user.did)
                                .then((response) => {
                                    user.dname = response.data.dname;
                                    setSessionStorage('user', user);
                                })
                                .catch((error) => {
                                    console.log(error);
                                })
                            setSessionStorage('user', user);
                            router.push('/Mainpage');
                        }
                        else {
                            alert('账号或密码不正确');
                        }
                    })
                    .catch((error) => {
                        console.log(error);
                    })
            }
            return {
                ...toRefs(state),
                login,
            }
        }
    }
</script>

<style scoped>
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: sans-serif;
}

.wrapper {
    display: flex;
    justify-content: center;
    align-items: center;
    min-height: 100vh;
    background: #eff0f4;
    background-image: linear-gradient(to left bottom, #f985c7, #fd87b5, #fd8ba5, #f99098, #f3968e, #f39e83, #efa87a, #e7b274, #dac46d, #c2d773, #9dea89, #5ffbb0);
}

.wrapper #intro {
    position: relative;
    left: -200px;
    background-color: rgba(255, 255, 255, 0.1);
    width: 500px;
    height: 500px;
    border-radius: 20px;
}

.container {
    position: relative;
    left: 0px;
    display: flex;
    justify-content: center;
    align-items: center;

}

.container .drop {
    position: relative;
    width: 350px;
    height: 350px;
    box-shadow: inset 20px 20px 20px rgba(0, 0, 0, 0.05),
        25px 35px 20px rgba(0, 0, 0, 0.05),
        25px 30px 30px rgba(0, 0, 0, 0.05),
        inset -20px -20px 25px rgba(255, 255, 255, 0.9);
    transition: 0.5s;
    display: flex;
    justify-content: center;
    align-items: center;
    border-radius: 52% 48% 33% 67% / 38% 45% 55% 62%;
}

.container .drop:hover {
    border-radius: 50%;
}

.container .drop::before {
    content: '';
    position: absolute;
    top: 50px;
    left: 85px;
    width: 35px;
    height: 35px;
    border-radius: 50%;
    background: #fff;
    opacity: 0.9;
}

.container .drop::after {
    content: '';
    position: absolute;
    top: 90px;
    left: 110px;
    width: 15px;
    height: 15px;
    border-radius: 50%;
    background: #fff;
    opacity: 0.9;
}

.container .drop .content {
    position: relative;
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
    text-align: center;
    padding: 40px;
    gap: 15px;
}

.container .drop .content h2 {
    position: relative;
    color: #333;
    font-size: 1.5em;
}

.container .drop .content form {
    display: flex;
    flex-direction: column;
    gap: 20px;
    justify-content: center;
    align-items: center;
}

.container .drop .content form .inputBox {
    position: relative;
    width: 225px;
    display: flex;
    box-shadow: inset 2px 5px 10px rgba(0, 0, 0, 0.1),
        inset -2px -5px 10px rgba(255, 255, 255, 1),
        15px 15px 10px rgba(0, 0, 0, 0.05),
        15px 10px 15px rgba(0, 0, 0, 0.025);
    border-radius: 25px;
}

.container .drop .content form .inputBox i {
    margin: 0;
    position: relative;
    font-size: 1.2em;
    top: 11px;
    left: 10px;
}

.container .drop .content form .inputBox::before {
    content: '';
    position: absolute;
    top: 8px;
    left: 50%;
    transform: translateX(-50%);
    width: 65%;
    height: 5px;
    background: rgba(255, 255, 255, 0.5);
    border-radius: 5px;
}

.container .drop .content form .inputBox input {
    border: none;
    outline: none;
    background: transparent;
    width: 100%;
    font-size: 1em;
    padding: 10px 15px;
}

.container .drop .content form .inputBox input [type="submit"] {
    color: #fff;
    text-transform: uppercase;
    font-size: 1em;
    cursor: pointer;
    letter-spacing: 0.1em;
    font-weight: 500;
}

.container .drop .content form .inputBox:last-child {
    width: 120px;
    background: #ff0f5b;
    box-shadow: inset 2px 5px 10px rgba(0, 0, 0, 0.1),
        15px 15px 10px rgba(0, 0, 0, 0.05),
        15px 10px 15px rgba(0, 0, 0, 0.025);
    cursor: pointer;
    transition: 0.5s;
}

.container .drop .content form .inputBox:last-child:hover {
    width: 150px;
}

.btns {
    position: absolute;
    right: -120px;
    bottom: 0;
    width: 120px;
    height: 120px;
    background: #d76cfb7e;
    display: flex;
    justify-content: center;
    align-items: center;
    cursor: pointer;
    color: #fff;
    line-height: 1.2em;
    letter-spacing: 0.1em;
    font-size: 0.9em;
    transition: 0.25s;
    text-align: center;
    box-shadow: inset 10px 10px 10px rgba(190, 1, 254, 0.05),
        15px 25px 10px rgba(190, 1, 254, 0.1),
        15px 20px 20px rgba(190, 1, 254, 0.1),
        inset -10px -10px 15px rgba(255, 255, 255, 0.5);
    border-radius: 44% 56% 65% 35% / 57% 58% 42% 43%;
    color: black;
}

.btns::before {
    content: '';
    position: absolute;
    top: 15px;
    left: 30px;
    width: 20px;
    height: 20px;
    border-radius: 50%;
    background: #fff;
    opacity: 0.45;
}

.btns.signup {
    bottom: 150px;
    right: -140px;
    width: 80px;
    height: 80px;
    border-radius: 49% 51% 52% 48% /63% 59% 41% 37%;
    background: #01b3ff7d;
    box-shadow: inset 10px 10px 10px rgba(1, 180, 255, 0.05),
        15px 25px 10px rgba(1, 180, 255, 0.1),
        15px 20px 20px rgba(1, 180, 255, 0.1),
        inset -10px -10px 15px rgba(255, 255, 255, 0.5);
}

.btns.signup::before {
    left: 20px;
    width: 15px;
    height: 15px;
}

.btns:hover {
    border-radius: 50%;
}
</style>
