# app

## Project setup
```
npm install
```

### Compiles and hot-reloads for development
```
npm run serve
```

### Compiles and minifies for production
```
npm run build
```

### Lints and fixes files
```
npm run lint
```

### Customize configuration
See [Configuration Reference](https://cli.vuejs.org/config/).

<!-- 按顺序执行以下npm命令 -->

<!-- 配置 npm 淘宝镜像： -->

npm config set registry  https://registry.npm.taobao.org

<!-- 全局安装@vue/cli。 -->

npm install -g @vue/cli

<!-- 输入以下命令 安装全局路由 -->

npm i vue-router@3

<!-- npm安装vuex  -->

npm install vuex@3


<!-- 在 vue 项目中引入 bootstrap，首先要引入两个依赖：jQuery 和 popper

第一步、安装
1、npm安装
安装命令如下： -->

cnpm install bootstrap --save-dev

cnpm install jquery --save-dev

cnpm install popper.js --save-dev
<!-- 第二步、引入
在 mian.js 页面，写以下代码 -->


// 引入jQuery、bootstrap

import $ from 'jquery'

import 'bootstrap'

 

// 引入bootstrap样式

import 'bootstrap/dist/css/bootstrap.min.css'

import 'bootstrap/dist/js/bootstrap.min.js'

 

// 全局注册 $

Vue.prototype.$ = $
<!-- 
第三步、配置 jQuery
在 vue.config.js 中，写如下代码（如果没有 vue.config.js ，则在 package.json 同级目录下手动新建） -->

<!-- 放在脚手架配置文件之前 -->

const webpack = require("webpack")

module.exports = {

    // 配置插件参数

    configureWebpack: {

        plugins: [

            // 配置 jQuery 插件的参数

            new webpack.ProvidePlugin({

                $: 'jquery',

                jQuery: 'jquery',

                'window.jQuery': 'jquery',

                Popper: ['popper.js', 'default']

            })

        ]

    }

}

<!-- 然后，就可以使用了 -->

<!-- 测试 bootstrap 5 -->



<!-- Vue单页面如何设置title -->
https://blog.csdn.net/ioszhanghui/article/details/95319214