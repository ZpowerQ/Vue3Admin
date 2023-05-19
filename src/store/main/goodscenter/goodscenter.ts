import { Module } from 'vuex'

import type { goodState } from './type'
import type { RootState } from '../../type'
import { ElMessage } from 'element-plus'
import {
  getPageListDate,
  addPageDate,
  deleteData,
  getGoodCategoryData
} from '@/service/main/management/management'
const goodsState: Module<goodState, RootState> = {
  namespaced: true,
  state() {
    return {
      goodlist: [],
      goodCount: 0,
      goodCategory: []
    }
  },
  mutations: {
    setGoodlist(state, payload) {
      state.goodlist = payload[0]
      state.goodCount = payload[1]
    },
    setGoodCategory(state, payload) {
      state.goodCategory = payload
    }
  },
  actions: {
    async getPageList({ commit }, payload: any) {
      let listdate = null
      switch (payload?.pageName) {
        case 'good':
          listdate = await getPageListDate(payload)
          commit('setGoodlist', listdate?.data.data)
          break
        case 'good_category':
          listdate = await getGoodCategoryData()
          commit('setGoodCategory', listdate.data)
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
