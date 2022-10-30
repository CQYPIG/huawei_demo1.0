<template>
    <div>
        <div class="topover">
            <div class="top">
                <div class="container   ">

                    <div class="row  text-center zhzc "><span>华为帐号注册</span></div>
                    <div class="row  text-center zhzc ">

                        <router-link class="qdl" to="/Login">
                            已有帐号, <i>去登录 ></i>
                        </router-link>

                    </div>


                    <form action="">
                        <div class="mb-3 mt-3 myzcdiv">
                            <!-- <label for="email" class="form-label">手机号:</label> -->
                            <input type="text" v-model="userObject.phone" class="form-control" id="email"
                                placeholder="手机号" name="text">
                        </div>
                        <div class="mb-3 mt-3 myzcdiv">
                            <!-- <label for="email" class="form-label">验证码:</label> -->
                            <input type="text" class="form-control" id="email" :value="userObject.yzm" placeholder="验证码"
                                name="text">
                            <button @click="getYanzm" type="button" class="input-group-text hqyzm">获取验证码</button>
                        </div>
                        <div class="mb-3 mt-3 myzcdiv">

                            <!-- <label for="pwd" class="form-label">密码:</label> -->
                            <input type="password" class="form-control" id="pwd" v-model="userObject.password"
                                placeholder="密码" name="pswd">

                        </div>

                        <div class="row myzcdiv">
                            <button @click="setUser" type="button" class="btn zc">注册</button>

                        </div>

                    </form>



                </div>
            </div>
        </div>
    </div>
</template>

<script>
import { nanoid } from 'nanoid';
export default {
    //给组件起一个名字,开发者工具中显示这个组件的时候，显示的就是这个名字
    name: "",
    data() {
        return {

            userObject: {
                yzm: '',
                phone: '',
                password: '',
                token:''
            }
        };
    },
    methods: {
        getYanzm() {
            this.userObject.token=nanoid()
            this.userObject.yzm = this.userObject.token.substring(0, 5)
            console.log(this.userObject.yzm);
        },
        setUser() {
            this.$store.state.zhuce.users.push(this.userObject)
        }
    },
};
</script>

<style scoped>
/* .topover {
    width: 1200px;
}
.top {
    width: 1200px;
} */
/* .container {
    width: 1200px;
    margin: 0 auto;
    overflow: hidden;
} */

/*规范页面最小宽度1200px */
.zhzc span {
    font-size: 30px;
    color: black;
}

.qdl {
    text-decoration: none;
    color: black;
}

.qdl:hover {
    text-decoration: none;
    color: black;
}

.qdl i {
    text-decoration: none;
    color: rgb(0, 155, 245);

}

.qdl i:hover {
    text-decoration: none;
    color: rgba(0, 155, 245, 0.76);
}

.hqyzm {
    position: absolute;
    border-radius: 5px !important;
    color: rgb(151, 198, 247);
    border: none;
    background: none;
    right: 0px;
    top: -0px;
    font-size: 14px;

}

.zc {
    position: relative;
    background: rgb(235, 167, 170);
    color: aliceblue;
    width: 375px;
    border: none;
    border-radius: 15px;
    /* left: 9px; */
}

.zc:hover {
    position: relative;
    background: rgb(235, 167, 170);
    color: rgb(0, 0, 0);
    width: 375px;
    border: none;
    border-radius: 15px;
    /* left: 9px; */
}

.myzcdiv {
    position: relative;
    margin-top: 50px !important;
}

.myzcdiv input {
    height: 50px;
    background-color: rgb(242, 242, 242);
    border: none;
    border-radius: 15px;
    color: black;
}

.myzcdiv button {
    height: 50px;
}
</style>
