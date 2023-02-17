import erRequest from '../index'
import type { account, loginResult } from './type'

//发送登录请求
export function accountLogin(data: account) {
  return erRequest.post<loginResult>({
    url: '/login/account',
    data: data
  })
}

export function parseToken() {
  return erRequest.post<loginResult>({
    url: '/login/parse'
  })
}

export function getUserinfo(id: number) {
  return erRequest.get<loginResult>({
    url: `/userinfo/${id}`
  })
}

export function getUserMenus(id: number) {
  return erRequest.get<loginResult>({
    url: `/menu/${id}`
  })
}
