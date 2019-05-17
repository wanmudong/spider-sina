package io.github.wanmudong.spidersina.spider.demo2.gecco;

/**
 * @author ：wanmudong
 * @date ：Created in 2019/5/17 10:36
 * @description：
 * @modified By：
 * @version: $
 */
import com.geccocrawler.gecco.annotation.*;
import com.geccocrawler.gecco.spider.HtmlBean;

@Gecco(matchUrl="http://news.iresearch.cn/content/{yeary}/{month}/{code}.shtml", pipelines={"consolePipeline", "productDetailPipeline"})
public class ProductDetail implements HtmlBean {

    private static final long serialVersionUID = -377053120283382723L;

    /**
     * 文本内容
     */
//    @Text
    @HtmlField(cssPath="body > div.g-content > div.g-bd.f-mt-auto > div > div.g-mn > div > div.g-article > div.m-article")
    private String content;

    @RequestParameter
    private String code;

    @RequestParameter
    private String year;

    @RequestParameter
    private String month;

    /**
     * 标题
     */
    @Text
    @HtmlField(cssPath="body > div.g-content > div.g-main.f-mt-auto > div > div > div.title > h1")
    private String title;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }
}
