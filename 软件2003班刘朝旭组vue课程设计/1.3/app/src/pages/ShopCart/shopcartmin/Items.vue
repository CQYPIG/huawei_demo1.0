<template>
  <div class="container">
    <div class="big">
      <div class="head">
        <label>
          <input type="checkbox" :checked="lastsumb"  @change="toplastsum" />
          &nbsp;
          <span>全选</span>
        </label>
        <ul class="items">
          <li>商品</li>
          <li>单价</li>
          <li>数量</li>
          <li>小计</li>
          <li>操作</li>
        </ul>
      </div>
      <div class="ddd">
        <Lists :a="a" :lastsumb="lastsumb"></Lists>
      </div>
    </div>
  </div>

</template>

<script>
import Lists from "./Lists.vue";
export default {
  data() {
    return {
      lastsumb: false,
      a: [],
      // a :{
      //     id: 3,
      //     unitPrice: 1899,
      //     number: 1,
      //     aftBaoPrice: 0,
      //     name:
      //       "【新品】HUAWEI FreeBuds Lipstick 有线充版（蜜语）业界首款口红外观设计 奢享品质 舒适佩戴",
      //     imgURL: require("../../../../public/images/erji.webp"),
      //     done: false,
      //     bigdone: false
      //   },
    };
  },
  components: {
    Lists,
  },
  methods: {


    toplastsum() {
      console.log("上总计被调用")
      this.lastsumb = !this.lastsumb;
      if (this.lastsumb) {
        for (let i = 0; i < this.a.length; i++) {
          this.a[i].bigdone = true;
        }
      } else {
        for (let i = 0; i < this.a.length; i++) {
          this.a[i].bigdone = false;
        }
      }
    },
  },
  mounted() {
    console.log("获取商品信息前的a===》", this.a);
    console.log("获取商品信息==》", this.$store.state.mycart.orders);
    console.log("要往购物车里加的orders对象", this.$store.state.mycart.orders);
    this.a.push(this.$store.state.mycart.orders)
    console.log("获取商品信息后的a===》", this.a);
  },
};
</script>

<style lang="css" scoped>
/* .ddd{
  background: #000;
} */
.container {
  position: relative;
  width: 1200px;
  margin: 0 auto;
  overflow: hidden;
  top: 5px;
}

.big {
  height: 100%;
  width: 1200px;
  margin: 0 auto;
  /* border: 1px solid black; */
}

.head label {
  padding-top: 4px;
  width: 150px;
  height: 40px;
  text-align: center;
}

.head label input {
  vertical-align: middle;
}

.head label span {
  height: 40px;
  color: #a4a4a4;
  font-size: 12px;
  vertical-align: middle;
  /* border: 1px solid black; */
}

.head {
  width: 1200px;
  height: 40px;
  /* border: 1px solid rgb(246, 246, 246); */
  background: #ffffff;
  display: flex;
  flex-direction: row;
  box-shadow: rgb(0 0 0 / 10%) 0px 0px 36px;

}

.items {
  width: 970px;
  height: 40px;
}

.items li:first-child {
  width: 450px;
  height: 40px;
  /* border: 1px solid aqua; */
  color: #a4a4a4;
  text-align: left;
  margin-left: 0;
}

.items li {
  float: left;
  width: 90px;
  height: 40px;
  margin-left: 30px;
  min-height: 14px;
  font-size: 12px;
  list-style: none;
  text-align: center;
  color: #a4a4a4;
  padding-top: 8px;
}
</style>