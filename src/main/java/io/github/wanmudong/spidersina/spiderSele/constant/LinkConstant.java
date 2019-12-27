package io.github.wanmudong.spidersina.spiderSele.constant;

/**
 * @author ：wanmudong
 * @date ：Created in 2019/5/18 13:16
 * @description：    请求链接
 */
public class LinkConstant {
    /**
     * 用户微博信息  后面附上用户id
     * https://m.weibo.cn/api/container/getIndex?containerid=1005053675865547
     */
    public static final String WEIBO_USER_INDEX = "https://m.weibo.cn/api/container/getIndex?containerid=";
    /**
     * 用户微博首页  后面附上用户id
     * https://m.weibo.cn/p/1005053669102477
     */
    public static final String WEIBO_START = "https://m.weibo.cn/p/";
    /**
     * 用户微博简介   containId可以从用户微博首页获取 value为用户id
     *https://m.weibo.cn/api/container/getIndex?type=uid&value=3675865547&containerid=1076033675865547&page=1
     */
    public static final String WEIBO_INDEX = "https://m.weibo.cn/api/container/getIndex?type=uid&value=";
    /**
     *用户微博评论  id即为微博id，max_id可以从上一批微博评论中获取
     * https://m.weibo.cn/comments/hotflow?id=4368390368509845&mid=4368390368509845&max_id=0&max_id_type=0
     */
    public static final String WEIBO_COMMENT = "https://m.weibo.cn/comments/hotflow?max_id_type=0";
    /**
     * 用户微博点赞 id即为微博id，page自增
     * https://m.weibo.cn/api/attitudes/show?id=4368390368509845&page=1
     */
    public static final String WEIBO_SHOW = "https://m.weibo.cn/api/attitudes/show?";
    /**
     * 用户微博转发
     * https://m.weibo.cn/api/statuses/repostTimeline?id=4372575549518375&page=1
     */
    public static final String WEIBO_REPOST = "https://m.weibo.cn/api/statuses/repostTimeline?";

    /**
     * 用户微博信息  后面附上用户id
     * https://m.weibo.cn/api/container/getIndex?containerid=1005053675865547
     */
    public static final String WEIBO_USER_INDEX_ANOTHER = "https://m.weibo.cn/api/container/getIndex?containerid=";
    /**
     * 用户微博首页  后面附上用户id
     * https://m.weibo.cn/p/1005053669102477
     */
    public static final String WEIBO_START_ANOTHER = "https://m.weibo.cn/p/";
    /**
     * 用户微博简介   containId可以从用户微博首页获取 value为用户id
     *https://m.weibo.cn/api/container/getIndex?type=uid&value=3675865547&containerid=1076033675865547&page=1
     */
    public static final String WEIBO_INDEX_ANOTHER = "https://m.weibo.cn/api/container/getIndex?type=uid&value=";
    /**
     *用户微博评论  id即为微博id，page递增即可
     * https://m.weibo.cn/api/comments/show?id=HrVmp5ma1&page=3
     */
    public static final String WEIBO_COMMENT_ANOTHER = "https://m.weibo.cn/api/comments/show?";
    /**
     * 用户微博点赞 id即为微博id，page自增
     * https://m.weibo.cn/api/attitudes/show?id=4368390368509845&page=1
     */
    public static final String WEIBO_SHOW_ANOTHER = "https://m.weibo.cn/api/attitudes/show?";
    /**
     * 用户微博转发
     * https://m.weibo.cn/api/statuses/repostTimeline?id=4372575549518375&page=1
     */
    public static final String WEIBO_REPOST_ANOTHER = "https://m.weibo.cn/api/statuses/repostTimeline?";

    /**
     *用户微博评论  uid即为用户id，page递增即可  HiAzT4u0y 为微博id
     * pc国际版
     * https://weibo.cn/comment/HiAzT4u0y?uid=3591355593&rl=0&page=1
     */
    public static final String WEIBO_COMMENT_ANOTHER_PC_CN = "https://weibo.cn/comment";

    /**
     *用户微博转发  uid即为用户id，page递增即可  HiAzT4u0y 为微博id
     * pc国际版
     * https://weibo.cn/repost/HiAzT4u0y?uid=3591355593&rl=0&page=1
     */
    public static final String WEIBO_REPOST_ANOTHER_PC_CN = "https://weibo.cn/repost";


