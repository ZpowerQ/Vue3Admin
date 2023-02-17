import type { Router } from 'vue-router'
import { parseToken } from '@/service/login/login'
import { ElMessage } from 'element-plus'
import LocalCache from '@/utils/LocalCache'
import store from '@/store'
export function checklogin(router: Router) {
  //对除登录以外的页面进行token检测
  router.beforeEach((to) => {
    if (to.path !== '/login') {
      //发送token验证，拦截器自动在header添加token
      parseToken().then((res) => {
        if (!res.data?.data) {
          router.replace('/login')
          ElMessage.error({
            message: '登录过期,请重新登录',
            duration: 1500
          })
          LocalCache.removeMoreCache(
            'id',
            'token',
            'userinfo',
            'userMenus',
            'activeMenu'
          )
        } else {
          store.commit('loginState/setBaseInfo', {
            token: LocalCache.getCache('token'),
            id: LocalCache.getCache('id')
          })
          store.commit(
            'loginState/setUserinfo',
            LocalCache.getCache('userinfo')
          )
          store.commit(
            'loginState/setUserMenus',
            LocalCache.getCache('userMenus')
          )
        }
      })
    }
  })
}
