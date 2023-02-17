<template>
  <div class="barChart" id="barChart"></div>
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
      var chartDom = document.getElementById('barChart') as HTMLElement
      const data = computed(() => {
        return store.state?.overviewState.goodcelllist.map((item: any) => {
          return item.name
        })
      })
      const dataVal = computed(() => {
        return store.state?.overviewState.goodcelllist.map((item: any) => {
          return item.money
        })
      })
      var options = computed(() => {
        return {
          tooltip: {
            trigger: 'axis',
            axisPointer: {
              type: 'shadow'
            },
            formatter: function (params: any) {
              //params[0].name表示x轴数据
              let str = params[0].name + '<br/>'
              //params是数组格式
              for (let item of params) {
                //设置浮层图形的样式跟随图中展示的颜色
                str +=
                  "<span style='display:inline-block;width:10px;height:10px;border-radius:10px;background-color:" +
                  item.color +
                  ";'></span>" +
                  '\t' +
                  item.seriesName +
                  ' : ' +
                  `￥${item.value}`
              }
              return str
            }
          },
          grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
          },
          xAxis: [
            {
              type: 'category',
              data: data.value,
              axisTick: {
                alignWithLabel: true
              },
              axisLabel: {
                interval: 0
              }
            }
          ],
          yAxis: [
            {
              type: 'value'
            }
          ],
          series: [
            {
              name: '销售额',
              type: 'bar',
              barWidth: '60%',
              data: dataVal.value
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
.barChart {
  width: 100%;
  height: 300px;
}
</style>
