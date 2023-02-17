export const tableConfig = {
  title: '菜单列表',
  //是否展示序号
  showIndexColum: false,
  //是否展示选择列
  showSelectColum: false,
  //是否展示分页器
  showPagination: false,
  //展示的数据列
  proplist: [
    { prop: 'index', label: '编号', minWidth: '30' },
    { prop: 'name', label: '菜单名', minWidth: '80' },
    { prop: 'icon', label: '图标', minWidth: '30', slotName: 'menuicon' },
    { prop: 'url', label: '组件路径', minWidth: '100' },
    { prop: 'state', label: '状态', minWidth: 40, slotName: 'status' },
    {
      prop: 'createtime',
      label: '创建时间',
      minWidth: '100',
      slotName: 'createAt'
    },
    {
      label: '操作',
      minWidth: '80',
      slotName: 'handler'
    }
  ]
}
