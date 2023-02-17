<template>
  <div class="dynamicNum">
    <el-row :gutter="12">
      <el-col :span="6" v-for="item in dynamicItems" :key="item.id">
        <el-card shadow="always">
          <template #header>
            <div class="card-header">
              <span>{{ item.title }}</span>
            </div>
          </template>
          <h2 :id="item.id" class="card-content"></h2>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script lang="ts">
import { defineComponent, onMounted } from 'vue'
import { initCountJs } from './configCountJs'
import { CountJsConfigItem } from '@/views/main/overview/goodscount/type'
export default defineComponent({
  name: '',
  props: {
    dynamicItems: {
      type: Array,
      default: () => []
    }
  },
  setup(props) {
    onMounted(() => {
      for (const item of props.dynamicItems) {
        const ele = document.querySelector(`#${(item as CountJsConfigItem).id}`)
        const countUp = initCountJs(
          ele,
          (item as CountJsConfigItem).endVal as number,
          (item as CountJsConfigItem).options
        )
        if (!countUp.error) {
          countUp.start()
        } else {
          console.log(countUp.error)
        }
      }
    })
    return {}
  }
})
</script>

<style scoped lang="less">
:deep(.el-card__header) {
  padding: 5px 10px;
}
:deep(.el-card__body) {
  padding: 10px;
}
</style>
