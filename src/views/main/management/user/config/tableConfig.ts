export const tableConfig = {
  title: '用户列表',
  //是否展示序号
  showIndexColum: false,
  //是否展示选择列
  showSelectColum: true,
  //展示的数据列
  proplist: [
    { prop: 'id', label: '编号', minWidth: '30' },
    { prop: 'username', label: '用户名', minWidth: '80' },
    { prop: 'role', label: '角色', minWidth: '50' },
    { prop: 'phone', label: '手机号码', minWidth: '90' },
    { prop: 'enable', label: '状态', minWidth: '50', slotName: 'status' },
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
