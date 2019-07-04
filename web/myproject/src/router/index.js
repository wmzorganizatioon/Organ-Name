import Vue from 'vue'
import Router from 'vue-router'
import loginPage from '@/components/login/loginPage'

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: '/',
      name: 'loginPage',
      component: loginPage
    },{
      path: '/registeredPage',
      name: 'registeredPage',
      component: () => import('@/components/login/registeredPage')
    },{
      path:"/forGetPassword",
      name:"forGetPassword",
      component:() => import('@/components/login/forGetPassword')
    },{
      path:"/meunPage",
      name:"meunPage",
      component:() => import('@/components/meun/meunPage')
    }
  ]
})
