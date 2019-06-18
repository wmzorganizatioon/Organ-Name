<template>
  <div class="loginPage">
    <el-row>
      <el-col :span="8">
        <el-input id="name"  v-model="name" placeholder="请输入帐号">
          <template slot="prepend">帐号</template>
        </el-input>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="8">
        <el-input id="password" v-model="password" type="password" placeholder="请输入密码">
          <template slot="prepend">密码</template>
        </el-input>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="8">
        <el-button id="registered" @click="sure()" style="width:50%" type="primary">确定</el-button>
      </el-col>
    </el-row>
  </div>
</template>

<script>
    export default {
      name: "registeredPage",
      props:[],
      components:{},
      created:function () {
        var data = this.$route.query.dataValue;   //路由请求接收值；
        console.log(data);
      },
      mounted:function () {

      },
      data(){
        return{
          name:"",
          password:""
        }
      },
      methods:{
        sure(){
          var user = {
            name:this.name,
            password:this.password
          };
          this.$post("/user/registered",user,{timeout: 1000 * 60 * 2}).then(data =>{
            if(data.success)
              this.$router.push({path:"/"});

          }).catch(e => {
            debugger;
            console.log(e)
          });

        }
      },
      filter:{

      },
      watch:{

      }
    }
</script>

<style scoped>

</style>
