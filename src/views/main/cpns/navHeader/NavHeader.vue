<template>
  <div class="navHeader">
    <UserInfo />
  </div>
</template>

<script lang="ts">
import { defineComponent } from 'vue'
import UserInfo from './UserInfo.vue'
export default defineComponent({
  name: 'NavHeader',
  components: {
    UserInfo
  }
})
</script>

<style scoped lang="less"></style>
