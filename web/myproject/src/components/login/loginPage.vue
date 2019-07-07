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
      <el-col :span="8" label="验证码:">
        <!--验证码图解-->
        <img src="/api/user/getCode" />
        <template slot="prepend">验证码:</template>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="8">
        <el-button id="registered" v-on:click="registered()" style="float: left" type="primary">注册</el-button>
        <el-button id="forGetPassword" v-on:click="forGetPassword()" style="" type="primary">忘记密码</el-button>
        <el-button id="login" v-on:click="checkLogin()" style="float: right" type="primary">登录</el-button>
      </el-col>
    </el-row>
  </div>
</template>

<script>
    //import ElButton from "element-ui/packages/button/src/button";
    export default {
      name: "loginPage",
      props:[],
      components:{},
      created(){
      },
      mounted(){

      },
      data(){
        return{
          name:"",
          password:"",
          getCode:""
        }
      },
      methods:{
        //登录
        checkLogin(){
          var user = {
            name:this.name,
            password:this.password
          };

          this.$post("/user/login",user,{timeout: 1000 * 60 * 2}).then(data =>{
            if(data.success){
              localStorage.setItem("token",data.code);
              this.$router.push({path:"/meunPage"});
            }

          }).catch(e => {
            console.log(e)
          });
        },

        //注册账号
        registered(){
          this.$router.push({path:"/registeredPage",query:{dataValue:"传个值试试！！！"}});
        },
        //忘记密码
        forGetPassword(){
          this.$router.push({path:"/forGetPassword"});
        }
      },
      watch:{

      },
      filter:{

      }
    }
</script>

<style lang="scss" scoped>
  .loginPage{
    padding: .1rem;
  }
  .el-row {
    margin-bottom: 20px;
    margin-left: 35rem;
  &:last-child {
     margin-bottom: 0;

   }
  }
  .login-box {
    margin-top:20%;
    margin-left:40%;
  }

</style>
