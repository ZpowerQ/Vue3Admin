<template>
  <div class="common-layout">
    <el-container>
      <el-aside :width="isCollapse ? '65px' : '200px'" class="elAider">
        <nav-menu />
      </el-aside>
      <el-container>
        <el-header><nav-header /></el-header>
        <el-main><router-view></router-view></el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script lang="ts">
import { defineComponent, ref } from 'vue'
import NavMenu from './cpns/NavMenu.vue'
import NavHeader from './cpns/navHeader/NavHeader.vue'
import { emitter } from '@/global/index'
export default defineComponent({
  name: 'ErMain',
  components: {
    NavMenu,
    NavHeader
  },
  setup() {
    let isCollapse = ref<boolean>()
    emitter.on('menuCollapse', (data) => {
      isCollapse.value = data as boolean
    })
    return { isCollapse }
  }
})
</script>

<style scoped lang="less">
.common-layout,
.el-container {
  width: 100%;
  height: 100%;
}
.el-aside {
  background-color: #304156;
  height: 100%;
}
.el-header {
  height: 50px;
  border-bottom: 1px solid #d8dce5;
  box-shadow: 0px 1px rgba(0, 0, 0, 0.1);
  padding: 0px;
}
.elAider {
  transition: all 0.5s ease;
}
.el-main {
  background-color: #f2f2f6;
}
</style>
