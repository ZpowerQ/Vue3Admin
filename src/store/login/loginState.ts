import { Module } from 'vuex'
import { RootState } from '../type'
import { LoginState } from './type'
import { accountLogin, getUserinfo, getUserMenus } from '@/service/login/login'
import LocalCache from '@/utils/LocalCache'
import { ElMessage } from 'element-plus'
import { mapMenusToRouters } from '@/utils/mapMenus'
import router from '@/router'
const loginState: Module<LoginState, RootState> = {
  namespaced: true,
  state() {
    return {
      token: '',
      userinfo: {},
      id: 0,
      userMenus: {}
    }
  },
  getters: {},
  mutations: {
    setBaseInfo(state, data) {
      state.token = data?.token
      state.id = data?.id
    },
    setUserinfo(state, data) {
      state.userinfo = data
    },
    setUserMenus(state, data) {
      state.userMenus = data
      const routes = mapMenusToRouters(data)
      routes.forEach((route) => {
        router.addRoute('main', route)
      })
    },
    selectMenus(state, data) {
      state.userMenus = data
    }
  },
  actions: {
    //账号登录事件
    async accountLogin({ dispatch }, payload: any) {
      // 获取token及用户id
      const res = await accountLogin(payload)
      const data = res.data?.data
      //检测返回的数据是否为空
      if (!data) {
        ElMessage.error({
          message: '账号不存在',
          duration: 1500
        })
      } else {
        LocalCache.setCache('token', data?.token)
        LocalCache.setCache('id', data?.id)
        ElMessage.success({
          message: '登录成功',
          duration: 1500
        })
        router.replace('/main')
        LocalCache.setCache('token', data?.token)
        LocalCache.setCache('id', data?.id)
      }
      // 获取用户基本信息
      const userinfo = await getUserinfo(data?.id)
      LocalCache.setCache('userinfo', userinfo.data?.data)
      //获取菜单
      const userMenus = await getUserMenus(data?.id)
      LocalCache.setCache('userMenus', userMenus.data?.data)
      // 设置vuex
      dispatch('loadLocalCache')
    },
    loadLocalCache({ commit }) {
      const token = LocalCache.getCache('token')
      const id = LocalCache.getCache('id')
      if (token && id) {
        commit('setBaseInfo', { token, id })
      }
      const userInfo = LocalCache.getCache('userInfo')
      if (userInfo) {
        commit('setUserinfo', userInfo)
      }
      const userMenus = LocalCache.getCache('userMenus')
      if (userMenus) {
        commit('setUserMenus', userMenus)
      }
    }
    //手机登录事件
    // phonetLogin({ commit }, payload: any) {
    //   console.log(payload)
    // }
  }
}

export default loginState
