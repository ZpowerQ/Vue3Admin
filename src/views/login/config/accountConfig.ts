import { reactive } from 'vue'
import { FormRules } from 'element-plus'
//定义账号登录规则
const accountRules = reactive<FormRules>({
  username: [
    {
      required: true,
      message: '用户名不能为空',
      trigger: 'blur'
    },
    {
      pattern: /^[a-zA-z0-9]{5,10}$/,
      message: '用户名必须是5-10个字母或数字',
      trigger: 'blur'
    }
  ],
  password: [
    {
      required: true,
      message: '密码不能为空',
      trigger: 'blur'
    },
    {
      pattern: /^[a-zA-z0-9]{5,}$/,
      message: '密码必须是5位以上的字母或数字',
      trigger: 'blur'
    }
  ]
})
export default accountRules
