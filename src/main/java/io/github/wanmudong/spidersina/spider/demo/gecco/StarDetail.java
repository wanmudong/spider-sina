package io.github.wanmudong.spidersina.spider.demo.gecco;

import com.geccocrawler.gecco.annotation.Html;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.spider.HtmlBean;
import lombok.Data;

/**
 * @author ：wanmudong
 * @date ：Created in 2019/5/17 10:18
 * @description：
 * @modified By：
 * @version: $
 */
@Data
public class StarDetail implements HtmlBean {

    /*//明星的照片
    @Image("src")
    @HtmlField(cssPath = "a > img")
    prie String PhotoString;*/

    //明星的名字
    @Html
    @HtmlField(cssPath ="div > div > h4")
    private String  starNameHtml;

    //明星的性别
    @Text
    @HtmlField(cssPath = "div > p:nth-child(2)")
    private  String starSex;

    //明星的职业
    @Html
    @HtmlField(cssPath = "div > p:nth-child(3)")
    private String professionHtml;

    //明星的国籍
    @Text
    @HtmlField(cssPath = " div > p:nth-child(4)")
    private String  nationality;

    //明星的出生日期
    @Text
    @HtmlField(cssPath = "div > p.special")
    private String birthday;

    //明星的星座
    @Text
    @HtmlField(cssPath = "div > p:nth-child(6)>a")
    private String constellation;

    //明星的身高
    @Text
    @HtmlField(cssPath = "div > p:nth-child(7)")
    private String height;


}

