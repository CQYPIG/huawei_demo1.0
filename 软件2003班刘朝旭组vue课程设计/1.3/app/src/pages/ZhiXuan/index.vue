<template>
  <div>
    <!-- 首页(华为专区)路由组件 -->
<TuiJian></TuiJian>
  </div>
</template>

<script>
//局部组件:引入、注册、使用
//全局组件：只需要在入口文件定义一次,直接使用
import TuiJian from "./TuiJian"
export default {
  name: "ZhiXuan",
  components: {
TuiJian
  },
};
</script>

<style scoped>
</style>
