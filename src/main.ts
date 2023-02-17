import { createApp } from 'vue'
import App from './App.vue'
import { registerUI, registerIcon, registerProperties } from './global/index'
import router from './router/index'
import store, { setupStore } from './store/index'
import './assets/css/base.css'
const app = createApp(App)
app.use(store)
setupStore()
app.use(router)
registerUI(app)
registerIcon(app)
registerProperties(app)
app.mount('#app')
