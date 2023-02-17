import { Module } from 'vuex'

import type { ManageState } from './type'
import type { RootState } from '../../type'
import { ElMessage } from 'element-plus'
import {
  getPageListDate,
  addPageDate,
  deleteData
} from '@/service/main/management/management'
const manageState: Module<ManageState, RootState> = {
  namespaced: true,
  state() {
    return {
      userlist: [],
      userCount: 0,
      rolelist: [],
      roleCount: 0,
      menulist: [],
      menuCount: 0,
      departmentlist: [],
      departmentCount: 0
    }
  },
  mutations: {
    setUserlist(state, payload) {
      state.userlist = payload[0]
      state.userCount = payload[1]
    },
    setRolelist(state, payload) {
      state.rolelist = payload
      state.roleCount = payload.length
    },
    setMenulist(state, payload) {
      state.menulist = payload
      state.menuCount = payload.length
    },
    setDepartmentlist(state, payload) {
      state.departmentlist = payload
      state.departmentCount = payload.length
    }
  },
  actions: {
    async getPageList({ commit }, payload: any) {
      const listdate = await getPageListDate(payload)
      switch (payload?.pageName) {
        case 'userinfo':
          commit('setUserlist', listdate?.data.data)
          break
        case 'role':
          commit('setRolelist', listdate?.data.data)
          break
        case 'menu':
          commit('setMenulist', listdate?.data.data)
          commit('loginState/selectMenus', listdate?.data.data, { root: true })
          break
        case 'department':
          commit('setDepartmentlist', listdate?.data.data)
          break
      }
    },
    async handleData(store, payload: any) {
      const res = await addPageDate(payload)
      if (res) {
        ElMessage({
          message: '操作成功',
          type: 'success',
          duration: 1500
        })
      } else {
        ElMessage({
          message: '操作失败',
          type: 'error',
          duration: 1500
        })
      }
    },
    async handledeleteData(store, payload) {
      const res = await deleteData(payload)
      if (res) {
        ElMessage({
          message: '操作成功',
          type: 'success',
          duration: 1500
        })
      } else {
        ElMessage({
          message: '操作失败',
          type: 'error',
          duration: 1500
        })
      }
    }
  }
}

export default manageState
