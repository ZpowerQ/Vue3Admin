export const tableConfig = {
  title: '角色列表',
  //是否展示序号
  showIndexColum: false,
  //是否展示选择列
  showSelectColum: true,
  //是否展示分页器
  showPagination: false,
  //展示的数据列
  proplist: [
    { prop: 'id', label: '编号', minWidth: '20' },
    { prop: 'name', label: '角色名', minWidth: '80' },
    { prop: 'intro', label: '角色权限', minWidth: '50' },
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
