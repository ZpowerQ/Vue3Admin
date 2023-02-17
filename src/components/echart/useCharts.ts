import * as echarts from 'echarts'
import type { EChartsOption } from 'echarts'

export function useCharts(
  domEl: HTMLElement,
  options: EChartsOption,
  theme = 'light'
) {
  // 初始化echarts
  const mychart = echarts.init(domEl, theme, { renderer: 'svg' })

  //设置options
  mychart.setOption(options)

  window.addEventListener('resize', () => {
    mychart.resize()
  })
  return mychart
}
