<template>
  <div>
    <div class="topover">
      <div class="top">
        <div class="container">
          <div class="showImg">
            <!-- //轮播图片 -->
            <img @mouseover="changeInterval(true)" @mouseleave="changeInterval(false)" v-for="(b1, index) in banner"
              :key="b1.id" :src="b1.imgUrl" alt="暂无图片" v-show="index === currentIndex">
            <!-- //左侧按钮 -->
            <div @click="clickIcon('up')"
              class="iconDiv iconDivl icon-left el-icon-caret-left carousel-control-prev-icon">
            </div>
            <!-- //右侧按钮 -->
            <div @click="clickIcon('down')"
              class="iconDiv iconDivr icon-right el-icon-caret-right carousel-control-next-icon">
            </div>
            <!-- //控制圆点 -->
            <div class="banner-circle">
              <ul>
                <li @click="changeImg(b1.id)" v-for="(b1, index) in banner" :key="b1.id" :src="b1.imgurl"
                  :class="index === currentIndex ? 'active' : ''"></li>
              </ul>
            </div>
          </div>
          <!-- 多级菜单 -->
          <ul class="topmenu shadow">
            <li v-for="(c1, index) in category" :key="c1.categoryId">
              <a href="#">{{ c1.categoryName }}</a>
              <!-- 二级菜单 -->
              <div class="submenu">
                <dl v-for="(c2, index) in c1.categoryChild" :key="c2.categoryId">
                  <!-- <dt><a href="#">ing</a></dt> -->
                  <dd>
                    <img :src="c2.imgUrl" />
                    <a href="#">{{ c2.categoryName }}</a>
                  </dd>
                </dl>
              </div>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </div>
</template>

<script>

  import { mapState } from "vuex";
  export default {
    //给组件起一个名字,开发者工具中显示这个组件的时候，显示的就是这个名字
    name: "",
    data() {
      return {
        currentIndex: 0,//当前所在图片下标
        timer: null,//定时轮询


      }
    },
    mounted() {
      this.$store.dispatch("getCategoryList");
      this.$store.dispatch("getBannerList");

      this.startInterval()

    },
    // //计算属性
    computed: {
      //数组的写法:目前书写的是大仓库state的K  ...mapState(['home'])

      ...mapState({
        // 对象写法,对象的K,给VC新增的属性
        // 新增的属性erha,右侧属性值为箭头函数返回的结果。作为新增属性的属性值
        // 箭头函数执行，注入一个参数state->大仓库【包含小仓库】
        category: state => state.home.category, //对象简写形式
        banner: state => state.home.banner
      })
    },
    methods: {
      //开启定时器
      startInterval() {
        // 事件里定时器应该先清除在设置，防止多次点击直接生成多个定时器
        clearInterval(this.timer);
        this.timer = setInterval(() => {
          this.currentIndex++;
          if (this.currentIndex > this.banner.length - 1) {
            this.currentIndex = 0
          }
        }, 3000)
      },
      // 点击左右箭头
      clickIcon(val) {
        if (val === 'down') {
          this.currentIndex++;
          if (this.currentIndex === this.banner.length) {
            this.currentIndex = 0;
          }
        } else {
          /* 第一种写法
          this.currentIndex--;
          if(this.currentIndex < 0){
            this.currentIndex = this.imgArr.length-1;
          } */
          // 第二种写法
          if (this.currentIndex === 0) {
            this.currentIndex = this.banner.length;
          }
          this.currentIndex--;
        }
      },
      // 点击控制圆点
      changeImg(index) {
        this.currentIndex = index
      },
      //鼠标移入移出控制
      changeInterval(val) {
        if (val) {
          clearInterval(this.timer)
        } else {
          this.startInterval()
        }
      }
    },

    //   //进入页面后启动定时轮询
    //   mounted() {
    // this.startInterval()
    //   }
  };


</script>

