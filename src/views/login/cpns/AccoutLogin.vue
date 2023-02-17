<template>
  <div>
    <el-form :model="account" :rules="accountRules" ref="formRef">
      <el-form-item label="账号" prop="username">
        <el-input v-model="account.username" />
      </el-form-item>
      <el-form-item label="密码" prop="password">
        <el-input show-password v-model="account.password" />
      </el-form-item>
    </el-form>
  </div>
</template>

<script lang="ts">
import { FormInstance } from 'element-plus'
import { defineComponent, reactive, ref } from 'vue'
import accountRules from '../config/accountConfig'
import LocalCache from '@/utils/LocalCache'
import { useStore } from 'vuex'
export default defineComponent({
  name: 'AccountLogin',
  setup() {
    //定义账号信息
    let account = reactive({
      username: LocalCache.getCache('username') ?? '',
      password: LocalCache.getCache('password') ?? ''
    })
    // 获取表单元素
    const formRef = ref<FormInstance>()
    // 获取vuex属性
    const store = useStore()
    //登录按钮事件
    const loginAction = (isRemember: boolean) => {
      formRef.value?.validate((valid) => {
        if (valid) {
          //判断是否记住密码
          if (isRemember) {
            LocalCache.setCache('username', account.username)
            LocalCache.setCache('password', account.password)
          } else {
            LocalCache.removeCache('username')
            LocalCache.removeCache('password')
          }
          store.dispatch('loginState/accountLogin', { ...account })
        }
      })
    }
    return { account, accountRules, loginAction, formRef }
  }
})
</script>

<style scoped lang="less">
.el-form-item {
  margin: 20px auto;
}
</style>
