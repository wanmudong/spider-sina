package io.github.wanmudong.spidersina.spiderSele;

import com.alibaba.fastjson.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ：wanmudong
 * @date ：Created in 2019/5/17 14:11
 * @description：
 * 登录用浏览器模拟
 * 其余操作在浏览器里请求json
 *
 *
 */
public class CookieMain {
    //微博存在后门，即微博移动端不受PC端游客访问的限制
    //先获取cookie再进行访问

    private final static Logger log = LoggerFactory.getLogger(CookieMain.class);



    public static void main(String[] args) throws InterruptedException {
        //先登录获取cookie
        //调用chrome driver
        System.setProperty("webdriver.chrome.driver", "C:/Program Files (x86)/Google/Chrome/Application/chromedriver.exe");
        //声明chromeoptions,主要是给chrome设置参数
        ChromeOptions options = new ChromeOptions();
        //设置user agent为手机端
        options.addArguments("--user-agent=Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/%s Mobile Safari/537.36");
        //调用chrome
        WebDriver driver = new ChromeDriver(options);

        //调整高度
        ((ChromeDriver) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");

        //先登录
        ((ChromeDriver) driver).get("https://passport.weibo.cn/signin/login?entry=mweibo&res=wel&wm=3349&r=https%3A%2F%2Fm.weibo.cn%2F");

        //显式等待， 针对某个元素等待
        //没用，还是直接睡一觉
        WebDriverWait wait = new WebDriverWait(driver,10,1);

        wait.until((ExpectedCondition<WebElement>)
                text -> text.findElement(By.id("loginAction")));

        Thread.sleep(5000);

        WebElement loginName = driver.findElement(By.id("loginName"));
        WebElement loginPassword = driver.findElement(By.id("loginPassword"));
        WebElement loginAction = driver.findElement(By.id("loginAction"));

        loginName.sendKeys("13215518510");
        loginPassword.sendKeys("liukejiang");
        loginAction.click();



//        Set<Cookie> cookies = driver.manage().getCookies();
//        System.out.println("cookie:"+cookies);
//        String statement = "io.github.wanmudong.mapping.userMapper.getUser";//映射sql的标识字符串
//        //执行查询返回一个唯一user对象的sql
//        SqlSession session = MybatisSession.getSession();
//        Cookies cookies = session.selectOne(statement, "13215518510");
        //访问所希望爬取的用户首页
        String linsiyi = "3675865547";
        String orginUrl = "https://m.weibo.com/u/";
        String url = orginUrl+linsiyi;
        ((ChromeDriver) driver).get(url);

        Thread.sleep(5000);

        //循环爬取用户所有微博
        int page = 0;
        int ok = 1;
//        while(true){
//
//            String indexUrl = "https://m.weibo.cn/api/container/getIndex?jumpfrom=weibocom&type=uid&value="+linsiyi+"&containerid=1076033675865547";
//            String getIndexUrl = indexUrl+"&page="+page;
//            driver.get(getIndexUrl);
//            String pageSource = driver.getPageSource();
//            pageSource = driver.findElement(By.tagName("pre")).getText();
//            JSONObject jsonObject = JSONObject.parseObject(pageSource);
//
//            ok = jsonObject.getInteger("ok");
//            //当后面无数据时
//            log.info("ok="+ok);
//            if (ok == 0) {
//                break;
//            }
//
//            //业务逻辑   主要是保存数据
//            //dosomething
//            log.info("爬完了一批微博，这批微博url为："+getIndexUrl);
//
//
//            page++;
//            Thread.sleep(1000);
//        }

        log.info("微博已经爬完啦，准备开始爬评论啦！");
//        driver.get("https://m.weibo.cn/detail/"+linsiyi+"#comment");

        //循环爬取所有微博的所有评论
//        String weiboId = "4372575549518375";
//        String weiboMaxId = "0";
//        while(true){
//            //获取api信息
//            String hotFlow = "https://m.weibo.cn/comments/hotflow?id="+weiboId+"&mid="+weiboId+"&max_id_type=0";
//            String getHotFlow = hotFlow+"&max_id="+weiboMaxId;
//            driver.get(getHotFlow);
//            wait.until((ExpectedCondition<WebElement>)
//                    text -> text.findElement(By.tagName("pre")));
//            //由于无法直接获取响应数据，只能解析dom
//            String pageSource = driver.getPageSource();
//            Document parse = Jsoup.parse(pageSource);
//            Elements select = parse.select("body > pre");
//            JSONObject jsonObject = JSONObject.parseObject(select.text());
//
             //这是一个循环爬取的过程，当weiboMaxId=0时，证明以及进入下个循环
//            weiboMaxId = jsonObject.getJSONObject("data").getString("max_id");
//            //当后面无数据时
//            if ("0".equals(weiboMaxId)) {
//                break;
//            }
//
//            //业务逻辑   主要是保存数据
//            //dosomething
//            log.info("爬完了一批评论，这批评论是属于id为："+weiboId+"的微博，这批评论的url为："+getHotFlow);
//
//
//
//        }

        log.info("评论已经爬完啦，准备开始爬跟评啦！");

//        //爬取所有评论的跟评
//        String commentId = "4368392435227058";
//        String commentMaxId = "0";
//        while(true){
//
//            //获取api信息
//            String hotFlowChild = " https://m.weibo.cn/comments/hotFlowChild?cid="+commentId+"&max_id_type=0";
//            String getHotFlowChild = hotFlowChild+"&max_id="+commentMaxId;
//            driver.get(getHotFlowChild);
//            String pageSource = driver.getPageSource();
//            wait.until((ExpectedCondition<WebElement>)
//                    text -> text.findElement(By.tagName("pre")));
//            pageSource = driver.findElement(By.tagName("pre")).getText();
//            JSONObject jsonObject = JSONObject.parseObject(pageSource);
//
//            //这是一个循环爬取的过程，当weiboMaxId=0时，证明以及进入下个循环
//            commentMaxId = jsonObject.getString("max_id");
//            //当后面无数据时
//            if ("0".equals(commentMaxId)) {
//                break;
//            }
//
//            //业务逻辑   主要是保存数据
//            //dosomething
//            log.info("爬完了一批跟评，这批跟评是属于id为："+commentId+"的评论，这跟评论的url为："+getHotFlowChild);
//
//
//        }

        log.info("跟评已经爬完啦！");

        //循环爬取所有微博的所有点赞
        String weiboId = "4372575549518375";
        page=1;
        while(true){
            //获取api信息
            String show = "https://m.weibo.cn/api/attitudes/show?id="+weiboId;
            String getShow = show+"&page="+page;
            driver.get(getShow);
            wait.until((ExpectedCondition<WebElement>)
                    text -> text.findElement(By.tagName("pre")));
            Thread.sleep(400);
            //由于无法直接获取响应数据，只能解析dom
            String pageSource = driver.getPageSource();
            Document parse = Jsoup.parse(pageSource);
            Elements select = parse.select("body > pre");
            JSONObject jsonObject = JSONObject.parseObject(select.text());

             ok = jsonObject.getInteger("ok");
            //当后面无数据时
            log.info("ok="+ok);
            if (ok == 0) {
                break;
            }

            //业务逻辑   主要是保存数据
            //dosomething
            log.info("爬完了一批点赞，这批点赞是属于id为："+weiboId+"的微博，这批点赞的url为："+getShow);


            page++;
        }


    }
}
