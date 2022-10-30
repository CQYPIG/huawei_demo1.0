<template>
  <div>
    <Header></Header>
    <!-- Header  Footer会随着路由的变化进行显示与隐藏 -->
    <Header2 v-show="$route.meta.showheader2"></Header2>
    <router-view></router-view>
    <Footer v-show="$route.meta.showfooter"></Footer>
  </div>
</template>

<script>
import Footer from './components/Footer/index.vue'
import Header from './components/Header/index.vue'
import Header2 from './components/Header2/index.vue'

export default {
  // name: '',
  components: {
    Footer,
    Header,
    Header2
  },
mounted() {
          // this.$store.dispatch("getSpxq");
},
}
</script>

<style>
</style>