    /**
     *微博特定话题  uid即为用户id，page递增即可  HiAzT4u0y 为微博id
     * 移动版
     * https://m.weibo.cn/search?containerid=231522type%3D1%26t%3D10%26q%3D%23%E5%90%B4%E4%BA%A6%E5%87%A1%E5%A4%A7%E7%A2%97%E5%AE%BD%E9%9D%A2%23&extparam=%23%E5%90%B4%E4%BA%A6%E5%87%A1%E5%A4%A7%E7%A2%97%E5%AE%BD%E9%9D%A2%23&luicode=10000011&lfid=100103type%3D38%26q%3D%E5%90%B4%E4%BA%A6%E5%87%A1%E5%A4%A7%E7%A2%97%E5%AE%BD%E9%9D%A2%26t%3D0
     * https://m.weibo.cn/api/container/getIndex?containerid=231522type%3D1%26t%3D10%26q%3D%23%E5%90%B4%E4%BA%A6%E5%87%A1%E5%A4%A7%E7%A2%97%E5%AE%BD%E9%9D%A2%23&extparam=%23%E5%90%B4%E4%BA%A6%E5%87%A1%E5%A4%A7%E7%A2%97%E5%AE%BD%E9%9D%A2%23&luicode=10000011&lfid=100103type%3D38%26q%3D%E5%90%B4%E4%BA%A6%E5%87%A1%E5%A4%A7%E7%A2%97%E5%AE%BD%E9%9D%A2%26t%3D0&page_type=searchall&page=1232
     *
     *
     * https://m.weibo.cn/api/container/getIndex?containerid=231522type%3D1%26t%3D10%26q%3D%23%E8%94%A1%E5%BE%90%E5%9D%A4%E7%BB%99B%E7%AB%99%E5%8F%91%E5%BE%8B%E5%B8%88%E5%87%BD%23&extparam=%23%E8%94%A1%E5%BE%90%E5%9D%A4%E7%BB%99B%E7%AB%99%E5%8F%91%E5%BE%8B%E5%B8%88%E5%87%BD%23&luicode=10000011&lfid=100103type%3D1%26q%3D%E8%94%A1%E5%BE%90%E5%9D%A4%E7%BB%99b%E7%AB%99%E5%8F%91%E5%BE%8B%E5%B8%88%E5%87%BD&page_type=searchall&page=2
     *
     * 大碗宽面
     * https://m.weibo.cn/api/container/getIndex?containerid=100103type%3D1%26q%3D%23%E5%90%B4%E4%BA%A6%E5%87%A1%E5%A4%A7%E7%A2%97%E5%AE%BD%E9%9D%A2%23&page_type=searchall&page=3
     * 蔡徐坤给b站发律师函
     * https://m.weibo.cn/api/container/getIndex?containerid=100103type%3D61%26q%3D%23%E8%94%A1%E5%BE%90%E5%9D%A4%E7%BB%99B%E7%AB%99%E5%8F%91%E5%BE%8B%E5%B8%88%E5%87%BD%23%26t%3D0&page_type=searchall&page=2
     *
     */
    public static final String WEIBO_TOPIC_WUYIFAN_DAWANKUANMIAN_INDEX = "https://m.weibo.cn/api/container/getIndex?" +
            "containerid=231522type%3D1%26t%3D10%26q%3D%23%E8%94%A1%E5%BE%90%E5%9D%A4%E7%BB%99B%E7%AB%99%E5%8F%91%E5%BE%8B%E5%B8%88%E5%87%BD%23" +
            "&extparam=%23%E8%94%A1%E5%BE%90%E5%9D%A4%E7%BB%99B%E7%AB%99%E5%8F%91%E5%BE%8B%E5%B8%88%E5%87%BD%23&luicode=10000011&lfid=100103type" +
            "%3D1%26q%3D%E8%94%A1%E5%BE%90%E5%9D%A4%E7%BB%99b%E7%AB%99%E5%8F%91%E5%BE%8B%E5%B8%88%E5%87%BD&page_type=searchall&page=";
}
