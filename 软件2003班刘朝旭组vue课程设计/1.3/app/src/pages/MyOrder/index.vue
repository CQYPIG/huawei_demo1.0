<template>
  <div>
    <div class="topover">
      <div class="top">
        <div class="container">
          <!-- <Top></Top> -->
          <Main></Main>





        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Main from './main/Main.vue'
export default {

  mounted() {
    // this.$store.dispatch("getOrder")
    setTimeout(() => {

      console.log("index===>",this.$store.state.myorder.orders);

    },200)
  },
  components: {
    Main
  },
  data() {
    return {

    }
  }
}
</script>

<style scoped>
.topover {
  /* width: 1200px; */
  background: rgb(255, 255, 255);
}

/* .top {
    width: 1200px;
} */
.container {
  width: 1200px;
  margin: 0 auto;
  /* overflow: hidden; */
  padding-top: 15px;
  padding-bottom: 1000px;

}

/*规范页面最小宽度1200px */
</style>
