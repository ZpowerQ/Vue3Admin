import { App } from 'vue'
import { formateUTCtime } from '@/utils/formateUTCtime'
export default function registerProperties(app: App) {
  app.config.globalProperties.$utils = {
    formateTime(value: string, dateType?: string) {
      return formateUTCtime(value, dateType)
    }
  }
}
