<template>
  <div class="container">
    <div class="list" v-for="(cg, index) of cargoods" :key="index">
      <div class="check">
        <input type="checkbox" :checked="cg.commoditys[0].bigdone" @change="bigchange(index)" />
      </div>
      <div class="time">
        <div class="tu">ϟ</div>
        <label class="title">限时特惠</label>
        <div>距离活动结束还有</div>
        &nbsp;&nbsp;
        <p>
          <span>02</span>
          <strong>:</strong>
          <span>19</span>
          <strong>:</strong>
          <span>{{ times }}</span>
        </p>
      </div>

      <div class="text">
        <div class="img">
          <img :src="cg.commoditys[0].imgURL" alt="" />
        </div>
        <ul class="sp">
          <li>
            {{ cg.commoditys[0].name }}
            <div></div>
            <span>分期免息</span>
            <div class="fh">此商品由华为商城自营发货</div>
          </li>
          <li>
            <span>¥&nbsp;{{ cg.commoditys[0].unitPrice }}</span>
            <br />
            <s>¥&nbsp;{{ cg.commoditys[0].unitPrice + 1000 }}</s>
          </li>
          <li class="count">
            <div>
              <button class="sub" @click="sub(index)">-</button>
              <span class="shu">{{ cg.commoditys[0].number }}</span>
              <button class="add" @click="add(index)">+</button>
            </div>
          </li>
          <li class="lprice">¥ {{ sum(index) }}</li>
          <li @click="del(index)"><a href="#" class="del">删除</a></li>
        </ul>
      </div>

      <div class="youhui">
        <!-- @change 在输入框发生变化且失去焦点后触发 -->
        <label><input type="checkbox" :checked="cg.commoditys[0].done" @change="change(index)" /></label>
        <div class="bao">
          <i>优惠</i>
          <span>延长服务宝一年</span>
        </div>
        <div class="baoPrice">
          <span>¥{{ baoPrice }}</span><s>138.00</s>
        </div>
      </div>
    </div>

    <div class="foot">
      <div class="left">
        <input type="checkbox" :checked="lastsuma" @change="lastsum" />
        &nbsp;
        <span>全选</span>
        &nbsp;
        <a href="#" @click="quanshan" style="color:black">删除</a>
      </div>
      <div class="right">
        <div class="right-left">
          <span class="zj">
            <label>总计：</label>
            <span>￥&nbsp;{{ bigSum }}</span>
            <p>
              已选择<strong>{{ countsum }}</strong>件商品
            </p>
          </span>
        </div>
        <router-link class="ljjsjj" to="/MyOrder">
          <a href="#" class="right-right" @click="jiesuan">立即结算</a>
        </router-link>

      </div>
    </div>
  </div>
</template>

<script>