<style scoped>
  .topover {
    background: rgb(241, 243, 245);
    margin: 0;
    padding: 0;
    height: 515PX;

  }

  /* .top {} */

  .container {
    max-width: 1920px !important;
    min-width: 1200px !important;

    margin: 0 auto;
    overflow: hidden;
    /* margin: 0; */
    padding: 0;
  }

  /*规范页面最小宽度1200px */


  /* 多级菜单 */
  .topmenu {
    display: block;
    width: 170px;
    background: rgb(247, 247, 247);
    margin: 0;
    /* 调整二级菜单垂直位置 */
    margin-top: -510px;
    margin-bottom: 40px;
    left: 360px;
    padding: 0;
    z-index: 3;
    position: relative;
    border-radius: 5px;
  }

  .topmenu li {
    height: 36px;
    line-height: 30px;
    list-style-type: none;
    padding-left: 25px;
    margin: 0;
    background-repeat: no-repeat;
    background-position: right;
  }

  .topmenu li:hover {
    background: white;
    border-right: 0px;
    border-radius: 5px;
    font-weight: bold;


  }

  .topmenu li a {
    color: black;
    font-size: 15px;
    text-decoration: none;
  }

  .topmenu li a:hover {
    color: #000000;
    /* font-weight: bold; */
    text-decoration: none;

  }

  .submenu {
    border-radius: 5px;

    display: none;
    width: 450px;
    height: 432px;
    position: absolute;
    left: 164px;
    top: -5px;
    /* box-shadow: 0 0 5px #ddd; */
    background: white;
    z-index: 4;
    margin: 5px;
  }

  .topmenu li:hover .submenu {
    display: block;
  }

  .topmenu li:hover span {
    background: white;
    width: 20px;
    height: 30px;
    display: inline-block;
    position: relative;
    /* float:right; */
    z-index: 5;
  }

  .submenu dl {
    display: block;
    width: 140px;
    height: 60px;
    /* border-bottom: 1px solid #eee; */
    overflow: hidden;
    float: left;
    margin: 13px auto;
    padding-bottom: 6px;
  }


  .submenu dl dd {
    display: block;
    float: left;
    margin-left: 10px;
    overflow: hidden;
  }

  .submenu dl dd a {
    padding-right: 6px;
    border-left: 1px solid #ccc;
    color: #737373;
    font-size: 12px;
    padding: 0 5px;
    height: 14px;
    line-height: 14px;
    margin: 4px 0;
  }

  .submenu dl dd img {
    width: 50px;
    height: 50px;
  }



  /* 轮播 */


  .showImg {
    position: relative;
    width: 100% !important;
    height: 550px;
    overflow: hidden;
  }

  /* 轮播图片 */
  .showImg img {
    display: block;
    width: 1920px;
    height: 515px;
  }

  /* 箭头图标 */
  .iconDiv {
    color: rgb(8, 8, 8) !important;
    text-align: center;
    background-color: rgba(0, 0, 0, 0.2);
  }

  .iconDiv.iconDivl {
    position: absolute;
    top: 50%;
    transform: translateY(-50%);
    width: 60px;
    height: 60px;
    border-radius: 50%;
    margin-left: 590px;

    text-align: center;
    cursor: pointer;
  }

  .iconDiv.iconDivr {
    position: absolute;
    top: 50%;
    transform: translateY(-50%);
    width: 60px;
    height: 60px;
    border-radius: 50%;
    margin-right: 340px;
    /* line-height: 30px; */
    text-align: center;
    cursor: pointer;
  }

  .iconDiv:hover {
    background-color: rgba(0, 0, 0, 0.3);
  }

  .icon-left {
    left: 0px;
  }

  .icon-right {
    right: 0px;
  }

  /* 控制圆点 */
  .banner-circle {
    position: absolute;
    bottom: 70px;
    width: 100%;
    height: 20px;
  }

  .banner-circle ul {
    margin: 0 50px;
    height: 100%;
    text-align: center;
  }

  .banner-circle ul li {
    display: inline-block;
    width: 14px;
    height: 14px;
    margin: 0 5px;
    border-radius: 7px;
    background-color: rgba(125, 125, 125, .3);
    cursor: pointer;
  }

  .active {
    background-color: rgb(255, 255, 255) !important;
  }

  .topmenu li {
    /* margin: 0; */

    /* padding-top:  6px; */
  }
</style>