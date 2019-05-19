package io.github.wanmudong.model;

import org.openqa.selenium.Cookie;

import java.util.Date;

/**
 * @author ：wanmudong
 * @date ：Created in 2019/5/17 20:44
 * @description：
 */
public class Cookies {
    private String name;
    private String value;
    private String path;
    private String domain;
    private Date expiry;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public Date getExpiry() {
        return expiry;
    }

    public void setExpiry(Date expiry) {
        this.expiry = expiry;
    }

    public Cookie getSeleCookie(){
        Cookie cookie = new Cookie(name,value,domain,path,expiry);
        return cookie;
    }
    @Override
    public String toString() {
        return "Cookies{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", path='" + path + '\'' +
                ", domain='" + domain + '\'' +
                ", expiry=" + expiry +
                '}';
    }
}
