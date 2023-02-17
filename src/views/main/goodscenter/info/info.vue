<template>
  <div class="info">
    <er-form
      :formItems="formItems"
      :queryDate="formDate"
      @handleSelect="handleSelect"
      @formDateChange="handleFormDate"
    />
    <div class="tableContent">
      <er-table
        :listdate="goodlist"
        v-bind="tableConfig"
        @selectChange="selectChange"
        :total="goodCount"
        @sizeChange="handleSizeChange"
        @pageChange="handlePageChange"
        @refresh="handleRefresh"
        @addevent="handleAddEvent"
        @delmoreevent="handleDelMore"
      >
        <template #photo="scope">
          <el-image
            style="width: 50px; height: 50px"
            :src="scope.row.photo"
            :preview-src-list="[scope.row.photo]"
            hide-on-click-modal
            preview-teleported
          />
        </template>
        <template #originalprice="scope">
          <span>{{ '￥' + scope.row.originalprice }}</span>
        </template>
        <template #currentprice="scope">
          <span>{{ '￥' + scope.row.currentprice }}</span>
        </template>
        <template #status="scope">
          <el-button
            plain
            :type="scope.row.state ? 'primary' : 'danger'"
            size="small"
            >{{ scope.row.state ? '上架' : '下架' }}</el-button
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
import { defineComponent, reactive, ref, computed, nextTick } from 'vue'
import ErForm from '@/components/form/ErForm.vue'
import ErTable from '@/components/table/ErTable.vue'
import ErDialog from '@/components/dialog/ErDialog.vue'
import { formItems } from './config/searchConfig'
import baseOperate from '@/hook/main/pagination/index'
import { Delete, Edit } from '@element-plus/icons-vue'
import { tableConfig } from './config/tableConfig'
import { dialogItems } from './config/dialogConfig'
import { useStore } from 'vuex'
export default defineComponent({
  name: 'info',
  components: {
    ErForm,
    ErTable
  },
  setup() {
    const {
      getPageDate,
      getOriginalTerm,
      erformRef,
      initinfo,
      handleFormDate,
      handleSelect,
      handleSizeChange,
      handlePageChange,
      handleRefresh
    } = baseOperate
    const store = useStore()
    //当前页数
    const currentpage = ref<number>(1)
    //每页显示数量
    const size = ref<number>(10)
    //获取添加对话框
    const addDialogRef = ref<InstanceType<typeof ErDialog>>()
    //表单数据
    let formDate = reactive({
      id: '',
      name: '',
      state: '',
      createtime: ['', '']
    })
    //选择的多条数据
    let selectedData = ref([])
    initinfo('goodsState/getPageList', currentpage, size, 'good', formDate)
    getPageDate(getOriginalTerm('good'))
    //获取用户列表
    const goodlist = computed(() => store.state.goodsState.goodlist)
    //获取总数
    const goodCount = computed(() => store.state.goodsState.goodCount)
    //提示框标题
    let dialogtitle = ref('')
    //获取添加表单
    const addformRef = ref<InstanceType<typeof ErForm>>()
    //对话框数据
    let addData = ref({})
    //处理选择事件
    const selectChange = (value: any) => {
      selectedData.value = value
    }
    //同步更新添加数据
    const handleAddDateChange = (value: any) => {
      addData.value = value
    }
    //处理添加事件
    const handleAddEvent = () => {
      dialogtitle.value = '添加商品'
      addDialogRef?.value?.showDialog()
      nextTick(() => {
        addformRef?.value?.setData({})
      })
    }
    //确认数据事件
    const handleConfig = () => {
      if (dialogtitle.value === '添加商品') {
        store.dispatch('goodsState/handleData', {
          url: '/good/add',
          data: addData.value
        })
        setTimeout(() => {
          getPageDate(getOriginalTerm('good'))
        })
        addformRef?.value?.resetForm()
      } else if (dialogtitle.value === '编辑商品') {
        store.dispatch('goodsState/handleData', {
          url: '/good/update',
          data: addData.value
        })
        setTimeout(() => {
          getPageDate(getOriginalTerm('good'))
        })
      }
    }
    //处理编辑事件
    const handleEdit = (row: any) => {
      dialogtitle.value = '编辑商品'
      addDialogRef?.value?.showDialog()
      nextTick(() => {
        addformRef?.value?.setData(row)
      })
    }
    //删除单条数据
    const handleDelete = (id: number) => {
      store.dispatch('goodsState/handledeleteData', {
        url: `/good/delete/${id}`
      })
      setTimeout(() => {
        getPageDate(getOriginalTerm('good'))
      })
    }
    //删除多条数据
    const handleDelMore = () => {
      store.dispatch('goodsState/handleData', {
        url: '/good/delete',
        data: selectedData.value
      })
      setTimeout(() => {
        getPageDate(getOriginalTerm('good'))
      })
    }
    return {
      formItems,
      formDate,
      goodlist,
      selectChange,
      Edit,
      Delete,
      tableConfig,
      handleSelect,
      goodCount,
      handleSizeChange,
      handlePageChange,
      handleRefresh,
      handleFormDate,
      erformRef,
      addDialogRef,
      addformRef,
      handleAddEvent,
      handleAddDateChange,
      dialogItems,
      dialogtitle,
      handleConfig,
      addData,
      handleEdit,
      handleDelete,
      handleDelMore
    }
  }
})
</script>

<style scoped></style>
