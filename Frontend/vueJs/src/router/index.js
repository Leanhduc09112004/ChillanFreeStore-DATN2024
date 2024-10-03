import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'
import BanHang from '../views/BanHang.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home
    },
    {
      path: '/ban-hang',
      name: 'ban-hang',
      component: BanHang
    },
  ]
})

export default router
