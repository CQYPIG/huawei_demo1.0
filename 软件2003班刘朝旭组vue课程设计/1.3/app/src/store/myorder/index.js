import { reqGetOrder } from "@/api"
//home模块专享的小仓库
//任何的小仓库:state、mutations、actions、getters 
//仓库存储数据的地方
let state = {
  //添加数据规范
  //已完成  有效 且 已付款  且  已收货
  //已取消  无效
  //待收货的前提是  有效  且  已付款
  //待评价的前提 是 有效  且已付款 且已收货
  orders: [
    // {
    //   orderId: '5645564564', date: '2020-6-12  08:35:22', logistics: '物流信息', pay: '0.00', dfk: false, dsh: false, yx: true, dpj: true,
    //   commoditys: [
    //     {
    //       id: '001',
    //       name: 'HUAWEI WATCH GT 3 （46mm）活力款 黑色氟橡胶表带 14天续航',
    //       unitPrice: '1288.00',
    //       number: '1',
    //       imgURL: require('../../../public/images/erji.webp')
    //     },
    //     {
    //       id: '002',
    //       name: '	【新品】华为HUAWEI MateBook D 14 2022 12代酷睿版 I5 16GB 512GB 锐炬显卡 14英寸 护眼全面屏 华为笔记本电脑 轻薄本 超级终端 多屏协同 皓月银',
    //       unitPrice: '4999.00',
    //       number: '1',
    //       imgURL: require('../../../public/images/erji.webp')
    //     },
    //     {
    //       id: '003',
    //       name: 'HUAWEI nova 9 Pro 8GB+128GB（9号色）',
    //       unitPrice: '4999.00',
    //       number: '1',
    //       imgURL: require('../../../public/images/erji.webp')
    //     }
    //   ]
    // },
    //待付款的
    //待收货的  前提 已经付款
    //已完成的  前提 已付款  且已收货
    //待评价    前提 已完成
    // {
    //   orderId: '485486855', date: '2022-6-12  08:35:22', logistics: '物流信息', pay: '0.00', dfk: false, dsh: true, yx: true, dpj: false,
    //   commoditys: [
    //     {
    //       id: '004',
    //       name: 'HUAWEI WATCH GT 3 （46mm）活力款 黑色氟橡胶表带 14天续航',
    //       unitPrice: '1288.00',
    //       number: '1',
    //       imgURL: require('../../../public/images/erji.webp')
    //     },
    //   ]
    // },
    //待付款的
    //待收货的  前提 已经付款
    //已完成的  前提 已付款  且已收货
    //待评价    前提 已完成
    // {
    //   orderId: '465487855', date: '2022-6-12  09:45:32', logistics: '物流信息', pay: '0.00', dfk: false, dsh: false, yx: true, dpj: true,
    //   commoditys: [
    //     {
    //       id: '005',
    //       name: '	【新品】华为HUAWEI MateBook D 14 2022 12代酷睿版 I5 16GB 512GB 锐炬显卡 14英寸 护眼全面屏 华为笔记本电脑 轻薄本 超级终端 多屏协同 皓月银',
    //       unitPrice: '4999.00',
    //       number: '1',
    //       imgURL: require('../../../public/images/erji.webp')
    //     },
    //   ]
    // },
    //待付款的
    //待收货的  前提 已经付款
    //已完成的  前提 已付款  且已收货
    //待评价    前提 已完成
//     {
//       orderId: '5645568464', date: '2022-6-12  09:45:32', logistics: '物流信息', pay: '0.00', dfk: true, dsh: false, yx: true, dpj: false,
//       commoditys: [
//         {
//           id: '009',
//           name: 'HUAWEI nova 9 Pro 8GB+128GB（9号色）',
//           unitPrice: '4999.00',
//           number: '1',
//           imgURL: require('../../../public/images/erji.webp')
//         }
//       ]
//     },
//     {
//       orderId: '564848464', date: '2022-6-12  09:45:32', logistics: '物流信息', pay: '0.00', dfk: true, dsh: false, yx: false, dpj: false,
//       commoditys: [
//         {
//           id: '008',
//           name: 'HUAWEI nova 9 Pro 8GB+128GB（9号色）',
//           unitPrice: '4999.00',
//           number: '1',
//           imgURL: require('../../../public/images/erji.webp')
//         }
//       ]
//     },

  ]
};
//唯一可以修改仓库数据地方【工人】
let mutations = {
  //取消订单
  cancel(state, orderId) {
    for (let i = 0; i < state.orders.length; i++) {
      //修改指定订单编号的订单的状态
      if (state.orders[i].orderId == orderId) {
        state.orders[i].yx = false
      }
    }
  },
  //支付订单
  pay(state, orderId) {
    for (let i = 0; i < state.orders.length; i++) {
      //修改指定订单编号的订单的状态
      if (state.orders[i].orderId == orderId) {
        state.orders[i].dfk = false
        state.orders[i].dsh = true

      }
    }
  },
  deleteOrder(state, orderId) {
    for (let i = 0; i < state.orders.length; i++) {
      //修改指定订单编号的订单的状态
      if (state.orders[i].orderId == orderId) {
        console.log('删除前', state.orders);
        state.orders.splice(i, 1)
        console.log('删除后', state.orders);
      }
    }
  },
  GETORDER(state, orders) {
    state.orders = orders
  }

};
//可以处理业务逻辑【if、异步语句等等】
let actions = {
  //获取订单信息的方法
  async getOrder({ commit, state, dispatch }) {

    let result = await reqGetOrder();
    //判断服务器返回的状态是200->成功
    if (result.code == 200) {
      // console.log( result.data);
      commit("GETORDER", result.data);
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




