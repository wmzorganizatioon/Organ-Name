<!--菜单栏集-->
<template>
    <div>
      <!--导航栏-->
      <el-menu
        :default-active="activeIndex"
        class="el-menu-demo"
        mode="horizontal"
        active-text-color="#ffd04b"
        text-color="#fff"
        @select="handleSelect"
        style="background-color: #545c64;margin-top: -4rem;">
        <el-menu-item index="1" class="meunItem"><a href="https://www.ele.me" target="_blank"><i class="el-icon-circle-close-outline"></i>关闭</a></el-menu-item>
        <el-menu-item index="2" class="meunItem"><span>关于我们</span></el-menu-item>
        <el-menu-item index="3" class="meunItem"><a href="https://www.ele.me" target="_blank"><i class="el-icon-location-outline"></i>地理位置</a></el-menu-item>
      </el-menu>
      <!--左树形菜单-->
      <el-tree
        :data="meunData"
        :highlight-current= true
        empty-text = "菜单暂无数据"
        accordion
        :load="loadNode"
        :props="defaultProps"
        @node-click="handleNodeClick"
        style="width: 12rem;float: left"
      />
      <div style="padding-left: 12rem;">
        <div style="border: 1px solid #dedede;font-size: 1.8rem;font-weight: bold;font-family: 'Microsoft YaHei'">
          规模统计

        </div>
      </div>
    </div>
</template>

<script>
  //import commonCss from '@/components/common/commonCss';
    export default {
        name: "meunPage",
      props:[],
      components:{},
      created() {
          this.getMeuns();
      },
      mounted() {
      },
      data(){
          return{
            meunData:[],
            defaultProps:{
              children: 'childMeuns',
              label: 'meunName'
            },
            activeIndex: "1"
          }
      },
      methods:{
          //获取菜单集
        getMeuns(){
          this.$get("/meun/meun/get/meuns").then(data=>{
            this.meunData = data.data;

          })
        },
          //点击菜单事件
        handleNodeClick(data){
        },

        //加载子树数据（暂无）
        loadNode(node, resolve){
        },

        //选择导航栏
        handleSelect(key, keyPath) {
          console.log(key, keyPath);
        }

      },
      watch:{

      },
      filters:{

      }
    }
</script>

<style scoped lang="scss">
  .el-menu-item{
    float: right;
    margin-right: 5rem;
  }
  .is-active:hover{
    background-color: #677480;
  }
  .meunItem:hover{
    background-color: #677480 !important;
  }

</style>
