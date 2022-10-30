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

                Popper: ['popper.js', 'default'],
                // lintOnSave: false

            })


        ],
        // webpack-devser@4.X的使用





    }

}


const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
    transpileDependencies: true,
    lintOnSave: false,
    devServer: {
        proxy: 'http://localhost:8001'
    },
})