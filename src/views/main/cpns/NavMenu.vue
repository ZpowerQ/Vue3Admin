<template>
  <div class="NavMenu">
    <div class="title">
      <img src="~@/assets/logo.png" alt="" class="logo" />
      <span v-show="!isCollapse">CMS</span>
    </div>
    <div class="menu">
      <el-menu
        :default-active="activeMenu"
        class="el-menu-vertical-demo"
        background-color="#304156"
        text-color="#fff"
        :collapse="isCollapse"
      >
        <el-sub-menu
          v-for="item in menus"
          :key="item.index"
          :index="item.index"
        >
          <template #title>
            <el-icon>
              <component :is="item.icon"></component>
            </el-icon>
            <span>{{ item.name }}</span>
          </template>
          <el-menu-item
            class="menuItem"
            v-for="sitem in item.children"
            :key="sitem.id"
            :index="sitem.index"
            @click="
              handleMenuItemClick(sitem.url, item.name, sitem.name, sitem.index)
            "
          >
            <el-icon>
              <component :is="sitem.icon"></component>
            </el-icon>
            <span>{{ sitem.name }}</span></el-menu-item
          >
        </el-sub-menu>
      </el-menu>
    </div>
  </div>
</template>

<script lang="ts">
import { defineComponent, ref } from 'vue'
import { emitter } from '@/global/index'
import { useRouter, useRoute } from 'vue-router'
import LocalCache from '@/utils/LocalCache'
export default defineComponent({
  name: 'NavMenu',
  setup() {
    const router = useRouter()
    const route = useRoute()
    let isCollapse = ref(false)
    let activeMenu = ref<string>('1-1')
    //获取菜单
    const menus = LocalCache.getCache('userMenus') ?? []
    //处理路径和菜单元素激活的映射
    const mapRouteToMenu = (url: string) => {
      for (const item of menus) {
        for (const m of item.children) {
          if (url === m.url) activeMenu.value = m.index
        }
      }
    }
    mapRouteToMenu(route.path)
    //监听是否折叠菜单
    emitter.on('menuCollapse', (data) => {
      isCollapse.value = data as boolean
    })
    //处理菜单元素点击事件
    const handleMenuItemClick = (
      url: string,
      menuName: string,
      smenuName: string
    ) => {
      router.push({ path: url ?? '/notFound' })
      emitter.emit('showBreadCrumb', { menuName, smenuName })
      mapRouteToMenu(url)
    }

    return {
      menus,
      isCollapse,
      handleMenuItemClick,
      activeMenu
    }
  }
})
</script>

<style scoped lang="less">
.title {
  margin: 15px auto;
  text-align: center;
  white-space: nowrap;
}
.title span {
  font-size: 35px;
  vertical-align: middle;
  padding-left: 5px;
  color: #41b883;
  letter-spacing: 1px;
}
.logo {
  width: 40px;
  vertical-align: middle;
}
.el-menu {
  border-right: none;
}
// .menuItem {
//   padding-left: 70px !important;
// }
</style>
