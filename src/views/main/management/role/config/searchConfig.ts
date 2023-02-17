import type { formItem } from '../../../type'
export const formItems: formItem[] = [
  {
    label: '角色编号',
    type: 'input',
    placeholder: '请输入角色编号',
    field: 'id'
  },
  {
    label: '角色名称',
    type: 'input',
    placeholder: '请输入角色名称',
    field: 'name'
  },
  {
    label: '角色权限',
    type: 'select',
    selectOptions: [
      { label: '所有权限', value: '所有权限' },
      { label: '人员管理', value: '人员管理' },
      { label: '商品管理', value: '商品管理' },
      { label: '系统管理', value: '系统管理' }
    ],
    placeholder: '角色权限',
    field: 'intro'
  },
  {
    label: '创建时间',
    type: 'date',
    field: 'createTine'
  }
]
