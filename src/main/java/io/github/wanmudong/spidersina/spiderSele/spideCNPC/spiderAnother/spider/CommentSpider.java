package io.github.wanmudong.spidersina.spiderSele.spideCNPC.spiderAnother.spider;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.github.wanmudong.dataBase.MongoDBUtil;
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

import static io.github.wanmudong.spidersina.spiderSele.constant.LinkConstant.WEIBO_COMMENT_ANOTHER;
import static io.github.wanmudong.spidersina.spiderSele.constant.LinkConstant.WEIBO_COMMENT_ANOTHER_PC_CN;

/**
 * @author ：wanmudong
 * @date ：Created in 2019/5/18 13:11
 * @description：评论爬虫
 */
public class CommentSpider {
    WebDriver driver;

    String weiboId;

    String uid;

    int page;


    private final static Logger log = LoggerFactory.getLogger(WeiBoSpider.class);

    public CommentSpider(WebDriver driver,String weiboId,String uid,int page){
        this.driver = driver;
        this.weiboId = weiboId;
        this.page = page;
        this.uid = uid;
    }

    public int start() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,10,1);


            while (true) {

                String hot = WEIBO_COMMENT_ANOTHER_PC_CN + "/" + weiboId +"?uid="+uid+"&page="+page;

                driver.get(hot);
                //如果没有分页，要么太频繁，要么查完了
                try {
                    wait.until((ExpectedCondition<WebElement>)
                            text -> text.findElement(By.id("pagelist")));
                }catch (Exception e){
                    Thread.sleep(1000);

                    return page;

                }
                String pageSource = driver.getPageSource();

                Document doc = Jsoup.parse(pageSource);

                Elements elements = doc.select("[id^=C_]");

                List<org.bson.Document> listDoc = new ArrayList<>();
                for (Element element:elements){
                    org.bson.Document document = new org.bson.Document();

                    Element user = element.select("[href^=/]").first();

                    document.append("user_name",user.text());
                    document.append("user_info",user.attr("href"));

                    Elements text = element.select(".ctt");

                    document.append("comment_text",text.html());

                    Elements time = element.select(".ct");

                    document.append("comment_time",time.text());


                    document.append("comment_id",element.attr("id").substring(2));

                    document.append("weibo_id",weiboId);

                    listDoc.add(document);
                }

                MongoDBUtil.insertListDocument(listDoc,"cxk_comment_pc_cn");

                log.info("插入第"+page+"页的评论数据");

                page++;
            }

//        }

    }


}
