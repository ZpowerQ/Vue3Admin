const department = () =>
  import('@/views/main/management/department/department.vue')
export default {
  path: '/main/management/department',
  name: 'department',
  component: department,
  children: []
}
