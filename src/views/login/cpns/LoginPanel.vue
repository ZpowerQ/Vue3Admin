<template>
  <div class="LoginPanel">
    <h2>后台管理系统</h2>
    <!-- 选项卡 -->
    <el-tabs type="border-card" class="login-tabs" v-model="activeName" stretch>
      <el-tab-pane name="accountLogin">
        <template #label>
          <span class="custom-tabs-label">
            <el-icon size="18px"><User /></el-icon>
            <span>账号登录</span>
          </span>
        </template>
        <!-- 账号登录模块 -->
        <AccountLogin ref="accountRef" />
      </el-tab-pane>
      <el-tab-pane name="phoneLogin">
        <template #label>
          <span class="custom-tabs-label">
            <el-icon size="18px"><Iphone /></el-icon>
            <span>手机登录</span>
          </span>
        </template>
        <!-- 手机登录模块 -->
        <PhoneLogin ref="phoneRef" />
      </el-tab-pane>
    </el-tabs>
    <div class="accountControl" v-show="activeName == 'accountLogin'">
      <el-checkbox v-model="isRemember">记住密码</el-checkbox>
      <el-link :underline="false">忘记密码?</el-link>
    </div>
    <!-- 登录按钮 -->
    <el-button type="primary" class="loginBtn" @click="loginAction"
      >登&nbsp;录</el-button
    >
  </div>
</template>

<script lang="ts">
import { defineComponent, ref } from 'vue'
import AccountLogin from './AccoutLogin.vue'
import PhoneLogin from './PhoneLogin.vue'
export default defineComponent({
  name: 'LoginPanel',
  components: {
    AccountLogin,
    PhoneLogin
  },
  setup() {
    //选项卡处于活跃的
    let activeName = ref<string>('accountLogin')
    //是否记住密码
    const isRemember = ref<boolean>(true)
    //获取账号登录模块
    const accountRef = ref<InstanceType<typeof AccountLogin>>()
    // 获取手机登录模块
    const phoneRef = ref<InstanceType<typeof PhoneLogin>>()
    //登录按钮事件
    const loginAction = () => {
      if (activeName.value === 'accountLogin') {
        accountRef.value?.loginAction(isRemember.value)
      } else {
        phoneRef.value?.loginAction()
      }
    }

    return { activeName, loginAction, accountRef, isRemember, phoneRef }
  }
})
</script>

<style scoped lang="less">
.LoginPanel {
  width: 400px;
  height: 360px;
  background-color: white;
  margin-bottom: 50px;
}
h2 {
  text-align: center;
  margin: 20px auto;
}
.el-tabs--border-card {
  width: 80%;
  margin: 0 auto;
}
.login-tabs .custom-tabs-label .el-icon {
  vertical-align: middle;
}
.login-tabs .custom-tabs-label span {
  vertical-align: middle;
  margin-left: 4px;
}
.accountControl {
  width: 80%;
  margin: 0 auto;
  display: flex;
  justify-content: space-between;
}
:deep(.el-checkbox__label) {
  padding-left: 5px;
}
.loginBtn {
  display: block;
  margin: 10px auto;
  width: 80%;
}
</style>
