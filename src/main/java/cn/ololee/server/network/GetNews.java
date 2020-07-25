package cn.ololee.server.network;

import cn.ololee.server.beans.NewsItem;
import cn.ololee.server.mybaits.NewsMapper;
import cn.ololee.server.utils.HttpUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetNews {
    public static final String APPKEY = "6bafd47f0036b025";
    public static final String URL = "https://api.jisuapi.com/news/get";
    // utf8  新闻频道(头条,财经,体育,娱乐,军事,教育,科技,NBA,股票,星座,女性,健康,育儿)
    public static final int num = 40;// 数量 默认10，最大40
    public static List<String> channellist=Arrays.asList( "头条","新闻","国内","国际","政治",
            "财经", "体育", "娱乐", "军事", "教育", "科技", "NBA", "股票",
            "星座", "女性", "健康", "育儿");

    public interface Callback{
        void done(Exception e,String...arg);
    }

    public static void NewGet(int start,String channelCh,Callback callback) throws Exception {
        String result = null;
        String url = URL + "?start="+start+"channel=" + URLEncoder.encode(channelCh, "utf-8") + "&num=" + num + "&appkey=" + APPKEY;
        try {
            result = HttpUtil.sendGet(url, "utf-8");
            JSONObject json = JSONObject.fromObject(result);
            if (json.getInt("status") != 0) {
                System.out.println(json.getString("msg"));
            } else {
                JSONObject resultarr = (JSONObject) json.opt("result");
                String channel = resultarr.getString("channel");
                String num = resultarr.getString("num");
                JSONArray list = resultarr.optJSONArray("list");
                for (int i = 0; i < list.size(); i++) {
                    JSONObject obj = (JSONObject) list.opt(i);
                    String title = obj.getString("title");
                    String time = obj.getString("time");
                    String src = obj.getString("src");
                    String category = obj.getString("category");
                    String pic = obj.getString("pic");
                    String content = obj.getString("content");
                    String url1 = obj.getString("url");
                    String weburl = obj.getString("weburl");
                    callback.done(null,channelCh,title,time,src,category,pic,content,url1,weburl);
                }
            }
        } catch (Exception e) {
            callback.done(e);
            e.printStackTrace();
        }
    }

    /*
    title;      title =
    time;       time =
    source;    src = o
    category;  categor
    picture;   pic = o
    content;   content
    url;      url1 =
    weburl;   weburl*/
}
