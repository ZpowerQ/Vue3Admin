import { Result } from '../type'
export interface account {
  username: string
  password: string
}

// 后端返回数据类型
export interface loginMsg {
  token: string
  id: number
  userinfo: object
}

export interface finalResult {
  data: loginMsg
  msg: string
  flag: boolean
}
//登录过程的axios类型
export interface loginResult extends Result {
  data: finalResult
}
