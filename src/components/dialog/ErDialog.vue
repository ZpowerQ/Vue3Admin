<template>
  <div class="erDialog">
    <el-dialog
      v-model="dialogVisible"
      :title="title"
      width="30%"
      center
      draggable
    >
      <slot></slot>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="dialogVisible = false">取消</el-button>
          <el-button type="primary" @click="handleConfig"> 确认 </el-button>
        </span>
      </template>
    </el-dialog>
  </div>
</template>

<script lang="ts">
import { defineComponent, ref } from 'vue'
export default defineComponent({
  name: 'erDialog',
  props: {
    title: {
      type: String,
      default: ''
    }
  },
  emits: ['configevent'],
  setup(props, { emit }) {
    const dialogVisible = ref<boolean>(false)
    //展示对话框
    const showDialog = () => {
      dialogVisible.value = true
    }
    //隐藏对话框
    const hiddenDialog = () => {
      dialogVisible.value = false
    }
    //处理确认按钮事件
    const handleConfig = () => {
      dialogVisible.value = false
      emit('configevent')
    }
    return { dialogVisible, showDialog, handleConfig, hiddenDialog }
  }
})
</script>

<style scoped lang="less">
:deep(.el-dialog--center .el-dialog__body) {
  padding: 0px;
  text-align: center;
}
</style>
