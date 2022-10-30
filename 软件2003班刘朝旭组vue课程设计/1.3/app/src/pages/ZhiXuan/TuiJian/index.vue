<template>
    <div>
        <div class="topover">
            <div class="top">
                <div class="zhixuanimg">
                    <img src="./images/zhixuan.webp" alt="" srcset="">
                </div>
                <div class="container">

                    <!--商品-->
                    <div class="bdwindow">

                        <template v-for="(sp, index) in sps">

                            <router-link class="routerall"  :to="{
                        name: 'detalls',
                        query: {
                          spxqdx: sps[index],
                        }
                      }">
                                <div class="item"  :key="sp.id">
                                    <img :src="sp.orders.imgURL" class="photo" />
                                    <div class="textbg01">
                                        <div class="text3">{{ sp.orders.czms }}</div>
                                    </div>
                                    <div class="itemname">{{ sp.orders.name }}</div>
                                    <!--这里的物品名要能换-->
                                    <div class="sellmsg">{{ sp.orders.body }}</div>
                                    <!--这里价格要能更换-->
                                    <div style="display: flex; justify-content: center;">
                                        <div class="price">￥{{ sp.orders.unitPrice }}</div>
                                        <!--这里价格要能更换-->
                                        <div class="oprice">￥{{ sp.orders.oldPrice }}</div>
                                        <!--这里价格要能更换-->
                                    </div>
                                </div>

                            </router-link>
                        </template>

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
    background: rgb(241, 243, 245);
}

/* .top {
    width: 1200px;
} */
.container {
    width: 1200px;
    margin: 0 auto;
    overflow: hidden;
    min-width: 1200px;
}

/*规范页面最小宽度1200px */
/* .zhixuanimg {
} */
.zhixuanimg img {
    position: relative;
    margin: 0 auto;
    display: block;
    /* width: 1920px; */
    /* height: 490px; */
    min-width: 1200px;

    width: 100%;
    height: 100%
}


/* 正文窗口（物品展示窗口） */

.bdwindow {
    width: 1200px;
}




/* 单个商品空位 */
.routerall {
    text-decoration: none;
    color: black;
}

.routerall:hover {
    text-decoration: none;
    color: black;
}

.item {
    background-color: white;
    display: flex;
    justify-content: space-around;
    flex-direction: column;
    float: left;
    margin: 7px 4px 7px 4px;
    height: 328px;
    width: 280px;
}

.item:hover {
    box-shadow: rgb(0 0 0 / 10%) 0px 0px 36px;
}

/* 标题左侧文本 */
.titletxtl {
    font-size: 24px;
}

/* 标题中部文本 */
.titletxtc {
    font-size: 18px;
    color: rgb(128, 128, 128);
    display: flex;
    flex-direction: column;
    justify-content: center;
}

/* 标题右侧文本 */
.titletxtr {
    /* line-height: 36px; */
    /* padding: auto 0 !important; */
    font-size: 14px;
    display: flex;
    flex-direction: column;
    justify-content: center;
}

.text3 {
    color: rgb(255, 255, 255);
    font-size: 12px;
    /* margin: auto; */
    background-image: linear-gradient(rgb(207, 10, 44), rgb(255, 45, 78));
    border-radius: 5px;
    height: 16px;
    width: 56px;
    text-align: center;
}

/* 商品名 */
.itemname {
    font-size: 14px;
    text-align: center;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
    padding: 0 15px;
}

/* 促销文本背景 */
.textbg01 {
    display: flex;
    justify-content: center;

}

/* 商品图片 */
.photo {
    height: 142px;
    width: 142px;
    margin: 20px auto;
}

/* 促销信息 */
.sellmsg {
    font-size: 13px;
    color: rgb(128, 128, 128);
    text-align: center;
    margin-bottom: 10px;
}

/* 促销价格 */
.price {
    font-size: 16px;
    color: red;
    text-align: center;
    margin-right: 8px;
}

/* 原价 */
.oprice {
    font-size: 12px;
    color: rgb(128, 128, 128);
    text-align: center;
    text-decoration-line: line-through;
    line-height: 24px;
}
</style>
