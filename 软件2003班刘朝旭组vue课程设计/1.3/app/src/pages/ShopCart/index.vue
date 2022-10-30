<template>
    <div>
        <div class="topover">
            <div class="top">
                <div class="container">
                    <Items></Items>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import Items from "./shopcartmin/Items"

export default {
    //给组件起一个名字,开发者工具中显示这个组件的时候，显示的就是这个名字
    name: "",
    data() {
        return {


        };
    },
    components: {
        Items
    }

};
</script>

<style scoped>
.topover {
    /* width: 1200px; */
    background: rgb(240, 240, 240);
    padding-bottom: 720px;
}

/* .top {
    width: 1200px;
} */
.container {
    width: 1200px;
    margin: 0 auto;
    overflow: hidden;
    /* background: rgb(207, 206, 206); */
    padding: 0;
}

/*规范页面最小宽度1200px */
</style>
