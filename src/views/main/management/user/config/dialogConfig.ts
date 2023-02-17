import type { formItem } from '../../../type'
export const dialogItems: formItem[] = [
  {
    label: '用户编号',
    type: 'input',
    placeholder: '请输入用户编号',
    field: 'id'
  },
  {
    label: '用户名称',
    type: 'input',
    placeholder: '请输入用户名称',
    field: 'username'
  },
  {
    label: '用户密码',
    type: 'input',
    placeholder: '请输入用户密码',
    field: 'password'
  },
  {
    label: '手机号码',
    type: 'input',
    placeholder: '请输入手机号码',
    field: 'phone'
  },
  {
    label: '角色',
    type: 'select',
    selectOptions: [],
    placeholder: '用户角色',
    field: 'role'
  },
  {
    label: '状态',
    type: 'select',
    selectOptions: [
      { label: '正常', value: '1' },
      { label: '停用', value: '0' }
    ],
    placeholder: '用户状态',
    field: 'state'
  }
]
