<template>
    <div class="about">
        <h1>Favorites</h1>
    </div>
    <!-- <el-input v-model="input" placeholder="Please input" /> -->
</template>

<script lang="ts" setup>
import { ref } from 'vue'
const input = ref('')

</script>

<style scoped>
@media (min-width: 1024px) {
  .about {
    min-height: 100vh;
    display: flex;
    align-items: center;
  }
}
</style>
