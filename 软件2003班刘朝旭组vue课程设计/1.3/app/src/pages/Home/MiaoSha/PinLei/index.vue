<template>
    <div>
        <div class="topover">
            <div class="top">
                <div class="container">
                    <!-- 主体 -->
                    <!-- 标题图案 -->
                    <div>
                        <div>
                            <img src="../images/seckill-title01.png" style="position: absolute;">
                        </div>
                        <div class="tphotobox">
                            <img src="../images/seckill-title03.png" class="tphoto">
                        </div>
                    </div>
                    <!-- 商品区 -->
                    <div>
                        <div class="categorybox">
                            <div class="categorytime">
                                <div class="classify">
                                    <!-- 秒杀分类要是能改的 共两处-->
                                    <div class="classtxt">手机秒杀</div>
                                    <div class="classicon">></div>
                                </div>
                                <div class="classtime">
                                    <div class="timetxt">距结束</div>
                                    <!-- 倒计时需要加工 两处-->
                                    <div
                                        style="color: red; background-color: white; line-height: 32px; height: 32px; margin: 0px 8px; font-size: 18px;">
                                        20 : 20 : 20</div>
                                </div>
                            </div>
                            <div class="categorymsg" style="background-color: white;">
                                <!-- 单行商品 -->
                                <div class="sitemline">
                                    <!-- 单个商品 -->
                                    <template v-for="(sp, index) in sps">

                                        <div class="sitem" :key="sp.id">
                                            <router-link class="roturlinka" :to="{
                                                name: 'detalls',
                                                query: {
                                                    spxqdx: sps[index],
                                                }
                                            }">


                                                <!-- 商品图(要能改) 为了省空间和方便，暂时先用了同一张图 二十处（20）-->
                                                <div style="padding: 16px 31px;">
                                                    <img :src="sp.orders.imgURL" class="sitemp" />

                                                </div>
                                                <!-- 商品信息 -->
                                                <div class="sitemmsg">
                                                    <!-- 商品名(要能改)20 -->
                                                    <div class="sitemname">{{ sp.orders.name }}</div>
                                                    <div class="price">
                                                        <!-- 现价(要能改)20 -->
                                                        <div class="nprice">￥{{ sp.orders.unitPrice }}</div>
                                                        <!-- 原价(要能改)20 -->
                                                        <div class="oprice">￥{{ sp.orders.oldPrice }}</div>
                                                    </div>
                                                </div>
                                            </router-link>

                                        </div>
                                    </template>

                                </div>
                            </div>
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
    .roturlinka {
        color: black;
        text-decoration: none;
    }

    .roturlinka:hover {
        color: black;
        text-decoration: none;
    }

    .topover {
        background: rgb(241, 243, 245);
    }

    /* .top {
} */
    .container {
        width: 1200px;
        margin: 0 auto;
        overflow: hidden;
        background: rgb(241, 243, 245);
        padding: 0;
    }

    /*规范页面最小宽度1200px */


    /* 顶部边框红线 */
    .tbox {
        border-bottom: 2px solid red;
        background-color: rgb(255, 255, 255);
    }

    /* 被选中顶部按键样式 */
    .buttoncheck {
        background-color: rgb(207, 10, 44);
        min-width: 132px;
        line-height: 48px;
        color: rgb(255, 255, 255);
        border: 0px;
        font-size: 20px;
    }

    /* 未选中顶部按键样式 */
    .buttonother {
        background-color: rgb(255, 255, 255);
        min-width: 132px;
        line-height: 48px;
        border: 0px;
        font-size: 20px;
    }

    /* 品类秒杀图片样式 */
    .tphoto {
        height: 60px;
        width: 195px;
    }

    /* 品类秒杀外层样式 */
    .tphotobox {
        height: 200px;
        width: 195px;
        margin: auto;
        line-height: 200px;
    }

    /* 整体背景色 */
    .allbg {
        background: rgb(255, 101, 101);

    }

    /* 背景样式 */
    .categorybox {
        background: rgb(255, 101, 101);

        position: relative;
        margin: 0;
        padding: 0;
        padding-bottom: 130px;

    }

    /* 标题外层样式 */
    .categorytime {
        position: relative;
        height: 0px;
        width: 1200px;
        top: 0px;
        padding: 0px 38px;
        display: flex;
    }

    /* 商品外层样式 */
    .categorymsg {
        background: rgb(255, 101, 101) !important;

        position: relative;
        top: 84px;
        width: 1200px;
        height: 522px;
    }

    /* 秒杀分类外层样式 */
    .classify {
        height: 48px;
        widows: 200px;
        padding-top: 17px;
        display: flex;
    }

    /* 秒杀分类文字样式 */
    .classtxt {
        color: white;
        font-size: 24px;
    }

    /* 秒杀分类图标样式 */
    .classicon {
        color: white;
        background-color: rgb(255, 255, 255, 0.5);
        width: 20px;
        height: 20px;
        border-radius: 10px;
        margin-top: 8px;
        margin-left: 8px;
        text-align: center;
        line-height: 20px;
    }

    /* 计时外层样式 */
    .classtime {
        display: flex;
        margin-left: 772px;
        padding-top: 24px;
        width: 204px;
    }

    /* 计时文字样式 */
    .timetxt {
        color: white;
        font-size: 18px;
        line-height: 32px;
        width: 54px;
    }

    /* 商品行样式 */
    .sitemline {
        background: rgb(255, 101, 101);

        width: 1200px;
        padding: 0;
        display: flex;
        flex-wrap: wrap;
    }

    /* 单个秒杀商品样式 */
    .sitem {
        background-color: white;
        box-shadow: rgb(0 0 0/10%) 0px 0px 6px;
        margin: 5px 18px 5px 20px;
        height: 237px;
        width: 200px;
    }

    .sitem:hover {
        box-shadow: rgb(0 0 0/10%) 0px 0px 36px;
    }

    /* 秒杀商品图片样式 */
    .sitemp {
        height: 122px;
        width: 122px;
    }

    /* 秒杀商品信息样式 */
    .sitemmsg {
        width: 168px;
        height: 105px;
        display: flex;
        flex-direction: column;
    }

    /* 商品名字样式 */
    .sitemname {
        font-size: 16px;
        line-height: 16px;
        text-align: center;
        overflow: hidden;
        text-overflow: ellipsis;
    }

    /* 价格外部样式 */
    .price {
        display: flex;
        margin: 9px auto;
    }

    /* 现价样式 */
    .nprice {
        color: rgb(207, 10, 44);
    }

    /* 原价样式 */
    .oprice {
        color: rgb(128, 128, 128);
        text-decoration-line: line-through;
        font-size: 12px;
        line-height: 24 px;
        margin: auto 0px;
    }
</style>