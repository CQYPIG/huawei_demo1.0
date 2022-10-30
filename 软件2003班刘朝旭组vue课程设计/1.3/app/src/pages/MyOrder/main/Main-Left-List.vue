<template>
    <div>
        <!-- <h3><strong>订单中心</strong></h3> -->
        <slot name="title"></slot>
          <!-- <ul class="">
              <li>
                  <router-link to="">我的订单</router-link>
              </li>
              <li>
                  <router-link to="">我的退换货</router-link>
              </li>
              <li>
                  <router-link to="">我的退款</router-link>
              </li>
              <li>
                  <router-link to="">我的收获单</router-link>
              </li>
              <li>
                  <router-link to="">商品评价/追评</router-link>
              </li>
          </ul> -->
          <slot name="list"></slot>
    </div>
</template>
<script>
export default {
    name:'Main-Left'
};
</script>
<style scoped>
*{
    padding: 0;
    margin: 0;
}
#myshop{
    color: red !important;
    font-size: 18px;
    padding: 0;
    padding-left: 30px;
}
.mainleft{
    min-width: 200px;
}
h3{
    padding-top: 10px;
    padding-bottom: 10px;
    border-top: 1px solid #F6F6F6;
    font-size: 14px;
    padding-left: 30px;
    font-weight: 700;
}
a{
  text-decoration: none;
  margin: auto 0px;
  line-height: 36px;
  color: rgb(119, 119, 119) ;
  font-size: 14px;
  font-family: Arial, Helvetica, sans-serif;
}
ul{
    list-style: none;
}
ul a:hover{
    color: red;
}
li{
    padding-left: 30px;
}
.myborder{
    width: 176px;
    line-height: 34px;
    border-radius: 10px;
    border: 2px solid #f5f5f5;
    /* padding: 0 0 0 0; */
}
</style>