export const tableConfig = {
  title: '用户列表',
  //是否展示序号
  showIndexColum: false,
  //是否展示选择列
  showSelectColum: true,
  //展示的数据列
  proplist: [
    { prop: 'id', label: '编号', minWidth: '30' },
    { prop: 'name', label: '商品名', minWidth: '60' },
    {
      prop: 'originalprice',
      label: '原价格',
      minWidth: '50',
      slotName: 'originalprice'
    },
    {
      prop: 'currentprice',
      label: '现价格',
      minWidth: '50',
      slotName: 'currentprice'
    },
    { prop: 'photo', label: '图片', minWidth: '60', slotName: 'photo' },
    { prop: 'state', label: '状态', minWidth: '50', slotName: 'status' },
    { prop: 'stock', label: '库存', minWidth: '35' },
    {
      prop: 'createtime',
      label: '创建时间',
      minWidth: '90',
      slotName: 'createAt'
    },
    {
      prop: 'updatetime',
      label: '更新时间',
      minWidth: '90',
      slotName: 'updateAt'
    },
    {
      label: '操作',
      minWidth: '80',
      slotName: 'handler'
    }
  ]
}
