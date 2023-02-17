import dayjs from 'dayjs'
import utc from 'dayjs/plugin/utc'
dayjs.extend(utc)
export function formateUTCtime(
  value: string,
  dateType = 'YYYY-MM-DD HH:mm:ss'
) {
  return value ? dayjs.utc(value).format(dateType) : null
}
export function formateLocaltime(
  value: string,
  dateType = 'YYYY-MM-DD HH:mm:ss'
) {
  return value ? dayjs(value).format(dateType) : null
}
