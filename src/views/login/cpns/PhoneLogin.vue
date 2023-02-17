<template>
  <div>
    <el-form ref="formRef" :rules="phoneRules" :model="phone">
      <el-form-item label="手机号" :model="phone" prop="num">
        <el-input v-model="phone.num" />
      </el-form-item>
      <el-form-item label="验证码" prop="code">
        <el-input
          v-model="phone.code"
          style="width: 53%; padding-right: 10px"
        /><el-button type="primary">获取验证码</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script lang="ts">
import { FormInstance } from 'element-plus'
import { defineComponent, reactive, ref } from 'vue'
import phoneRules from '../config/phoneConfig'
import { useStore } from 'vuex'
export default defineComponent({
  name: 'PhoneLogin',
  setup() {
    //号码和验证码
    let phone = reactive({
      num: '',
      code: ''
    })
    //获取表单元素
    const formRef = ref<FormInstance>()
    // 获取vuex属性
    const store = useStore()
    //验证表单内容
    const loginAction = () => {
      formRef.value?.validate((valid) => {
        if (valid) {
          store.dispatch('loginState/phonetLogin', { ...phone })
        }
      })
    }
    return {
      phone,
      formRef,
      loginAction,
      phoneRules
    }
  }
})
</script>

<style scoped lang="less">
.el-form-item {
  margin: 20px auto;
}
</style>
