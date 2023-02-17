import { Module } from 'vuex'

import type { goodState } from './type'
import type { RootState } from '../../type'
import { ElMessage } from 'element-plus'
import {
  getPageListDate,
  addPageDate,
  deleteData
} from '@/service/main/management/management'
const goodsState: Module<goodState, RootState> = {
  namespaced: true,
  state() {
    return {
      goodlist: [],
      goodCount: 0
    }
  },
  mutations: {
    setGoodlist(state, payload) {
      state.goodlist = payload[0]
      state.goodCount = payload[1]
    }
  },
  actions: {
    async getPageList({ commit }, payload: any) {
      const listdate = await getPageListDate(payload)
      switch (payload?.pageName) {
        case 'good':
          commit('setGoodlist', listdate?.data.data)
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

export default goodsState
