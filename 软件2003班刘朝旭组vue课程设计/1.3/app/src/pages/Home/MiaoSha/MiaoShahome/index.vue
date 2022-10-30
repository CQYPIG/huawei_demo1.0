<template>
  <div>
    <div class="topover">
      <div class="top">
        <div class="container">
          <!-- 抬头 -->
          <div class="tbox">
            <div class="outstyl">
              <!-- 这两个要做互跳 -->

              <router-link to="/MiaoShahome/XianShi">
                <button class="buttoncheck">限时秒杀</button>
              </router-link>

              <router-link to="/MiaoShahome/PinLei">
                <button class="buttonother">品类秒杀</button>
              </router-link>
            </div>
          </div>
          <router-view></router-view>
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
      return {};
    }
  };
</script>

<style scoped>
  .topover {
    background: rgb(241, 243, 245);
    /* margin-bottom: 100px; */


  }

  .top {
    background-color: rgb(255, 255, 255);

  }

  .container {
    max-width: 1920px !important;
    min-width: 1200px !important;
    padding: 0;
    margin: 0;
    margin: 0 auto;
    overflow: hidden;
  }

  /*规范页面最小宽度1200px */
  /* 默认样式 */
  .outstyl {
    width: 1200px;
    margin: 0 auto;
    margin-top: 50px;
    overflow: hidden !important;
  }

  /* 顶部边框红线 */
  .tbox {
    border-bottom: 2px solid red;
    background-color: rgb(255, 255, 255);
  }

  /* 被选中顶部按键样式 */
  .buttoncheck {
    background-color: rgb(207, 10, 44);
    min-width: 132px;
    line-height: 48px;
    color: rgb(255, 255, 255);
    border: 0px;
    font-size: 20px;
  }

  /* 未选中顶部按键样式 */
  .buttonother {
    background-color: rgb(255, 255, 255);
    min-width: 132px;
    line-height: 48px;
    border: 0px;
    font-size: 20px;
  }
</style>