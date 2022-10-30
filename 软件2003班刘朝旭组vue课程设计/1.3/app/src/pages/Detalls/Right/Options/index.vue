<template>
  <div class="big">
    <!-- 选择地区 -->
    <dl>
      <!--dl自带边距-->
      <label>服务说明</label>
      <div class="op">
        <select v-model="selected.city">
          <option value="">请选择地区</option>
          <option value="北京">北京</option>
          <option value="上海">上海</option>
          <option value="武汉">武汉</option>
        </select>
      </div>
    </dl>
    <div class="baoyou">
      <span>√满48包邮</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>√由华为终端提供商品、发货开票及售后服务</span>
      &nbsp;<a href="#">查看详情</a>
    </div>
    <div class="bigbianma">
      <span>商品编码</span><span class="bianma">9802207207</span>
    </div>
    <hr />
    <dl>
      <label for="">选择颜色</label>
      <div class="in">
        <a href="#" class="one" v-for="(m, index) of models" :key="index" @click="selectcolor(index)">
          <img :src="m.photo" />
          <span class="sp1">
            {{ m.name }}
          </span>
        </a>
      </div>
    </dl>
    <dl class="">
      <label>选择套餐</label>
      <div class="in">
        <a href="#" class="two" v-for="(e, index) of edition" :key="index" @click="selectcombo(index)">
          <span class="sp2">
            {{ e.value }}
          </span>
        </a>
      </div>
    </dl>
    <dl>
      <label>保障服务</label>
      <div class="fw">
        <span>
          <select name="" id="">
            <option value="">花呗分期</option>
            <option value="">无</option>
          </select>
        </span>
        <span>
          <select name="" id="">
            <option value="">花呗分期</option>
            <option value="">无</option>
          </select>
        </span>
      </div>
    </dl>
    <dl>
      <label for="">已选择商品</label>
      <span class="select">
        {{ this.selected.city }}&nbsp;
        {{ this.selected.color }}&nbsp;
        {{ this.selected.combo }}
      </span>
    </dl>

    <div class="footer d-flex">
      <!-- 计数器 -->
      <div class="d-flex number">
        <div class="shu">
          {{ number }}
        </div>
        <div>
          <button class="jiahao font-weight-bold" @click="jia">+</button>
          <button class="jianhao font-weight-bold" @click="jian">-</button>
        </div>
      </div>
      <!-- 提交按钮 -->
      <div class="container">
        <router-link to="/ShopCart">
          <input type="button" @click="setCarOrder" class="btn  jiaru" value="加入购物车" />
        </router-link>

        <router-link to="/MyOrder">
          <input type="submit" @click="setOrder" class="btn  xiadan" value="立即下单" />
        </router-link>
      </div>
    </div>
  </div>
</template>

<script>
import { nanoid } from 'nanoid';

export default {
  data() {
    return {
      // 要在遍历的图片地址前加入require
      models: [
        { id: 1, name: "冰霜", photo: require("../../images/手机.png") },
        { id: 2, name: "密语", photo: require("../../images/手机.png") },
      ],
      edition: [
        { id: 1, value: "单品" },
        { id: 2, value: "听书vip(季卡)套餐" },
        { id: 3, value: "超级音乐vip(季卡)套餐" },
      ],

      // 搜集已选择的数据
      selected: {
        city: "",
        color: "",
        combo: "",
      },
      number: '',
      orders: {
        orderId: "HUAWE_SHOP_"+nanoid(), date: '2022-6-12  09:45:32', logistics: '物流信息', pay: 0, dfk: true, dsh: false, yx: true, dpj: false,
        commoditys: [

        ]
      },
     
    };
  },
  methods: {
    //添加购物车
    setCarOrder() {
      // console.log("当前商品详情对象", this.spxqdx.orders);
      this.orders.commoditys.push(this.spxqdx.orders)
      console.log("添加前购物车数组",this.$store.state.mycart.orders);
      this.$store.state.mycart.orders=this.orders
      console.log("成功添加到购物车",this.$store.state.mycart.orders);

    },
    //添加订单
    setOrder() {
      console.log("当前商品详情对象", this.spxqdx.orders);
      this.orders.pay = this.number * this.spxqdx.orders.unitPrice
      this.orders.commoditys.push(this.spxqdx.orders)
      this.$store.state.myorder.orders.push(this.orders)
    },
    //将单个商品数据对象赋值
    getSpxqdx(spxqdx) {
      this.spxqdx = spxqdx
      // console.log(this.spxqdx);
      // console.log(this.spxqdx.orders.imgurls);
      this.number = this.spxqdx.orders.number
    },












    // 购买数量的加减
    jia(spxqdx) {
      if (this.number < 10) {
        this.number++
        this.spxqdx.orders.number = this.number
        console.log("增加后当前数量", this.spxqdx.orders.number);

      } else {
        this.number = 10
      }
    },
    jian(spxqdx) {
      if (this.number > 1) {
        this.number--
        this.spxqdx.orders.number = this.number
        console.log("减小后当前数量", this.spxqdx.orders.number);
      } else {
        this.number = 1
      }
    },





    //收集选择的颜色
    selectcolor(index) {
      this.selected.color = this.models[index].name;
      console.log(this.models[index].name);
    },

    // 收集选择的套餐
    selectcombo(index) {
      this.selected.combo = this.edition[index].value;
      console.log(this.edition[index].value);
    },
  },








  mounted() {
    //从全局事件总线获取单个点击的商品详情数据
    this.$bus.$on('spxqdx', (spxqdx) => { this.getSpxqdx(spxqdx) });
  },
};
</script>

