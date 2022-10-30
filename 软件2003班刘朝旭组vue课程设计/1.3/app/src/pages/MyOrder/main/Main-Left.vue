<template>
    <div class="col-2 mainleft p-0">
        <div class="myborder">
            <!-- <h5>我的商城</h5> -->
            <div class="myshop-outer myshop">
                <router-link to="/">
                    <a class="nav-link text-muted myshop" >我的商城</a>
                </router-link>
            </div>
            <main-left-list>
                <h3 slot="title">我的消息</h3>
                <ul slot="list">
                    <li>
                        <router-link to="">消息中心</router-link>
                    </li>
                    <li>
                        <router-link to="">活动推送</router-link>
                    </li>
                </ul>
            </main-left-list>

            <main-left-list>
                <h3 slot="title">订单中心</h3>
                <ul slot="list">
                    <li>
                        <router-link to="/myOrder" class="wddd" active-class="active">我的订单</router-link>
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
                </ul>
            </main-left-list>
            <main-left-list>
                <h3 slot="title">我的资产</h3>
                <ul slot="list" class="">
                    <li>
                        <router-link to="">我的积分</router-link>
                    </li>
                    <li>
                        <router-link to="">我的优惠券</router-link>
                    </li>
                    <li>
                        <router-link to="">我的代金券</router-link>
                    </li>
                    <li>
                        <router-link to="">等级与特权</router-link>
                    </li>
                </ul>
            </main-left-list>
            <main-left-list>
                <h3 slot="title">购买支持</h3>
                <ul slot="list" class="">
                    <li>
                        <router-link to="">收货地址管理</router-link>
                    </li>
                    <li>
                        <router-link to="">实名认证</router-link>
                    </li>
                    <li>
                        <router-link to="">我的预约</router-link>
                    </li>
                    <li>
                        <router-link to="">到货通知</router-link>
                    </li>
                    <li>
                        <router-link to="">我的优享购</router-link>
                    </li>
                </ul>
            </main-left-list>
            <main-left-list>
                <h3 slot="title">
                    <router-link to="">隐私设置</router-link>
                </h3>
            </main-left-list>
            <main-left-list>
                <h3 slot="title">
                    <router-link to="">帮助中心</router-link>
                </h3>
            </main-left-list>
        </div>
    </div>

</template>
<script>
import MainLeftList from './Main-Left-List.vue';
export default {
    name: 'Main-Left',
    components: {
        MainLeftList
    }
};
</script>
<style scoped>
* {
    padding: 0;
    margin: 0;
}

.mainleft {
    width: 240px;
}

.myborder {
    width: 176px;
    line-height: 30px;
    border-radius: 10px;
    border: 2px solid #f5f5f5;
}

h3 a {
    color: black;
}

.myshop {
    line-height: 60px;
    font-size: 20px;
    color: #CF0A2C !important;
    text-indent: 29px;
    text-decoration: none;
}

.myshop-outer {
    padding-left: 0px;
}

a:hover {
    text-decoration: none;
}
a{
    text-decoration: none;
}
.active {
    color: red !important;
}
.wddd:hover {
    color: red !important;
}
</style>