export default {
  props: [
    "a",
    'lastsumb'
  ],
  data() {
    return {
      cartoorders: [],

      pay: 0,


      // number 详情页传

      //   购物车商品数据 详情页传
      cargoods: [],

      //被勾选的对象
      selected: [],

      baoPrice: 121,

      // 总计复选框
      lastsuma: '',

      // 倒计时
      times: 60
    };
  },
  mounted() {
    console.log("接收前的cargoods==》", this.cargoods);
    console.log("接收到的a==》", this.a);
    this.lastsuma = this.lastsumb
    console.log("xxxxx",this.lastsumb);
    this.cargoods = this.a;

    console.log("接收后的cargoods==》", this.cargoods);
  },
  created() {
    this.getTime();   //只要该页面一渲染创建，就开始倒计时
  },
  methods: {
    // 单个商品前面的勾选或取消
    bigchange(index) {
      this.cargoods[index].commoditys[0].bigdone = !this.cargoods[index].commoditys[0].bigdone;
      const se = this.cargoods[index];
      if (this.cargoods[index].commoditys[0].bigdone) {
        // 被勾选时向selected加入此对象
        this.selected.push(se);
      }
    },

    //点击结算按钮，被勾选的商品被删除
    jiesuan() {
      console.log("被调用了")
      this.cartoorders = this.cargoods.filter((item) => {
        // 筛选出被勾选的
        return item.commoditys[0].bigdone = true
      })
      this.cargoods = this.cargoods.filter((item) => {
        // 筛选出等于不被勾选的
        return item.commoditys[0].bigdone != true
      })
      console.log("当前商品数组", this.cartoorders);
      console.log("添加前订单数组", this.$store.state.myorder.orders);
      this.$store.state.myorder.orders = this.$store.state.myorder.orders.concat(this.cartoorders)
      // this.$store.state.myorder.orders = this.cartoorders
      console.log("成功添加到订单", this.$store.state.myorder.orders);
    },

    // 全部删除
    quanshan() {
      this.cargoods = this.cargoods.filter((item) => {
        // 筛选出等于不被勾选的
        return item.commoditys[0].bigdone != true
      })
    },

    // 优惠框前面勾选框的勾选或取消
    change(index) {
      // 勾选时为ture  取消为false
      this.cargoods[index].commoditys[0].done = !this.cargoods[index].commoditys[0].done;
      if (this.cargoods[index].commoditys[0].done) {
        // 被勾选时加上121
        this.cargoods[index].commoditys[0].aftBaoPrice = this.baoPrice;
        console.log("加", this.cargoods[index].commoditys[0].aftBaoPrice);
      } else {
        // 不被勾选则加0
        this.cargoods[index].commoditys[0].aftBaoPrice = 0;
        console.log("加", this.cargoods[index].commoditys[0].aftBaoPrice);
      }
    },

    // 总计复选框
    lastsum() {
      console.log("下总计被调用");

      this.lastsuma = !this.lastsuma;
      if (this.lastsuma) {
        for (let i = 0; i < this.cargoods.length; i++) {
          this.cargoods[i].commoditys[0].bigdone = true;
        }
      } else {
        for (let i = 0; i < this.cargoods.length; i++) {
          this.cargoods[i].commoditys[0].bigdone = false;
        }
      }
    },

    // 数量增加
    add(index) {
      this.cargoods[index].commoditys[0].number++;
    },
    // 数量减少
    sub(index) {
      if (this.cargoods[index].commoditys[0].number > 1) {
        this.cargoods[index].commoditys[0].number--;
      } else {
        alert("商品数量不能小于1");
      }
    },
    //删除按钮
    del(index) {
      this.cargoods.splice(index, 1);
    },
    // 计时
    getTime() {
      this.timer = setInterval(() => {
        this.times--
        if (this.times === 0) {
          clearInterval(this.timer)
        }
      }, 1000)
    }
  },
  computed: {
    // 所有被勾选商品个数的总和
    countsum() {
      var s = 0;
      for (let i = 0; i < this.cargoods.length; i++) {
        if (this.cargoods[i].commoditys[0].bigdone) {
          s += this.cargoods[i].commoditys[0].number;
        }
      }
      return s;
    },

    // 单个商品后面的小计
    sum() {
      // 如果直接传参则会提示错误
      return function (index) {
        return (
          this.cargoods[index].commoditys[0].unitPrice * this.cargoods[index].commoditys[0].number +
          this.cargoods[index].commoditys[0].aftBaoPrice
        );
      };
    },

    // 所有被勾选商品价格的总和
    bigSum() {
      var bigSum = 0;
      for (var i = 0; i < this.cargoods.length; i++) {
        if (this.cargoods[i].commoditys[0].bigdone) {
          bigSum += this.sum(i);
          this.cargoods[i].pay = bigSum

        }
      }
      this.pay = bigSum
      return bigSum;
    },
  },
};
</script>

<style lang="css" scoped>
.container {
  width: 1200px;
  margin: 0 auto;
  overflow: hidden;
  padding: 0;

}

a {
  text-decoration: none;
}

.title {
  font-size: 16px;
  font-weight: 900;
  margin-right: 6px;
}

.tu {
  margin-right: 7px;
  font-weight: 900;
}

.lprice {
  color: #ca141d;
  font-weight: 700;
}

.check {
  position: absolute;
  left: 44px;
  /* padding-right: 10px; */
  top: 67px;
}

.time {
  width: 1130px;
  height: 24px;
  margin: 0px 0px 16px;
  padding: 0px 0px 0px 18px;
  display: flex;
  flex-direction: row;
}

.time p {
  display: inline-block;
  line-height: 18px;
}

