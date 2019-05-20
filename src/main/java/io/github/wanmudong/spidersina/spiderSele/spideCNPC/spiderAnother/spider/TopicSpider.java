package io.github.wanmudong.spidersina.spiderSele.spideCNPC.spiderAnother.spider;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.github.wanmudong.dataBase.MongoDBUtil;
import io.github.wanmudong.test.RexText;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static io.github.wanmudong.spidersina.spiderSele.constant.LinkConstant.*;

/**
 * @author ：wanmudong
 * @date ：Created in 2019/5/20 13:59
 * @description：话题爬虫
 * @modified By：
 * @version: $
 */
public class TopicSpider {
    WebDriver driver;

    String weiboId;

    String uid;

    int page;


    private final static Logger log = LoggerFactory.getLogger(WeiBoSpider.class);

    public TopicSpider(WebDriver driver,String weiboId,String uid,int page){
        this.driver = driver;
        this.weiboId = weiboId;
        this.page = page;
        this.uid = uid;
    }

    public int start() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,10,1);


        while (true) {

            String hot = WEIBO_TOPIC_WUYIFAN_DAWANKUANMIAN_INDEX +page;

            driver.get(hot);

            try {
                wait.until((ExpectedCondition<WebElement>)
                        text -> text.findElement(By.tagName("pre")));
            }catch (Exception e){
                return page;
            }

            String pre = driver.findElement(By.tagName("pre")).getText();
            JSONObject jsonObject = JSONObject.parseObject(pre);

            List<org.bson.Document> listDoc = new ArrayList<>();
            /**
             * 爬取内容 ：微博id，微博主体，发博时间，发博来源，点赞，评论，转发数，用户个人信息（主页，昵称，简介，性别，关注数，粉丝数，微博数，认证情况）
             */
            JSONArray weiboCards =  jsonObject.getJSONObject("data").getJSONArray("cards");
            if (weiboCards.size() > 0) {
                for (int i = 0; i < weiboCards.size(); i++) {

                    JSONArray weiboArray =weiboCards.getJSONObject(i).getJSONArray("card_group");

                    if (weiboArray.size() > 0) {
                        for (int j = 0; j < weiboArray.size(); j++) {
                            // 遍历 jsonarray 数组，把每一个对象转成 json 对象
                            JSONObject weibo = weiboArray.getJSONObject(j).getJSONObject("mblog");

                            org.bson.Document document = new org.bson.Document();

                            document.append("id",weibo.getString("id"));
                            document.append("text", weibo.getString("text"));
                            document.append("row_text", RexText.Html2Text(weibo.getString("text")));
                            document.append("created_at",weibo.getString("created_at"));
                            document.append("source",weibo.getString("source"));
                            document.append("attitudes_count",weibo.getString("attitudes_count"));
                            document.append("comments_count",weibo.getString("comments_count"));
                            document.append("reposts_count",weibo.getString("reposts_count"));
                            document.append("user",weibo.getJSONObject("user"));

                            listDoc.add(document);

                        }
                    }
                }

            }

            MongoDBUtil.insertListDocument(listDoc,"wuyifan_dawankuanmian_topic_pc_cn");

            log.info("插入第"+page+"页的话题微博数据");

            page++;
        }

//        }

    }


}
