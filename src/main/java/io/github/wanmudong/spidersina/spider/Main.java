package io.github.wanmudong.spidersina.spider;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.request.HttpGetRequest;

/**
 * @author ：wanmudong
 * @date ：Created in 2019/5/17 9:48
 * @description：爬虫主入口
 * @modified By：
 * @version: $
 */
public class Main {
    public static void main(String[] args) {
        String url = "https://weibo.com/u/3675865547"; //想要爬取的网站的首页地址
        HttpGetRequest start = new HttpGetRequest(url); //获取网站请求
        start.setCharset("GBK");
        GeccoEngine.create() //创建搜索引擎
                .classpath("io.github.wanmudong.spidersina.spider.gecco") //要搜索的包名，会自动搜索该包下，含@Gecco注解的文件。
                .start(start)
                .thread(1)//开启多少个线程抓取
                .interval(2000) //隔多长时间抓取1次
                .run();
    }
}
