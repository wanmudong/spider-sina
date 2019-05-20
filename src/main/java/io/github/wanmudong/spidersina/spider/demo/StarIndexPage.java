package io.github.wanmudong.spidersina.spider.demo;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.request.HttpGetRequest;

/**
 * @author ：wanmudong
 * @date ：Created in 2019/5/17 10:17
 * @description：
 * @modified By：
 * @version: $
 */
public class StarIndexPage{
    public static void main(String[] args) {
        String url = "http://ent.sina.com.cn/ku/star_search_index.d.html?page=1"; //想要爬取的网站的首页地址
        HttpGetRequest start = new HttpGetRequest(url); //获取网站请求
        start.setCharset("UTF-8");
        GeccoEngine.create() //创建搜索引擎
                .classpath("io.github.wanmudong.spidersina.spider.demo.gecco") //要搜索的包名，会自动搜索该包下，含@Gecco注解的文件。
                .start(start)
                .thread(5)//开启多少个线程抓取
                .interval(2000) //隔多长时间抓取1次
                .run();
    }
}