<style lang="css" scoped>
hr {
  margin-top: 7px;
}

/* 最外围div */
.big {
  margin-left: 17px;
}

/* 遍历的a标签 */
/* 选择颜色 */
.one {
  /* display:inline-block:行级块元素 */
  display: inline-block;
  height: 40px;
  width: 86px;
  margin-left: 27px;
  /* 把此元素放在父元素中部 */
  vertical-align: middle;
  border: 1px solid #a4a4a4;
  text-align: center;
  border-radius: 2px;
  position: relative;
  padding: 0 12px;
  text-decoration: none;
}

.one:hover {
  border: 1px solid red;
}

/* 选择套餐 */
.two {
  display: inline-block;
  margin-left: 27px;
  height: 30px;
  vertical-align: middle;
  border: 1px solid #a4a4a4;
  text-align: center;
  border-radius: 2px;
  position: relative;
  padding: 0px 12px;
  overflow: hidden;
  text-decoration: none;
}

.two:hover {
  border: 1px solid red;
}

img {
  width: 30px;
  height: 30px;
  margin-top: 4px;
}

.sp1 {
  color: black;
  vertical-align: middle;
  font-size: 12px;
}

.sp2 {
  color: black;
  font-size: 12px;
}

.in {
  display: inline-block;
}

/* 服务说明 */
/* 选择地区下拉列表 */
.op {
  display: inline-block;
  margin-left: 27px;
  margin-top: 0px;
  font-size: 12px;
}

.baoyou {
  margin-left: 75px;
  font-size: 12px;
}

/* 保障服务 */
.fw {
  display: inline-block;
  font-size: 12px;
}

.fw span {
  display: inline-block;
  margin-left: 27px;
}

/* 已选择商品 */
.select {
  display: inline-block;
  margin-left: 17px;
  color: red;
  font-size: 12px;
}

/* 商品编码 */
.bigbianma {
  margin-top: 17px;
}

.bianma {
  margin-left: 27px;
}

/* 计数器 */
.number {
  width: 70px;
  border: 1px solid #a4a4a4;
  border-radius: 2px;
  border-right: #ffffff;
}

.shu {
  width: 42px;
  height: 44px;
  text-align: center;
  padding-top: 7px;
  font-size: 20px;
}

.jiahao,
.jianhao {
  display: block;
  width: 21px;
  height: 22px;
  text-align: center;
  border: 1px solid #a4a4a4;
  border-top: #ffffff;
  border-radius: 2px;
  color: black;
  margin-top: 0px;
  text-decoration: none;
}

.jiaru {
  height: 46px;
  width: 172px;
  background-color: #fc660c;
  color: #ffffff;
}

.xiadan {
  height: 46px;
  width: 171px;
  margin-left: 17px;
  background-color: #CA151D;
  color: #ffffff;
}

label,
.bigbianma {
  font-size: 12px;
}
</style>