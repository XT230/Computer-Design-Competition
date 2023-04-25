<template>
    <div class="content">
        <div class="dialogue">
            <el-scrollbar style="height: 80vh;">
                <div v-for="(message, index) in conversation" class="conversation">
                    <div style="width: 100%;min-height: 45px;">
                        <div class="user">
                            <p style="width:100%;padding-top: 5px; padding-bottom: 5px; font-size:19px ;">{{ message.user }}
                            </p>
                        </div>
                    </div>
                    <br>
                    <div style="width: 100%;min-height: 45px;">
                        <div class="ai">
                            <p style="width:100%;padding-top: 5px; padding-bottom: 5px; font-size:19px ;">{{ message.ai }}
                            </p>
                        </div>
                    </div>

                </div>
            </el-scrollbar>
        </div>
        <div class="box">
            <div class="inputbox">
                <textarea @keydown="handleKeyCode($event)" v-model="message" name="question" id="q" cols="30" rows="1"
                    placeholder="说出你的困惑"></textarea>
            </div>
        </div>
    </div>
</template>

<script lang="ts">
import axios from "axios";
import { reactive, toRefs } from "vue";
import { Conversation } from  '@/common'
import { getSessionStorage } from "@/common";
export default {
    
    setup() {
        var ws = new WebSocket("ws://localhost:8088/api/websocket/" + getSessionStorage("user").uid)
        var postData = {
                "model": "gpt-3.5-turbo",
                "messages": [
                    { "role": "system", "content": "你是一个心理咨询老师" },
                    // {"role": "user", "content": "你好"}
                ]
            }
        const data = reactive({
            message: '',
            conversation: new Array<Conversation>(),
            config: {
                headers: {
                    ///////
                    ///////
                }
            }
        });
        function handleKeyCode(event: KeyboardEvent) {
            if (event.keyCode == 13) {
                if (!event.metaKey) {
                    event.preventDefault();
                    data.conversation.push({ user: data.message, ai: '' });
                    postData.messages.push({
                        "role": "user",
                        "content": data.message
                    })
                    // // alert(data.message);
                    // axios.post("https://api.openai.com/v1/chat/completions", data.postData, data.config)
                    //     .then(response => {
                    //         let re = response.data;
                    //         let index = data.conversation.length - 1;
                    //         data.conversation[index].ai = re["choices"][0]["message"]["content"];
                    //         data.postData.messages.push({
                    //             "role": "assistant",
                    //             "content": re["choices"][0]["message"]["content"]
                    //         })
                    //     })
                    //     .catch(err => {
                    //         // alert("here");
                    //         console.log(err);
                    //     })
                    let submitStr = JSON.stringify(postData);
                    ws.send(submitStr);
                    data.message = '';
                }
            }
        }
        ws.onmessage = (message) => {
            // message.data
            let message1 = JSON.parse(message.data)
            let index = data.conversation.length - 1;
            data.conversation[index].ai = message1.content;
            postData.messages.push(message1)
        }

        // ws.onclose = 

        return {
            ...toRefs(data),
            handleKeyCode,
        }
    },
}
</script>

<style scoped>
.content {
    width: calc(100% - 200px);
    margin-top: 10px;
    float: left;
    height: 100%;
    /* display: flex;
        align-items: center;
        justify-content: center; */
    /* background-color: #efefef; */
}

.dialogue {
    height: 90%;
    overflow: auto;
    position: relative;
    left: 100px
}

.user {
    float: right;
    color: white;
    overflow: hidden;
    overflow: auto;
    min-height: 45px;
    max-width: 50vw;
    padding-left: 5px;
    padding-right: 5px;
    border-radius: 10px;
    display: flex;
    justify-content: center;
    margin-bottom: 10px;
    background-image: linear-gradient(90deg, #2870EA 10.79%, #1B4AEF 87.08%);

}


.ai {
    float: left;
    overflow: hidden;
    overflow: auto;
    display: flex;
    min-height: 45px;
    max-width: 50vw;
    justify-content: center;
    padding-left: 5px;
    padding-right: 5px;
    margin-bottom: 10px;
    border-radius: 10px;
    color: black;
    background-color: white;
}

.conversation .icon {
    float: left;
    height: 30px;
    width: 30px;
}

.conversation p {
    float: left;
    width: 50%;
    white-space: pre-line;
}

.box {
    display: flex;
    align-items: center;
    justify-content: center;
    height: 10%;
}

.inputbox {
    display: flex;
    position: relative;
    left: 60px;
    align-items: center;
    justify-content: center;
    width: 768px;
    height: 40px;
    box-shadow: 0 0 15px rgba(0, 0, 0, 0.20);
    border-radius: 10px;
    border: 1px solid #d9d9e3;
}

.inputbox textarea {
    resize: none;
    /* border:0 none white; */
    border: none;
    width: 750px;
    height: 24px;
    font-size: 20px;
    line-height: 24px;
}

.inputbox textarea:focus {
    outline: none;
}
</style>
