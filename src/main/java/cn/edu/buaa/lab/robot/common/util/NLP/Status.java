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

    public static int recommendIndex = -1;
    public static int weather_time = -3;

    //以下需要每个机器单独发送状态
    public static boolean isSleep = false;
    public static String input = "";
    public static boolean waitNext = false;
    public static String weather_city = "";

    //更新算法后不再用
    //public static boolean isGetResult = false;
    //public static char rsn = '0';
    //public static int notMatchTime = 0;
    //public static int lowMatchTime = 0;
    //public static int recommend = 0;
    //public static final int RECOMMEND = -3;
    //public static final int LOW_MATCH_AND_RECOMMEND = -6;
    //public static final int CHANGE_TO_QUESTION = -11;
    //public static final int CHANGE_TO_SONG = -12;
    //public static final int CHANGE_TO_STORY = -13;
    //public static final int CHANGE_TO_ENGLISH = -14;

//    public static void resetAll() {
//        //isGetResult = false;
//        //notMatchTime = 0;
//        //lowMatchTime = 0;
//        input = "";
//        waitNext = false;
//        recommendIndex = -1;
//    }
//
//    public static void reset() {
//        //isGetResult = false;
//        input = "";
//        //notMatchTime = 0;
//        //lowMatchTime = 0;
//        recommendIndex = -1;
//    }
}
