import type { formItem } from '../../../type'
export const dialogItems: formItem[] = [
  {
    label: '编号',
    type: 'input',
    placeholder: '请输入部门编号',
    field: 'id'
  },
  {
    label: '部门名称',
    type: 'input',
    placeholder: '请输入部门名称',
    field: 'name'
  },
  {
    label: '状态',
    type: 'select',
    selectOptions: [
      { label: '正常', value: '1' },
      { label: '停用', value: '0' }
    ],
    placeholder: '部门状态',
    field: 'state'
  }
]
