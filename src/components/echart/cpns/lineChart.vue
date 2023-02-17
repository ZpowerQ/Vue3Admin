<template>
  <div class="lineChart" id="lineChart"></div>
</template>

<script lang="ts">
import { computed, defineComponent, onMounted, watch } from 'vue'
import { useCharts } from '../useCharts'
import type { EChartsOption } from 'echarts'
import { useStore } from 'vuex'
export default defineComponent({
  name: 'ntChart',
  props: {
    datalist: {
      type: Array,
      default: () => []
    }
  },
  setup() {
    const store = useStore()
    onMounted(() => {
      var chartDom = document.getElementById('lineChart') as HTMLElement
      var options = computed(() => {
        return {
          tooltip: {
            trigger: 'item',
            axisPointer: {
              type: 'shadow'
            }
          },
          xAxis: {
            type: 'category',
            data: store.state?.overviewState.goodcelllist.map((item: any) => {
              return item.name
            }),
            axisLabel: {
              interval: 0
            }
          },
          yAxis: {
            type: 'value',
            axisLabel: {
              interval: 0
            }
          },
          series: [
            {
              data: store.state?.overviewState.goodcelllist.map((item: any) => {
                return item.count
              }),
              type: 'line'
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
.lineChart {
  width: 100%;
  height: 245px;
}
</style>
