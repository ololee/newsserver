package cn.ololee.server.controller;

import cn.ololee.server.MainController;
import cn.ololee.server.beans.NewsItem;
import cn.ololee.server.constant.TimeConstant;
import cn.ololee.server.mybaits.ChannelNewsMapper;
import cn.ololee.server.mybaits.NewsMapper;
import cn.ololee.server.network.GetNews;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static cn.ololee.server.network.GetNews.NewGet;

@Controller
public class NewsController {
    private Logger logger = LoggerFactory.getLogger(MainController.class);
    @Autowired
    NewsMapper newsMapper;
    public static List<String> channellist= Arrays.asList( "头条","新闻","国内","国际","政治",
            "财经", "体育", "娱乐", "军事", "教育", "科技", "NBA", "股票",
            "星座", "女性", "健康", "育儿");

    @ResponseBody
    @RequestMapping("/news")
    public List<NewsItem> news(
            @RequestParam(value = "channelId",
                    required = false,
                    defaultValue = "0")
                    int channelId,
            @RequestParam(value = "time",
                    required = false,
                    defaultValue = "1")
                    int time,
            @RequestParam(value = "skip",
                    required = false,
                    defaultValue = "0")
                    int skip,
            @RequestParam(value = "limit",
                    required = false,
                    defaultValue = "10")
                    int limit) {
        List<NewsItem> result = null;
        switch (time) {
            case TimeConstant.YESTERDAY:
                result = newsMapper.getYesterdayNewsByChannelIdSkipLimit(channelId, skip, limit);
                break;
            case TimeConstant.LASTSEVENDAYS:
                result = newsMapper.getLastSevendayNewsByChannelIdSkipLimit(channelId, skip, limit);
                break;
            case TimeConstant.CURRENTWEEK:
                result = newsMapper.getCurrentWeekNewsByChannelIdSkipLimit(channelId,skip,limit);
                break;
            case TimeConstant.LASTWEEK:
                result=newsMapper.getLastWeekNewsByChannelIdSkipLimit(channelId,skip,limit);
                break;
            case TimeConstant.CURRENTMONTH:
                result=newsMapper.getCurrentMonthNewsByChannelIdSkipLimit(channelId,skip,limit);
                break;
            case TimeConstant.LASTMONTH:
                result=newsMapper.getLastMonthNewsByChannelIdSkipLimit(channelId,skip,limit);
                break;
            case TimeConstant.CURRENTQUARTER:
                result=newsMapper.getCurrentQuarterNewsByChannelIdSkipLimit(channelId,skip,limit);
                break;
            case TimeConstant.CURRENTHALFYEAR:
                result=newsMapper.getLastHalfYearNewsByChannelIdSkipLimit(channelId,skip,limit);
                break;
            case TimeConstant.CURRENTYEAR:
                result=newsMapper.getCurrentYearNewsByChannelIdSkipLimit(channelId,skip,limit);
                break;
            case TimeConstant.CURRENTDAY:
            default:
                result = newsMapper.getTodayNewsByChannelIdSkipLimit(channelId, skip, limit);
                break;
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("/spider")
    public void startSpider(){
        List<NewsItem> newsItems = new ArrayList<>();
        try {
            for (String s : channellist) {
                for (int i = 0; i < 11; i++) {
                    NewGet(40*i, s, new GetNews.Callback() {
                        @Override
                        public void done(Exception e, String... arg) {
                            if(e==null)
                            {
                                NewsItem newsItem = new NewsItem(arg[1],
                                        arg[2],
                                        arg[3],
                                        arg[4],
                                        arg[5],
                                        arg[6],
                                        arg[7],
                                        arg[8]);
                                newsItem.setChannelId(channellist.indexOf(arg[0]));
                                newsItems.add(newsItem);
                                System.out.println(newsItem);
                            }
                            else
                                e.printStackTrace();

                        }
                    });
                }
                newsMapper.batchInsert(newsItems);
                newsItems.removeAll(new ArrayList<>());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
