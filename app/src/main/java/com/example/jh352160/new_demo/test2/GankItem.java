package com.example.jh352160.new_demo.test2;

import java.util.List;

/**
 * Created by jh352160 on 2016/8/23.
 */

public class GankItem {

    /**
     * error : false
     * results : [{"_id":"57b52b44421aa93a74c34636","createdAt":"2016-08-18T11:28:04.913Z","desc":"Android学习笔记，总结的文章质量都不错。","publishedAt":"2016-08-23T11:29:45.813Z","source":"chrome","type":"Android","url":"https://github.com/GcsSloop/AndroidNote","used":true,"who":"wuzheng"},{"_id":"57b80e39421aa93a804bea30","createdAt":"2016-08-20T16:00:57.19Z","desc":"Android 开发之 MP4 文件转 GIF 文件详解","publishedAt":"2016-08-23T11:29:45.813Z","source":"web","type":"Android","url":"http://www.jianshu.com/p/cc94213ec4ab","used":true,"who":"单刀土豆"},{"_id":"57b85b67421aa93a78dd75f4","createdAt":"2016-08-20T21:30:15.339Z","desc":"仿照 Google Space 实现的导航栏效果，做的很漂亮！！","publishedAt":"2016-08-23T11:29:45.813Z","source":"chrome","type":"Android","url":"https://github.com/armcha/Space-Navigation-View","used":true,"who":"花开堪折枝"},{"_id":"57b9406f421aa950d7bc7b5a","createdAt":"2016-08-21T13:47:27.603Z","desc":"很概念化设计的一个注册动画效果。","publishedAt":"2016-08-23T11:29:45.813Z","source":"chrome","type":"Android","url":"https://github.com/JeasonWong/SignUpTransition","used":true,"who":"代码家"},{"_id":"57b97550421aa950cf805101","createdAt":"2016-08-21T17:33:04.693Z","desc":"多种形状波纹特效，可以用来实现一些背景特效。","publishedAt":"2016-08-23T11:29:45.813Z","source":"chrome","type":"Android","url":"https://github.com/poldz123/ShapeRipple","used":true,"who":"蒋朋"},{"_id":"57ba3b60421aa950d7bc7b5f","createdAt":"2016-08-22T07:38:08.604Z","desc":"仿支付宝实现的一个笑脸 LoadingView 效果。☺","publishedAt":"2016-08-23T11:29:45.813Z","source":"chrome","type":"Android","url":"https://github.com/andyxialm/SmileyLoadingView","used":true,"who":"代码家"},{"_id":"57bb01f1421aa91265f4a3b6","createdAt":"2016-08-22T21:45:21.482Z","desc":"Android 炫酷发送效果 Demo，赶紧翻开代码学习学习。","publishedAt":"2016-08-23T11:29:45.813Z","source":"chrome","type":"Android","url":"https://github.com/Jaouan/Sending-Animation-Example","used":true,"who":"代码家"},{"_id":"57bb1013421aa9126b1a1585","createdAt":"2016-08-22T22:45:39.845Z","desc":"有了json-api-mock framework， 再也不用担心后端API还没开发好，无论多复杂的状态我也能Mock出来","publishedAt":"2016-08-23T11:29:45.813Z","source":"web","type":"Android","url":"https://github.com/shanbay/mock-api","used":true,"who":"diaocow"},{"_id":"57bbae92421aa9125fa3ed62","createdAt":"2016-08-23T10:01:54.511Z","desc":"Freeline - Android平台上的秒级编译方案","publishedAt":"2016-08-23T11:29:45.813Z","source":"web","type":"Android","url":"https://yq.aliyun.com/articles/59177?spm=5176.100238.goodcont.51.bedUuR","used":true,"who":"XiaoGu"},{"_id":"57ba3aa2421aa950d35eb33e","createdAt":"2016-08-22T07:34:58.215Z","desc":"类似 Duolingo 的 Card 滑动和选择效果","publishedAt":"2016-08-22T11:29:37.164Z","source":"chrome","type":"Android","url":"https://github.com/rubensousa/ViewPagerCards","used":true,"who":"代码家"}]
     */

    private boolean error;
    /**
     * _id : 57b52b44421aa93a74c34636
     * createdAt : 2016-08-18T11:28:04.913Z
     * desc : Android学习笔记，总结的文章质量都不错。
     * publishedAt : 2016-08-23T11:29:45.813Z
     * source : chrome
     * type : Android
     * url : https://github.com/GcsSloop/AndroidNote
     * used : true
     * who : wuzheng
     */

    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
        private String who;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }
    }
}
