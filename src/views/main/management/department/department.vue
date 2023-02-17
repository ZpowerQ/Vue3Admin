<template>
  <div class="department">
    <er-form
      :formItems="formItems"
      :queryDate="formDate"
      @handleSelect="handleSelect"
      @formDateChange="handleFormDate"
      ref="erformRef"
    />
    <div class="tableContent">
      <er-table
        :listdate="departmentlist"
        v-bind="tableConfig"
        @refresh="handleRefresh"
        @addevent="handleAddEvent"
        @delmoreevent="handleDelMore"
      >
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
        <template #updateAt="scope">
          <span>{{ $utils.formateTime(scope.row.updatetime) }}</span>
        </template>
        <template #handler="scope">
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
            @click="handleDelete(scope.row.id)"
            >删除</el-button
          >
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
import { formItems } from './config/searchConfig'
import { dialogItems } from './config/dialogConfig'
import ErForm from '@/components/form/ErForm.vue'
import ErTable from '@/components/table/ErTable.vue'
import ErDialog from '@/components/dialog/ErDialog.vue'
import { useStore } from 'vuex'
import { tableConfig } from './config/tableConfig'
import { Delete, Edit } from '@element-plus/icons-vue'
import { ElMessage } from 'element-plus'
export default defineComponent({
  name: 'department',
  components: { ErForm, ErTable, ErDialog },
  setup() {
    //获取store
    const store = useStore()
    //表单数据
    let formDate = reactive({
      name: '',
      state: ''
    })
    //对话框的数据
    let addData = ref({})
    //获取数据
    const getPageDate = (payload: object) => {
      store.dispatch('manageState/getPageList', payload)
    }
    //获取表单元素
    const erformRef = ref<InstanceType<typeof ErForm>>()
    //获取添加对话框
    const addDialogRef = ref<InstanceType<typeof ErDialog>>()
    //获取添加表单
    const addformRef = ref<InstanceType<typeof ErForm>>()
    //提示框标题
    let dialogtitle = ref('')
    //同步更新查询条件
    const handleFormDate = (value: any) => {
      formDate = value
    }
    //同步更新添加数据
    const handleAddDateChange = (value: any) => {
      addData.value = value
    }
    getPageDate({ pageName: 'department', type: 'list' })
    //处理查询事件
    const handleSelect = () => {
      getPageDate({
        pageName: 'department',
        data: formDate,
        type: 'list'
      })
    }
    //获取部门列表
    const departmentlist = computed(
      () => store.state.manageState.departmentlist
    )
    //处理刷新事件
    const handleRefresh = () => {
      getPageDate({
        pageName: 'department',
        type: 'list'
      })
      erformRef.value?.resetForm()
    }
    //确认数据事件
    const handleConfig = () => {
      if (dialogtitle.value === '添加部门') {
        store.dispatch('manageState/handleData', {
          url: '/department/add',
          data: addData.value
        })
        setTimeout(() => {
          getPageDate({
            pageName: 'department',
            type: 'list'
          })
        })
        addformRef?.value?.resetForm()
      } else if (dialogtitle.value === '编辑部门') {
        store.dispatch('manageState/handleData', {
          url: '/department/update',
          data: addData.value
        })
        setTimeout(() => {
          getPageDate({
            pageName: 'department',
            type: 'list'
          })
        })
      }
    }
    //处理添加事件
    const handleAddEvent = () => {
      dialogtitle.value = '添加部门'
      addDialogRef?.value?.showDialog()
      nextTick(() => {
        addformRef?.value?.setData({})
      })
    }
    //处理编辑事件
    const handleEdit = (row: any) => {
      dialogtitle.value = '编辑部门'
      addDialogRef?.value?.showDialog()
      nextTick(() => {
        addformRef?.value?.setData(row)
      })
    }
    //删除单条数据
    const handleDelete = (id: number) => {
      store.dispatch('manageState/handledeleteData', {
        url: `/department/delete/${id}`
      })
      setTimeout(() => {
        getPageDate({
          pageName: 'department',
          type: 'list'
        })
      })
    }
    const handleDelMore = () => {
      ElMessage({
        message: '不可操作',
        type: 'warning',
        duration: 1500
      })
    }
    return {
      formItems,
      formDate,
      handleSelect,
      departmentlist,
      handleFormDate,
      tableConfig,
      Delete,
      Edit,
      handleRefresh,
      erformRef,
      addDialogRef,
      dialogtitle,
      handleConfig,
      dialogItems,
      addData,
      handleAddDateChange,
      addformRef,
      handleAddEvent,
      handleEdit,
      handleDelete,
      handleDelMore
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
