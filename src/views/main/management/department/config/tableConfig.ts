export const tableConfig = {
  title: '部门列表',
  //是否展示序号
  showIndexColum: false,
  //是否展示选择列
  showSelectColum: false,
  //是否展示分页器
  showPagination: false,
  //展示的数据列
  proplist: [
    { prop: 'id', label: '编号', minWidth: '30' },
    { prop: 'name', label: '部门名称', minWidth: '80' },
    { prop: 'state', label: '状态', minWidth: 40, slotName: 'status' },
    {
      prop: 'createtime',
      label: '创建时间',
      minWidth: '100',
      slotName: 'createAt'
    },
    {
      prop: 'updatetime',
      label: '更新时间',
      minWidth: '100',
      slotName: 'updateAt'
    },
    {
      label: '操作',
      minWidth: '80',
      slotName: 'handler'
    }
  ]
}
