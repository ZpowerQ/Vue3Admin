<template>
  <div class="role">
    <er-form
      :formItems="formItems"
      :queryDate="formDate"
      @handleSelect="handleSelect"
      @formDateChange="handleFormDate"
      ref="erformRef"
    />
    <div class="tableContent">
      <er-table
        :listdate="rolelist"
        v-bind="tableConfig"
        @selectChange="selectChange"
        @refresh="handleRefresh"
        @addevent="handleAddEvent"
        @delmoreevent="handleDelMore"
      >
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
import { useStore } from 'vuex'
import ErTable from '@/components/table/ErTable.vue'
import ErForm from '@/components/form/ErForm.vue'
import ErDialog from '@/components/dialog/ErDialog.vue'
import { formItems } from './config/searchConfig'
import { tableConfig } from './config/tableConfig'
import { Delete, Edit } from '@element-plus/icons-vue'
import { dialogItems } from './config/dialogConfig'
import { formateLocaltime } from '@/utils/formateUTCtime'
export default defineComponent({
  name: 'role',
  components: {
    ErForm,
    ErTable,
    ErDialog
  },
  setup() {
    const store = useStore()
    //表单数据
    let formDate = reactive({
      id: '',
      name: '',
      intro: '',
      createtime: ['', '']
    })
    //获取表单元素
    const erformRef = ref<InstanceType<typeof ErForm>>()
    //提示框标题
    let dialogtitle = ref('')
    //对话框的数据
    let addData = ref({})
    //选择的多条数据
    let selectedData = ref([])
    //获取数据
    const getPageDate = (payload: object) => {
      store.dispatch('manageState/getPageList', payload)
    }
    //获取添加表单
    const addformRef = ref<InstanceType<typeof ErForm>>()
    //获取所有角色信息
    getPageDate({
      pageName: 'role',
      type: 'list'
    })
    //获取用户列表
    const rolelist = computed(() => store.state.manageState.rolelist)
    //获取添加对话框
    const addDialogRef = ref<InstanceType<typeof ErDialog>>()
    //处理查询事件
    const handleSelect = () => {
      const { id, name, intro, createtime } = formDate
      getPageDate({
        pageName: 'role',
        data: {
          id,
          name,
          intro,
          starttime: formateLocaltime(createtime[0]),
          endtime: formateLocaltime(createtime[1])
        },
        type: 'list'
      })
    }
    //处理选择事件
    const selectChange = (value: any) => {
      selectedData.value = value
    }
    //同步更新查询条件
    const handleFormDate = (value: any) => {
      formDate = value
    }
    //处理刷新事件
    const handleRefresh = () => {
      getPageDate({
        pageName: 'role',
        type: 'list'
      })
      erformRef.value?.resetForm()
    }
    //同步更新添加数据
    const handleAddDateChange = (value: any) => {
      addData.value = value
    }
    //处理添加事件
    const handleAddEvent = () => {
      dialogtitle.value = '添加角色'
      addDialogRef?.value?.showDialog()
      nextTick(() => {
        addformRef?.value?.setData({})
      })
    }
    //处理编辑事件
    const handleEdit = (row: any) => {
      dialogtitle.value = '编辑角色'
      addDialogRef?.value?.showDialog()
      nextTick(() => {
        addformRef?.value?.setData(row)
      })
    }
    //确认数据事件
    const handleConfig = () => {
      if (dialogtitle.value === '添加角色') {
        store.dispatch('manageState/handleData', {
          url: '/role/add',
          data: addData.value
        })
        setTimeout(() => {
          getPageDate({
            pageName: 'role',
            type: 'list'
          })
        })
        addformRef?.value?.resetForm()
      } else if (dialogtitle.value === '编辑角色') {
        store.dispatch('manageState/handleData', {
          url: '/role/update',
          data: addData.value
        })
        setTimeout(() => {
          getPageDate({
            pageName: 'role',
            type: 'list'
          })
        })
      }
    }
    //删除单条数据
    const handleDelete = (id: number) => {
      store.dispatch('manageState/handledeleteData', {
        url: `/role/delete/${id}`
      })
      setTimeout(() => {
        getPageDate({
          pageName: 'role',
          type: 'list'
        })
      })
    }
    //删除多条数据
    const handleDelMore = () => {
      store.dispatch('manageState/handleData', {
        url: '/role/delete',
        data: selectedData.value
      })
      setTimeout(() => {
        getPageDate({
          pageName: 'role',
          type: 'list'
        })
      })
    }
    return {
      formDate,
      formItems,
      rolelist,
      selectChange,
      tableConfig,
      Delete,
      Edit,
      handleSelect,
      handleFormDate,
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
      handleDelete,
      handleDelMore,
      erformRef
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
