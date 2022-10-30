<template>
    <div>
        <div class="topover">
            <div class="top">
                <div class="container">


                    <div style="height: 24px;"></div>
                    <!-- 距结束 要加计时器-->
                    <div class="timeset">
                        距结束 12:34:00
                    </div>
                    <!-- 限时购物品 -->
                    <div class="flash">
                        <!-- 秒杀商品-单个 -->
                        <template v-for="(sp, index) in sps">

                            <div class="sitem" :key="sp.id" style="margin-left: 0px;">
                                <!-- 商品图(要能改) -->
                                <div class="sitempout">
                                    <img :src="sp.orders.imgURL" class="sitemp" />
                                    <div class="sitempsout">
                                        <div class="sitemps">限时直降{{ sp.orders.jianjia }}</div>
                                    </div>
                                </div>
                                <!-- 商品信息 -->
                                <div class="sitemmsg">
                                    <!-- 商品名(要能改) -->
                                    <div class="sitemname">
                                        <span class="bj618">保价618</span>
                                        {{ sp.orders.name }}
                                    </div>
                                    <!-- 描述(要能改) -->
                                    <div class="imsg">{{ sp.orders.body }}</div>
                                    <div style="display: flex;">
                                        <div class="flashclass">限时特价</div>
                                    </div>
                                    <div class="price">
                                        <!-- 现价(要能改) -->
                                        <div class="nprice">￥{{ sp.orders.unitPrice }}</div>
                                        <!-- 原价(要能改) -->
                                        <div class="oprice">￥{{ sp.orders.oldPrice }}</div>
                                    </div>
                                    <!-- 抢购键 -->
                                    <router-link :to="{
                                        name: 'detalls',
                                        query: {
                                            spxqdx: sps[index],
                                        }
                                    }">

                                        <button class="buybtn">立即购买</button>


                                    </router-link>
                                </div>
                            </div>
                        </template>

                        <!-- 已经到底了 -->
                        <div class="end">
                            已加载全部
                        </div>
                    </div>
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
        return {
            sps: []
        };
    },
    mounted() {
        this.sps = this.$store.state.detalls.spxq


    },
};
</script>

<style scoped>
.topover {
    background-color: rgb(254, 102, 117);
    padding-bottom: 400px;

}

/* .top {
    width: 1200px;
} */
.container {
    width: 1200px;
    margin: 0 auto;
    overflow: hidden;
    background-color: rgb(254, 102, 117);

}

/*规范页面最小宽度1200px */
/* 默认样式 */

.timeset {
    height: 80px;
    text-align: center;
    font-size: 18px;
    color: white;
    margin: auto;
    line-height: 80px;
}

/* 商品区外层 */
.flash {
    width: 1200px;
    padding: 0px 0px;
    display: flex;
    justify-content: space-around;
    flex-wrap: wrap;
}

/* 单个秒杀商品样式 */
.sitem {
    background-color: white;
    display: flex;
    margin: 12px 0px 0px 12px;
    height: 190px;
    width: 392px;
}

/* 图片外层样式 */
.sitempout {
    padding: 21px;
    position: relative;
}

/* 图下文本外层 */
.sitempsout {
    align-items: center;
    padding: 0px 12px 20px 12px;
    position: absolute;
    width: 100%;
    left: 0px;
    /* top: 148px; */
    bottom: 0px;
    height: 40px;
    display: flex;
}

/* 图下文本 */
.sitemps {
    color: #CF0A2C;
    background-color: rgb(251, 231, 234);
    text-align: center;
    padding: 0px 8px;
    border-radius: 8px;
    margin: 0px auto;
    font-size: 12px;
    line-height: 20px;
}

/* 秒杀商品图片样式 */
.sitemp {
    height: 147.728px;
    width: 147.728px;
}

/* 秒杀商品信息样式 */
.sitemmsg {
    width: 202px;
    padding: 20px 12px 20px 8px;
    display: flex;
    flex-direction: column;
    position: relative;
}

/* 保价618样式 */
.bj618 {
    background-image: linear-gradient(1.5708rad, rgb(207, 10, 44), rgb(249, 42, 74));
    color: white;
    line-height: 16px;
    font-size: 12px;
    padding: 0px 4px;
    border-radius: 4px;
}

/* 商品名字样式 */
.sitemname {
    font-size: 16px;
    font-weight: bold;
    overflow: hidden;
    text-overflow: ellipsis;
    display: -webkit-box;
    -webkit-line-clamp: 2;
    -webkit-box-orient: vertical;
    line-height: 21px;
}

/* 商品描述样式 */
.imsg {
    color: gray;
    font-size: 14px;
    line-height: 19px;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
}

/* 限时类型 */
.flashclass {
    color: #CF0A2C;
    font-size: 12px;
    height: 16px;
    border-width: 1px;
    border-style: solid;
    border-color: rgba(207, 10, 44, 0.4);
    border-radius: 4px;
    padding: 0px 4px;
    margin-right: 4px;
}

/* 价格外部样式 */
.price {
    display: flex;
    margin: 0px 0px 8px 0px;
    position: absolute;
    bottom: 56px;
}

/* 现价样式 */
.nprice {
    color: rgb(207, 10, 44);
    margin: 0px 4px 0px 0px;
}

/* 原价样式 */
.oprice {
    color: rgb(128, 128, 128);
    text-decoration-line: line-through;
    font-size: 12px;
    line-height: 16px;
    margin: auto 0px;
}

/* 抢购按钮 */
.buybtn {
    position: absolute;
    bottom: 20px;
    border-radius: 18px;
    color: white;
    background-color: rgb(207, 10, 44);
    border: 0;
    min-width: 102px;
    max-width: 102px;
    font-size: 18px;
    height: 36px;
}

/* 尾部 */
.end {
    opacity: 0.6;
    text-align: center;
    padding: 16px 0px;
}

a {
    text-decoration: none !important;
}
</style>
