package io.github.wanmudong.spidersina.spiderHtmlSpider.spider;

import jdk.jfr.events.ExceptionThrownEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author ：wanmudong
 * @date ：Created in 2019/5/19 11:44
 * @description：
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
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
        String [] nameArr = {"13215518510"
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
        String [] passwordArr = {"liukejiang"
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
        String [] userAgentArr={"--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.157 Safari/537.36"
                ,"--user-agent=Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/%s Mobile Safari/537.36"
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

        WebDriver[] webDrivers = new WebDriver[11];

        int i=0;

        //先登录获取cookie
        //调用chrome driver
        System.setProperty("webdriver.chrome.driver", "C:/Program Files (x86)/Google/Chrome/Application/chromedriver.exe");

        //声明chromeoptions,主要是给chrome设置参数
        ChromeOptions options = new ChromeOptions();

        //窗口默认就是最大化
        options.addArguments("--start-maximized");
        //设置user agent为手机端
        options.addArguments(userAgentArr[i]);
        //调用chrome
        webDrivers[i] = new ChromeDriver(options);
        WebDriver driver = webDrivers[i];
        //先登录
        ((ChromeDriver) driver).get("https://weibo.com/login.php");
        Thread.sleep(2000);
        //显式等待， 针对某个元素等待
        //没用，还是直接睡一觉
        WebDriverWait wait = new WebDriverWait(driver,10,1);
        wait.until((ExpectedCondition<WebElement>)
                text -> text.findElement(By.xpath("//*[@id=\"pl_login_form\"]/div/div[3]/div[6]/a")));

//        WebElement loginClick = driver.findElement(By.xpath("//*[@id=\"weibo_top_public\"]/div/div/div[3]/div[2]/ul/li[3]/a"));



//        loginClick.click();

        Thread.sleep(2000);

        WebElement loginName = driver.findElement(By.id("loginname"));
        WebElement loginPassword = driver.findElement(By.name("password"));
        WebElement loginAction = driver.findElement(By.xpath("//*[@id=\"pl_login_form\"]/div/div[3]/div[6]/a"));

        loginName.click();
        loginName.sendKeys(nameArr[i]);
        Thread.sleep(1000);
        loginPassword.click();
        loginPassword.sendKeys(passwordArr[i]);
        Thread.sleep(1000);
        loginAction.click();

//        //访问所希望爬取的用户首页
//        String linsiyi = "3675865547";
//        String orginUrl = "https://m.weibo.com/u/";
//        String url = orginUrl+linsiyi;
        String commentUrl = "https://weibo.com/3675865547/HrVmp5ma1?filter=hot&root_comment_id=0&type=comment";

        ((ChromeDriver) driver).get(commentUrl);
        Thread.sleep(4000);
        //如果进去没有加载出来
        try {
            wait.until((ExpectedCondition<WebElement>)
                    text -> text.findElement(By.className("WB_text")));
        }catch (Exception e){
            //刷新页面
            ((ChromeDriver) driver).get(commentUrl);
        }



        ((ChromeDriver) driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
        Thread.sleep(1000);
        ((ChromeDriver) driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
        Thread.sleep(1000);
        ((ChromeDriver) driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
        Thread.sleep(1000);
        ((ChromeDriver) driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
        Thread.sleep(1000);

        WebElement more_txt;
        while (true) {
            ((ChromeDriver) driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
            Thread.sleep(1000);
            //当加载完了之后就没有该元素了
            try {
                more_txt = ((ChromeDriver) driver).findElementByClassName("more_txt");
            }catch (Exception e){
                break;
            }

            //有时候反应慢了
            try {
                more_txt.click();
            }catch (Exception e){
                continue;
            }


        }


        Thread.sleep(3000);
    }
}
