<template>
  <div class="">
    <h4>{{ name }}</h4>
    <p class="text-danger">{{ body }}</p>
    <div class="bg container">
      <!-- 促销价要写成计算属性 -->
      <div>
        <span class="jiage1">价&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;格</span>
        <h4 class="font-weight-bold text-danger jiage2">
          促销价￥
          {{ unitPrice }}
          <S class="sss">{{ oldPrice }}</S>
        </h4>
      </div>
      <div class="d-flex foot">
        <div class="cuxiao">促&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;销</div>
        <div class="cen">
          <span class="text-danger border border-danger s">限时直降</span><span class="s2">限时直降{{jianjia}}元</span><br />
          <span class="text-danger border border-danger s">以旧换新抵现</span><span class="s2">以旧换新至高补贴2022元</span><br />
          <span class="text-danger border border-danger s">整点赠礼</span><span class="s2">整点赠华为手环4</span><br />
          <span class="text-danger border border-danger s">分期免息</span><span
            class="text-danger border border-danger s">赠送积分</span>
        </div>
      </div>
    </div>
    <hr>
  </div>
</template>

<script>
export default {
  data() {
    return {
      unitPrice: '',
      oldPrice: '',
      name: "",
      body: "",
      spxqdx: '',
      jianjia:''
    };
  },
  methods: {
    //将单个商品数据对象赋值
    getspinfo(spxqdx) {
      this.spxqdx = spxqdx
      this.unitPrice = this.spxqdx.orders.unitPrice;
      this.oldPrice = this.spxqdx.orders.oldPrice;
      this.name = this.spxqdx.orders.name;
      this.body = this.spxqdx.orders.body;
      this.jianjia = this.spxqdx.orders.jianjia;
      // console.log(this.spxqdx.orders);
    }
  },
  mounted() {
    //从全局事件总线获取单个点击的商品详情数据
    this.$bus.$on('spxqdx', (spxqdx) => { this.getspinfo(spxqdx) });
  },
};

</script>

<style lang="css" scoped>
/* 背景颜色 */
.bg {
  background-color: #F5F5F5;
}

.jiage1 {
  font-size: 12px;
}

.jiage2 {
  display: inline-block;
  margin-top: 13px;
  margin-left: 24px;

}

.sss {
  color: #919191 !important;
  font-size: 18px;

}

.cuxiao {
  margin-top: 14px;
  font-size: 12px;
}

/* 灰色框 */
.s {
  display: inline-block;
  margin-top: 17px;
  margin-left: 24px;
  font-size: 12px;
  padding: 0px 6px;
}

.s2 {
  font-size: 12px;
  margin-left: 10px;
}

.foot {
  padding-bottom: 15px;
}

hr {
  margin-top: 5px;
}
</style>