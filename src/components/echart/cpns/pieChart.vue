<template>
  <div class="pieChart" id="pieChart"></div>
</template>

<script lang="ts">
import { computed, defineComponent, onMounted, watch } from 'vue'
import { useCharts } from '../useCharts'
import type { EChartsOption } from 'echarts'
import { useStore } from 'vuex'
export default defineComponent({
  name: 'pieChart',
  props: {
    datalist: {
      type: Array,
      default: () => []
    }
  },
  setup() {
    const store = useStore()
    onMounted(() => {
      var chartDom = document.getElementById('pieChart') as HTMLElement
      type data = { value: number; name: string }
      var options = computed(() => {
        return {
          title: {},
          tooltip: {
            trigger: 'item'
          },
          legend: {
            orient: 'horizontal',
            left: 'left'
          },
          series: [
            {
              name: '分类商品数量',
              type: 'pie',
              radius: '50%',
              data: store.state?.overviewState.goodcelllist.map((item: any) => {
                return { value: item.count, name: item.name }
              }) as data[],
              emphasis: {
                itemStyle: {
                  shadowBlur: 10,
                  shadowOffsetX: 0,
                  shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
              }
            }
          ]
        }
      })
      useCharts(chartDom, options.value as EChartsOption)
      watch(options, () => {
        useCharts(chartDom, options.value as EChartsOption)
      })
    })
    return {}
  }
})
</script>

<style scoped lang="less">
.pieChart {
  width: 100%;
  height: 300px;
}
</style>
