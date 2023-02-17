import type { formItem } from '../../../type'
export const formItems: formItem[] = [
  {
    label: '菜单名称',
    type: 'input',
    placeholder: '请输入菜单名称',
    field: 'name'
  },
  {
    label: '状态',
    type: 'select',
    selectOptions: [
      { label: '正常', value: '1' },
      { label: '停用', value: '0' }
    ],
    placeholder: '菜单状态',
    field: 'state'
  }
]
