// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'

import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
Vue.use(ElementUI);
import 'element-ui/lib/theme-chalk/index.css'

//全局调用方法
import {get,post,put,deletePrams,patch} from '@/components/api/http'
Vue.prototype.$get = get;
Vue.prototype.$post = post;
Vue.prototype.$put = put;
Vue.prototype.$deletePrams = deletePrams;
Vue.prototype.$patch = patch;

Vue.config.productionTip = false;

//前台先自动判断，若无token直接跳到登陆
router.beforeEach((to,from,next)=>{
  if(to.path != "/"){
    if(localStorage.getItem('token')){
      next()
    }else{
      next({path:'/'})
    }

  }else{
    next()
  }

})

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
});
