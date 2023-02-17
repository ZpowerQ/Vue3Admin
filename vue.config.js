const AutoImport = require('unplugin-auto-import/webpack')
const Components = require('unplugin-vue-components/webpack')
const { ElementPlusResolver } = require('unplugin-vue-components/resolvers')
const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  // publicPath: './'
  configureWebpack: {
    //按需引入element-plus的配置
    plugins: [
      AutoImport({
        resolvers: [ElementPlusResolver()]
      }),
      Components({
        resolvers: [ElementPlusResolver()]
      })
    ],
    //网络请求代理配置
    devServer: {
      proxy: {
        '/api': {
          target: 'http://localhost:8080',
          pathRewrite: { '^/api': '' },
          changeOrigin: true
        }
      }
    }
  }
})
