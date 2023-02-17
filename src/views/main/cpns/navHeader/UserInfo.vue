<template>
  <div class="userInfo">
    <el-icon size="30px" class="colIcon" @click="handleCollapse">
      <component :is="colIcon"></component>
    </el-icon>
    <div class="userhandle">
      <div class="road">
        <el-breadcrumb separator="/">
          <el-breadcrumb-item>{{ firstMenu }}</el-breadcrumb-item>
          <el-breadcrumb-item>{{ secondMenu }}</el-breadcrumb-item>
        </el-breadcrumb>
      </div>
      <div class="showuser">
        <el-icon :size="20" style="padding: 10px"><Search /></el-icon>
        <el-icon :size="20" style="padding: 10px"><Bell /></el-icon>
        <el-icon :size="20" style="padding: 10px"><Setting /></el-icon>
        <el-dropdown class="dropDwon">
          <span>
            <el-avatar :size="32" :src="usericon" />
            <el-icon>
              <arrow-down />
            </el-icon>
          </span>
          <template #dropdown>
            <el-dropdown-menu>
              <el-dropdown-item>个人中心</el-dropdown-item>
              <el-dropdown-item>布局设置</el-dropdown-item>
              <el-dropdown-item divided @click="loginout()"
                >退出登录</el-dropdown-item
              >
            </el-dropdown-menu>
          </template>
        </el-dropdown>
      </div>
    </div>
  </div>
</template>

<script lang="ts">
import { defineComponent, ref } from 'vue'
import { emitter } from '@/global/index'
import type { menu } from './type'
import LocalCache from '@/utils/LocalCache'
import { useRouter } from 'vue-router'
import { ElMessage } from 'element-plus'
export default defineComponent({
  name: 'UserInfo',
  setup() {
    let colIcon = ref<string>('Fold')
    let isCollapse = ref<boolean>(false)
    let firstMenu = ref<string>('系统总览')
    let secondMenu = ref<string>('核心技术')
    const router = useRouter()
    //折叠菜单事件
    const handleCollapse = () => {
      isCollapse.value = !isCollapse.value
      colIcon.value = isCollapse.value ? 'Expand' : 'Fold'
      emitter.emit('menuCollapse', isCollapse.value)
    }
    //更新面包屑
    emitter.on('showBreadCrumb', (menu) => {
      firstMenu.value = (menu as menu).menuName
      secondMenu.value = (menu as menu).smenuName
    })
    //设置头像
    let usericon = ref(
      LocalCache.getCache('userinfo')?.usericon ??
        'http://localhost:8080/default.png'
    )
    setTimeout(() => {
      usericon.value = LocalCache.getCache('userinfo')?.usericon
    }, 500)

    const loginout = () => {
      router.replace('/login')
      LocalCache.removeMoreCache('token', 'userinfo', 'userMenus', 'id')
      ElMessage({
        message: '退出登录成功',
        duration: 1500,
        type: 'success'
      })
    }
    return {
      colIcon,
      handleCollapse,
      isCollapse,
      firstMenu,
      secondMenu,
      usericon,
      loginout
    }
  }
})
</script>

<style scoped lang="less">
.userInfo {
  border-bottom: 1px solid #e9ecf0;
  height: 50px;
  display: flex;
}
.colIcon {
  padding: 10px;
  cursor: pointer;
}
.userhandle {
  flex: 1;
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding-right: 50px;
}
.el-breadcrumb__inner {
  font-size: 16px;
}
.showuser {
  display: flex;
  align-items: center;
}
.dropDwon {
  margin-left: 10px;
}
</style>
