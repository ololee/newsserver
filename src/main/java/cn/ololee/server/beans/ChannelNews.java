package cn.ololee.server.beans;

import java.util.List;

public class ChannelNews {
    private int id;
    private String channel;
    private List<NewsItem> newsItems;

    public ChannelNews() {
    }

    public ChannelNews(String channel, List<NewsItem> newsItems) {
        this.channel = channel;
        this.newsItems = newsItems;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public List<NewsItem> getNewsItems() {
        return newsItems;
    }

    public void setNewsItems(List<NewsItem> newsItems) {
        this.newsItems = newsItems;
    }

    @Override
    public String toString() {
        return "ChannelNews{" +
                "id=" + id +
                ", channel='" + channel + '\'' +
                ", newsItem=" + newsItems +
                '}';
    }
}
