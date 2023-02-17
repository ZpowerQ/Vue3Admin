<template>
  <div class="ntChart" id="ntChart"></div>
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
      var chartDom = document.getElementById('ntChart') as HTMLElement
      type data = { value: number; name: string }
      var options = computed(() => {
        return {
          legend: {
            top: 'top'
          },
          tooltip: {
            trigger: 'item'
          },
          toolbox: {
            show: false,
            feature: {
              mark: { show: true },
              dataView: { show: true, readOnly: true },
              restore: { show: true },
              saveAsImage: { show: true }
            }
          },
          series: [
            {
              name: '分类商品数量',
              type: 'pie',
              radius: [0, 100],
              center: ['50%', '50%'],
              roseType: 'area',
              itemStyle: {
                borderRadius: 8
              },
              data: store.state?.overviewState.goodcelllist.map((item: any) => {
                return { value: item.like, name: item.name }
              }) as data[],
              label: {
                show: false
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
.ntChart {
  width: 100%;
  height: 300px;
}
</style>
