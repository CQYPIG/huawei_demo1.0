<template>
    <div>
        <div class="topover">
            <div class="top">
                <div class="container">
                    <div class="row" style="height:600px;">
                        <div class="col-sm-4 p-3 ">
                            <div class="row  d-flex flex-wrap align-content-center">
                                <router-link to="/Shouji">
                                    <button class="btn xuanze">手机登录</button>
                                </router-link>
                            </div>
                            <div class="row">
                                <router-link to="/Email">
                                    <button class="btn xuanze">邮箱登录</button>
                                </router-link>
                            </div>

                        </div>
                        <div class="col-sm-4 p-3  ">
                            <router-view></router-view>
                        </div>
                        <div class="col-sm-4 p-3  "></div>
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


        };
    }
};
</script>

<style scoped>
.topover {
/* background-color: rgb(172, 172, 172); */
 padding-top: 100px;
    padding-bottom: 40px;
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

.xuanze{
    position: relative;
    background: rgb(241, 241, 241);
    /* margin-top: 20px; */
    margin-bottom: 10px;
    border-radius: 20px !important;
    left: 150px;
    width: 200px;
    height: 50px;
}
.xuanze.xuanze:focus,
.xuanze.xuanze.focus{
	box-shadow: none;
		/* border: rgb(255, 81, 0) solid 1px; */


}


.hwzhzc {
    text-align: center;
}

</style>
