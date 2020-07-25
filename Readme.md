### 由于极速数据的新闻API每天使用上限只有100次

**背景：**
由于极数数据的api使用上限是每天100次,用于学习的次数也就100次;
那么我们所有的客户端使用上限也就只有100次，这。。。太糟糕了吧
于是乎，我就想我能不能存下来呢，然后后面使用我存的东西。
或者我自己去爬什么央视，新浪，头条啊...太麻烦了
于是乎就有了这个工程

**这个工程为android NewsClient 服务**
本项目使用到的产品或者开源库:`云服务器`,`mysql`,`mybaits`,`springmvc`,`sl4j`,`极速数据`
**我的项目地址**
base:http://ololee.cn:8080/news
param:
time={1-10可选,默认无参或其他数为今天的新闻}
skip=正整数 --表示跳过多少条
limit=正整数 --表示一次加载多少条
channelId=channellist可取值size之内{正整数}

```java
 public static final int CURRENTDAY = 1,/*今天*/
            YESTERDAY = 2,/*昨天*/
            LASTSEVENDAYS=3,/*过去7天*/
            CURRENTWEEK = 4,/*本周*/
            LASTWEEK = 5,/*上周*/
            CURRENTMONTH = 6,/*本月*/
            LASTMONTH = 7,/*上月*/
            CURRENTQUARTER = 8,/*本季度*/
            CURRENTHALFYEAR = 9,/*半年以来*/
            CURRENTYEAR = 10;/*今年*/
public static List<String> channellist= Arrays.asList( "头条","新闻","国内","国际","政治",
            "财经", "体育", "娱乐", "军事", "教育", "科技", "NBA", "股票",
            "星座", "女性", "健康", "育儿");
```



**参考与引用**

- 极速数据新闻API[ https://www.jisuapi.com/api/news/]( https://www.jisuapi.com/api/news/)