package com.example.demo.service.mongomail;

import com.example.demo.entity.mongomail.MongoDBEntity;
import org.bson.Document;

import java.util.Date;
import java.util.List;

/**
 *@Author 86151
 *@date 2019/9/1 21:02
 *@description mongodb的service层
 *return
 */
public interface MongoDBService {

    /**
     *@Author 86151
     *@Date 2019/9/1 21:06
     *Description 批量创建对象
     @Param
     *return
     */
    void batchInsert(List<MongoDBEntity> entList);

    /**
     *@Author 86151
     *@Date 2019/9/1 21:08
     *Description 创建对象
     @Param 
     *return
     */
    void insert(Document document);

    /**
     *@Author 86151
     *@Date 2019/9/1 21:10
     *Description 根据ID查询对象
     @Param 
     *return
     */
    MongoDBEntity findMailById(Long mailId);

    /**
     *@Author 86151
     *@Date 2019/9/1 21:11
     *Description 查询一段时间范围内待发送的邮件
     @Param 
     *return
     */
    List<MongoDBEntity> findToSendList(Date startTime, Date endTime);

    /**
     *@Author 86151
     *@Date 2019/9/1 21:12
     *Description 更新
     @Param 
     *return
     */
    boolean update(Document filter,Document update);

    /**
     *@Author 86151
     *@Date 2019/9/1 21:12
     *Description 删除
     @Param
     *return
     */
    void delete(Document document);

    /**********************************************************主要运用下面的方法******************************************************************/

    /**
     *@Author 86151
     *@Date 2019/9/5 17:33
     *Description 新增
     @Param
     *return
     */
    boolean increaseMongoDBDatabase(MongoDBEntity mongoDBEntity);

    /**
     *@Author 86151
     *@Date 2019/9/5 19:05
     *Description 修改
     @Param
     *return
     */
    boolean editMongoDBDatabase(MongoDBEntity mongoDBEntity);


    /**
     *@Author 86151
     *@Date 2019/9/5 17:04
     *Description 查询总数量
     @Param
      *return
     */
    int lookMongoDBDatabaseAllCount();

    /**
     *@Author 86151
     *@Date 2019/9/5 17:07
     *Description 按要求查询数据是否存在
     @Param mongoDBEntity:条件字段 （mongodb的count()后面无法跟limit、skip和sort）
     *return
     */
    int lookMongoDBDatabaseCount(MongoDBEntity mongoDBEntity);

    /**
     *@Author 86151
     *@Date 2019/9/5 15:09
     *Description 查询显示数据
     @Param
     *return
     */
    List<Document> lookMongoDBDatabase(String mongoDBEntity,Integer currentPage,Integer pageSize,Integer sort);

    /**
     *@Author 86151
     *@Date 2019/9/5 20:01
     *Description 删除
     @Param
     *return
     */
    boolean removeMongoDBDatabase(long id);

}
