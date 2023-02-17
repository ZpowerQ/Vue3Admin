//本地存储的工具函数
class LocalCache {
  //设置本地存储
  setCache(key: string, value: any) {
    window.localStorage.setItem(key, JSON.stringify(value))
  }
  //取出缓存值
  getCache(key: string) {
    const value = window.localStorage.getItem(key)
    if (value) {
      return JSON.parse(value)
    }
  }
  //去除缓存属性
  removeCache(key: string) {
    window.localStorage.removeItem(key)
  }
  //去除多个属性
  removeMoreCache(...args: string[]) {
    for (const item of args) {
      window.localStorage.removeItem(item)
    }
  }
  //清空本地缓存
  clear() {
    window.localStorage.clear()
  }
}

export default new LocalCache()
