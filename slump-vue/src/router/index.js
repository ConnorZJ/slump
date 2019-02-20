import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

const page = name => () => import('@/pages/' + name)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      redirect: '/login'
    },
    {
      path: '/404',
      name: '404',
      component: page('404')
    },
    {
      path: '/register',
      name: 'register',
      component: page('register')
    },
    {
      path: '/login',
      name: 'login',
      component: page('login')
    },
    {
      path: '*',
      redirect: '/404'
    }
  ]
})
