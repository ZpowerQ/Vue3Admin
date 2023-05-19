import erRequest from '@/service'

export function getCpuInfo() {
  return erRequest.get({
    url: '/systemInfo/getCpuInfo'
  })
}

export function getDdrInfo() {
  return erRequest.get({
    url: '/systemInfo/getDdrInfo'
  })
}

export function getDiskInfo() {
  return erRequest.get({
    url: '/systemInfo/getDiskInfo'
  })
}
