<template>
  <div class="erTable">
    <div class="tableHeader">
      <span>{{ title }}</span>
      <div>
        <el-button size="small" plain :icon="Refresh" @click="handleRefresh"
          >刷新</el-button
        >
        <el-button
          type="primary"
          size="small"
          plain
          :icon="Plus"
          @click="handleAddEvent"
          >新增</el-button
        >
        <el-button
          type="danger"
          size="small"
          plain
          :icon="Delete"
          @click="handleDelmore"
          >删除</el-button
        >
      </div>
    </div>
    <el-table
      :data="listdate"
      border
      style="width: 100%"
      @selection-change="handleSelectChange"
      row-key="index"
    >
      <el-table-column
        v-if="showSelectColum"
        type="selection"
        width="45"
        align="center"
      ></el-table-column>
      <el-table-column
        v-if="showIndexColum"
        type="index"
        label="序号"
        align="center"
        width="60"
      ></el-table-column>
      <template v-for="propItem in proplist" :key="propItem.prop">
        <el-table-column
          v-bind="propItem"
          align="center"
          :sortable="
            propItem.prop === 'createtime' || propItem.prop === 'updatetime'
          "
          :show-overflow-tooltip="propItem.prop === 'name'"
        >
          <template #default="scope">
            <slot :name="propItem.slotName" :row="scope.row">
              {{ scope.row[propItem.prop] }}
            </slot>
          </template>
        </el-table-column>
      </template>
    </el-table>
    <div class="footer" v-if="showPagination">
      <el-pagination
        :page-sizes="[10, 20, 50, 80]"
        small
        layout="total, sizes, prev, pager, next, jumper"
        :total="total"
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
      />
    </div>
  </div>
</template>

<script lang="ts">
import { defineComponent } from 'vue'
import { Refresh, Plus, Delete } from '@element-plus/icons-vue'
export default defineComponent({
  name: 'ErTable',
  props: {
    listdate: {
      type: Array,
      required: true
    },
    proplist: {
      type: Array,
      required: true
    },
    showIndexColum: {
      type: Boolean,
      default: false
    },
    showSelectColum: {
      type: Boolean,
      default: false
    },
    title: {
      type: String,
      default: ''
    },
    total: {
      type: Number,
      default: 0
    },
    showPagination: {
      type: Boolean,
      default: true
    }
  },
  emits: [
    'selectChange',
    'sizeChange',
    'pageChange',
    'refresh',
    'addevent',
    'delmoreevent'
  ],
  setup(props, { emit }) {
    const handleSelectChange = (value: any) => {
      emit('selectChange', value)
    }
    //处理每页显示数量
    const handleSizeChange = (value: number) => {
      emit('sizeChange', value)
    }
    //处理页数改变
    const handleCurrentChange = (value: number) => {
      emit('pageChange', value)
    }
    //处理刷新事件
    const handleRefresh = () => {
      emit('refresh')
    }
    const handleAddEvent = () => {
      emit('addevent')
    }
    const handleDelmore = () => {
      emit('delmoreevent')
    }
    return {
      handleSelectChange,
      Refresh,
      Plus,
      Delete,
      handleSizeChange,
      handleCurrentChange,
      handleRefresh,
      handleAddEvent,
      handleDelmore
    }
  }
})
</script>

<style scoped lang="less">
.erTable {
  background-color: #fff;
  padding: 10px;
}
.tableHeader {
  padding-bottom: 10px;
  display: flex;
  justify-content: space-between;
}
.footer {
  padding-top: 10px;
  text-align: right;
}
.el-pagination {
  justify-content: right;
}
</style>
