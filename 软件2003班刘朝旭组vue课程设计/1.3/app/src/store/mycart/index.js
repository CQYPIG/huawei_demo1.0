import { reqGetcartOrder } from "@/api"
//home模块专享的小仓库
//任何的小仓库:state、mutations、actions、getters 
//仓库存储数据的地方
let state = {
  orders: []
};
//唯一可以修改仓库数据地方【工人】
let mutations = {
  GETCARTORDER(state, orders) {
    state.orders = orders
  }
};
//可以处理业务逻辑【if、异步语句等等】
let actions = {
  //获取订单信息的方法
  async getCartOrder({ commit, state, dispatch }) {
    let result = await reqGetcartOrder();
    //判断服务器返回的状态是200->成功
    if (result.code == 200) {
      // console.log( result.data);
      commit("GETCARTORDER", result.data);
    }
  },
};
//仓库计算属性
let getters = {



};

//对外暴露小仓库
export default {
  state,
  mutations,
  actions,
  getters
}




