package cn.ololee.server.mybaits;

import cn.ololee.server.beans.NewsItem;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface NewsMapper {
    /*获取所有的消息,不建议执行*/
    @Select("select * from news")
    List<NewsItem> getAll();

    /*插入一条新闻*/
    @Insert("insert into news(id,title,time,source,category,picture,content,url,weburl,channelId) values(" +
            "#{id},#{title},#{time},#{source},#{category},#{picture},#{content},#{url},#{weburl},#{channelId})")
    void insert(NewsItem newsItem);

    @Insert({"<script>" ,
            "insert into news " +
            "(id,title,time,source,category,picture,content,url,weburl,channelId) " +
            "values ",
            "<foreach collection='list' item='it' index='index' separator=','> " ,
            "(#{it.id},#{it.title},#{it.time},#{it.source},#{it.category}," +
            "#{it.picture},#{it.content},#{it.url},#{it.weburl},#{it.channelId})" +
            "</foreach> ",
            "</script>"})
    int batchInsert(@Param("list")List<NewsItem> newsItemList);

    /*获取今日的新闻*/
    @Select("select * from news where to_days(time) = to_days(now())")
    List<NewsItem> getTodayNews();

    /*获取昨天的新闻*/
    @Select("select * from news where to_days(now()) - to_days(time) =1")
    List<NewsItem> getYesterdayNews();

    /*获取近7天的新闻*/
    @Select("select * from news where date_sub(curdate(), interval 7 day)<= date(time)")
    List<NewsItem> getLastSevendayNews();

    /*获取本周的新闻*/
    @Select("select * from news where yearweek(date_format(time,'%Y-%m-%d')) = yearweek(now())")
    List<NewsItem> getCurrentWeekNews();

    /*获取上周的新闻*/
    @Select("select * from news where yearweek(date_format(time,'%Y-%m-%d')) = yearweek(now())-1")
    List<NewsItem> getLastWeekNews();

    /*获取近30天的新闻*/
    @Select("select * from news where date_sub(curdate(), interval 30 day)<= date(time)")
    List<NewsItem> getLastThirtydaysNews();

    /*获取近一个月的新闻*/
    @Select("select * from news where date_format(time,'%Y%m') = date_format(curdate(),'%Y%m')")
    List<NewsItem> getCurrentMonthNews();

    /*获取上一个月的新闻*/
    @Select("select * from news where period_diff(date_format(now(),'%Y%m'),date_format(time,'%Y%m')) =1")
    List<NewsItem> getLastMonthNews();

    /*查询本季度的新闻*/
    @Select("select * from news where quarter(time) = quarter(now())")
    List<NewsItem> getCurrentQuarterNews();

    /*查询半年以来的数据*/
    @Select("select * from news where time between date_sub(now(), interval 6 month) and now()")
    List<NewsItem> getLastHalfYearNews();

    /*查询本年的新闻*/
    @Select("select * from news where year(time) = year(now())")
    List<NewsItem> getCurrentYearNews();


    @Select("select * from news where channelId=#{channelId}")
    List<NewsItem> getNewsByChannelId(int channelId);


    /*获取今日的某一频道的新闻*/
    @Select("select * from news where channelId=#{channelId} and to_days(time) = to_days(now())")
    List<NewsItem> getTodayNewsByChannelId(int channelId);

    /*获取今日的某一频道的新闻limit条新闻*/
    @Select({"select * from news where channelId=#{channelId} and to_days(time) = to_days(now())","limit #{limit}"})
    List<NewsItem> getTodayNewsByChannelIdLimit(int channelId,int limit);


    /*获取今日的某一频道的新闻limit条新闻,跳过skip条*/
    @Select({"select * from news where channelId=#{channelId} and to_days(time) = to_days(now())","limit #{begin} ,#{end}"})
    List<NewsItem> getTodayNewsByChannelIdSkipLimit(int channelId,int begin,int end);

    /*获取昨天的某一频道的新闻*/
    @Select("select * from news where channelId=#{channelId} and to_days(now()) - to_days(time) =1")
    List<NewsItem> getYesterdayNewsByChannelId(int channelId);

    /*获取昨天的某一频道的新闻limit条新闻,跳过skip条*/
    @Select({"select * from news where channelId=#{channelId} and to_days(now()) - to_days(time) =1","limit #{begin} ,#{end}"})
    List<NewsItem> getYesterdayNewsByChannelIdSkipLimit(int channelId,int begin,int end);

    /*获取近7天的某一频道的新闻*/
    @Select({"select * from news where channelId=#{channelId} and date_sub(curdate(), interval 7 day)<= date(time)","limit #{begin} ,#{end}"})
    List<NewsItem> getLastSevendayNewsByChannelIdSkipLimit(int channelId,int begin,int end);

    /*获取本周的某一频道的新闻*/
    @Select({"select * from news where channelId=#{channelId} and yearweek(date_format(time,'%Y-%m-%d')) = yearweek(now())","limit #{begin} ,#{end}"})
    List<NewsItem> getCurrentWeekNewsByChannelIdSkipLimit(int channelId,int begin,int end);

    /*获取上周的某一频道的新闻*/
    @Select({"select * from news where channelId=#{channelId} and yearweek(date_format(time,'%Y-%m-%d')) = yearweek(now())-1","limit #{begin} ,#{end}"})
    List<NewsItem> getLastWeekNewsByChannelIdSkipLimit(int channelId,int begin,int end);

    /*获取近30天的某一频道的新闻*/
    @Select("select * from news where channelId=#{channelId} and date_sub(curdate(), interval 30 day)<= date(time)")
    List<NewsItem> getLastThirtydaysNewsByChannelId(int channelId);

    /*获取近一个月的某一频道的新闻*/
    @Select({"select * from news where channelId=#{channelId} and date_format(time,'%Y%m') = date_format(curdate(),'%Y%m')","limit #{begin} ,#{end}"})
    List<NewsItem> getCurrentMonthNewsByChannelIdSkipLimit(int channelId,int begin,int end);

    /*获取上一个月的某一频道的新闻*/
    @Select({"select * from news where channelId=#{channelId} and period_diff(date_format(now(),'%Y%m'),date_format(time,'%Y%m')) =1","limit #{begin} ,#{end}"})
    List<NewsItem> getLastMonthNewsByChannelIdSkipLimit(int channelId,int begin,int end);

    /*查询本季度的某一频道的新闻*/
    @Select({"select * from news where channelId=#{channelId} and quarter(time) = quarter(now())","limit #{begin} ,#{end}"})
    List<NewsItem> getCurrentQuarterNewsByChannelIdSkipLimit(int channelId,int begin,int end);

    /*查询半年以来的某一频道的数据*/
    @Select({"select * from news where channelId=#{channelId} and time between date_sub(now(), interval 6 month) and now()","limit #{begin} ,#{end}"})
    List<NewsItem> getLastHalfYearNewsByChannelIdSkipLimit(int channelId,int begin,int end);

    /*查询本年的某一频道的新闻*/
    @Select({"select * from news where channelId=#{channelId} and year(time) = year(now())","limit #{begin} ,#{end}"})
    List<NewsItem> getCurrentYearNewsByChannelIdSkipLimit(int channelId,int begin,int end);
}
