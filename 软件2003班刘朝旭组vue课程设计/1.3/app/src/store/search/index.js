import { reqGetSearchList } from "@/api"


//home模块专享的小仓库
//任何的小仓库:state、mutations、actions、getters 

//仓库存储数据的地方
let state = {
    //商品分类的数据,仓库里面数据起始数值不要瞎写【服务器返回的是啥】
    searchlist:{}
};
//唯一可以修改仓库数据地方【工人】
let mutations = {
    GETAEARCHLIST(state, searchlist) {
        state.searchlist = searchlist;
    }
};
//可以处理业务逻辑【if、异步语句等等】
let actions = {
    async getSearchList({ commit }, params = {}) {
        let result = await reqGetSearchList(params);
        console.log(result);
        if (result.code == 200) {
            commit("GETAEARCHLIST", result.data);
        }
    }
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




