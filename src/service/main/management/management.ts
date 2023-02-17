import erRequest from '@/service'

export function getPageListDate(payload?: any) {
  if (payload?.type === 'list') {
    return erRequest.post({
      url: `${payload?.pageName}/${payload?.type}`,
      data: payload?.data ?? {}
    })
  } else {
    return erRequest.post({
      url: `${payload?.pageName}/${payload?.type}/${payload.currentpage}/${payload.size}`,
      data: payload?.data ?? {}
    })
  }
}

export function addPageDate(payload?: any) {
  return erRequest.post({
    url: payload.url,
    data: payload.data
  })
}

export function deleteData(payload?: any) {
  return erRequest.get({
    url: payload.url
  })
}