.time p span {
  display: inline-block;
  width: 19px;
  height: 18px;
  border: 1px solid #333;
  border-radius: 2px;
  vertical-align: middle;
  text-align: center;
}

.list {
  position: relative;
  width: 1200px;
  height: 262px;
  background-color: #ffffff;
  margin-top: 10px;
  padding-left: 50px;
  padding-top: 10px;

  /* padding: 20px 0px 0px 40px; */
}

.sp {
  width: 1099px;
  height: 40px;
  margin-left: 8px;
}

.sp li:first-child {
  width: 450px;
  height: 40px;
  /* border: 1px solid aqua; */
  color: #3a3a3a;
  text-align: left;
  margin-left: 0;
}

.sp li:first-child span {
  display: inline-block;
  margin: 5px 8px 0px 0px;
  border: 1px solid #ca141d;
  padding: 0px 8px;
  color: #ca141d;
}

.fh {
  color: #a4a4a4;
  font-size: 14px;
  margin: 3px 0px 6px;
}

.sp li {
  float: left;
  width: 90px;
  height: 40px;
  margin-left: 30px;
  min-height: 14px;
  font-size: 14px;
  list-style: none;
  text-align: center;
  padding-top: 8px;
}

.sp li s {
  color: #a4a4a4;
}

.img {
  width: 100px;
  height: 100px;
}

img {
  width: 94.94;

  height: 100px;
}

.text {
  height: 114px;
  /* border: 1px solid red; */
  display: flex;
  flex-direction: row;
  /* width: 1200px; */
}

.youhui {
  width: 1030px;
  height: 50px;
  border: solid 1px #a4a4a4;
  margin: 16px 9px 0px;
  padding: 0px 35px 0px 14px;
  display: flex;
  flex-direction: row;
}

.youhui label {
  /* border: 1px solid black; */
  padding-top: 12px;
}

/* .youhui div{
				border: 1px solid black;
			} */
.bao {
  width: 176px;
  height: 48px;
  margin: 0px 0px 0px 20px;
  padding-top: 12px;
}

.baoPrice {
  width: 116px;
  height: 48px;
  margin: 0px 0px 0px 16px;
  padding-top: 12px;
}

.baoPrice s {
  font-size: 15px;
  color: #aaaaaa;
  margin-left: 5px;
}

.baoPrice span {
  font-size: 15px;
  color: #3a3a3a;
}

.bao i {
  border: 1px solid #cb1f17;
  margin: 0px 6px 0px 0px;
  padding: 0px 10px;
  width: 52px;
  height: 20px;
  color: #cb1f17;
}

.shu {
  display: inline-block;
  width: 44px;
  height: 20px;
  border-top: 1px solid #d6d6d6;
  border-bottom: 1px solid #d6d6d6;
  vertical-align: middle;
}

.add,
.sub {
  width: 21px;
  height: 22px;
  color: #717171;
  background: #fff;
  border: 1px solid #d6d6d6;
  vertical-align: middle;
}

.foot {
  position: fixed;
  bottom: 0px;
  left: 0px;
  width: 100%;
  height: 60px;
  background-color: #fff;
  box-shadow: #a4a4a4 0px 0px 10px;
}

.left {
  float: left;
  /* border: #333 1px solid; */
  margin-top: 20px;
  margin-left: 351px;
}

.right {
  /* border: #333 1px solid; */
  float: right;
  padding-right: 351px;
}

.right-right {
  display: inline-block;
  border: #ca151e 4px solid;
  /* line-height: 30px; */
  padding-top: 18px;
  width: 180px;
  height: 60px;
  font-size: 18px;
  color: #ffffff;
  text-align: center;
  background-color: #ca151e;
  margin-left: 10px;
}
.right-right:hover {
    text-decoration: none;
}

.right-left {
  display: inline-block;
  /* border: #333 1px solid; */
}

.zj label {
  font-size: 14px;
}

.zj span {
  /* padding-top: 10px; */
  color: #ca151e;
  font-size: 18px;
  font-weight: 600;
}

.zj p {
  color: #a4a4a4;
  font-size: 12px;
}

.zj strong {
  color: #ca151e;
  font-size: 15px;
  margin: 0px 10px;
}

.del {
  color: #a4a4a4;
}
.ljjsjj:hover{
  text-decoration: none;
}
</style>