import { AxiosRequestConfig, AxiosResponse, AxiosHeaders } from 'axios'

//请求拦截器的接口
export interface ErEquestInterceptor {
  requestInceptor?: (config: AxiosRequestConfig) => AxiosRequestConfig
  requestInceptorCatch?: (error: any) => any
  responseInceptor?: (res: AxiosResponse) => AxiosResponse
  responseInceptorCatch?: (error: any) => any
}

//创建axios实例的参数的接口，继承原接口并添加拦截器属性
export interface ErRequestConfig extends AxiosRequestConfig {
  interceptors?: ErEquestInterceptor
}

//axios返回数据的对象属性
export interface Result {
  config: any
  data: any
  headers: AxiosHeaders
  request: any
  status: number
  statusText: string
}
