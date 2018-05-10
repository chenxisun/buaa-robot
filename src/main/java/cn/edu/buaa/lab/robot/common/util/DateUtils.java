package cn.edu.buaa.lab.robot.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
            return src.substring(7) + "日" + week;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }
}
