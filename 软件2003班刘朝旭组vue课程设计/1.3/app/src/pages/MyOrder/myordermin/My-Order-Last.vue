<template>
    <div class="col">
        <div>
            <!-- 最近六个月内订单 -->
            <!-- <a ref="first" href="#" class="btn">全部有效订单</a> -->
            <div class="mylist">
                <a class="listItem active" ref="defalut" @click.prevent="active" @click="all">
                    全部有效订单
                </a>
                <a class="listItem" @click.prevent="active" @click="dfk">
                    待付款
                </a>
                <a class="listItem" @click.prevent="active" @click="dsh">
                    待收货
                </a>
                <a class="listItem" @click.prevent="active" @click="ywc">
                    已完成
                </a>
                <a class="listItem" @click.prevent="active" @click="dpj">
                    待评价
                </a>
                <a class="listItem" @click.prevent="active" @click="yqx">
                    已取消
                </a>
            </div>
            <div>
                <div class="mylist">
                    <div class="thead">
                        <div style="width: 437px;" class="thead-td">商品</div>
                        <div style="width: 96px;" class="thead-td">单价/元</div>
                        <div style="width: 76px;" class="thead-td">数量</div>
                        <div style="width: 76px;" class="thead-td">物流</div>
                        <div style="width: 110px;" class="thead-td">实付款/元</div>
                        <div style="width: 153px;border-right: 0px;" class="thead-td">订单状态及操作</div>
                    </div>
                </div>
                <div v-for="order in orders" :key="order.id">
                    <div class="list-top">
                        <div class="list-top-left my">
                            <input type="checkbox" name="payCheck" paymentstatus="2" clearorder="false"
                                value="28781324342">
                            <span class="date">{{ order.date }}&nbsp;&nbsp;</span>
                            <span class="orderNumber">订单号：<a :href="order.orderURL">{{ order.orderId }}</a></span>
                        </div>
                        <div class="list-top-right">{{ state(order) }}</div>
                    </div>
                    <div class="list">
                        <table>
                            <tr v-for="commodity in order.commoditys" :key="commodity.id">
                                <td style="width: 437px;border-left: 0;" class="tbody-td my">
                                    <div class="td-inner">
                                        <img :src="commodity.imgURL" />
                                        <div class="p-outer">
                                            <a href="" class="m-0">{{ commodity.name }}</a>
                                        </div>
                                    </div>
                                </td>
                                <td style="width: 96px;" class="tbody-td">
                                    {{ commodity.unitPrice }}
                                </td>
                                <td style="width: 76px;" class="tbody-td">
                                    {{ commodity.number }}
                                </td>
                            </tr>
                        </table>
                        <div style="width: 76px;" class="tbody-td div-td">
                            {{ order.logistics }}
                        </div>
                        <div style="width: 110px;" class="tbody-td div-td">
                            {{ order.pay }}
                        </div>
                        <div style="width: 153px;border-right: 0;padding: 10px 0;" class="tbody-td div-td last-td my">
                            <!--立即支付 需要订单有效 且 订单待付款  -->
                            <p v-if="order.dfk == true && order.yx == true">
                                <button class="mybtn" @click="pay(order)">立即支付</button>
                            </p>
                            <!--取消订单 需要 订单有效 且 订单未付款-->
                            <p v-if="order.yx == true && order.dfk == true">
                                <a href="#" @click.prevent @click="cancel(order)">取消订单</a>
                            </p>
                            <!--修改订单 需要订单有效 且订单未完成 订单未付款 -->
                            <p v-if="order.yx == true && order.dfk == true">
                                <a href="#" @click.prevent>修改订单</a>
                            </p>
                            <!--删除订单 订单已完成 或者订单以关闭 -->
                            <p
                                v-if="(order.yx == true && order.dfk == false && order.dsh == false) || order.yx == false">
                                <a href="#" @click.prevent @click="deleteOrder(order)">删除订单</a>
                            </p>
                            <p><a href="#" @click.prevent>订单详情</a></p>
                        </div>
                    </div>
                </div>
                <!-- 卸载订单循环的外面，不然当订单数为0的时候执行不到这行代码 -->
                <div class="zero-outer" v-if="orders.length == 0">
                    <p class="zero-p">您暂时没有相关记录。</p>
                </div>

            </div>
        </div>
    </div>
