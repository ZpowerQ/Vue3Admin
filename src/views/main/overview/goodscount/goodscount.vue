<template>
  <div class="goodscount">
    <dynamic-num :dynamicItems="CountJsConfig" />
    <div class="chart-content">
      <page-charts />
    </div>
  </div>
</template>

<script lang="ts">
import { defineComponent } from 'vue'
import DynamicNum from '@/components/DynamicNum/dynamicNum.vue'
import { CountJsConfig } from './config/CountJsConfig'
import pageCharts from '@/components/echart/pageCharts.vue'
import { useStore } from 'vuex'
export default defineComponent({
  name: 'goodscount',
  components: {
    DynamicNum,
    pageCharts
  },
  setup() {
    const store = useStore()
    store.dispatch('overviewState/getchartDate', {
      cname: 'cellcount',
      url: '/show/cellcount'
    })
    return { CountJsConfig }
  }
})
</script>

<style scoped>
.chart-content {
  margin-top: 12px;
}
</style>
