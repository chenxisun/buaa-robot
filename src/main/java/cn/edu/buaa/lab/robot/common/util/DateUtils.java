package cn.edu.buaa.lab.robot.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtils {
    private static final Logger logger = LoggerFactory.getLogger("DateUtils");


    private static DateFormat DF_YYYY_MM_DD = new SimpleDateFormat("yyyy-MM-dd");

    private static String[] weeks = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };

    public static String today() {
        return DF_YYYY_MM_DD.format(new Date());
    }

    public static String yestoday() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE,   -1);
        return DF_YYYY_MM_DD.format(cal.getTime());
    }

    public static String tomorrow() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE,   +1);
        return DF_YYYY_MM_DD.format(cal.getTime());
    }

    // date: 2018-05-09
    public static int compareToday(String date) {
        try {
            Date d = DF_YYYY_MM_DD.parse(date);
            return d.compareTo(new Date());
        } catch (Exception e) {
            logger.error(date, e);
            return -1;
        }
    }

    // 2018-05-09, 10日星期四 -> 2018-05-10
    public static String toDate(String date, String src) {
        try {
            return date.substring(0, 8) + src.substring(0, 2);
        } catch (Exception e) {
            logger.error(src, e);
        }
        return "";
    }

    // 2018-05-10 -> 10日星期四
    public static String toDayWeek(String src) {
        try {
            Date date = DF_YYYY_MM_DD.parse(src);
            Calendar cal = Calendar.getInstance(); // 获得一个日历
            cal.setTime(date);
            int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
            if (w < 0)
                w = 0;
            String week = weeks[w];
            return src.substring(8) + "日" + week;
        } catch (ParseException e) {
//            e.printStackTrace();
            logger.error(src, e);
        }
        return "";
    }

    // {"date":"9日星期三","high":"高温 25℃","fx":"东风","low":"低温 15℃","fl":"<![CDATA[<3级]]>","type":"晴"}
    public static void main(String[] args) throws Exception {
        System.out.println("hello");
        System.out.println(toDate("2018-05-09","10日星期四"));
        System.out.println(toDayWeek("2018-05-10"));

        String src = "{\"data\":{\"yesterday\":{\"date\":\"9日星期三\",\"high\":\"高温 25℃\",\"fx\":\"东风\",\"low\":\"低温 15℃\",\"fl\":\"<![CDATA[<3级]]>\",\"type\":\"晴\"},\"city\":\"苏州\",\"aqi\":\"44\",\"forecast\":[{\"date\":\"10日星期四\",\"high\":\"高温 25℃\",\"fengli\":\"<![CDATA[<3级]]>\",\"low\":\"低温 15℃\",\"fengxiang\":\"东风\",\"type\":\"晴\"},{\"date\":\"11日星期五\",\"high\":\"高温 24℃\",\"fengli\":\"<![CDATA[3-4级]]>\",\"low\":\"低温 17℃\",\"fengxiang\":\"东南风\",\"type\":\"多云\"},{\"date\":\"12日星期六\",\"high\":\"高温 27℃\",\"fengli\":\"<![CDATA[3-4级]]>\",\"low\":\"低温 20℃\",\"fengxiang\":\"东南风\",\"type\":\"多云\"},{\"date\":\"13日星期天\",\"high\":\"高温 29℃\",\"fengli\":\"<![CDATA[3-4级]]>\",\"low\":\"低温 22℃\",\"fengxiang\":\"西南风\",\"type\":\"雷阵雨\"},{\"date\":\"14日星期一\",\"high\":\"高温 31℃\",\"fengli\":\"<![CDATA[3-4级]]>\",\"low\":\"低温 22℃\",\"fengxiang\":\"北风\",\"type\":\"多云\"}],\"ganmao\":\"各项气象条件适宜，无明显降温过程，发生感冒机率较低。\",\"wendu\":\"14\"},\"status\":1000,\"desc\":\"OK\"}";
//        Map weatherMap = GsonUtils.gToObject(src, Map.class);
        Map weatherData = ((Map) GsonUtils.gToObject(src, Map.class).get("data"));
        String city = (String) weatherData.get("city");
        String wendu = (String) weatherData.get("wendu");
        Map yesterdayMap = (Map) weatherData.get("yesterday");
        List forecastList = (List) weatherData.get("forecast");
        forecastList.add(yesterdayMap);
        for (Object o : forecastList) {
            System.out.println(o);
            System.out.println(GsonUtils.gToJson(o));
        }

        String wtf = "{date=9日星期三, high=高温 25℃, fx=东风, low=低温 15℃, fl=<![CDATA[<3级]]>, type=晴}";

        System.out.println();
    }
}
