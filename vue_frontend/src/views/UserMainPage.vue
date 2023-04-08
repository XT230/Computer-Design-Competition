<template>
    <div>
        <span>
            <img :src="userAvatar" alt="avatar" style="width: 100px; height: 100px; border-radius: 50%;"/>
        </span>
        <span >
            {{ userID }}
        </span>
    </div>
</template>

<script lang="ts">
import { defineComponent } from 'vue'
import { computed, ref } from 'vue'
export default defineComponent({
    data() {
        return {
            userAvatar: 'https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png',
            userID: "大家好我是说的道理",
            userSchool: "东北大学秦皇岛分校",
            userEdu: "本科",

        }
    }
})
</script>

<style></style>