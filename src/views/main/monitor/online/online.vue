<template>
  <div class="online">
    <div class="top_section">
      <el-card class="box-card">
        <template #header>
          <div class="card-header">
            <span
              ><el-icon><Cpu /></el-icon>CPU</span
            >
            <el-button
              class="button"
              type="primary"
              plain
              size="small"
              @click="handleRefresh('cpu')"
              >刷新</el-button
            >
          </div>
        </template>
        <el-table :data="cpuInfo" style="width: 100%">
          <el-table-column prop="name" label="属性" />
          <el-table-column prop="value" label="值" />
        </el-table>
      </el-card>
      <el-card class="box-card">
        <template #header>
          <div class="card-header">
            <span
              ><el-icon><Coin /></el-icon>内存</span
            >
            <el-button
              class="button"
              type="primary"
              plain
              size="small"
              @click="handleRefresh('ddr')"
              >刷新</el-button
            >
          </div>
        </template>
        <el-table :data="ddrInfo" style="width: 100%">
          <el-table-column prop="name" label="属性" />
          <el-table-column prop="value" label="值" />
        </el-table>
      </el-card>
    </div>
    <div class="bottom_section">
      <el-card class="box-card">
        <template #header>
          <div class="card-header">
            <span
              ><el-icon><Files /></el-icon>磁盘</span
            >
            <el-button
              class="button"
              type="primary"
              plain
              size="small"
              @click="handleRefresh('disk')"
              >刷新</el-button
            >
          </div>
        </template>
        <el-table :data="diskInfo" style="width: 100%">
          <el-table-column prop="path" label="磁盘路径" />
          <el-table-column prop="total" label="总大小" />
          <el-table-column prop="use" label="可用大小" />
          <el-table-column prop="free" label="已用大小" />
          <el-table-column prop="usage" label="已用百分比" />
        </el-table>
      </el-card>
    </div>
  </div>
</template>

<script lang="ts">
import { defineComponent, ref } from 'vue'
import { Cpu, Coin, Files } from '@element-plus/icons-vue'
import {
  getCpuInfo,
  getDdrInfo,
  getDiskInfo
} from '@/service/main/monitor/index'
import { ElMessage } from 'element-plus'
export default defineComponent({
  name: 'online',
  components: {
    Cpu,
    Coin,
    Files
  },
  methods: {},
  setup() {
    let cpuInfo = ref()
    let ddrInfo = ref()
    let diskInfo = ref()
    const getCpuInfoDate = () => {
      getCpuInfo().then((res) => {
        let arr = []
        for (const item of Object.keys(res.data)) {
          arr.push({ name: item, value: res.data[item] })
        }
        cpuInfo.value = arr
      })
    }
    const getDdrInfoDate = () => {
      getDdrInfo().then((res) => {
        let arr = []
        for (const item of Object.keys(res.data)) {
          arr.push({ name: item, value: res.data[item] })
        }
        ddrInfo.value = arr
      })
    }
    const getDiskInfoDate = () => {
      getDiskInfo().then((res) => {
        diskInfo.value = res.data
        console.log(res.data)
      })
    }
    const handleRefresh = async (type: string) => {
      switch (type) {
        case 'cpu':
          await getCpuInfoDate()
          ElMessage({
            message: '刷新成功',
            type: 'success'
          })
          break
        case 'ddr':
          await getDdrInfoDate()
          ElMessage({
            message: '刷新成功',
            type: 'success'
          })
          break
        case 'disk':
          await getDiskInfoDate()
          ElMessage({
            message: '刷新成功',
            type: 'success'
          })
          break
      }
    }
    getCpuInfoDate()
    getDdrInfoDate()
    getDiskInfoDate()
    return {
      cpuInfo,
      ddrInfo,
      diskInfo,
      handleRefresh
    }
  }
})
</script>

<style scoped lang="less">
.top_section {
  display: flex;
  gap: 25px;
  .box-card {
    flex: 1;
  }
}
.card-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  span {
    display: flex;
    align-items: center;
    gap: 5px;
  }
}
:deep(.el-card__header) {
  padding: 10px;
}
.bottom_section {
  margin-top: 20px;
}
</style>
