package io.github.wanmudong.spidersina.spider.util;

import com.alibaba.fastjson.JSON;
import okhttp3.*;

import java.util.Map;

/**
 * @author ：wanmudong
 * @date ：Created in 2019/5/17 10:07
 * @description：生成请求
 * @modified By：
 * @version: $
 */
public class OkHttpUtil {
    public static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.6 Safari/537.36";

    private static final MediaType MEDIA_TYPE_JSON = MediaType.get("application/json");


    private OkHttpUtil() {
    }

    public static Request newGetRequest(HttpUrl url) {
        return new Request.Builder()
                .url(url)
                .header("Connection", "keep-alive")
                .header("User-Agent", USER_AGENT)
                .get()
                .build();
    }

    public static Request newGetRequest(String url) {
        return new Request.Builder()
                .url(url)
                .header("Connection", "keep-alive")
                .header("User-Agent", USER_AGENT)
                .get()
                .build();
    }

    public static Request newPostRequest(HttpUrl url, MediaType type, String content) {
        return new Request.Builder()
                .url(url)
                .header("Connection", "keep-alive")
                .header("User-Agent", USER_AGENT)
                .post(RequestBody.create(type, content))
                .build();
    }


    public static Request newPostJsonRequest(HttpUrl url, Object obj) {
        return new Request.Builder()
                .url(url)
                .header("Connection", "keep-alive")
                .header("User-Agent", USER_AGENT)
                .post(RequestBody.create(MEDIA_TYPE_JSON, JSON.toJSONBytes(obj)))
                .build();
    }

    public static Request newPostFormRequest(HttpUrl url, Map<String, String> formData) {
        // Objects.requireNonNull(formData, "formData must not be null!");

        final FormBody.Builder formBodyBuilder = new FormBody.Builder();

//        formData.forEach(formBodyBuilder::add);

        for (Map.Entry<String,String> entry:formData.entrySet()){
            formBodyBuilder.add(entry.getKey(),entry.getValue());
        }
        return new Request.Builder()
                .url(url)
                .header("Connection", "keep-alive")
                .header("User-Agent", USER_AGENT)
                .post(formBodyBuilder.build())
                .build();
    }
}
