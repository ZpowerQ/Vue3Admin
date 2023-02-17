import { CountJsConfigItem } from '../type'
export const CountJsConfig: CountJsConfigItem[] = [
  {
    title: '商品总收藏量',
    id: 'num1',
    endVal: 87606,
    options: {
      useEasing: true, //过渡动画效果
      useGrouping: true, //千分位效果
      separator: ',', //千分位分隔符
      decimal: '', //小数位分隔符
      prefix: '', //前置符号
      suffix: '', //后置符号
      duration: 3
    }
  },
  {
    title: '商品总库存',
    id: 'num2',
    endVal: 867271,
    options: {
      useEasing: true, //过渡动画效果
      useGrouping: true, //千分位效果
      separator: ',', //千分位分隔符
      decimal: '', //小数位分隔符
      prefix: '', //前置符号
      suffix: '', //后置符号
      duration: 3
    }
  },
  {
    title: '商品总销售量',
    id: 'num3',
    endVal: 510173,
    options: {
      useEasing: true, //过渡动画效果
      useGrouping: true, //千分位效果
      separator: ',', //千分位分隔符
      decimal: '', //小数位分隔符
      prefix: '', //前置符号
      suffix: '', //后置符号
      duration: 3
    }
  },
  {
    title: '商品总销售额',
    id: 'num4',
    endVal: 43130820,
    options: {
      useEasing: true, //过渡动画效果
      useGrouping: true, //千分位效果
      separator: ',', //千分位分隔符
      decimal: '', //小数位分隔符
      prefix: '￥', //前置符号
      suffix: '', //后置符号
      duration: 3
    }
  }
]
