<template>
    <el-row justify='space-between'>
        <el-col v-for="(o, index) in 5" :key="o" :span="5">
            <el-card id="tuijianwenzhang">
                <img src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"
                    class="image" style="width: 100%;" />
                <div>
                    <span>Yummy hamburger</span>
                    <div class="bottom">
                        <el-button text class="button">Operating</el-button>
                    </div>
                </div>
            </el-card>
        </el-col>
    </el-row>
</template>
  
<script lang="ts" setup>
import { ref } from 'vue'

</script>
  
<style scoped>

.bottom {
  margin-top: 13px;
  line-height: 12px;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.button {
  padding: 0;
  min-height: auto;
}
 
#tuijianwenzhang>.image {
  width: 100%;
  display: block;
}

#tuijianwenzhang {
  margin-bottom: 20px;
  height: 90%;
}

#tuijianwenzhang>img{
  width: 100%;
  display: block;
}
.image {
    width: 100%;
    display: block;
}

#user {
    margin-bottom: 20px;
    height: 400px;
}
</style>
  