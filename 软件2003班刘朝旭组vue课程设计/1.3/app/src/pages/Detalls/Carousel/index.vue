<template>
  <div id="demo" class="carousel slide" data-bs-ride="carousel">
    <!-- 轮播图片 -->
    <div class="carousel-inner big">
      <div v-for="(imgs, index) in imageslist" :key="index">
        <div class="carousel-item" data-bs-interval="1000" :class="index === 0? 'active' : ''">
          <img :src="imgs.imgURL" class="big1" />
        </div>
      </div>
    </div>

    <!-- 指示符 -->
    <div class="foot">
      <div v-for="(imgs, index) in imageslist" :key="index">
        <span data-bs-target="#demo" :data-bs-slide-to="index">
          <img :src="imgs.imgURL"/>
        </span>
      </div>

    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      imageslist: [],
      //准备接收单个商品详细信息对象
      spxqdx: {}
    }
  },
  methods: {
    //将单个商品数据对象赋值
    getSpxqdx(spxqdx) {
      this.spxqdx = spxqdx
      // console.log(this.spxqdx);
      // console.log(this.spxqdx.orders.imgurls);
      this.imageslist = this.spxqdx.orders.imgurls
    }
  },
  mounted() {
    //从全局事件总线获取单个点击的商品详情数据
    this.$bus.$on('spxqdx', (spxqdx) => { this.getSpxqdx(spxqdx) });
  },

}
</script>

<style lang="css" scoped>
.carousel-inner img {
  width: 100%;
  height: 100%;
}

.foot {
  margin-top: 22px;
  width: 461px;
  height: 81px;
  /* background-color: bisque; */
}

.foot span {
  display: inline-block;
  margin-left: 10px;
  width: 80px;
  height: 80px;
  border: 1px solid white;
}

.foot span img:hover {
  border: 1px solid red;
}

.foot span img {

  width: 80px;
  height: 80px;
}

.big {
  width: 482px;
  height: 482px;
}

.carousel-item {
  width: 100%;
  height: 100%;
}
</style>