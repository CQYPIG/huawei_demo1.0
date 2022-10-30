import Vue from 'vue'
import App from './App.vue'

// 引入jQuery、bootstrap
import $ from 'jquery'
import 'bootstrap'
// 引入bootstrap样式
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap/dist/js/bootstrap.min.js'
// 全局注册 $
Vue.prototype.$ = $


//引入VueRouter
import VueRouter from 'vue-router'
//引入路由器
import router from './router'
//应用插件
Vue.use(VueRouter)



//注册仓库功能
import store from './store';



//引入mock.js文件,让咱们模拟接口跑起来

import "@/mock/index";

//将项目全部请求函数引入进来[分别暴露]
import * as http from '@/api';

// import {reqGetSpxq} from "@/api"
// console.log(reqGetSpxq);


Vue.config.productionTip = false

new Vue({
  //配置全局事件总线
  beforeCreate() {
    //配置全局事件总线
    Vue.prototype.$bus = this;
    //通过Vue.prototype原型对象,将全部请求函数挂载到原型对象身上[VC:就可以使用请求函数]
    Vue.prototype.$http = http;
  },
  //给项目添加路由功能,给全部VC实例身上拥有两个属性,$router|$route
  router,
  //给项目添加仓库功能,给全部VC拥有一个$store属性
  store,
  render: h => h(App),
}).$mount('#app')
