<template>
    <div id="big_box">
        <div id="title">
            <h1>{{ title }}</h1>
            <h6>{{ author }}</h6>
        </div>
        <div>
            <div id="main_part">
                <p>{{ main_part }}</p>
            </div>
        </div>
    </div>
</template>

<script lang="ts">
import { defineComponent } from 'vue'
export default defineComponent({
    setup() {
        const title = "这是标题"
        const main_part = "这是正文"
        const author = "这是作者"
        return {
            title,
            main_part,
            author,
        }
    }
})
</script>

<style scoped>
#big_box {
    width: 70%;
    height: 100%;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    margin-left: auto;
    margin-right: auto;
    background-color: white;
    color: black;
    border-radius: 10px;
    margin-top: 5px;
}
</style>