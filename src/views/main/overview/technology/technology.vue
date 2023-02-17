<template>
  <div class="technology">
    <el-card class="box-card">
      <template #header>
        <div class="card-header">
          <strong>关于</strong>
        </div>
      </template>
      <span
        >Vue3Admin是基于Vue3、Vuex、VueRouter、Webpack、ElementPlus、Typescript、Echart5等后台系统解决方案。</span
      >
    </el-card>
    <el-card class="box-card">
      <template #header>
        <div class="card-header">
          <strong>技术栈</strong>
        </div>
      </template>
      <ul>
        <li v-for="tool in tools" :key="tool.tname">
          {{ tool.tname }}&nbsp; :&emsp;<el-link type="primary">{{
            tool.tvalue
          }}</el-link>
        </li>
      </ul>
    </el-card>
    <el-card class="box-card">
      <template #header>
        <div class="card-header">
          <strong>生产环境依赖</strong>
        </div>
      </template>
      <el-descriptions :column="2" border>
        <el-descriptions-item v-for="depend in dependences" :key="depend.name">
          <template #label>
            <span>{{ depend.name }}</span></template
          >
          <el-button type="primary" plain size="small">{{
            depend.data
          }}</el-button>
        </el-descriptions-item>
      </el-descriptions>
    </el-card>
  </div>
</template>

<script lang="ts">
import { defineComponent } from 'vue'

export default defineComponent({
  name: 'technology',
  setup() {
    const tools = [
      { tname: '开发工具', tvalue: 'Visual Studio Code' },
      { tname: '编程语言', tvalue: 'Typescript 4.x + Javascript' },
      { tname: '构建工具', tvalue: 'Webpack5.x' },
      { tname: '前端框架', tvalue: 'Vue 3.x' },
      { tname: '路由工具', tvalue: 'Vue Router 4.x' },
      { tname: '状态管理', tvalue: 'Vuex 4.x' },
      { tname: 'UI框架', tvalue: 'Element Plus' },
      { tname: '可视化', tvalue: 'Echart 5.x' },
      { tname: '工具库', tvalue: '@vueuse/core + dayjs + countup.js' },
      { tname: 'CSS预编译', tvalue: 'Sass/Less' },
      { tname: 'HTTP工具', tvalue: 'Axios' },
      { tname: 'Git Hook工具', tvalue: 'EditorConfig + Prettier + ESLint' },
      { tname: '代码规范', tvalue: 'Visual Studio Code' },
      { tname: '提交规范', tvalue: 'Commitizen + Commitlint' },
      { tname: '自动部署', tvalue: 'Centos + Jenkins + Nginx' }
    ]
    const dependences = [
      { name: 'vue', data: '^3.2.13' },
      { name: 'vue-router', data: '^4.0.13' },
      { name: 'vuex', data: '^4.1.0' },
      { name: 'axios', data: '^1.1.3' },
      { name: 'element-plus', data: '^2.2.18' },
      { name: 'echarts', data: '^5.4.0' },
      { name: 'dayjs', data: '^1.11.6' },
      { name: 'counter.js', data: '^2.3.2' }
    ]
    return { tools, dependences }
  }
})
</script>

<style scoped>
:deep(.el-card__header) {
  padding: 12px;
}
:deep(.el-card__body) {
  padding: 12px;
}
:deep(.el-card:not(:first-child)) {
  margin-top: 15px;
}
ul {
  font-size: 14px;
  padding-left: 24px;
}
ul li {
  padding: 5px;
}
</style>
