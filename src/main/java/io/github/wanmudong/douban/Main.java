package io.github.wanmudong.douban;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.github.wanmudong.spidersina.spiderSele.spider.CommentSpider;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.json.Json;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.bind.SchemaOutputResolver;

/**
 * @author ：wanmudong
 * @date ：Created in 2019/12/27 23:01
 * @description:
 */
public class Main {
    /**
     * kzpzjrphqmjtld-ott@yahoo.com----Wdgfohon8
     * bbvwzurikyqfoi-dzyg@yahoo.com----Awfdiwsy7
     * sujiwgywiniveqb-odn@yahoo.com----LWipndygxol07
     * upvbajyijkoalmw-tnh@yahoo.com----Bepsijsm7
     * wvkwitrtzuga-wwm331@yahoo.com----Nmjjcmhmi7
     * jcfjrbgmazduiv-anr@yahoo.com----Qtatvktv8
     * tixbdzddsrthvdm-xix25@yahoo.com----Uxqaqpsso4
     * nkxymakonnwdyjk-kdmv6@yahoo.com----ETewzwawow88
     * jdkduticvtsieh-ckgv@yahoo.com----Ggpryrchn4
     */
    static String [] nameArr = {"13215518510"
            ,"eicdvwfigexg-er00658@yahoo.com"
            ,"kzpzjrphqmjtld-ott@yahoo.com"
            ,"bbvwzurikyqfoi-dzyg@yahoo.com"
            ,"sujiwgywiniveqb-odn@yahoo.com"
            ,"upvbajyijkoalmw-tnh@yahoo.com"
            ,"wvkwitrtzuga-wwm331@yahoo.com"
            ,"jcfjrbgmazduiv-anr@yahoo.com"
            ,"tixbdzddsrthvdm-xix25@yahoo.com"
            ,"nkxymakonnwdyjk-kdmv6@yahoo.com"
            ,"jdkduticvtsieh-ckgv@yahoo.com"
    };
    static String [] passwordArr = {"liukejiang"
            ,"Jjqakuktv1"
            ,"Wdgfohon8"
            ,"Awfdiwsy7"
            ,"LWipndygxol07"
            ,"Bepsijsm7"
            ,"Nmjjcmhmi7"
            ,"Qtatvktv8"
            ,"Uxqaqpsso4"
            ,"ETewzwawow88"
            ,"Ggpryrchn4"
    };
    static String [] userAgentArr={"--user-agent=Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/%s Mobile Safari/537.36"
            ,"--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.157 Safari/537.36"
            ,"--user-agent=Mozilla/5.0 (iPhone; CPU iPhone OS 11_0 like Mac OS X) AppleWebKit/604.1.38 (KHTML, like Gecko) Version/11.0 Mobile/15A372 Safari/604.1"
            ,"--user-agent=Mozilla/5.0 (Linux; Android 5.0; SM-G900P Build/LRX21T) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.157 Mobile Safari/537.36"
            ,"--user-agent=Mozilla/5.0 (Linux; Android 8.0; Pixel 2 Build/OPD3.170816.012) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.157 Mobile Safari/537.36"
            ,"--user-agent=Mozilla/5.0 (Linux; Android 8.0.0; Pixel 2 XL Build/OPD1.170816.004) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.157 Mobile Safari/537.36"
            ,"--user-agent=Mozilla/5.0 (iPhone; CPU iPhone OS 10_3_1 like Mac OS X) AppleWebKit/603.1.30 (KHTML, like Gecko) Version/10.0 Mobile/14E304 Safari/602.1"
            ,"--user-agent=Mozilla/5.0 (iPad; CPU OS 11_0 like Mac OS X) AppleWebKit/604.1.34 (KHTML, like Gecko) Version/11.0 Mobile/15A5341f Safari/604.1"
            ,"--user-agent=Mozilla/5.0 (Windows Phone 10.0; Android 4.2.1; Microsoft; Lumia 550) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2486.0 Mobile Safari/537.36 Edge/14.14263"
            ,"--user-agent=Mozilla/5.0 (Linux; U; Android 4.0; en-us; GT-I9300 Build/IMM76D) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30"
            ,"--user-agent=Mozilla/5.0 (Linux; U; Android 4.4.2; en-us; LGMS323 Build/KOT49I.MS32310c) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/74.0.3729.157 Mobile Safari/537.36"
    };
    public static void main(String[] args) throws InterruptedException {
        WebDriver[] webDrivers = new WebDriver[11];

        //先登录获取cookie
        //调用chrome driver
        System.setProperty("webdriver.chrome.driver", "C:/Program Files (x86)/Google/Chrome/Application/chromedriver.exe");
        String max_id="0";

        for (int i = 0; i < 1; i++) {
            //声明chromeoptions,主要是给chrome设置参数
            ChromeOptions options = new ChromeOptions();

            //设置user agent为手机端
            options.addArguments("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.88 Safari/537.36");
            //调用chrome
            webDrivers[i] = new ChromeDriver(options);
            WebDriver driver = webDrivers[i];
//            String coo = "{\"douban-fav-remind\": \"1\", \" gr_user_id\": \"97d950fe-ac94-4f38-857d-2590f10ac988\", \" _vwo_uuid_v2\": \"D6DA5B84BFBE095046AEB564838C1F5ED|c5f7ea041b94e09bce1f19f472c1cc93\", \" bid\": \"JJF_-eBI9ow\", \" viewed\": \"\\\"1233434_26707463_26772632\\\"\", \" ap_v\": \"0,6.0\", \" _pk_ref.100001.4cf6\": \"%5B%22%22%2C%22%22%2C1577457630%2C%22https%3A%2F%2Flink.zhihu.com%2F%3Ftarget%3Dhttps%253A%2F%2Fmovie.douban.com%2Fsubject%2F26581837%2Fcomments%253Fstatus%253DP%22%5D\", \" _pk_ses.100001.4cf6\": \"*\", \" __utma\": \"223695111.1386891555.1577457630.1577457630.1577457630.1\", \" __utmb\": \"223695111.0.10.1577457630\", \" __utmc\": \"223695111\", \" __utmz\": \"223695111.1577457630.1.1.utmcsr=link.zhihu.com|utmccn=(referral)|utmcmd=referral|utmcct=/\", \" dbcl2\": \"\\\"168259890:FqsEqz8m4SY\\\"\", \" ck\": \"WY5o\", \" _pk_id.100001.4cf6\": \"e6892af8409520f1.1577457630.1.1577457665.1577457630.\", \" push_noty_num\": \"0\", \" push_doumail_num\": \"0\"}\n";
//            JSONObject jsonObject = JSON.parseObject(coo);
//
//            Cookie cookie = new Cookie();
//
//            driver.manage().addCookie();
            //先登录
            ((ChromeDriver) driver).get("https://accounts.douban.com/passport/login");

            //显式等待， 针对某个元素等待
            //没用，还是直接睡一觉
            WebDriverWait wait = new WebDriverWait(driver,10,1);
//            wait.until((ExpectedCondition<WebElement>)
//                    text -> text.findElement(By.className("short")));

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            WebElement login = ((ChromeDriver) driver).findElementByCssSelector("#account > div.login-wrap > div.login-right > div > div.account-body-tabs > ul.tab-start > li.account-tab-account");
            login.click();
            Thread.sleep(500);
            WebElement loginName = driver.findElement(By.id("username"));
            WebElement loginPassword = driver.findElement(By.id("password"));
            WebElement loginAction = driver.findElement(By.className("account-form-field-submit"));

            loginName.sendKeys("15855152923");
            loginPassword.sendKeys("leiheng.1.1");
            loginAction.click();


            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Thread.sleep(3000);

        }




//
//        while (true) {
//            boolean success = false;
            try {
                DouCommentSpider commentSpider = new DouCommentSpider(webDrivers[0],"26581837",0,10000,"douban_comment_shanghaibaolei");
                commentSpider.start();
            }catch (Exception e){
                System.out.println("爬完了上海堡垒");
                e.printStackTrace();
            }
            try {
                DouCommentSpider commentSpider = new DouCommentSpider(webDrivers[0],"26266893",0,10000,"douban_comment_liulangdiqiu");
                commentSpider.start();
            }catch (Exception e){
                System.out.println("爬完了流浪地球");
                e.printStackTrace();
            }
//            if (success){
//                break;
//            }
//
//        }
    }

}
