package com.example.demo.dao.mongomail;

import com.example.demo.entity.mongomail.MongoDBEntity;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.apache.commons.collections4.map.LinkedMap;
import org.bson.Document;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import static com.mongodb.client.model.Filters.eq;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

@Repository
public class MongoDBDao {

    private static Logger logger = LoggerFactory.getLogger(MongoDBDao.class);

    CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
    CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
            fromProviders(pojoCodecProvider));

    //client、database、collection三层
    MongoClient mongoClient = new MongoClient("localhost",27017);

    MongoDatabase database = mongoClient.getDatabase("testdbs").withCodecRegistry(pojoCodecRegistry);

    MongoCollection<Document> mongoCollections = database.getCollection("test");

    MongoCollection<MongoDBEntity> mongoCollection = database.getCollection("test",MongoDBEntity.class);


    /**********************************************************主要运用下面的方法******************************************************************/

    /**
     *@Author 86151
     *@Date 2019/9/5 15:15
     *Description 查询总数量
     @Param
     *return
     */

    public long findMongoDBDatabaseAllCount() {
        long count = 0;
        try{
            count =  mongoCollection.count();
        }catch (Exception e){
            logger.info("dao层接口异常;方法名:" + "findMongoDBDatabaseAllCount");
        }
        return count;
    }

    /**
     *@Author 86151
     *@Date 2019/9/5 15:15
     *Description 按条件查询数量
     @Param
      *return
     */

    public long findMongoDBDatabaseCount(MongoDBEntity mongoDBEntity) {
        long count = 0;
        try{
                count =  mongoCollection.count(new Document("mongoDBEntity",567));   //567:是可以修改的

        }catch (Exception e){
            logger.info("dao层接口异常;方法名:" + "findMongoDBDatabaseCount");
        }
        return count;
    }

    /**
     *@Author 86151
     *@Date 2019/9/5 15:23
     *Description 按照条件查询数据
     @Param
     *return
     */
    public List<Document> findMongoDBDatabase(String mongoDBEntity, Integer currentPage, Integer pageSize,Integer sort,String fieldName){
        // 按指定地段排序
        BasicDBObject sorts = new BasicDBObject();

        List<Document> mongoDBEntityList = new ArrayList<Document>();
        try{
            //判断降序还是升序，这里的值可以随机添加，由于时间问题我直接固定死了
            if(sort == 1){
                sorts.put(fieldName, 1);
            }else {
                sorts.put(fieldName, -1);
            }

            FindIterable<Document> iterable = null;

            //Collection<MongoDBEntity> items = mongoDBEntity.getQueryItems();
            //条件查询
            Document documents = new Document();
            documents.put("mongoDBEntity",Integer.valueOf(mongoDBEntity));

            iterable = mongoCollections.find(documents).limit(pageSize).skip((currentPage - 1) * pageSize).sort(sorts);

            MongoCursor<Document> cursor = iterable.iterator();

            while (cursor.hasNext()) {
                Document document = cursor.next();
                mongoDBEntityList.add(document);
            };
        }catch (Exception e){
            logger.info("dao层接口异常;方法名:" + "findMongoDBDatabase");
        }
        return mongoDBEntityList;
    }

    /**
     *@Author 86151
     *@Date 2019/9/5 17:37
     *Description 新增
     @Param
     *return
     */
    public boolean insertMongoDBDatabase(MongoDBEntity mongoDBEntity){

        try {
            mongoCollection.insertOne(mongoDBEntity);
            return true;
        }catch (Exception e){
            logger.info("dao层接口异常;方法名:" + "findMongoDBDatabase");
        }

        return false;
    }

    /**
     *@Author 86151
     *@Date 2019/9/5 19:06
     *Description 修改
     @Param
     *return
     */
    public boolean updateMongoDBDatabase(MongoDBEntity mongoDBEntity){
        try {
             UpdateResult result =  mongoCollection.updateOne(eq("id",mongoDBEntity.getId()),new Document("$set", new Document("mailType",mongoDBEntity.getMailType())));

             return (result.getModifiedCount() > 0L);
           // mongoCollection.updateOne(new Document("id",mongoDBEntity.getId()),new Document("$set", mongoDBEntity.getMailType()));
           // return true;
        }catch (Exception e){
            logger.info("dao层接口异常;方法名:" + "updateMongoDBDatabase");
        }
        return false;
    }

    /**
     *@Author 86151
     *@Date 2019/9/5 19:06
     *Description 修改[删除不需要的字段]
     @Param
      *return
     */
    public boolean unUpdateMongoDBDatabase(MongoDBEntity mongoDBEntity){
        try {
            UpdateResult result =  mongoCollection.updateOne(eq("id",mongoDBEntity.getId()),new Document("$unset", new Document("mailType",mongoDBEntity.getMailType())));

            return (result.getModifiedCount() > 0L);
            // mongoCollection.updateOne(new Document("id",mongoDBEntity.getId()),new Document("$set", mongoDBEntity.getMailType()));
            // return true;
        }catch (Exception e){
            logger.info("dao层接口异常;方法名:" + "updateMongoDBDatabase");
        }
        return false;
    }

    /**
     *@Author 86151
     *@Date 2019/9/5 19:57
     *Description 删除
     @Param
     *return
     */
    public boolean deleteMongoDBDatabase(long id){
        try {
            DeleteResult result = mongoCollection.deleteOne(eq("id",id));
            return (result.getDeletedCount() > 0L);
        }catch (Exception e){
            logger.info("dao层接口异常;方法名:" + "deleteMongoDBDatabase");
        }
        return false;
    }
}
