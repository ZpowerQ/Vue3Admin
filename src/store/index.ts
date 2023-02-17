import { createStore } from 'vuex'

import { RootState } from './type'

import loginState from './login/loginState'
import manageState from './main/management/management'
import goodsState from './main/goodscenter/goodscenter'
import overviewState from './main/overview/overview'
const store = createStore<RootState>({
  state() {
    return {
      name: 'power',
      age: 18
    }
  },
  modules: {
    loginState,
    manageState,
    goodsState,
    overviewState
  }
})
export function setupStore() {
  store.dispatch('loginState/loadLocalCache')
}
export default store
