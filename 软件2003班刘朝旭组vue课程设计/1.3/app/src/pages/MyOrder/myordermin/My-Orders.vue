<template>
    <div>
        <my-order-top></my-order-top>
        <router-view></router-view>
    </div>
</template>
<script>
import MyOrderTop from './My-Order-Top.vue'
export default{
    components:{
        MyOrderTop,
    }
}
</script>
<style scoped>



</style>