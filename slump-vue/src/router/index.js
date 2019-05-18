import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

const page = name => () => import('@/pages/' + name)


export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      redirect: '/home'
    },
    {
      path: '/home',
      name: 'home',
      component: page('home')
    },
    {
      path: '/clazz',
      name: 'clazz',
      component: page('clazz')
    },
    {
      path: '/topic',
      name: 'topic',
      component: page('topic')
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
      path: '/signup',
      name: 'signup',
      component: page('signup')
    },
    {
      path:'/profile',
      name:'profile',
      component:page('profile')
    },
    {
      path:'/create',
      name:'create',
      component:page('create')
    },
    {
      path: '*',
      redirect: '/404'
    }
  ]
})
