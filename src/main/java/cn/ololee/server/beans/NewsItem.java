package cn.ololee.server.beans;

import cn.ololee.server.utils.StringUtil;

import java.util.Random;

public class NewsItem {
    private String id;
    private String title;
    private String time;
    private String source;
    private String category;
    private String picture;
    private String content;
    private String url;
    private String weburl;
    private int channelId;


    public NewsItem(String title, String timestring, String source, String category, String pictureurl, String content, String url, String weburl) {
        this.title = title;
        this.time = timestring;
        this.source = source;
        this.category = category;
        this.picture = pictureurl;
        this.content = content;
        this.url = url;
        this.weburl = weburl;
        calcId();
        trimHtmlTag();
    }

    public NewsItem() {

    }

    private void calcId(){
        id=time.replaceAll("-","")
                .replace(" ","")
                .replaceAll(":","");
        id+= StringUtil.generateString(16);
    }

    private void trimHtmlTag(){
        content=content.replaceAll("<[^>]+>","").replaceAll("\\s*","");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTimestring() {
        return time;
    }

    public void setTimestring(String timestring) {
        this.time = timestring;
        calcId();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPictureurl() {
        return picture;
    }

    public void setPictureurl(String pictureurl) {
        this.picture = pictureurl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        trimHtmlTag();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getWeburl() {
        return weburl;
    }

    public void setWeburl(String weburl) {
        this.weburl = weburl;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    @Override
    public String toString() {
        return "NewsItem{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", time='" + time + '\'' +
                ", source='" + source + '\'' +
                ", category='" + category + '\'' +
                ", picture='" + picture + '\'' +
                ", content='" + content + '\'' +
                ", url='" + url + '\'' +
                ", weburl='" + weburl + '\'' +
                ", channelId=" + channelId +
                '}';
    }
}
