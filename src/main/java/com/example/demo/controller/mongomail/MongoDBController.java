package com.example.demo.controller.mongomail;

import com.example.demo.common.annotation.PostAnnotation;
import com.example.demo.entity.mongomail.MongoDBEntity;
import com.example.demo.service.mongomail.MongoDBService;
import com.example.demo.utils.JsonDomainArray;
import com.example.demo.utils.JsonResponseValue;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 *@Author 86151
 *@date 2019/9/1 22:19
 *@description MongoDB控制层用来调用service
 *return
 */
@RestController
public class MongoDBController {

    static final Logger logger = LoggerFactory.getLogger(MongoDBController.class);

    @Autowired
    private MongoDBService mongoDBService;

    @GetMapping(value = "mongodb")
    public void setMongoDBService(){
        MongoDBEntity mongoDBEntity = new MongoDBEntity();
        mongoDBEntity.setRemark("这是我添加的一条");
       // mongoDBEntity.setMailId(Long.valueOf(1));
        Document document = new Document("mongoDBEntity","123").append("key",123);
        mongoDBService.insert(document);
    }

    @GetMapping(value = "mongodbdelete")
    public void deleteMongoDBService(){
        Document document = new Document("mongoDBEntity","123");
        mongoDBService.delete(document);
    }

    @GetMapping(value = "mongodbupdate")
    public void updateMongoDBService(){
        Document document = new Document("mongoDBEntity","123");
        Document document1 = new Document("key","1256asd");
        if(mongoDBService.update(document,document1)){
            logger.info("mongodb修改成功！");
        }
    }

    /**********************************************************主要运用下面的方法******************************************************************/

    /**
     *@Author 86151
     *@Date 2019/9/5 17:26
     *Description 查询
     @Param
     *return
     */
    @PostMapping(value = "mongodbQuery")
    @ResponseBody
    public JsonDomainArray queryMongoDBCondition(@RequestBody MongoDBEntity mongoDBEntity, Integer currentPage, Integer pageSize, Integer sort){
        logger.info("成功进入查询接口！！！");
        JsonDomainArray jsonDomainArray = new JsonDomainArray();

        try {
            //查看条数
            int count = mongoDBService.lookMongoDBDatabaseCount(mongoDBEntity);   //按照要求查询
            //int count = mongoDBService.lookMongoDBDatabaseAllCount();//查询所有
            if(count != 0){
               //List<Document> queryMongoDBDatabase = mongoDBService.lookMongoDBDatabase(mongoDBEntity,currentPage,pageSize,sort);  //按要求查询
                List<Document> queryMongoDBDatabase = mongoDBService.lookMongoDBDatabase("567",1,5,-1);
                jsonDomainArray.setCode("0000");
                jsonDomainArray.setSuccess(true);
                jsonDomainArray.setReason("成功获取显示数据！！！");
                jsonDomainArray.setData(queryMongoDBDatabase);
            }else {
                jsonDomainArray.setCode("0000");
                jsonDomainArray.setSuccess(true);
                jsonDomainArray.setReason("成功获取显示数据,但是数据为0！！！");
            }
        }catch (Exception e){
            logger.info("mongodb查询接口异常");
            jsonDomainArray.setSuccess(false);
            jsonDomainArray.setCode("9999");
            jsonDomainArray.setReason("接口异常;接口名称:" + "mongodbQuery");
        }

        return jsonDomainArray;
    }

    /**
     *@Author 86151
     *@Date 2019/9/5 17:27
     *Description 新增(新增编辑分开了要想通过id来确定可改)
     @Param
     *return
     */
    @PostMapping(value = "mongodbAdd")
    @ResponseBody
    public JsonResponseValue addMongoDBDatabase(@RequestBody MongoDBEntity mongoDBEntity){
        logger.info("成功进入新增接口！！！");
        JsonResponseValue jsonResponseValue = new JsonResponseValue();

        try {

            if(mongoDBService.increaseMongoDBDatabase(mongoDBEntity)){
                jsonResponseValue.setCode("0000");
                jsonResponseValue.setReason("添加成功！！！");
                jsonResponseValue.setSuccess(true);
            }else {
                jsonResponseValue.setSuccess(false);
                jsonResponseValue.setReason("添加失败");
                jsonResponseValue.setCode("2222");
            }

        }catch (Exception e){
            logger.info("mongodb新增接口异常");
            jsonResponseValue.setCode("9999");
            jsonResponseValue.setSuccess(false);
            jsonResponseValue.setReason("接口异常;接口名称:" + "mongodbAdd");
        }
        return jsonResponseValue;
    }

    /**
     *@Author 86151
     *@Date 2019/9/5 19:03
     *Description 修改
     @Param
     *return
     */

    @PostMapping(value = "mongodbModify")
    @ResponseBody
    public JsonResponseValue modifyMongoDBDatabase(@RequestBody MongoDBEntity mongoDBEntity){
        logger.info("成功进入修改接口！！！");
        JsonResponseValue jsonResponseValue = new JsonResponseValue();

        try {

            if(mongoDBService.editMongoDBDatabase(mongoDBEntity)){
                jsonResponseValue.setCode("0000");
                jsonResponseValue.setReason("修改成功！！！");
                jsonResponseValue.setSuccess(true);
            }else {
                jsonResponseValue.setSuccess(false);
                jsonResponseValue.setReason("修改失败");
                jsonResponseValue.setCode("2222");
            }

        }catch (Exception e){
            logger.info("mongodb修改接口异常");
            jsonResponseValue.setCode("9999");
            jsonResponseValue.setSuccess(false);
            jsonResponseValue.setReason("接口异常;接口名称:" + "mongodbModify");
        }
        return jsonResponseValue;
    }

    /**
     *@Author 86151
     *@Date 2019/9/5 20:02
     *Description 删除
     @Param
     *return
     */
    @PostMapping("mongodbDelete")
    @ResponseBody
    public JsonResponseValue removeMongoDBDatabase(@RequestBody long id){
        logger.info("成功进入删除接口！！！");
        JsonResponseValue jsonResponseValue = new JsonResponseValue();

        try {

            if(mongoDBService.removeMongoDBDatabase(id)){
                jsonResponseValue.setCode("0000");
                jsonResponseValue.setReason("修改成功！！！");
                jsonResponseValue.setSuccess(true);
            }else {
                jsonResponseValue.setSuccess(false);
                jsonResponseValue.setReason("修改失败");
                jsonResponseValue.setCode("2222");
            }

        }catch (Exception e){
            logger.info("mongodb修改接口异常");
            jsonResponseValue.setCode("9999");
            jsonResponseValue.setSuccess(false);
            jsonResponseValue.setReason("接口异常;接口名称:" + "mongodbDelete");
        }
        return jsonResponseValue;
    }
}
