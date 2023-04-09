<template>
    <div class="content">
        <div class="dialogue">
            <div v-for="(message, index) in conversation" class="conversation">
                <div class="user">
                    <!-- <i class="fa fa-user-o" aria-hidden="true"></i> -->
                    <!-- <img class="icon" src="@/assets/user.webp" alt="用户"> -->
                    <p>{{ message.user }}</p>
                </div>
                <div class="ai">
                    <!-- <i class="fa fa-comments-o" aria-hidden="true"></i> -->
                    <!-- <img class="icon" src="@/assets/女老师.png" alt="用户"> -->
                    <p>{{ message.ai }}</p>
                </div>
            </div>

        </div>
        <div class="box">
            <div class="inputbox">
                <textarea @keydown="handleKeyCode($event)" v-model="message" name="question" id="q" cols="30" rows="1" placeholder="说出你的困惑"></textarea>
            </div>
        </div>
    </div>
</template>

<script>
import axios from "axios";
import { reactive, toRefs } from "vue";
export default {
    setup()
    {
        const data = reactive({
            message: '',
            conversation: [
                // {user: '', ai: ''}
            ],
            postData: {
                "model": "gpt-3.5-turbo",
                "messages": [
                    {"role": "system", "content": "你是一个心理咨询老师"},
                    // {"role": "user", "content": "你好"}
                ]
            },
            config: {
                headers: {
                    ///////
                    ///////
                }
            }
        });

        function handleKeyCode(event)
        {
            if(event.keyCode == 13)
            {
                if(!event.metaKey)
                {
                    event.preventDefault();
                    data.conversation.push({user: data.message, ai: ''});
                    data.postData.messages.push({
                        "role": "user",
                        "content": data.message
                    })
                    // alert(data.message);
                    axios.post("https://api.openai.com/v1/chat/completions", data.postData, data.config)
                    .then(response => {
                        let re = response.data;
                        let index = data.conversation.length - 1;
                        data.conversation[index].ai = re["choices"][0]["message"]["content"];
                        data.postData.messages.push({
                            "role": "assistant",
                            "content": re["choices"][0]["message"]["content"]
                        })
                    })
                    .catch(err => 
                    {
                        // alert("here");
                        console.log(err);
                    })
                    data.message = '';
                }
            }
        }

        return {
            ...toRefs(data),
            handleKeyCode,
        }
    },
}
</script>

<style scoped>
    .content
    {
        width: calc(100% - 200px);
        float: left;
        height: 621px;
        /* display: flex;
        align-items: center;
        justify-content: center; */
        /* background-color: #efefef; */
    }
    .dialogue
    {
        height: 90%;
        overflow: auto;
    }
    .user,
    .ai 
    {
        overflow: hidden;
        display: flex;
        justify-content: center;
        padding: 20px;
    }
    .ai
    {
        background-color: #f7f7f8;
        border: 1px solid #d9d9e3;
    }
    .conversation .icon
    {
        float: left;
        margin-right: 10px;
        height: 30px;
        width: 30px;
    }
    .conversation p
    {
        float: left;
        width: 50%;
        white-space: pre-line;
    }
    .box 
    {
        display: flex;
        align-items: center;
        justify-content: center;
        height: 10%;
    }
    .inputbox
    {
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
    .inputbox textarea
    {
        resize: none;
        /* border:0 none white; */
        border: none;
        width: 750px;
        height: 24px;
        font-size: 20px;
        line-height: 24px;
    }
    .inputbox textarea:focus
    {
        outline: none;
    }
</style>
