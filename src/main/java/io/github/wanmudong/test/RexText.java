package io.github.wanmudong.test;

import org.junit.Test;

import java.util.regex.Pattern;

/**
 * @author ：wanmudong
 * @date ：Created in 2019/5/20 15:21
 * @description：
 * @modified By：
 * @version: $
 */
public class RexText {
    public static void main(String[] args) {
        String s = "<a href=\"https://m.weibo.cn/p/index?containerid=1008084859662b1e491eaefde4d08a0d9cc82a&extparam=%E5%90%B4%E4%BA%A6%E5%87%A1&luicode=10000011&lfid=231522type%3D1%26t%3D10%26q%3D%23%E5%90%B4%E4%BA%A6%E5%87%A1%E5%A4%A7%E7%A2%97%E5%AE%BD%E9%9D%A2%23\" data-hide=\"\">" +
                "<span class='url-icon'><img style='width: 1rem;height: 1rem' src='http://n.sinaimg.cn/photo/5213b46e/20181127/timeline_card_small_super_default.png'>" +
                "</span>" +
                "<span class=\"surl-text\">" +
                "吴亦凡" +
                "</span>" +
                "</a> " +
                "<a href=\"https://m.weibo.cn/search?containerid=231522type%3D1%26t%3D10%26q%3D%23%E5%90%B4%E4%BA%A6%E5%87%A1%E5%A4%A7%E7%A2%97%E5%AE%BD%E9%9D%A2%23&extparam=%23%E5%90%B4%E4%BA%A6%E5%87%A1%E5%A4%A7%E7%A2%97%E5%AE%BD%E9%9D%A2%23&luicode=10000011&lfid=231522type%3D1%26t%3D10%26q%3D%23%E5%90%B4%E4%BA%A6%E5%87%A1%E5%A4%A7%E7%A2%97%E5%AE%BD%E9%9D%A2%23\" data-hide=\"\">" +
                "<span class=\"surl-text\">" +
                "#吴亦凡大碗宽面#" +
                "</span>" +
                "</a> " +
                "吴亦凡《大碗宽面》带来快乐才是真谛，好音乐听起来 " +
                "<a href='/n/Mr_凡先生'>" +
                "@Mr_凡先生" +
                "</a>" +
                " <a href=\"https://m.weibo.cn/p/index?containerid=10151501_64801822&url_type=&object_type=audio&pos=1&luicode=10000011&lfid=231522type%3D1%26t%3D10%26q%3D%23%E5%90%B4%E4%BA%A6%E5%87%A1%E5%A4%A7%E7%A2%97%E5%AE%BD%E9%9D%A2%23\" data-hide=\"\">" +
                "<span class='url-icon'><img style='width: 1rem;height: 1rem' src='https://h5.sinaimg.cn/upload/2015/09/25/3/timeline_card_small_music_default.png'>" +
                "</span>" +
                "<span class=\"surl-text\">" +
                "大碗宽面-Mr_凡先生" +
                "</span>" +
                "</a>";
//        String s1 = Regex.Replace(s, "<.+?>", "");
        String s1 = Html2Text(s);
        System.out.println(s);
        System.out.println(s1);
    }

    public static String Html2Text(String inputString){
        String htmlStr = inputString; //含html标签的字符串
        String textStr ="";
        java.util.regex.Pattern p_script;
        java.util.regex.Matcher m_script;
        java.util.regex.Pattern p_style;
        java.util.regex.Matcher m_style;


        try{
//            String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>"; //定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script> }
//            String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>"; //定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style> }
            String regEx_html = "<[^>]+>[^<]<[^>]+>"; //定义HTML标签的正则表达式
            String regA_html = "<a[^>]+>.*?</a>"; //定义<a>标签的正则表达式
            String regS_html = "<span[^>]+>.*?</span>"; //定义<span>标签的正则表达式


            p_script = Pattern.compile(regA_html,Pattern.CASE_INSENSITIVE);
            m_script = p_script.matcher(htmlStr);
            htmlStr = m_script.replaceAll(""); //过滤<a>标签

            p_style = Pattern.compile(regS_html,Pattern.CASE_INSENSITIVE);
            m_style = p_style.matcher(htmlStr);
            htmlStr = m_style.replaceAll(""); //过滤span>标签

//            p_html = Pattern.compile(regEx_html,Pattern.CASE_INSENSITIVE);
//            m_html = p_html.matcher(htmlStr);
//            htmlStr = m_html.replaceAll(""); //过滤html标签
            htmlStr = htmlStr.replace("  ", "");
            htmlStr = htmlStr.replace("\n", "");
            htmlStr = htmlStr.replace("\t", "");
            textStr = htmlStr.trim();
            textStr = htmlStr;
        }catch(Exception e){

        }
        return textStr;//返回文本字符串
    }

}
