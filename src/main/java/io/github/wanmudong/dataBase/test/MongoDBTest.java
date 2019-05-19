package io.github.wanmudong.dataBase.test;

import com.alibaba.fastjson.JSONObject;
import com.mongodb.DBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;
import io.github.wanmudong.dataBase.MongoDBUtil;
import org.bson.Document;
import org.junit.Test;

import java.util.List;

/**
 * @author ：wanmudong
 * @date ：Created in 2019/5/18 14:57
 * @description：
 */
public class MongoDBTest {

    //插入一个文档
    @Test
    public void insertOneTest(){
        //获取数据库连接对象
        MongoDatabase mongoDatabase = MongoDBUtil.getConnect();
        //获取集合
        MongoCollection<Document> collection = mongoDatabase.getCollection("user");
        //要插入的数据
        Document document = new Document("name","张三")
                .append("sex", "男")
                .append("age", 18);
        //插入一个文档
        collection.insertOne(document);
    }
    //插入一个json
    @Test
    public void insertOneJsonTest(){
        //获取数据库连接对象
        MongoDatabase mongoDatabase = MongoDBUtil.getConnect();
        //获取集合
        MongoCollection<DBObject> collection = mongoDatabase.getCollection("collectionName", DBObject.class);

        DBObject bson = (DBObject)JSON.parse(weibo);

        collection.insertOne(bson);
    }
    //查询一个json list
    @Test
    public void selectOneJsonListTest(){

        List<JSONObject> list = MongoDBUtil.selectJsonFromMongoDB(null, weibo);

    }
    public static String weibo = "{\n" +
            "\t\t\t\"card_type\": 9,\n" +
            "\t\t\t\"itemid\": \"1076033675865547_-_4364362522813374\",\n" +
            "\t\t\t\"scheme\": \"https:\\/\\/m.weibo.cn\\/status\\/Hr0mwbNT0?mblogid=Hr0mwbNT0&luicode=10000011&lfid=1076033675865547\",\n" +
            "\t\t\t\"mblog\": {\n" +
            "\t\t\t\t\"created_at\": \"04-23\",\n" +
            "\t\t\t\t\"id\": \"4364362522813374\",\n" +
            "\t\t\t\t\"idstr\": \"4364362522813374\",\n" +
            "\t\t\t\t\"mid\": \"4364362522813374\",\n" +
            "\t\t\t\t\"can_edit\": false,\n" +
            "\t\t\t\t\"show_additional_indication\": 0,\n" +
            "\t\t\t\t\"text\": \"\\u6211\\u6ca1\\u4e70\\u96f6\\u70b9\\u573a\\u7684\\u7968\\uff0c\\u4e0d\\u8bb8\\u544a\\u8bc9\\u6211\\u5267\\u60c5\\uff01\\uff01\\uff01\\u8c01\\u5267\\u900f\\u8c01\\u5c0f\\u72d7\\ud83d\\udc36 \",\n" +
            "\t\t\t\t\"textLength\": 54,\n" +
            "\t\t\t\t\"source\": \"\",\n" +
            "\t\t\t\t\"favorited\": false,\n" +
            "\t\t\t\t\"pic_types\": \"0\",\n" +
            "\t\t\t\t\"thumbnail_pic\": \"http:\\/\\/wx2.sinaimg.cn\\/thumbnail\\/db1941cbgy1g2cx730z0ej20u00u0jvb.jpg\",\n" +
            "\t\t\t\t\"bmiddle_pic\": \"http:\\/\\/wx2.sinaimg.cn\\/bmiddle\\/db1941cbgy1g2cx730z0ej20u00u0jvb.jpg\",\n" +
            "\t\t\t\t\"original_pic\": \"http:\\/\\/wx2.sinaimg.cn\\/large\\/db1941cbgy1g2cx730z0ej20u00u0jvb.jpg\",\n" +
            "\t\t\t\t\"is_paid\": false,\n" +
            "\t\t\t\t\"mblog_vip_type\": 0,\n" +
            "\t\t\t\t\"user\": {\n" +
            "\t\t\t\t\t\"id\": 3675865547,\n" +
            "\t\t\t\t\t\"screen_name\": \"SNH48-\\u6797\\u601d\\u610f\",\n" +
            "\t\t\t\t\t\"profile_image_url\": \"https:\\/\\/tvax4.sinaimg.cn\\/crop.0.0.1242.1242.180\\/db1941cbly8frmsvyenboj20yi0yi0uu.jpg\",\n" +
            "\t\t\t\t\t\"profile_url\": \"https:\\/\\/m.weibo.cn\\/u\\/3675865547?uid=3675865547&luicode=10000011&lfid=1076033675865547\",\n" +
            "\t\t\t\t\t\"statuses_count\": 2049,\n" +
            "\t\t\t\t\t\"verified\": true,\n" +
            "\t\t\t\t\t\"verified_type\": 0,\n" +
            "\t\t\t\t\t\"verified_type_ext\": 1,\n" +
            "\t\t\t\t\t\"verified_reason\": \"\\u4eba\\u6c14\\u5076\\u50cf\\u56e2\\u4f53SNH48\\u6210\\u5458\\u6797\\u601d\\u610f\",\n" +
            "\t\t\t\t\t\"close_blue_v\": false,\n" +
            "\t\t\t\t\t\"description\": \"\\u5408\\u4f5c\\u8054\\u7cfb\\uff0c\\u5546\\u52a1\\uff1abusiness@snh48.com 021-66075351 \\u5f71\\u89c6\\uff1ayingshi@snh48.com 021-66078718*819 \\u7efc\\u827a\\uff1azongyi@snh48.com 021-66078718*821\",\n" +
            "\t\t\t\t\t\"gender\": \"f\",\n" +
            "\t\t\t\t\t\"mbtype\": 12,\n" +
            "\t\t\t\t\t\"urank\": 47,\n" +
            "\t\t\t\t\t\"mbrank\": 7,\n" +
            "\t\t\t\t\t\"follow_me\": false,\n" +
            "\t\t\t\t\t\"following\": true,\n" +
            "\t\t\t\t\t\"followers_count\": 1998254,\n" +
            "\t\t\t\t\t\"follow_count\": 307,\n" +
            "\t\t\t\t\t\"cover_image_phone\": \"https:\\/\\/tva3.sinaimg.cn\\/crop.0.0.0.0\\/db1941cbjw1enppihknfcj20hs0hqmz1.jpg\",\n" +
            "\t\t\t\t\t\"avatar_hd\": \"https:\\/\\/wx4.sinaimg.cn\\/orj480\\/db1941cbly8frmsvyenboj20yi0yi0uu.jpg\",\n" +
            "\t\t\t\t\t\"like\": false,\n" +
            "\t\t\t\t\t\"like_me\": false,\n" +
            "\t\t\t\t\t\"badge\": {\n" +
            "\t\t\t\t\t\t\"bind_taobao\": 1,\n" +
            "\t\t\t\t\t\t\"dzwbqlx_2016\": 1,\n" +
            "\t\t\t\t\t\t\"follow_whitelist_video\": 1,\n" +
            "\t\t\t\t\t\t\"user_name_certificate\": 1,\n" +
            "\t\t\t\t\t\t\"wenchuan_10th\": 1,\n" +
            "\t\t\t\t\t\t\"qixi_2018\": 1,\n" +
            "\t\t\t\t\t\t\"memorial_2018\": 1\n" +
            "\t\t\t\t\t}\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t\"picStatus\": \"0:1\",\n" +
            "\t\t\t\t\"reposts_count\": 3060,\n" +
            "\t\t\t\t\"comments_count\": 334,\n" +
            "\t\t\t\t\"attitudes_count\": 4986,\n" +
            "\t\t\t\t\"pending_approval_count\": 0,\n" +
            "\t\t\t\t\"isLongText\": false,\n" +
            "\t\t\t\t\"reward_exhibition_type\": 0,\n" +
            "\t\t\t\t\"hide_flag\": 0,\n" +
            "\t\t\t\t\"visible\": {\n" +
            "\t\t\t\t\t\"type\": 0,\n" +
            "\t\t\t\t\t\"list_id\": 0\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t\"mblogtype\": 0,\n" +
            "\t\t\t\t\"more_info_type\": 0,\n" +
            "\t\t\t\t\"cardid\": \"vip_001\",\n" +
            "\t\t\t\t\"extern_safe\": 0,\n" +
            "\t\t\t\t\"number_display_strategy\": {\n" +
            "\t\t\t\t\t\"apply_scenario_flag\": 3,\n" +
            "\t\t\t\t\t\"display_text_min_number\": 1000000,\n" +
            "\t\t\t\t\t\"display_text\": \"100\\u4e07+\"\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t\"content_auth\": 0,\n" +
            "\t\t\t\t\"hide_hot_flow\": 1,\n" +
            "\t\t\t\t\"edit_config\": {\n" +
            "\t\t\t\t\t\"edited\": false\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t\"weibo_position\": 1,\n" +
            "\t\t\t\t\"show_attitude_bar\": 0,\n" +
            "\t\t\t\t\"bid\": \"Hr0mwbNT0\",\n" +
            "\t\t\t\t\"pics\": [{\n" +
            "\t\t\t\t\t\"pid\": \"db1941cbgy1g2cx730z0ej20u00u0jvb\",\n" +
            "\t\t\t\t\t\"url\": \"https:\\/\\/wx2.sinaimg.cn\\/orj360\\/db1941cbgy1g2cx730z0ej20u00u0jvb.jpg\",\n" +
            "\t\t\t\t\t\"size\": \"orj360\",\n" +
            "\t\t\t\t\t\"geo\": {\n" +
            "\t\t\t\t\t\t\"width\": 360,\n" +
            "\t\t\t\t\t\t\"height\": 360,\n" +
            "\t\t\t\t\t\t\"croped\": false\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t\"large\": {\n" +
            "\t\t\t\t\t\t\"size\": \"large\",\n" +
            "\t\t\t\t\t\t\"url\": \"https:\\/\\/wx2.sinaimg.cn\\/large\\/db1941cbgy1g2cx730z0ej20u00u0jvb.jpg\",\n" +
            "\t\t\t\t\t\t\"geo\": {\n" +
            "\t\t\t\t\t\t\t\"width\": \"1080\",\n" +
            "\t\t\t\t\t\t\t\"height\": \"1080\",\n" +
            "\t\t\t\t\t\t\t\"croped\": false\n" +
            "\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t}\n" +
            "\t\t\t\t}]\n" +
            "\t\t\t},\n" +
            "\t\t\t\"show_type\": 0\n" +
            "\t\t}";

}
