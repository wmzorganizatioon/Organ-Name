/*
* 封装get、post、delete、put等方法
* */
import fetch from './fetch'          //由于我重新创建了个axios，这里使用地址统一修改

export function get(url,params){
  return new Promise((resolve,reject)=>{
    fetch.get(url,{
      params:params}).then(response =>{
      resolve(response.data)
    }).catch(error =>{
      reject(error)
    })
  })
}

export function post(url,data){
  return new Promise((resolve,reject)=>{
    fetch.post(url,data).then(response =>{
      resolve(response.data)
    }).catch(error =>{
      reject(error)
    })
  })
}

export function put(url,data){
  return new Promise((resolve,reject)=>{
    fetch.put(url,data).then(response =>{
      resolve(response.data)
    }).catch(error =>{
      reject(error)
    })
  })
}

export function patch(url,data){
  return new Promise((resolve,reject)=>{
    fetch.patch(url,data).then(response =>{
      resolve(response.data)
    }).catch(error =>{
      reject(error)
    })
  })
}

export function deletePrams(url,data){
  return new Promise((resolve,reject)=>{
    fetch.delete(url,data).then(response =>{
      resolve(response.data)
    }).catch(error =>{
      reject(error)
    })
  })
}
