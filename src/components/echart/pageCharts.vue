<template>
  <div class="page-charts">
    <el-row :gutter="12">
      <el-col :span="8">
        <el-card>
          <template #header><span>分类商品销量(饼图)</span></template>
          <pie-chart />
        </el-card>
      </el-col>
      <el-col :span="8">
        <el-card>
          <template #header><span>分类商品销售额(柱状图)</span></template>
          <bar-chart />
        </el-card>
      </el-col>
      <el-col :span="8">
        <el-card>
          <template #header><span>分类商品收藏量(玫瑰图)</span></template>
          <nt-chart />
        </el-card>
      </el-col>
    </el-row>
    <el-row :gutter="12" style="margin-top: 12px">
      <el-col :span="16">
        <el-card><map-chart /></el-card>
      </el-col>
      <el-col :span="8">
        <el-row>
          <el-col :span="24"
            ><el-card
              ><template #header><span>分类商品销售额(折线图)</span></template
              ><line-chart /></el-card
          ></el-col>
          <el-col :span="24" style="margin-top: 10px"
            ><el-card
              ><template #header><span>分类商品销售额(折线图)</span></template
              ><scatter-chart /></el-card
          ></el-col>
        </el-row>
      </el-col>
    </el-row>
  </div>
</template>

<script lang="ts">
import { defineComponent } from 'vue'
import pieChart from './cpns/pieChart.vue'
import ntChart from './cpns/ntChart.vue'
import mapChart from './cpns/mapChart.vue'
import BarChart from './cpns/barChart.vue'
import lineChart from './cpns/lineChart.vue'
import scatterChart from './cpns/scatterChart.vue'
export default defineComponent({
  name: 'pageCharts',
  components: {
    pieChart,
    ntChart,
    mapChart,
    BarChart,
    lineChart,
    scatterChart
  },
  setup() {
    return {}
  }
})
</script>

<style scoped lang="less">
.el-card {
  width: 100%;
}
:deep(.el-card__header) {
  padding: 5px;
  border-bottom: none;
}
:deep(.el-card__body) {
  padding: 10px;
}
</style>
