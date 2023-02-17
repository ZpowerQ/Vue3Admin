import type { formItem } from '../../../type'
export const dialogItems: formItem[] = [
  {
    label: '商品编号',
    type: 'input',
    placeholder: '请输入商品编号',
    field: 'id'
  },
  {
    label: '商品名称',
    type: 'input',
    placeholder: '请输入商品名称',
    field: 'name'
  },
  {
    label: '原价格',
    type: 'input',
    placeholder: '请输入原价格',
    field: 'originalprice'
  },
  {
    label: '现价格',
    type: 'input',
    placeholder: '请输入现价格',
    field: 'currentprice'
  },
  {
    label: '图片',
    type: 'input',
    placeholder: '请输入图片路径',
    field: 'photo'
  },
  {
    label: '库存',
    type: 'input',
    placeholder: '请输入库存',
    field: 'stock'
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
  }
]
