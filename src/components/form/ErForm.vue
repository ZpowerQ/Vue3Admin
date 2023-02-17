<template>
  <div class="erForm">
    <el-form
      :inline="true"
      class="demo-form-inline"
      label-position="right"
      :model="formDate"
      ref="formRef"
    >
      <el-row>
        <el-col
          v-bind="normalLayout"
          v-for="(item, index) in formItems"
          :key="index"
        >
          <template v-if="item.type === 'input'">
            <el-form-item :label="item.label" :prop="item.field">
              <el-input
                :placeholder="item.placeholder"
                v-model="formDate[`${item.field}`]"
              />
            </el-form-item>
          </template>
          <template v-if="item.type === 'select'">
            <el-form-item :label="item.label" :prop="item.field">
              <el-select
                :placeholder="item.placeholder"
                v-model="formDate[`${item.field}`]"
              >
                <el-option
                  v-for="(option, index) in item.selectOptions"
                  :key="index"
                  :label="option.label"
                  :value="option.value"
                />
              </el-select>
            </el-form-item>
          </template>
          <template v-if="item.type === 'date'">
            <el-form-item
              :label="item.label"
              style="width: 100%"
              :prop="item.field"
            >
              <el-date-picker
                unlink-panels
                type="daterange"
                start-placeholder="开始日期"
                end-placeholder="结束日期"
                v-model="formDate[`${item.field}`]"
              />
            </el-form-item>
          </template>
        </el-col>
        <el-col
          v-bind="normalLayout"
          style="padding-left: 15px"
          v-if="showhandle"
        >
          <el-form-item>
            <el-button type="primary" :icon="Search" @click="selectDate"
              >查询</el-button
            >
          </el-form-item>
          <el-form-item>
            <el-button type="default" :icon="Refresh" @click="resetForm"
              >重置</el-button
            >
          </el-form-item>
        </el-col>
      </el-row>
    </el-form>
  </div>
</template>

<script lang="ts">
import { defineComponent, PropType, ref, watch } from 'vue'
import { formItem } from '@/views/main/type'
import { Search, Refresh } from '@element-plus/icons-vue'
import { FormInstance } from 'element-plus'
export default defineComponent({
  name: 'ErForm',
  props: {
    formItems: {
      type: Array as PropType<formItem[]>,
      default: () => []
    },
    queryDate: {
      type: Object,
      required: true
    },
    showhandle: {
      type: Boolean,
      default: () => true
    },
    normalLayout: {
      type: Object,
      default: () => ({
        xs: 24,
        sm: 12,
        md: 8,
        lg: 8,
        xl: 6
      })
    }
  },
  emits: ['formDateChange', 'handleSelect'],
  setup(props, { emit }) {
    const formDate = ref({ ...props.queryDate })
    watch(formDate, (newValue) => emit('formDateChange', newValue), {
      deep: true
    })
    const formRef = ref<FormInstance>()
    //表单重置
    const resetForm = () => {
      if (!formRef.value) return
      formRef?.value?.resetFields()
    }
    const setData = (value: any) => {
      formDate.value = value
    }
    //查询事件
    const selectDate = () => {
      emit('handleSelect')
    }
    return {
      Search,
      Refresh,
      formRef,
      resetForm,
      selectDate,
      formDate,
      setData
    }
  }
})
</script>

<style scoped lang="less">
.erForm {
  background-color: #fff;
  padding: 15px;
  border-radius: 10px;
}
.el-form--inline .el-form-item {
  margin: 15px;
}
:deep(.el-form-item__label) {
  font-weight: bolder;
}
// .el-col {
//   text-align: center;
// }
</style>
