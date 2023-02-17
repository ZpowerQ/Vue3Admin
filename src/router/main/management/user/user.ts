const user = () => import('@/views/main/management/user/user.vue')
export default {
  path: '/main/management/user',
  name: 'user',
  component: user,
  children: []
}
