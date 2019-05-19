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
}