</template>
<script>
export default {
    data() {
        return {
            orders: [],

        }
    },
    components: {
    },
    methods: {
        active(e) {
            let as = document.getElementsByClassName('listItem')
            for (let i = 0; i < as.length; i++) {
                as[i].style.backgroundColor = '#F2F2F2';
                as[i].style.color = '#666';
            }
            e.target.style.backgroundColor = '#2D2D2D'
            e.target.style.color = 'white'
        },
        //所有数据
        all() {
            console.log("all");
            console.log("all===>", this.$store.state.myorder.orders);

            this.orders = this.$store.state.myorder.orders.filter((order) => {
                return Date.now() - Date.parse(order.date) < 2592000000 * 6
            })
        },
        //待付款的
        dfk() {
            this.orders = this.$store.state.myorder.orders.filter((order) => {
                return order.yx == true && order.dfk == true && Date.now() - Date.parse(order.date) < 2592000000 * 6
            })
        },
        //待收货的  前提 已经付款
        dsh() {
            this.orders = this.$store.state.myorder.orders.filter((order) => {
                return order.yx == true && order.dfk == false && order.dsh == true && Date.now() - Date.parse(order.date) < 2592000000 * 6
            })
        },
        //已完成的  前提 已付款  且已收货
        ywc() {
            this.orders = this.$store.state.myorder.orders.filter((order) => {
                return order.yx == true && order.dfk == false && order.dsh == false && Date.now() - Date.parse(order.date) < 2592000000 * 6
            })
        },
        //待评价    前提 已完成
        dpj() {
            this.orders = this.$store.state.myorder.orders.filter((order) => {
                return order.yx == true && order.dfk == false && order.dsh == false && Date.now() - Date.parse(order.date) < 2592000000 * 6
            })
        },
        yqx() {
            this.orders = this.$store.state.myorder.orders.filter((order) => {
                return order.yx == false && Date.now() - Date.parse(order.date) < 2592000000 * 6
            })
        },
        state(order) {
            if (order.yx == true && order.dfk == true) {
                return '待付款'
            }
            if (order.yx == true && order.dfk == false && order.dsh == true) {
                return '待收货'
            }
            if (order.yx == true && order.dfk == false && order.dsh == false) {
                return '已完成'
            }
            if (order.yx == true && order.dfk == false && order.dsh == false && order.dpj == true) {
                return '待评价'
            }
            if (order.yx == false) {
                return '交易关闭'
            }
        },
        //取消订单
        cancel(order) {
            if (confirm('是否确定取消订单？')) {
                this.$store.commit('cancel', order.orderId)
                for (let i = 0; i < this.orders.length; i++) {
                    //修改指定订单编号的订单的状态
                    if (this.orders[i].orderId == order.orderId) {
                        console.log("想要的代码执行了");
                        this.orders[i].yx = false
                    }
                }
            }
        },
        //订单支付
        pay(order) {
            this.$store.commit('pay', order.orderId)
            for (let i = 0; i < this.orders.length; i++) {
                //修改指定订单编号的订单的状态
                if (this.orders[i].orderId == order.orderId) {
                    console.log("想要的代码执行了");
                    this.orders[i].dfk = false
                    this.orders[i].dsh = true

                }
            }
        },
        //删除订单
        deleteOrder(order) {
            if (confirm('是否确定删除订单？此操作不可逆！')) {
                //删除vuex中的这条数据  （用于数据库操作）
                this.$store.commit('deleteOrder', order.orderId)
                //删除当前页面拿到的那个用于展示数据的orders中删除这条数据  （用于数据展示）
                for (let i = 0; i < this.orders.length; i++) {
                    //修改指定订单编号的订单的状态
                    if (this.orders[i].orderId == order.orderId) {
                        this.orders.splice(i, 1)
                    }
                }
            }
            // this.all()
        }

    },
    //路由加载完成的时候更新orders
    mounted() {
        setTimeout(() => {

            console.log("last===>", this.$store.state.myorder.orders);
            this.orders = this.$store.state.myorder.orders.filter((order) => {
                return Date.now() - Date.parse(order.date) < 2592000000 * 6
            })
        }, 200)
        // this.orders = this.$store.state.myorder.orders.filter((order)=>{
        //     return Date.now() - Date.parse(order.date) < 2592000000*6
        // })

        //初始状态下  全部订单按钮处于active
        var e = document.createEvent("MouseEvents");
        e.initEvent("click", true, true);
        this.$refs.defalut.dispatchEvent(e);

    }
}
</script>
<style scoped>
* {
    padding: 0;
    margin: 0;
}

.mylist a:focus {
    box-shadow: none;
}

.mylist {
    height: 31px;
    margin-top: 16px;
    margin-bottom: 30px;
}

.mylist a {
    float: left;
    margin-right: 10px;
    padding: 3px 16px;
    font-size: 14px;
    background-color: #F2F2F2;
    text-decoration: none;
    color: #666;
}

.mylist a:hover {
    color: white !important;
    background-color: #2D2D2D !important;
}

.active {
    color: white;
    background-color: #2D2D2D;
}


/* list的央视 */
.thead {
    background-color: #FAFAFA;
    /* width: 936px; */
    padding: 13px 0;
    display: flex;
    flex-direction: row;
}

.thead-td {
    font-size: 14px;
    color: #888;
    text-align: center;
    border-right: 1px solid #DEDEDE;
}

.tbody-td {
    font-size: 14px;
    color: #888;
    text-align: center;
    border: 1px solid #DEDEDE;
    border-right: 0;
    border-top: 0;

}

.div-td {
    display: flex;
    flex-direction: column;
    justify-content: center;
}

.td-inner {
    display: flex;
    flex-direction: row;
    text-align: center;
    justify-content: flex-start;
}

.td-inner img {
    width: 100px;
    height: 100px;
}

.p-outer {
    display: flex;
    flex-direction: column;
    justify-content: center;
    padding: 10px;
}

.list {
    background-color: white;
    /* width: 936px; */
    padding: 0;
    display: flex;
    flex-direction: row;
    border-top: 1px solid #DEDEDE;
}

.list-top {
    /* border-bottom: 1px solid #DEDEDE; */
    font-size: 14px;
    padding: 23px 0 5px;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
}

input {
    margin: 2px 6px 0 8px;
}

.my a {
    text-decoration: none;
    color: #3a3a3a;
}

.my a:hover {
    color: red;
}

.date {
    color: #888888;
    font-size: 14px;
}

.list-top-right {
    color: #888888;
    font-size: 14px;
}

.last-td p {
    margin: 0;
    display: flex;
    flex-direction: row;
    justify-content: center;
}

.mybtn {
    color: white;
    width: 118px;
    height: 28px;
    line-height: 26px;
    text-align: center;
    font-size: 14px;
    background-color: #ca151e;
    border: 1px solid #ca151e;
    margin-bottom: 5px;
}

.mybtn:focus {
    outline: none;
    box-shadow: rgb(255, 0, 0) 0px 0px 36px;
}

.active {
    color: white;
    background-color: #2D2D2D;
}

.zero-p {
    color: #888888;
}

.zero-outer {
    padding: 50px 0;
    font-size: 14px;
    text-align: center;
}
</style>