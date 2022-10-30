<template>
    <div>
        <div class="topover">
            <div class="top">
                <div class="container">
                    <div class=" text-center mt-5 pt-5 h2">
                        华为账号登录
                    </div>

                    <div class=" text-center d-flex justify-content-center mt-5 pt-5">
                        <div class="row">
                            <div class="a8 col">
                                <img class="shadow rounded" src="./images/erweima.png" />
                                <p class="a1 mt-5 pt-2">若您使用华为手机，请进入“设置”>“华为帐号”扫码登录。</p>
                            </div>
                            <div class="a3 col ">
                                <form action="" class="">
                                    <input type="text" class="a2 mb-4 ml-5 form-control" v-modle="name"
                                        placeholder="手机号/邮件地址/账号名">
                                    <input type="password" class="a2 ml-5 mb-3 form-control" v-modle="password"
                                        placeholder="密码">
                                    <a href="#" class="a4 text-primary">短信验证码登录</a><br>
                                    <input type="submit" class="a5 ml-5 mt-4  form-control" @click="login" value="登录">
                                </form>
                                <div class="a6 mt-4 ">
                                    <span class=" pr-3">
                                        <router-link to="/ZhuCe">
                                            注册
                                        </router-link>
                                    </span>

                                    <a href="#" class="a7 ">忘记密码</a>
                                    <a href="#" class="a7 ">遇到问题</a>
                                </div>
                                <div class="a6 mt-4 ">
                                    <a href="#"> <img class="rounded-circle" src="./images/ali.png" /></a>
                                    <a href="#"> <img class="rounded-circle" src="./images/qq.png" /></a>
                                    <a href="#"> <img class="rounded-circle" src="./images/weixin.png" /></a>
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
import axios from 'axios';
export default {
    //给组件起一个名字,开发者工具中显示这个组件的时候，显示的就是这个名字
    name: "",
    data() {
        return {
            name: '',
            password: '',

        };
    },
    methods: {
        login(){
            axios({
                url:'/user/'+this.name+'/'+this.password,
                method:'get',
            }).then((response)=>{
                if(response == null){
                    alert("账号或者密码错误")
                }
            })
        }
    },

};
</script>

<style scoped>
.topover {
    width: 100%;
    background: rgb(242, 242, 242);
}

/* .top {
    width: 1200px;
} */
.container {
    width: 1200px;
    height: 740px;
    margin: 0 auto;
    overflow: hidden;
}

/*规范页面最小宽度1200px */

.a1 {
    font-size: 13px;
}

.a2 {
    height: 48px;
    width: 358px;

}

.a3 {
    margin-left: 60px;
    padding-left: 60px;
    border-left: solid 1px rgb(141, 137, 137);
}

.a3 input {
    border: 0px;
}

.a3 input:focus {
    box-shadow: none;
}


.a4 {
    font-size: 14px;
    float: left;
    text-decoration: none;

}
.a4:hover{
    font-size: 15px;
    float: left;
    text-decoration: none;

}


.a5 {
    width: 360px;
    height: 48px;
    color: aliceblue;
    background-color: rgb(235, 167, 170);
    font-size: 18px;

}

.a6 a {
    text-decoration: none;
    font-size: 18px;
    padding: 0px 20px 0px 20px;
}

.a7 {
    border-left: 1px solid;
    border-color: rgb(36, 36, 36);
}
</style>
