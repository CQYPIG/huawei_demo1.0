<template>
    <div>
        <div class="topover">
            <div class="top">
                <div class="container">
                    <!--限时购-->
                    <router-link class="adivwenzi" to="/Xshigou">
                        <div class="bdwindow">
                            <!-- 限时购标题 -->
                            <div class="title1">
                                <div style="display: flex;flex-direction: row;">
                                    <div class="titletxtl" style="margin-right: 24px;">限时购</div>
                                    <div class="titletxtc">距结束</div>
                                </div>
                                <!-- <div class="titletxtr">限时购></div> -->
                            </div>
                            <!-- 倒计时和商品 -->
                            <div class="bdwindow1">
                                <template v-for="(zs,index) in zhanshi">
                                    <div class="item" :key="zs.id">
                                        <img class="photo" :src="zs.imgURL" />
                                        <div class="textbg01">
                                            <div class="text3">{{zs.xsg}}</div>
                                        </div>
                                        <div class="itemname">{{zs.name}}</div>
                                        <!--这里的物品名要能换-->
                                        <div class="sellmsg">限时降{{zs.jianjia}}元</div>
                                        <!--这里价格要能更换-->
                                        <div style="display: flex; justify-content: center;">
                                            <div class="price">￥{{zs.unitPrice}}</div>
                                            <!--这里价格要能更换-->
                                            <div class="oprice">￥{{zs.oldPrice}}</div>
                                            <!--这里价格要能更换-->
                                        </div>
                                    </div>
                                </template>
                            </div>
                        </div>
                    </router-link>
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
            zhanshi: [],
            imgurl1: ''
        };
    },
    mounted() {
        setTimeout(() => {
            let zhanshi1 = this.$store.state.detalls.spxq[3].orders
            let zhanshi2 = this.$store.state.detalls.spxq[1].orders
            let zhanshi3 = this.$store.state.detalls.spxq[4].orders
            let zhanshi4 = this.$store.state.detalls.spxq[0].orders
            let zhanshi5 = this.$store.state.detalls.spxq[2].orders
            this.zhanshi.push(zhanshi1)
            this.zhanshi.push(zhanshi2)
            this.zhanshi.push(zhanshi3)
            this.zhanshi.push(zhanshi4)
            this.zhanshi.push(zhanshi5)
            // console.log('zhanshi', this.zhanshi);
        }, 200);
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
}

/*规范页面最小宽度1200px */



/* 正文窗口（物品展示窗口） */
.adivwenzi {
    text-decoration: none;
}

.adivwenzi:hover {
    text-decoration: none;
}

.bdwindow {
    margin: 15px 0;
    color: black !important;
}

.bdwindow1 {
    display: flex;
    justify-content: space-around;
    color: black !important;
}

/* 标题（秒杀、限时购分栏） */
.title1 {
    display: flex;
    justify-content: space-between;
}

/* 单个商品空位 */
.item {
    display: flex;
    flex-direction: column;
    width: 220px;
    height: 295px;
    background-color: rgb(255, 255, 255);
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
