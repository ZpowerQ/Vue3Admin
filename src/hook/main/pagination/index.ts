import store from '@/store/index'
import { ref } from 'vue'
import { formateLocaltime } from '@/utils/formateUTCtime'
import ErForm from '@/components/form/ErForm.vue'

let dispatchPath = ''
let currentpage: any = null
let size: any = null
let pageName = ''
let formDate: any = null
//获取初始查询条件
const getOriginalTerm = (pageName: string) => {
  return {
    pageName: pageName,
    currentpage: currentpage.value,
    size: size.value,
    type: 'page'
  }
}
//初始化变量
const initinfo = (
  path: string,
  current: any,
  pagesize: any,
  pname: string,
  fdate: any
) => {
  dispatchPath = path
  currentpage = current
  size = pagesize
  pageName = pname
  formDate = fdate
}
//表单组件实例
const erformRef = ref<InstanceType<typeof ErForm>>()
//获取数据
const getPageDate = (payload: object) => {
  store.dispatch(dispatchPath, payload)
}
//是否处于查询状态
const isSelect = ref<boolean>(false)
//处理查询事件
const handleSelectEvent = (pageName: string) => {
  const { createtime } = formDate
  getPageDate({
    pageName: pageName,
    data: {
      ...formDate,
      createtime: [
        formateLocaltime(createtime[0]),
        formateLocaltime(createtime[1])
      ]
    },
    currentpage: 1,
    size: 10,
    type: 'page'
  })
  isSelect.value = true
}
//是否处于查询状态的换页显示处理
const handleSelectChange = (pageName: string) => {
  if (!isSelect.value) {
    getPageDate(getOriginalTerm(pageName))
  } else {
    const { createtime } = formDate
    getPageDate({
      pageName: pageName,
      data: {
        ...formDate,
        createtime: [
          formateLocaltime(createtime[0]),
          formateLocaltime(createtime[1])
        ]
      },
      currentpage: currentpage.value,
      size: size.value,
      type: 'page'
    })
  }
}
//处理每页显示数量
const handleSizeChangeEvent = (value: number, pageName: string) => {
  handleSelectChange(pageName)
}
//处理换页事件
const handlePageChangeEvent = (value: number, pageName: string) => {
  handleSelectChange(pageName)
}
//处理刷新事件
const handleRefreshEvent = (pageName: string) => {
  getPageDate(getOriginalTerm(pageName))
  erformRef.value?.resetForm()
  isSelect.value = false
}

//同步更新查询条件
const handleFormDate = (value: any) => {
  formDate = value
}
//处理查询事件
const handleSelect = () => {
  handleSelectEvent(pageName)
}
//处理每页显示数量
const handleSizeChange = (value: number) => {
  size.value = value
  handleSizeChangeEvent(value, pageName)
}
//处理换页事件
const handlePageChange = (value: number) => {
  currentpage.value = value
  handlePageChangeEvent(value, pageName)
}
//处理刷新事件
const handleRefresh = () => {
  handleRefreshEvent(pageName)
}
export default {
  getPageDate,
  getOriginalTerm,
  isSelect,
  erformRef,
  initinfo,
  handleFormDate,
  handleSelect,
  handleSizeChange,
  handlePageChange,
  handleRefresh
}
