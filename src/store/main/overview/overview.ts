import { Module } from 'vuex'
import type { RootState } from '../../type'
import type { OverviewState } from './type'
import { getData } from '@/service/main/overview/overview'

const overviewState: Module<OverviewState, RootState> = {
  namespaced: true,
  state() {
    return {
      goodcelllist: []
    }
  },
  mutations: {
    setGoodcelllist(state, payload) {
      state.goodcelllist = payload
    }
  },
  actions: {
    async getchartDate({ commit }, payload: any) {
      const chartData = await getData(payload.url)
      switch (payload.cname) {
        case 'cellcount':
          commit('setGoodcelllist', chartData.data.data)
      }
    }
  }
}

export default overviewState
