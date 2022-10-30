<template>
  <div>
    <div class="topover">
      <div class="top">
        <div class="container">
          <!-- 主体 -->
          <div class="outstyl">
            <!-- 标题图案 -->
            <div>
              <div>
                <img src="../images/seckill-title.png" style="position: absolute;" />
              </div>
              <div class="tphotobox">
                <img src="../images/seckill-title02.png" class="tphoto" />
              </div>
            </div>
            <!--秒杀计时-->
            <div class="clockbg">
              <div class="clock">
                <!-- 时场要可以调整(要能改) -->
                <div class="time">00:00</div>
                <div class="clockmsg">
                  <div class="sing">进行中</div>
                  <!-- 这里时分秒要会动(要能改) -->
                  <div style="color: white; font-size: 18px; margin-top: 10px;">距结束 12:00:00</div>
                </div>
              </div>
            </div>
            <!-- 秒杀商品-全部 -->
            <div class="alllist">
              <!-- 秒杀商品-单行 -->
              <div class="sitemline">
                <!-- 秒杀商品-单个 -->

                <template v-for="(sp, index) in sps">
                  <div class="sitem" :key="sp.id">
                    <!-- 商品图(要能改) -->
                    <div style="padding: 21px;">
                      <img :src="sp.orders.imgURL" class="sitemp" />
                    </div>
                    <!-- 商品信息 -->
                    <div class="sitemmsg">
                      <!-- 商品名(要能改) -->
                      <div class="sitemname">{{ sp.orders.name }}</div>
                      <!-- 描述(要能改) -->
                      <div class="imsg">{{ sp.orders.body }}</div>
                      <div class="price">
                        <!-- 现价(要能改) -->
                        <div class="nprice">￥{{ sp.orders.unitPrice }}</div>
                        <!-- 原价(要能改) -->
                        <div class="oprice">￥{{ sp.orders.oldPrice }}</div>
                      </div>
                      <!-- 抢购键 -->
                      <router-link :to="{
                        name: 'detalls',
                        query: {
                          spxqdx: sps[index],
                        }
                      }">

                        <button class="buybtn">去抢购</button>

                      </router-link>
                    </div>
                  </div>
                </template>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  //给组件起一个名字,开发者工具中显示这个组件的时候，显示的就是这个名字
  name: "",
  data() {
    return {
      sps: []
    };
  },
  mounted() {
    this.sps = this.$store.state.detalls.spxq


  },
};
</script>

<style scoped>
.topover {
  background: rgb(241, 243, 245);
  padding-bottom: 100px;
}

/* .top {
} */
.container {
  width: 1200px;
  margin: 0 auto;
  padding: 0;
  overflow: hidden !important;
}

/*规范页面最小宽度1200px */
/* 默认样式 */
.outstyl {
  width: 1200px;
  margin: 0 auto;
  padding: 0;
}

/* 限时秒杀图片样式 */
.tphoto {
  height: 60px;
  width: 195px;
}

/* 限时秒杀外层样式 */
.tphotobox {
  height: 200px;
  width: 195px;
  margin: auto;
  line-height: 200px;
}

/* 整体背景色 */
.allbg {
  background-color: rgb(241, 243, 245);
}

/* 计时最外层样式 */
.clockbg {
  background-color: rgb(255, 255, 255);
}

/* 秒杀计时外部样式 */
.clock {
  background-color: rgb(207, 10, 44);
  width: 240px;
  height: 80px;
  display: flex;
  padding: 0 20px;
}

/* 几点场样式 */
.time {
  line-height: 80px;
  color: rgb(255, 255, 255);
  font-size: 18px;
}

/* 倒计时外部样式 */
.clockmsg {
  line-height: 30px;
  margin-top: 5px;
  margin-left: 5px;
}

/* "进行中"文本的css */
.sing {
  background-color: white;
  color: rgb(207, 10, 44);
  font-size: 12px;
  border-radius: 9px;
  line-height: 18px;
  margin-top: 12px;
  padding: 0px 4px;
  width: 44px;
}


.alllist {
  position: relative;
  width: 1200px;
  /* height: 500px; */
  background: #000;
}

/* 商品行样式 */
.sitemline {
  width: 1200px;
  /* display: flex; */
  /* float: left; */
  /* justify-content: space-around; */
}

/* 单个秒杀商品样式 */
.sitem {
  background-color: white;
  display: flex;
  justify-content: space-around;

  float: left;
  margin: 7px 4px 7px 4px;
  height: 206px;
  width: 392px;
}

.sitem:hover {
  box-shadow: rgb(0 0 0 / 10%) 0px 0px 36px;
}

/* 秒杀商品图片样式 */
.sitemp {
  height: 147.728px;
  width: 147.728px;
  /* margin-top: 10px; */
}

/* 秒杀商品信息样式 */
.sitemmsg {
  width: 180px;
  padding: 20px 12px 20px 0px;
  display: flex;
  flex-direction: column;
}

/* 商品名字样式 */
.sitemname {
  font-size: 16px;
  font-weight: bold;
  line-height: 21px;
  overflow: hidden;
  text-overflow: ellipsis;
}

/* 商品描述样式 */
.imsg {
  color: gray;
  font-size: 14px;
  line-height: 19px;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
}

/* 价格外部样式 */
.price {
  display: flex;
  margin-top: 18px;
  padding-top: 17px;
}

/* 现价样式 */
.nprice {
  color: rgb(207, 10, 44);
}

/* 原价样式 */
.oprice {
  color: rgb(128, 128, 128);
  text-decoration-line: line-through;
  font-size: 12px;
  line-height: 24 px;
  margin: auto 0px;
}

/* 抢购按钮 */
.buybtn {
  margin-top: 8px;
  border-radius: 18px;
  color: white;
  background-color: rgb(207, 10, 44);
  border: 0;
  min-width: 102px;
  max-width: 102px;
  font-size: 18px;
  line-height: 36px;
}
</style>
