// import { reqCategoryList } from "@/api"
import { reqBannerList } from "@/api"
import axios from 'axios';

//home模块专享的小仓库
//任何的小仓库:state、mutations、actions、getters 

//仓库存储数据的地方
let state = {
    //商品分类的数据,仓库里面数据起始数值不要瞎写【服务器返回的是啥】
    category: [],
    //轮播
    banner: [],
};
//唯一可以修改仓库数据地方【工人】
let mutations = {
    //多级菜单
    GETCATEGORYLIST(state, category) {
        state.category = category;
    },
    //轮播
    GETBANNERLIST(state, banner) {
        state.banner = banner;
    }
};
//可以处理业务逻辑【if、异步语句等等】
let actions = {
    async getCategoryList({ commit, state, dispatch }) {
        axios({
            url: '/getCategoryList',
            method: 'get',
        }).then((response) => {
            if (response.data.code == '200') {
                console.log(response.data.result);
                commit("GETBANNERLIST", response.data.result);
            }
        })

    },
    async getBannerList({ commit, state, dispatch }) {

        let result = await reqBannerList();
        //判断服务器返回的状态是200->成功
        if (result.code == 200) {
            commit("GETBANNERLIST", result.data);
        }


    },
};
//仓库计算属性
let getters = {};

//对外暴露小仓库
export default {
    state,
    mutations,
    actions,
    getters
}




