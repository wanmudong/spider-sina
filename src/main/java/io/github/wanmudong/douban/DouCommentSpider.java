package io.github.wanmudong.douban;

import io.github.wanmudong.dataBase.MongoDBUtil;
import io.github.wanmudong.spidersina.spiderSele.spideCNPC.spiderAnother.spider.WeiBoSpider;
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

import static io.github.wanmudong.spidersina.spiderSele.constant.LinkConstant.WEIBO_COMMENT_ANOTHER_PC_CN;

/**
 * @author ：wanmudong
 * @date ：Created in 2019/12/27 23:07
 * @description:
 */
public class DouCommentSpider {

        WebDriver driver;

        String commentId;
        String collectionName;

        int start;
        int max;



        private final static Logger log = LoggerFactory.getLogger(WeiBoSpider.class);



        public DouCommentSpider(WebDriver driver,String commentId,int start,int max,String collectionName){
            this.driver = driver;
            this.commentId = commentId;
            this.start = start;
            this.max = max;
            this.collectionName = collectionName;
        }

        public int start() throws InterruptedException {
            WebDriverWait wait = new WebDriverWait(driver,10,1);


            while (true) {


                //上海堡垒url https://movie.douban.com/subject/26581837/comments?start=0&limit=20&sort=new_score&status=P
                String commentUrl = " https://movie.douban.com/subject/"+commentId+"/comments?start="+start+"&limit=20&sort=new_score&status=P";

                driver.get(commentUrl);
                //如果没有分页，要么太频繁，要么查完了
                try {
                    wait.until((ExpectedCondition<WebElement>)
                            text -> text.findElement(By.id("paginator")));
                }catch (Exception e){
                    Thread.sleep(1000);

                    return start;

                }
                String pageSource = driver.getPageSource();

                Document doc = Jsoup.parse(pageSource);

                Elements elements = doc.getElementsByClass("comment");

                List<org.bson.Document> listDoc = new ArrayList<>();
                for (Element element:elements){
                    org.bson.Document document = new org.bson.Document();

                    Elements rating = element.getElementsByClass("rating");
                    document.append("rating",rating.attr("title"));

                    Elements time = element.getElementsByClass("comment-time");
                    document.append("time",time.html().trim());

                    Elements comment = element.getElementsByClass("short");
                    document.append("comment",comment.html());

                    listDoc.add(document);
                }

                MongoDBUtil.insertListDocument(listDoc,collectionName);

                log.info("插入第"+(start/20+1)+"页的评论数据");
                if (start > max){
                   return start;
                }
                start = start+20;
            }



        }



}
