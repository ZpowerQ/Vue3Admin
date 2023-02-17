import { BASR_URL, TIME_OUT } from './config'
import ErRequest from './erRequest'
const erRequest = new ErRequest({
  //基本路径和超时时间
  baseURL: BASR_URL,
  timeout: TIME_OUT,

  //拦截器
  interceptors: {
    requestInceptor: (config) => {
      return config
    },
    requestInceptorCatch(err) {
      return err
    },
    responseInceptor: (res) => {
      return res
    },
    responseInceptorCatch(err) {
      return err
    }
  }
})
export default erRequest
