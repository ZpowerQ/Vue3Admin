import { createRouter, createWebHashHistory } from 'vue-router'
import { RouteRecordRaw } from 'vue-router'
import { checklogin } from './login/login'
const routes: RouteRecordRaw[] = [
  {
    path: '/',
    redirect: '/login'
  },
  {
    path: '/main',
    name: 'main',
    redirect: '/main/overview/technology',
    component: () => import('@/views/main/main.vue')
  },
  {
    path: '/login',
    name: 'login',
    component: () => import('@/views/login/login.vue')
  },
  {
    path: '/:pathMatch(.*)*',
    component: () => import('@/views/notFound/NotFound.vue')
  }
]

const router = createRouter({
  routes,
  history: createWebHashHistory()
})
checklogin(router)

export default router
