import axios from 'axios'
import type { AxiosInstance, AxiosRequestConfig } from 'axios'
import type { ErEquestInterceptor, ErRequestConfig, Result } from './type'
import { ElLoading } from 'element-plus'
import LocalCache from '@/utils/LocalCache'
//封装请求类
class ErRequest {
  instance: AxiosInstance
  interceptors?: ErEquestInterceptor
  loading: any
  constructor(config: ErRequestConfig) {
    this.instance = axios.create(config) //允许创建多个实例
    this.interceptors = config.interceptors

    //使用拦截器
    this.instance.interceptors.request.use(
      this.interceptors?.requestInceptor,
      this.interceptors?.requestInceptorCatch
    )
    this.instance.interceptors.response.use(
      this.interceptors?.responseInceptor,
      this.interceptors?.responseInceptorCatch
    )
    //所有实例都有的拦截器
    this.instance.interceptors.request.use(
      (config) => {
        const token = LocalCache.getCache('token') ?? 'abcd'
        if (token && config.headers) {
          config.headers.Authorization = `Bearer ${token}`
        }
        //加载页面
        this.loading = ElLoading.service({
          lock: false,
          text: '加载中'
        })
        return config
      },
      (err) => {
        return err
      }
    )
    this.instance.interceptors.response.use(
      (res) => {
        this.loading?.close()
        return res
      },
      (err) => {
        return err
      }
    )
  }

  //请求方法(参数为路径和请求方法)
  request<T = Result>(config: ErRequestConfig): Promise<T> {
    return new Promise((resolve, reject) => {
      //单独的拦截
      if (config.interceptors?.requestInceptor) {
        config = config.interceptors.requestInceptor(config)
      }
      this.instance
        .request(config)
        .then((res) => {
          if (config.interceptors?.responseInceptor) {
            res = config.interceptors.responseInceptor(res)
          }
          resolve(res as unknown as Promise<T>)
        })
        .catch((err) => {
          reject(err)
        })
    })
  }
  //其他请求方法
  get<T = Result>(config: AxiosRequestConfig): Promise<T> {
    return this.request({ ...config, method: 'GET' })
  }

  post<T = Result>(config: AxiosRequestConfig): Promise<T> {
    return this.request({ ...config, method: 'POST' })
  }

  put<T = Result>(config: AxiosRequestConfig): Promise<T> {
    return this.request({ ...config, method: 'PUT' })
  }

  delete<T = Result>(config: AxiosRequestConfig): Promise<T> {
    return this.request({ ...config, method: 'DELETE' })
  }
}

export default ErRequest
