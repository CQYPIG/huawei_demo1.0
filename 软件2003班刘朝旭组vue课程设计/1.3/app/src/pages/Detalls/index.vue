<template>
  <div class="d-flex row c">
    <Carousel class="col-5"></Carousel>
    <Right class="col-7"></Right>

  </div>
</template>

<script>
import Right from "./Right";
import Carousel from "./Carousel";
export default {
  data() {
    return {
      spxqdx: {}
    }
  },
  props: [
    // uid,
  ],
  mounted() {



    this.spxqdx = this.$route.query.spxqdx;
    //将单个商品对象信息发布到全局事件总线
    this.$bus.$emit('spxqdx', this.spxqdx);

  },
  //    因为store里的数据是保存在运行内存中的,
  //     当页面刷新时，页面会重新加载vue实例，
  //     store里面的数据就会被重新赋值。
  // sessionStorage是存储到当前页面关闭为止;

  // created() {
  //   //在页面加载时读取sessionStorage里的状态信息
  //   if (sessionStorage.getItem("store")) {
  //     this.$store.replaceState(
  //       Object.assign(
  //         {},
  //         this.$store.detalls.state,
  //         JSON.parse(sessionStorage.getItem("store"))
  //       )
  //     );
  //   }

  //   //在页面刷新时将vuex里的信息保存到sessionStorage里
  //   window.addEventListener("beforeunload", () => {
  //     sessionStorage.setItem("store", JSON.stringify(this.$store.detalls.state));
  //   });
  // },
  components: {
    Carousel,
    Right,
    // uid,

  },

};
</script>

<style>
/* 整体居中 */
.c {
  width: 1200px;
  margin: 0 auto;
  margin-top: 50px;
  overflow: hidden;
  margin-bottom: 120px;
}
</style>