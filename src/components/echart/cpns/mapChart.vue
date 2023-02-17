<template>
  <div class="map-chart" id="mapChart"></div>
</template>

<script lang="ts">
import { defineComponent, onMounted } from 'vue'
import * as echarts from 'echarts'
import chinaJson from '@/assets/json/china.json'
export default defineComponent({
  name: 'mapChart',
  setup() {
    onMounted(() => {
      const elem = document.querySelector('#mapChart') as HTMLElement
      const data = [
        { name: '北京市', value: 177 },
        { name: '天津市', value: 42 },
        { name: '河北省', value: 102 },
        { name: '山西省', value: 81 },
        { name: '内蒙古自治区', value: 47 },
        { name: '辽宁省', value: 67 },
        { name: '吉林省', value: 82 },
        { name: '黑龙江省', value: 66 },
        { name: '上海市', value: 24 },
        { name: '江苏省', value: 92 },
        { name: '浙江省', value: 114 },
        { name: '安徽省', value: 109 },
        { name: '福建省', value: 116 },
        { name: '江西省', value: 91 },
        { name: '山东省', value: 119 },
        { name: '河南省', value: 137 },
        { name: '贵州省', value: 137 },
        { name: '广西壮族自治区', value: 137 },
        { name: '湖北省', value: 116 },
        { name: '湖南省', value: 114 },
        { name: '重庆市', value: 91 },
        { name: '四川省', value: 125 },
        { name: '云南省', value: 83 },
        { name: '西藏自治区', value: 9 },
        { name: '陕西省', value: 80 },
        { name: '甘肃省', value: 56 },
        { name: '青海省', value: 10 },
        { name: '宁夏回族自治区', value: 18 },
        { name: '新疆维吾尔自治区', value: 67 },
        { name: '广东省', value: 123 },
        { name: '广西省', value: 59 },
        { name: '海南省', value: 14 }
      ]
      var geoCoordMap: any = {}
      const myChart = echarts.init(elem, 'light', { renderer: 'svg' })
      /*获取地图数据*/
      echarts.registerMap('china', chinaJson as any)
      const mapFeatures = echarts.getMap('china').geoJson.features
      mapFeatures.forEach(function (v: any) {
        // 地区名称
        var name = v.properties.name
        // 地区经纬度
        geoCoordMap[name] = v.properties.cp
      })
      const convertData = (data: any) => {
        var res = []
        for (var i = 0; i < data.length; i++) {
          var geoCoord = geoCoordMap[data[i].name]
          if (geoCoord) {
            res.push({
              name: data[i].name,
              value: geoCoord.concat(data[i].value)
            })
          }
        }
        return res
      }
      let options = {
        title: {
          text: '中国各省市商品销售情况',
          x: 'center',
          textStyle: {
            color: 'rgb(55, 75, 113)',
            fontFamily: '等线',
            fontSize: 18
          },
          subtextStyle: {
            fontSize: 15,
            fontFamily: '等线'
          }
        },
        tooltip: {
          trigger: 'item',
          formatter: function (params: any) {
            if (typeof params.value[2] == 'undefined') {
              let toolTiphtml = ''
              for (let i = 0; i < data.length; i++) {
                if (params.name == data[i].name) {
                  toolTiphtml = '商品销售数量' + ':<br>'
                  toolTiphtml += data[i].value
                }
              }
              return toolTiphtml
            } else {
              let toolTiphtml = ''
              for (let i = 0; i < data.length; i++) {
                if (params.name == data[i].name) {
                  toolTiphtml = '商品销售数量' + ':<br>'
                  toolTiphtml += data[i].value
                }
              }
              return toolTiphtml
            }
          }
        },
        visualMap: {
          show: true,
          min: 0,
          max: 200,
          left: 'left',
          top: 'bottom',
          text: ['高', '低'], // 文本，默认为数值文本
          calculable: true,
          seriesIndex: [1],
          inRange: {
            color: ['#00467F', '#A5CC82'] // 蓝绿
          }
        },
        geo: {
          show: true,
          map: 'china',
          label: {
            show: false
          },
          roam: true,
          itemStyle: {
            areaColor: '#031525',
            borderColor: '#3B5077'
          }
        },
        series: [
          {
            name: '散点',
            type: 'scatter',
            coordinateSystem: 'geo',
            data: convertData(data),
            symbolSize: function (val: any) {
              return val[2] / 10
            },
            label: {
              formatter: '{b}',
              position: 'right',
              show: true
            },
            itemStyle: {
              color: '#05C3F9'
            }
          },
          {
            type: 'map',
            map: 'china',
            geoIndex: 0,
            aspectScale: 0.75, //长宽比
            showLegendSymbol: false, // 存在legend时显示
            label: {
              show: true
            },
            textStyle: {
              color: '#fff'
            },
            roam: true,
            itemStyle: {
              areaColor: '#031525',
              borderColor: '#3B5077'
            },
            animation: false,
            data: data
          },
          {
            name: 'Top 5',
            type: 'effectScatter',
            coordinateSystem: 'geo',
            data: convertData(
              data
                .sort(function (a, b) {
                  return b.value - a.value
                })
                .slice(0, 5)
            ),
            symbolSize: function (val: any) {
              return val[2] / 10
            },
            showEffectOn: 'render',
            rippleEffect: {
              brushType: 'stroke'
            },
            emphasis: {
              scale: true
            },
            label: {
              formatter: '{b}',
              position: 'right',
              show: true
            },
            itemStyle: {
              color: 'yellow',
              shadowBlur: 10,
              shadowColor: 'yellow'
            },
            zlevel: 1
          }
        ]
      }
      myChart.setOption(options)
      window.addEventListener('resize', () => {
        myChart.resize()
      })
    })

    return {}
  }
})
</script>

<style scoped lang="less">
.map-chart {
  width: 100%;
  height: 586px;
}
</style>
