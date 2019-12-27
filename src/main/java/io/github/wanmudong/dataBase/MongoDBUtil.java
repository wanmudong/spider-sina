package io.github.wanmudong.dataBase;

/**
 * @author ：wanmudong
 * @date ：Created in 2019/5/18 14:54
 * @description：
 */
import com.alibaba.fastjson.JSONObject;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.openqa.selenium.json.Json;

import java.util.ArrayList;
import java.util.List;

//mongodb 连接数据库工具类
public class MongoDBUtil {
     private static MongoDatabase mongoDatabase;
    //不通过认证获取连接数据库对象
    public static MongoDatabase getConnect(){
        if (mongoDatabase != null){
            return mongoDatabase;
        }
        //连接到 mongodb 服务
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        //连接到数据库
         mongoDatabase = mongoClient.getDatabase("douban");

        //返回连接数据库对象
        return mongoDatabase;
    }

    //需要密码认证方式连接
    public static MongoDatabase getConnect2(){
        List<ServerAddress> adds = new ArrayList<>();
        //ServerAddress()两个参数分别为 服务器地址 和 端口
        ServerAddress serverAddress = new ServerAddress("localhost", 27017);
        adds.add(serverAddress);

        List<MongoCredential> credentials = new ArrayList<>();
        //MongoCredential.createScramSha1Credential()三个参数分别为 用户名 数据库名称 密码
        MongoCredential mongoCredential = MongoCredential.createScramSha1Credential("username", "databaseName", "password".toCharArray());
        credentials.add(mongoCredential);

        //通过连接认证获取MongoDB连接
        MongoClient mongoClient = new MongoClient(adds, credentials);

        //连接到数据库
        MongoDatabase mongoDatabase = mongoClient.getDatabase("test");

        //返回连接数据库对象
        return mongoDatabase;
    }

    /**
     * 插入json
     * @param json
     * @param collectionName
     */
    public static void insertJsonToMongoDB(String json,String collectionName){
        //获取数据库连接对象
        MongoDatabase mongoDatabase = MongoDBUtil.getConnect();
        //获取集合
        MongoCollection<DBObject> collection = mongoDatabase.getCollection(collectionName, DBObject.class);

        DBObject bson = (DBObject)JSON.parse(json);

        collection.insertOne(bson);
    }
    public static void insertJsonListToMongoDB(List list,String collectionName){
        //获取数据库连接对象
        MongoDatabase mongoDatabase = MongoDBUtil.getConnect();
        //获取集合
        MongoCollection<DBObject> collection = mongoDatabase.getCollection(collectionName, DBObject.class);


        collection.insertMany(list);
    }

    /**
     * 查询json
     * @param filter
     * @param collectionName
     */
    public static List<JSONObject> selectJsonFromMongoDB(Bson filter,String collectionName){
        //获取数据库连接对象
        MongoDatabase mongoDatabase = MongoDBUtil.getConnect();
        //获取集合
        MongoCollection<DBObject> collection = mongoDatabase.getCollection(collectionName, DBObject.class);

        FindIterable findIterable;
        if (filter != null){
            //指定查询过滤器查询
            findIterable = collection.find(filter);
        }else {
            //查找集合中的所有文档
            findIterable = collection.find();
        }
        MongoCursor cursor = findIterable.iterator();
        List<JSONObject> list  = new ArrayList();
        while (cursor.hasNext()) {
            list.add(com.alibaba.fastjson.JSON.parseObject( cursor.next().toString()));
        }
        return list;
    }

    /**
     * 插入一条文档
     * @param document
     */
    public static void insertOneDocument(Document document){
        //获取数据库连接对象
        MongoDatabase mongoDatabase = MongoDBUtil.getConnect();
        //获取集合
        MongoCollection<Document> collection = mongoDatabase.getCollection("comment_pc_cn");
        //插入一个文档
        collection.insertOne(document);
    }
    /**
     * 批量插入文档
     * @param document
     */
    public static void insertListDocument(List<Document> document,String collectionName){
        //获取数据库连接对象
        MongoDatabase mongoDatabase = MongoDBUtil.getConnect();
        //获取集合
        MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName);
        //插入一个文档
        collection.insertMany(document);
    }
}
