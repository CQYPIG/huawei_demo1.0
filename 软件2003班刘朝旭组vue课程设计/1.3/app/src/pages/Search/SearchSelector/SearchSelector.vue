<template>
  <div class="clearfix selector shadow">
    <div class="type-wrap logo">
      <div class="fl key brand">品类:</div>
      <div class="value logos">
        <ul class="type-list">
          <li>手表</li>
          <li>手机</li>
        </ul>
      </div>
      <div class="ext">
        <a href="javascript:void(0);" class="sui-btn">多选</a>
        <a href="javascript:void(0);">更多</a>
      </div>
    </div>
    <div class="type-wrap">
      <div class="fl key">网络制式:</div>
      <div class="fl value">
        <ul class="type-list">
          <li>
            <a>4G</a>
          </li>
          <li>
            <a>5G</a>
          </li>
         
        </ul>
      </div>
      <div class="fl ext"></div>
    </div>
    <div class="type-wrap">
      <div class="fl key">显示屏尺寸:</div>
      <div class="fl value">
        <ul class="type-list">
          <li>
            <a>5.0-5.9英寸</a>
          </li>
          <li>
            <a>6.0-6.9英寸</a>
          </li>
        </ul>
      </div>
      <div class="fl ext"></div>
    </div>
    <div class="type-wrap">
      <div class="fl key">价格:</div>
      <div class="fl value">
        <ul class="type-list">
          <li>
            <a>0-500元</a>
          </li>
          <li>
            <a>500-1000元</a>
          </li>
          <li>
            <a>1000-1500元</a>
          </li>
          <li>
            <a>1500-2000元</a>
          </li>
          <li>
            <a>2000-3000元 </a>
          </li>
          <li>
            <a>3000元以上</a>
          </li>
        </ul>
      </div>
      <div class="fl ext">
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    name: 'SearchSelector',
  }
</script>

<style lang="less" scoped>
  .selector {
    border: 1px solid rgb(255, 255, 255);
    background: rgb(255, 255, 255) ;
    margin-bottom: 5px;
    overflow: hidden;

    .logo {
      border-top: 0;
      margin: 0;
      position: relative;
      overflow: hidden;

      .key {
        padding-bottom: 10px !important;
      }
    }

    .type-wrap {
      margin: 0;
      position: relative;
      overflow: hidden;

      .key {
        width: 120px;
        background: #ffffff;
        color: rgb(133,133,133);
        line-height: 26px;
        text-align: right;
        padding: 10px 10px 0 15px;
        float: left;
      }

      .value {
        overflow: hidden;
        padding: 10px 0 0 15px;
        color: #333;
        margin-left: 120px;
        padding-right: 90px;

       
        .type-list {
          li {
            float: left;
            display: block;
            margin-right: 30px;
            line-height: 26px;

            a {
              text-decoration: none;
              color:rgb(26,26,26);
            }
          }
        }
      }

      .ext {
        position: absolute;
        top: 10px;
        right: 10px;

        .sui-btn {
          display: inline-block;
          padding: 2px 14px;
          box-sizing: border-box;
          margin-bottom: 0;
          font-size: 12px;
          line-height: 18px;
          text-align: center;
          vertical-align: middle;
          cursor: pointer;
          padding: 0 10px;
          background: #fff;
          border: 1px solid #d5d5d5;
        }

        a {
          color: #666;
        }
      }
    }
  }
</style>