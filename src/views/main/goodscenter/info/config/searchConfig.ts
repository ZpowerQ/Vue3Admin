import type { formItem } from '../../../type'
export const formItems: formItem[] = [
  {
    label: '商品编号',
    type: 'input',
    placeholder: '请输入用户编号',
    field: 'id'
  },
  {
    label: '商品名称',
    type: 'input',
    placeholder: '请输入商品名称',
    field: 'name'
  },
  {
    label: '状态',
    type: 'select',
    selectOptions: [
      { label: '上架', value: '1' },
      { label: '下架', value: '0' }
    ],
    placeholder: '商品状态',
    field: 'state'
  },
  {
    label: '创建时间',
    type: 'date',
    field: 'createtime'
  }
]
