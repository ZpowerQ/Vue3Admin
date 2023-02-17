import { reactive } from 'vue'
import { FormRules } from 'element-plus'
//定义账号登录规则
const phoneRules = reactive<FormRules>({
  num: [
    {
      required: true,
      message: '手机号不能为空',
      trigger: 'blur'
    },
    {
      pattern: /^1(3[0-9]|5[0-3,5-9]|7[1-3,5-8]|8[0-9])\d{8}$/,
      message: '手机号格式错误',
      trigger: 'blur'
    }
  ],
  code: [
    {
      required: true,
      message: '验证码不能为空',
      trigger: 'blur'
    },
    {
      pattern: /^[0-9]{6}$/,
      message: '验证码必须为六位数字',
      trigger: 'blur'
    }
  ]
})
export default phoneRules
