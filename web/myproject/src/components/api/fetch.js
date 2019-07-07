/*
* axios的异步刷新
* */

import axios from 'axios'
import Vue from 'vue'
//判断线上环境与开发环境
let baseUrl;
if(process.env.NODE_ENV === 'development'){
  baseUrl = process.env.API_HOST;              //proxyTable会把base + '/api/c/xx'代理到【base baseUrl + '/api/c/xx'】的接口地址上。  这里的base是你的本地地址如：localhost:8080   这里的baseurl就是要代理的一串地址
}else if(process.env.NODE_ENV === 'production'){
  baseUrl = process.env.API_HOST;            //此处在未实现，后期打包实现此功能(另一种可通过nginx代理)
}else if(process.env.NODE_ENV === 'test'){
  baseUrl = "http://192.168.44.1:8092/";          // 测试环境，基本不会用到，知道有就行了
}
//创建axios（一些固定值统一化就行）
const request = axios.create({
  baseURL:baseUrl,
  headers:{ 'Content-Type': 'application/json;' },    //请求格式：json
  timeout:30000,                                        //1000ms = 1s
  changeOrigin: true, // 允许跨域
  credentials: 'include',
  withCredentials: true
});
//axios请求拦截
console.log("下面是拦截")
request.interceptors.request.use(
  config =>{
    console.log("是否走了拦截")
    // 增加判断，除登陆接口外，添加token； 此处判断需根据自身项目实际情况进行自定义
    //【只有在登陆的时候获取一次token，并保存起来传给后台】
    var token = localStorage.getItem("token");
    token?config.headers.Authorization=token:null;
    return config;
  },
  error => {
    console.log('加载超时')
    return Promise.reject(error);
  }
);

//axios响应拦截
request.interceptors.response.use(
  response =>{
    if(response.status === 200){   //此处只放行200的其他一律拦截报错
      return response
    }else {
      Vue.$vux.toast.show({
        text: response.data.message,
        type: 'text',
        width: '50%'
      });
      return Promise.reject(new Error(response.data.message)) // 拦截打印错误信息，在调用时，必须加入catch，浏览器才不会显示红色报错
    }
  },
  error => { // 请求失败时的提示
    //console.log(error.response.status);
    return Promise.reject(error)
  }
);

export default request;


//了解index.js下的地址与axios的baseurl的区别：https://segmentfault.com/q/1010000010964938
