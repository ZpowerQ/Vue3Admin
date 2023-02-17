<template>
  <div class="login">
    <login-panel />
  </div>
</template>

<script lang="ts">
import { defineComponent } from 'vue'
import LoginPanel from './cpns/LoginPanel.vue'
export default defineComponent({
  name: 'login',
  components: {
    LoginPanel
  }
})
</script>

<style scoped lang="less">
.login {
  width: 100%;
  height: 100%;
  background: url('../../assets/img/login-background.jpg') no-repeat;
  background-size: cover;
  display: flex;
  justify-content: center;
  align-items: center;
}
</style>
