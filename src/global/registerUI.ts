import { App } from 'vue'
import 'element-plus/theme-chalk/el-loading.css'
import 'element-plus/theme-chalk/el-message.css'
import {
  ElAside,
  ElAvatar,
  ElBreadcrumb,
  ElBreadcrumbItem,
  ElButton,
  ElCard,
  ElCheckbox,
  ElCol,
  ElConfigProvider,
  ElContainer,
  ElDatePicker,
  ElDropdown,
  ElDropdownItem,
  ElDropdownMenu,
  ElForm,
  ElFormItem,
  ElHeader,
  ElIcon,
  ElImage,
  ElInput,
  ElMain,
  ElMenu,
  ElMenuItem,
  ElOption,
  ElPagination,
  ElRow,
  ElSelect,
  ElSubMenu,
  ElTable,
  ElTableColumn,
  ElTabs
} from 'element-plus'
const components = [
  ElButton,
  ElTabs,
  ElCheckbox,
  ElInput,
  ElForm,
  ElFormItem,
  ElContainer,
  ElAside,
  ElMain,
  ElHeader,
  ElMenu,
  ElSubMenu,
  ElIcon,
  ElMenuItem,
  ElBreadcrumb,
  ElBreadcrumbItem,
  ElDropdown,
  ElDropdownMenu,
  ElDropdownItem,
  ElAvatar,
  ElSelect,
  ElOption,
  ElDatePicker,
  ElRow,
  ElCol,
  ElTable,
  ElTableColumn,
  ElConfigProvider,
  ElPagination,
  ElImage,
  ElCard
]
export default function (app: App): void {
  for (const component of components) {
    app.component(component.name, component)
  }
}
