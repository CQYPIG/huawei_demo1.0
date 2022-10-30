<template>
    <div>
        <!-- 首页(华为专区)路由组件 -->
        <LunBo></LunBo>
        <MiaoSha></MiaoSha>
        <XianShigou></XianShigou>
    </div>
</template>

<script>
//局部组件:引入、注册、使用
//全局组件：只需要在入口文件定义一次,直接使用
import MiaoSha from "./MiaoSha"
import LunBo from "./LunBo"
import XianShigou from "./XianShigou"



export default {
    name: "Home",
    components: {
        MiaoSha,
        LunBo,
        XianShigou,
    }
};
</script>

<style scoped>
</style>
