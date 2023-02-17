import erRequest from '@/service'

export function getData(url: string) {
  return erRequest.get({
    url: url
  })
}
