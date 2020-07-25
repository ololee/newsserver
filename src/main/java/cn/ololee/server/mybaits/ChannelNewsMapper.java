package cn.ololee.server.mybaits;


import cn.ololee.server.beans.ChannelNews;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface ChannelNewsMapper {
    @Insert("insert into channelnews(channel) values(#{channel})")
    void insertChannelNews(ChannelNews channelNews);

    @Select("select * from channelnews")
    List<ChannelNews> getAll();

    /*所有的新闻*/
    @Select("select * from channelnews where channel = #{channel}")
    @Results({
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "channel",property = "channel"),
            @Result(column = "id",property = "newsItems",
            many = @Many(select = "cn.ololee.server.mybaits.NewsMapper.getNewsByChannelId",fetchType= FetchType.EAGER))
    })
    List<ChannelNews> getNewsByChannel(String channel);

    /*今天的新闻*/
    @Select("select * from channelnews where channel = #{channel}")
    @Results({
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "channel",property = "channel"),
            @Result(column = "id",property = "newsItems",
                    many = @Many(select = "cn.ololee.server.mybaits.NewsMapper.getTodayNewsByChannelId",fetchType= FetchType.EAGER))
    })
    List<ChannelNews> getTodayNewsByChannel(String channel);

    /*获取昨天的某一频道的新闻*/
    @Select("select * from channelnews where channel = #{channel}")
    @Results({
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "channel",property = "channel"),
            @Result(column = "id",property = "newsItems",
                    many = @Many(select = "cn.ololee.server.mybaits.NewsMapper.getYesterdayNewsByChannelId",fetchType= FetchType.EAGER))
    })
    List<ChannelNews> getYesterdayNewsByChannel(String channel);

    /*获取近7天的某一频道的新闻*/
    @Select("select * from channelnews where channel = #{channel}")
    @Results({
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "channel",property = "channel"),
            @Result(column = "id",property = "newsItems",
                    many = @Many(select = "cn.ololee.server.mybaits.NewsMapper.getLastSevendayNewsByChannelId",fetchType= FetchType.EAGER))
    })
    List<ChannelNews> getLastSevendayNewsByChannel(String channel);

    /*获取本周的某一频道的新闻*/
    @Select("select * from channelnews where channel = #{channel}")
    @Results({
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "channel",property = "channel"),
            @Result(column = "id",property = "newsItems",
                    many = @Many(select = "cn.ololee.server.mybaits.NewsMapper.getCurrentWeekNewsByChannelId",fetchType= FetchType.EAGER))
    })
    List<ChannelNews> getCurrentWeekNewsByChannel(String channel);

    /*获取上周的某一频道的新闻*/
    @Select("select * from channelnews where channel = #{channel}")
    @Results({
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "channel",property = "channel"),
            @Result(column = "id",property = "newsItems",
                    many = @Many(select = "cn.ololee.server.mybaits.NewsMapper.getLastWeekNewsByChannelId",fetchType= FetchType.EAGER))
    })
    List<ChannelNews> getLastWeekNewsByChannel(String channel);

    /*获取近30天的某一频道的新闻*/
    @Select("select * from channelnews where channel = #{channel}")
    @Results({
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "channel",property = "channel"),
            @Result(column = "id",property = "newsItems",
                    many = @Many(select = "cn.ololee.server.mybaits.NewsMapper.getLastThirtydaysNewsByChannelId",fetchType= FetchType.EAGER))
    })
    List<ChannelNews> getLastThirtydaysNewsByChannel(String channel);


    /*获取近一个月的某一频道的新闻*/
    @Select("select * from channelnews where channel = #{channel}")
    @Results({
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "channel",property = "channel"),
            @Result(column = "id",property = "newsItems",
                    many = @Many(select = "cn.ololee.server.mybaits.NewsMapper.getCurrentMonthNewsByChannelId",fetchType= FetchType.EAGER))
    })
    List<ChannelNews> getCurrentMonthNewsByChannel(String channel);

    /*获取上一个月的某一频道的新闻*/
    @Select("select * from channelnews where channel = #{channel}")
    @Results({
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "channel",property = "channel"),
            @Result(column = "id",property = "newsItems",
                    many = @Many(select = "cn.ololee.server.mybaits.NewsMapper.getLastMonthNewsByChannelId",fetchType= FetchType.EAGER))
    })
    List<ChannelNews> getLastMonthNewsByChannel(String channel);

    /*查询本季度的某一频道的新闻*/
    @Select("select * from channelnews where channel = #{channel}")
    @Results({
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "channel",property = "channel"),
            @Result(column = "id",property = "newsItems",
                    many = @Many(select = "cn.ololee.server.mybaits.NewsMapper.getCurrentQuarterNewsByChannelId",fetchType= FetchType.EAGER))
    })
    List<ChannelNews> getCurrentQuarterNewsByChannel(String channel);

    /*查询半年以来的某一频道的数据*/
    @Select("select * from channelnews where channel = #{channel}")
    @Results({
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "channel",property = "channel"),
            @Result(column = "id",property = "newsItems",
                    many = @Many(select = "cn.ololee.server.mybaits.NewsMapper.getLastHalfYearNewsByChannelId",fetchType= FetchType.EAGER))
    })
    List<ChannelNews> getLastHalfYearNewsByChannel(String channel);

    /*查询本年的某一频道的新闻*/
    @Select("select * from channelnews where channel = #{channel}")
    @Results({
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "channel",property = "channel"),
            @Result(column = "id",property = "newsItems",
                    many = @Many(select = "cn.ololee.server.mybaits.NewsMapper.getCurrentYearNewsByChannelId",fetchType= FetchType.EAGER))
    })
    List<ChannelNews> getCurrentYearNewsByChannel(String channel);
}
