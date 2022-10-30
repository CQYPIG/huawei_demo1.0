<template>
<div class="top">
        <div class="top-left">
            <h2 class="m-0 p-0" id="myorder">我的订单</h2>
        </div>
        <div class="top-right">
            <div>
                <router-link active-class="active" style="position: relative;" class="btn axhx" to="/last">
                    <div class="btn-left"></div>
                    最近六个月内订单
                </router-link>
            </div>
            <div>
                <router-link active-class="active"    style="position: relative;" class="btn axhx" to="/ago">
                    <div class="btn-right"></div>
                    六个月前订单
                </router-link>
            </div>
        </div>
    </div>
</template>
<script>

export default{

}
</script>
<style scoped>
.top{
    display: flex;
    justify-content: space-between;
    border-bottom: 1px solid #DEDEDE;
}
h2{
    font-size: 24px;
    line-height: 1.2;
    padding: 8px 0 0 2px;
    color: #3a3a3a;
    line-height: 50px;
}
.top-right{
    display: flex;
    flex-direction: row;
}
/*选中时的样式 */
.btn:focus{
    box-shadow: none;
    border-bottom: 1px solid black;
    /*
        选中时禁用hover伪样式
        这玩意儿会禁路由，妈的
    */
    /* pointer-events:none; */
}
.active{
    border-bottom: 1px solid black;
    color: black !important;
}


.btn{
    height: 50px;
    display: block;
    color: #888;
    font-size: 14px;
    padding: 0 13px;
    line-height: 50px;
    border-radius: 0;
}
@keyframes left {
  from {width: 0%;}
  to {width: 100%;}
}
@keyframes right {
  from {width: 0%;}
  to {width: 100%;}
}
.btn-left{
    border-bottom: 1px solid black;
    height: 49px;
    /* width: 100%; */
    position: absolute;
    right: 0px;
    transition: all 2s linear;
}
.btn-right{
    border-bottom: 1px solid black;
    height: 49px;
    position: absolute;
    left: 0px;
}

.btn:hover .btn-left{
    animation-name: left;
    animation-duration: 0.5s;
    animation-fill-mode:forwards;
}
.btn:hover .btn-right{
    animation-name: right;
    animation-duration: 0.5s;
    animation-fill-mode:forwards;
}

.axhx:hover{
     text-decoration: none;
}
</style>