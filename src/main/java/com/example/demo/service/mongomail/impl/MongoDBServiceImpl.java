package com.example.demo.service.mongomail.impl;

import com.example.demo.dao.mongomail.MongoDBDao;
import com.example.demo.entity.mongomail.MongoDBEntity;
import com.example.demo.service.mongomail.MongoDBService;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 *@Author 86151
 *@date 2019/9/1 21:18
 *@description mongodb的service实体类层
 *return
 */
@Service
public class MongoDBServiceImpl implements MongoDBService {

    /*CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
    CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
            fromProviders(pojoCodecProvider));*/

    private static Logger logger = LoggerFactory.getLogger(MongoDBServiceImpl.class);

    //MongoClient mongoClient = new MongoClient("localhost",27017);

    //MongoDatabase database = mongoClient.getDatabase("testdbs");

    //MongoCollection<Document> mongoCollection = database.getCollection("test");

    @Autowired
    private MongoDBDao mongoDBDao;



    @Autowired(required = false)
    private MongoTemplate mongoTemplate;

    @Override
    public void batchInsert(List<MongoDBEntity> entList) {
        //分组批量多次插入 每次2000条
//        List<MongoDBEntity> gropuList = CollectionHelper.spliceArrays(entList,AppConst.BATCH_RECORD_COUNT);
//        for (List<MongoDBEntity> list : gropuList){
//            mongoTemplate.insert(list,MongoDBEntity.class);
//        }

    }

    /**
     *@Author 86151
     *@Date 2019/9/1 21:43
     *Description 添加
     @Param
     *return
     */
    @Override
    public void insert(Document document) {
       // mongoTemplate.save(mongoDBEntity);
       // mongoCollection.insertOne(document);
    }

    /**
     *@Author 86151
     *@Date 2019/9/1 21:45
     *Description 查找
     @Param
     *return
     */
    @Override
    public MongoDBEntity findMailById(Long mailId) {
        Query query = new Query(Criteria.where("mail_id").is(mailId));
        MongoDBEntity mongoDBEntity = mongoTemplate.findOne(query,MongoDBEntity.class);
        return mongoDBEntity;
    }

    /**
     * 查询一段时间范围内待发送的邮件
     *
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @return
     */
    @Override
    public List<MongoDBEntity> findToSendList(Date startTime, Date endTime) {
        Query query = new Query(Criteria.where("create_time").gt(startTime).lt(endTime)
                 .and("has_delete").is(Boolean.FALSE)
                .and("retry_count").lt(3))
                .limit(20);

        List<MongoDBEntity> entityList = mongoTemplate.find(query,MongoDBEntity.class);
        return entityList;
    }

    /**
     *@Author 86151
     *@Date 2019/9/1 22:08
     *Description 修改
     @Param
     *return
     */
    @Override
    public boolean update(Document filter,Document update) {

        //更新查询返回结果集的第一条
        //mongoTemplate.updateFirst(query, update, MongoDBEntity.class);
        try{
           // UpdateResult result =  mongoCollection.updateOne(filter,new Document("$unset", update));

           // return (result.getModifiedCount() > 0L);
        }catch (Exception e){
            logger.error("update error.filter:" + filter.toJson()
                    + "\n update:" + update.toJson() + " \n" + e.getMessage());
        }
        return false;
    }

    /**
     *@Author 86151
     *@Date 2019/9/1 22:08
     *Description 删除
     @Param
     *return
     */
    @Override
    public void delete(Document document) {
        //Query query = new Query(Criteria.where("_id").is(mailId));
       // mongoTemplate.remove(query, MongoDBEntity.class);
       // mongoCollection.deleteOne(document);
    }

    /**********************************************************主要运用下面的方法******************************************************************/

    @Override
    public boolean increaseMongoDBDatabase(MongoDBEntity mongoDBEntity) {
        return mongoDBDao.insertMongoDBDatabase(mongoDBEntity);
    }

    @Override
    public boolean editMongoDBDatabase(MongoDBEntity mongoDBEntity) {
        return mongoDBDao.updateMongoDBDatabase(mongoDBEntity);
    }

    /**
     *@Author 86151
     *@Date 2019/9/5 17:04
     *Description 查询总数量
     @Param
     *return
     */
    @Override
    public int lookMongoDBDatabaseAllCount() {
        return (int) mongoDBDao.findMongoDBDatabaseAllCount();
    }

    @Override
    public int lookMongoDBDatabaseCount(MongoDBEntity mongoDBEntity) {
        return (int) mongoDBDao.findMongoDBDatabaseCount(mongoDBEntity);
    }

    /**
     *@Author 86151
     *@Date 2019/9/5 17:04
     *Description 按照条件查询数据
     @Param
      *return
     */
    @Override
    public List<Document> lookMongoDBDatabase(String mongoDBEntity, Integer currentPage, Integer pageSize,Integer sort) {
        String fieldName = "id";  //可以用于修改，
        return mongoDBDao.findMongoDBDatabase(mongoDBEntity,currentPage,pageSize,sort,fieldName);
    }

    @Override
    public boolean removeMongoDBDatabase(long id) {
        return mongoDBDao.deleteMongoDBDatabase(id);
    }
}
