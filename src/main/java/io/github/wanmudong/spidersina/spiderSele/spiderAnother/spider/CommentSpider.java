package io.github.wanmudong.spidersina.spiderSele.spiderAnother.spider;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.github.wanmudong.dataBase.MongoDBUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static io.github.wanmudong.spidersina.spiderSele.constant.LinkConstant.WEIBO_COMMENT;
import static io.github.wanmudong.spidersina.spiderSele.constant.LinkConstant.WEIBO_COMMENT_ANOTHER;

/**
 * @author ：wanmudong
 * @date ：Created in 2019/5/18 13:11
 * @description：评论爬虫
 */
public class CommentSpider {
    WebDriver driver;

    String weiboId;

    int page;


    private final static Logger log = LoggerFactory.getLogger(WeiBoSpider.class);

    public CommentSpider(WebDriver driver,String weiboId,int page){
        this.driver = driver;
        this.weiboId = weiboId;
        this.page = page;
    }

    public boolean start() throws InterruptedException {
        List<JSONObject> list = MongoDBUtil.selectJsonFromMongoDB(null, "weibo");
//        String weiboId;
        WebDriverWait wait = new WebDriverWait(driver,10,1);

//        for (JSONObject json:list){
//            //只有card_type==9的微博才有评论
//            String  card_type= json.getString("card_type");
//            if (!"9".equals(card_type)){
//                continue;
//            }
//            weiboId = json.getString("itemid").split("_")[2];

            while (true) {
                Thread.sleep(410);

                String hot = WEIBO_COMMENT_ANOTHER + "&id=" + weiboId +"&page="+page;

                driver.get(hot);
                try {
                    wait.until((ExpectedCondition<WebElement>)
                            text -> text.findElement(By.tagName("pre")));
                }catch (Exception e){
                    return false;
                }
                String pre = driver.findElement(By.tagName("pre")).getText();
                JSONObject jsonObject = JSONObject.parseObject(pre);

                //如果出现ok=0 则出错或者爬完
                int ok = jsonObject.getInteger("ok");
                if (0==ok){
                    return true;
                }

                //此时存在热点评论
                if (page == 1){
                    JSONArray commentHotArray = jsonObject.getJSONObject("data").getJSONArray("hot_data");

                    if (commentHotArray.size() > 0) {
                        for (int i = 0; i < commentHotArray.size(); i++) {
                            // 遍历 jsonarray 数组，把每一个对象转成 json 对象
                            JSONObject comment = commentHotArray.getJSONObject(i);

                            MongoDBUtil.insertJsonToMongoDB(comment.toJSONString(), "comment");

                            log.info("插入一条热点评论数据，此评论id为：" + comment.getString("id")+"--它属于微博："+weiboId);
                        }

                    }
                }

                JSONArray commentArray = jsonObject.getJSONObject("data").getJSONArray("data");

                if (commentArray.size() > 0) {
                    for (int i = 0; i < commentArray.size(); i++) {
                        // 遍历 jsonarray 数组，把每一个对象转成 json 对象
                        JSONObject comment = commentArray.getJSONObject(i);

                        MongoDBUtil.insertJsonToMongoDB(comment.toJSONString(), "comment");

                        log.info("插入一条评论数据，此评论id为：" + comment.getString("id")+"--它属于微博："+weiboId);
                    }

                }


                page++;
            }

//        }

    }


}
