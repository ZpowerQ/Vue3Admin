<template>
  <div class="category">
    <div class="category_box">
      <div v-for="(item, index) in goodCategory" :key="item" class="item">
        <div class="cover_img">
          <img :src="require(`@/assets/good/${index + 1}.jpg`)" alt="image" />
        </div>
        <span class="title">{{ item.name }}</span>
      </div>
    </div>
  </div>
</template>

<script lang="ts">
import { computed, defineComponent } from 'vue'
import { useStore } from 'vuex'
export default defineComponent({
  name: 'category',
  setup() {
    const store = useStore()
    store.dispatch('goodsState/getPageList', { pageName: 'good_category' })
    const goodCategory = computed(() => store.state.goodsState.goodCategory)
    return { goodCategory }
  }
})
</script>

<style scoped lang="less">
.category_box {
  display: flex;
  flex-wrap: wrap;
  row-gap: 32px;
  padding: 10px 34px;
  column-gap: 40px;
}
.item {
  text-align: center;
  border: 1px solid #707070;
  border-radius: 5px;
  padding: 5px;
  &:hover {
    transform: translateY(-7px);
    box-shadow: 0 15px 30px rgba(0, 0, 0, 0.2);
    transition: all 300ms;
  }
}
.cover_img img {
  width: 200px;
  height: 150px;
}
.title {
  padding-top: 10px;
  font-weight: 700;
}
</style>
