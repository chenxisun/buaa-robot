package cn.edu.buaa.lab.robot.common.util.NLP;

public class Status {
    public static final float match_per = 0.8f;
    public static final int SILENCE = -1;
    public static final int LOW_MATCH = -2;
    public static final int NO = -4;
    public static final int OK = -5;
    public static final int WEATHER = -7;
    public static final int TRANSLATE = -8;
    public static final int RECOMMEND_QUESTION = -11;
    public static final int RECOMMEND_SONG = -12;
    public static final int RECOMMEND_STORY = -13;
    public static final int RECOMMEND_ENGLISH = -14;
    public static final int SLEEP = -21;
    public static final int WAKE = -22;

//    //每次要重置
//    public static int recommendIndex = -1;
//    public static int weather_time = -3;
//    public static String weather_city = "";
//
//    //以下需要每个机器单独发送状态
//    public static boolean isSleep = false;
//    public static String input = "";
//    public static boolean waitNext = false;

}
