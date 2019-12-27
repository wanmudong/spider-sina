package io.github.wanmudong.spidersina.spiderSele.spider;

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

/**
 * @author ：wanmudong
 * @date ：Created in 2019/5/18 13:11
 * @description：评论爬虫
 */
public class CommentSpider {
    WebDriver driver;

    String max_id;

    String weiboId;

    private final static Logger log = LoggerFactory.getLogger(WeiBoSpider.class);

    public CommentSpider(WebDriver driver,String max_id,String weiboId){
        this.driver = driver;
        this.max_id = max_id;
        this.weiboId = weiboId;
    }

    public boolean start() throws InterruptedException {
        List<JSONObject> list = MongoDBUtil.selectJsonFromMongoDB(null, "weibo");
        WebDriverWait wait = new WebDriverWait(driver,10,1);


            while (true) {
                Thread.sleep(410);

                String hotflow = WEIBO_COMMENT + "&id=" + weiboId + "&mid=" + weiboId + "&max_id=" + max_id;

                driver.get(hotflow);
                try {
                    wait.until((ExpectedCondition<WebElement>)
                            text -> text.findElement(By.tagName("pre")));
                }catch (Exception e){
                    return false;
                }
                String pre = driver.findElement(By.tagName("pre")).getText();
                JSONObject jsonObject = JSONObject.parseObject(pre);

                //如果出现ok=0 则出错
                int ok = jsonObject.getInteger("ok");
                if (0==ok){
                    break;
                }

                JSONArray commentArray = jsonObject.getJSONObject("data").getJSONArray("data");

                if (commentArray.size() > 0) {
                    for (int i = 0; i < commentArray.size(); i++) {
                        // 遍历 jsonarray 数组，把每一个对象转成 json 对象
                        JSONObject comment = commentArray.getJSONObject(i);

                        MongoDBUtil.insertJsonToMongoDB(comment.toJSONString(), "comment");
                        if ("4357505548975485".equals(comment.getString("id"))){
                            System.out.println("奇怪了");
                        }

                        log.info("插入一条评论数据，此评论id为：" + comment.getString("id")+"--他属于微博："+weiboId);
                    }

                }
                max_id = jsonObject.getJSONObject("data").getString("max_id");

                if ("0".equals(max_id)) {
                    return true;
//                    break;
                }
            }

//        }
        return false;
    }


}
