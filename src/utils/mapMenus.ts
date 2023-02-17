import { RouteRecordRaw } from 'vue-router'

export function mapMenusToRouters(userMenus: any[] = []): RouteRecordRaw[] {
  const routes: RouteRecordRaw[] = []

  //加载默认所有的routes
  const allRoutes: RouteRecordRaw[] = []
  const routeFiles = require.context('../router/main', true, /\.ts/)
  routeFiles.keys().forEach((key) => {
    const route = require('../router/main' + key.split('.')[1])
    allRoutes.push(route.default)
  })
  //根据菜单添加对应的路由
  for (const menu of userMenus) {
    for (const children of menu.children) {
      const route = allRoutes.find((route) => route.path === children.url)
      if (route) {
        routes.push(route)
      }
    }
  }
  return routes
}
