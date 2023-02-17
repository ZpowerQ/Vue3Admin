import { CountUp, CountUpOptions } from 'countup.js'
export function initCountJs(
  target: any,
  endVal: number,
  options?: CountUpOptions
) {
  return new CountUp(target, endVal, options)
}
