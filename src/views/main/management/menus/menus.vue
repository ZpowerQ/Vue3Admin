<template>
  <div class="menus">
    <er-form
      :formItems="formItems"
      :queryDate="formDate"
      @handleSelect="handleSelect"
      @formDateChange="handleFormDate"
    />
    <div class="tableContent">
      <er-table
        v-bind="tableConfig"
        :listdate="menus"
        @refresh="handleRefresh"
        @addevent="handleAddEvent"
        @delmoreevent="deletewarn"
      >
        <template #menuicon="scope">
          <el-icon>
            <component :is="scope.row.icon"></component>
          </el-icon>
        </template>
        <template #status="scope">
          <el-button
            plain
            :type="scope.row.state ? 'primary' : 'danger'"
            size="small"
            >{{ scope.row.state ? '正常' : '停用' }}</el-button
          >
        </template>
        <template #createAt="scope">
          <span>{{ $utils.formateTime(scope.row.createtime) }}</span>
        </template>
        <template #handler="scope">
          <template v-if="scope.row.url">
            <el-button
              text
              type="primary"
              :icon="Edit"
              size="small"
              @click="handleEdit(scope.row)"
              >编辑</el-button
            >
            <el-button
              text
              type="danger"
              :icon="Delete"
              size="small"
              @click="deletewarn"
              >删除</el-button
            >
          </template>
        </template>
      </er-table>
    </div>
    <er-dialog
      ref="addDialogRef"
      :title="dialogtitle"
      @configevent="handleConfig"
    >
      <er-form
        :normalLayout="{ span: 24 }"
        :showhandle="false"
        :formItems="dialogItems"
        :queryDate="addData"
        @formDateChange="handleAddDateChange"
        ref="addformRef"
      />
    </er-dialog>
  </div>
</template>

<script lang="ts">
import { defineComponent, reactive, computed, ref, nextTick } from 'vue'
import ErForm from '@/components/form/ErForm.vue'
import { formItems } from './config/searchConfig'
import { useStore } from 'vuex'
import ErTable from '@/components/table/ErTable.vue'
import ErDialog from '@/components/dialog/ErDialog.vue'
import { tableConfig } from './config/tableConfig'
import { Delete, Edit } from '@element-plus/icons-vue'
import { dialogItems } from './config/dialogConfig'
import LocalCache from '@/utils/LocalCache'
import { ElMessage } from 'element-plus'
export default defineComponent({
  name: 'menus',
  components: {
    ErForm,
    ErTable,
    ErDialog
  },
  setup() {
    const store = useStore()
    //表单数据
    let formDate = reactive({
      id: LocalCache.getCache('id'),
      name: '',
      state: ''
    })
    //对话框的数据
    let addData = ref({})
    //获取添加表单
    const addformRef = ref<InstanceType<typeof ErForm>>()
    //获取数据
    const getPageDate = (payload: object) => {
      store.dispatch('manageState/getPageList', payload)
    }
    //同步更新查询条件
    const handleFormDate = (value: any) => {
      formDate = value
    }
    //获取菜单
    const menus = computed(() => store.state.loginState?.userMenus)
    //获取添加对话框
    const addDialogRef = ref<InstanceType<typeof ErDialog>>()
    //提示框标题
    let dialogtitle = ref('')
    //处理查询事件
    const handleSelect = () => {
      getPageDate({
        pageName: 'menu',
        data: formDate,
        type: 'list'
      })
    }
    //处理刷新事件
    const handleRefresh = () => {
      getPageDate({
        pageName: 'menu',
        type: 'list',
        data: { id: LocalCache.getCache('id') }
      })
    }
    //同步更新添加数据
    const handleAddDateChange = (value: any) => {
      addData.value = value
    }
    //处理添加事件
    const handleAddEvent = () => {
      dialogtitle.value = '添加菜单'
      addDialogRef?.value?.showDialog()
      nextTick(() => {
        addformRef?.value?.setData({})
      })
    }
    //确认数据事件
    const handleConfig = () => {
      if (dialogtitle.value === '添加菜单') {
        store.dispatch('manageState/handleData', {
          url: '/menu/add',
          data: addData.value
        })
        addformRef?.value?.resetForm()
      } else if (dialogtitle.value === '编辑菜单') {
        store.dispatch('manageState/handleData', {
          url: '/menu/update',
          data: addData.value
        })
      }
    }
    //处理编辑事件
    const handleEdit = (row: any) => {
      dialogtitle.value = '编辑菜单'
      addDialogRef?.value?.showDialog()
      row.parentmenu = row.index.substr(0, 1)
      nextTick(() => {
        addformRef?.value?.setData(row)
      })
    }
    const deletewarn = () => {
      ElMessage({
        message: '不可操作',
        type: 'warning',
        duration: 1500
      })
    }
    return {
      formItems,
      formDate,
      menus,
      tableConfig,
      Delete,
      Edit,
      handleFormDate,
      handleSelect,
      handleRefresh,
      addDialogRef,
      dialogtitle,
      handleConfig,
      dialogItems,
      addData,
      handleAddDateChange,
      addformRef,
      handleAddEvent,
      handleEdit,
      deletewarn
    }
  }
})
</script>

<style scoped>
.tableContent {
  margin-top: 10px;
  border-radius: 10px;
  overflow: hidden;
}
</style>
