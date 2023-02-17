import type { formItem } from '../../../type'
export const dialogItems: formItem[] = [
  {
    label: '菜单名称',
    type: 'input',
    placeholder: '请输入菜单名称',
    field: 'name'
  },
  {
    label: '父级菜单',
    type: 'select',
    selectOptions: [
      { label: '系统总览', value: '1' },
      { label: '系统管理', value: '2' },
      { label: '商品中心', value: '3' },
      { label: '系统监控', value: '4' }
    ],
    placeholder: '父级菜单',
    field: 'parentmenu'
  },
  {
    label: '组件路径',
    type: 'input',
    placeholder: '请输入组件路径',
    field: 'url'
  },
  {
    label: '菜单编号',
    type: 'input',
    placeholder: '请输入菜单编号',
    field: 'index'
  },
  {
    label: '图标',
    type: 'select',
    selectOptions: [
      { label: 'Odometer', value: 'Odometer' },
      { label: 'ChatLineSquare', value: 'ChatLineSquare' },
      { label: 'MessageBox', value: 'MessageBox' },
      { label: 'Histogram', value: 'Histogram' }
    ],
    placeholder: '图标',
    field: 'icon'
  }
]
