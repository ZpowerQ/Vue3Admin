let BASR_URL = ''
const TIME_OUT = 10000
if (process.env.NODE_ENV === 'development') {
  BASR_URL = '/api'
} else if (process.env.NODE_ENV === 'production') {
  BASR_URL = '/api'
}
export { BASR_URL, TIME_OUT }
