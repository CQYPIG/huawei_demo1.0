<template>
  <div class="main">
    <div class="row">
      <main-left></main-left>
      <div class="col">
        <!-- 展示我的订单的路由 -->
        <router-view></router-view>
      </div>
    </div>
  </div>
</template>
<script>
import MainLeft from './Main-Left.vue';
export default {
  components:{
    MainLeft,
  }
};
</script>
<style scoped>
.main,.row{
  width: 1200px;
  margin: auto;
  min-width: 1000px;
  height: 50px;
}
.col{
    padding-right: 0px;
}
</style>