<template>
  <div class="user">
    <er-form
      :formItems="formItems"
      :queryDate="formDate"
      @handleSelect="handleSelect"
      @formDateChange="handleFormDate"
      ref="erformRef"
    />
    <div class="tableContent">
      <er-table
        :listdate="userlist"
        v-bind="tableConfig"
        @selectChange="selectChange"
        :total="userCount"
        @sizeChange="handleSizeChange"
        @pageChange="handlePageChange"
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
        :formItems="modelConfig"
        :queryDate="addData"
        @formDateChange="handleAddDateChange"
        ref="addformRef"
      />
    </er-dialog>
  </div>
</template>

<script lang="ts">
import { computed, defineComponent, reactive, ref, nextTick } from 'vue'
import ErForm from '@/components/form/ErForm.vue'
import ErTable from '@/components/table/ErTable.vue'
import ErDialog from '@/components/dialog/ErDialog.vue'
import { formItems } from './config/searchConfig'
import { useStore } from 'vuex'
import { Delete, Edit } from '@element-plus/icons-vue'
import { tableConfig } from './config/tableConfig'
import baseOperate from '@/hook/main/pagination/index'
import { dialogItems } from './config/dialogConfig'

export default defineComponent({
  name: 'user',
  components: {
    ErForm,
    ErTable,
    ErDialog
  },
  setup() {
    const {
      getPageDate,
      getOriginalTerm,
      erformRef,
      handleFormDate,
      handleSelect,
      handleSizeChange,
      handlePageChange,
      handleRefresh,
      initinfo
    } = baseOperate
    const store = useStore()
    //当前页数
    const currentpage = ref<number>(1)
    //每页显示数量
    const size = ref<number>(10)
    //提示框标题
    let dialogtitle = ref('')
    //表单数据
    let formDate = reactive({
      id: '',
      username: '',
      phone: '',
      state: '',
      createtime: ['', '']
    })
    //对话框的数据
    let addData = ref({})
    initinfo('manageState/getPageList', currentpage, size, 'userinfo', formDate)
    //选择的多条数据
    let selectedData = ref([])
    getPageDate(getOriginalTerm('userinfo'))
    //获取用户列表
    const userlist = computed(() => store.state.manageState.userlist)
    //获取总数
    const userCount = computed(() => store.state.manageState.userCount)
    //获取添加对话框
    const addDialogRef = ref<InstanceType<typeof ErDialog>>()
    //获取添加表单
    const addformRef = ref<InstanceType<typeof ErForm>>()
    //处理添加事件
    const handleAddEvent = () => {
      dialogtitle.value = '添加用户'
      addDialogRef?.value?.showDialog()
      nextTick(() => {
        addformRef?.value?.setData({})
      })
    }
    //处理编辑事件
    const handleEdit = (row: any) => {
      dialogtitle.value = '编辑用户'
      addDialogRef?.value?.showDialog()
      nextTick(() => {
        addformRef?.value?.setData(row)
      })
    }
    //动态获取表单选项
    getPageDate({
      pageName: 'role',
      type: 'list'
    })
    const modelConfig = computed(() => {
      const roleItem = dialogItems.find((item) => item.field === 'role')
      roleItem!.selectOptions = store.state.manageState.rolelist.map(
        (item: any) => {
          return { label: item.name, value: item.name }
        }
      )
      return dialogItems
    })
    //确认数据事件
    const handleConfig = () => {
      if (dialogtitle.value === '添加用户') {
        store.dispatch('manageState/handleData', {
          url: '/userinfo/add',
          data: addData.value
        })
        setTimeout(() => {
          getPageDate(getOriginalTerm('userinfo'))
        })
        addformRef?.value?.resetForm()
      } else if (dialogtitle.value === '编辑用户') {
        store.dispatch('manageState/handleData', {
          url: '/userinfo/update',
          data: addData.value
        })
        setTimeout(() => {
          getPageDate(getOriginalTerm('userinfo'))
        })
      }
    }
    //同步更新添加数据
    const handleAddDateChange = (value: any) => {
      addData.value = value
    }
    //删除单条数据
    const handleDelete = (id: number) => {
      store.dispatch('manageState/handledeleteData', {
        url: `/userinfo/delete/${id}`
      })
      setTimeout(() => {
        getPageDate(getOriginalTerm('userinfo'))
      })
    }
    //处理选择事件
    const selectChange = (value: any) => {
      selectedData.value = value
    }
    //删除多条数据
    const handleDelMore = () => {
      store.dispatch('manageState/handleData', {
        url: '/userinfo/delete',
        data: selectedData.value
      })
      setTimeout(() => {
        getPageDate(getOriginalTerm('userinfo'))
      })
    }
    return {
      formItems,
      formDate,
      userlist,
      selectChange,
      Edit,
      Delete,
      tableConfig,
      handleSelect,
      userCount,
      handleSizeChange,
      handlePageChange,
      handleRefresh,
      handleFormDate,
      erformRef,
      handleAddEvent,
      addDialogRef,
      addData,
      handleConfig,
      modelConfig,
      handleEdit,
      handleAddDateChange,
      addformRef,
      dialogtitle,
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
