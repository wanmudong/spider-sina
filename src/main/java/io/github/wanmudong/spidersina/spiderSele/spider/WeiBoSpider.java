package io.github.wanmudong.spidersina.spiderSele.spider;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.github.wanmudong.dataBase.MongoDBUtil;
import lombok.Data;
import org.bson.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static io.github.wanmudong.spidersina.spiderSele.constant.LinkConstant.WEIBO_INDEX;
import static io.github.wanmudong.spidersina.spiderSele.constant.LinkConstant.WEIBO_USER_INDEX;

/**
 * @author ：wanmudong
 * @date ：Created in 2019/5/18 13:11
 * @description：微博爬虫
 */
@Data
public class WeiBoSpider {
    WebDriver driver;

    private final static Logger log = LoggerFactory.getLogger(WeiBoSpider.class);

    public WeiBoSpider(WebDriver driver){
        this.driver = driver;
    }

    public void start(String id) throws InterruptedException {

        //明星会有明星id 也就是containid
        String startId = driver.getCurrentUrl().replace("https://m.weibo.cn/p/","");
        String containerid = startId;
        driver.get(WEIBO_USER_INDEX+containerid);

        WebDriverWait wait = new WebDriverWait(driver,10,1);

        wait.until((ExpectedCondition<WebElement>)
                text -> text.findElement(By.tagName("pre")));

        String pre = driver.findElement(By.tagName("pre")).getText();
        JSONObject jsonObject = JSONObject.parseObject(pre);
        containerid = jsonObject.getJSONObject("data").getJSONObject("tabsInfo")
                .getJSONArray("tabs").getJSONObject(1).getString("containerid");

        int page = 1;
        int ok = 1;
        while (true){
            Thread.sleep(410);

            String indexUrl = WEIBO_INDEX+id+"&containerid="+containerid+"&page="+page;

            driver.get(indexUrl);

            pre = driver.findElement(By.tagName("pre")).getText();
            jsonObject = JSONObject.parseObject(pre);

            ok = jsonObject.getInteger("ok");
            //当后面无数据时
            if (ok == 0) {
                break;
            }

            JSONArray weiboArray = jsonObject.getJSONObject("data").getJSONArray("cards");

            if(weiboArray.size()>0){
                for(int i=0;i<weiboArray.size();i++){
                    // 遍历 jsonarray 数组，把每一个对象转成 json 对象
                    JSONObject weibo = weiboArray.getJSONObject(i);

                    MongoDBUtil.insertJsonToMongoDB(weibo.toJSONString(),"weibo");

                    log.info("插入一条微博数据，此微博itemid为："+weibo.getString("itemid"));
                }

            }

            page++;
        }
    }
}
