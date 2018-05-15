package cn.edu.buaa.lab.robot.common.util.NLP;

import cn.edu.buaa.lab.robot.common.util.Pair;

import java.util.*;

public class Match {

    private static Pair<Integer, Float> GetAnswerIndex(ArrayList<ArrayList<Integer>> aaiAnswer)
    {
        HashMap<Integer, Integer> mii = new HashMap<Integer, Integer>();
        HashMap<Integer, Float> mif = new HashMap<Integer, Float>();

        for (int i = 0; i < aaiAnswer.size(); i++)
        {
            for (int j = 0; j < aaiAnswer.get(i).size(); j++)
            {
                if (!mii.containsKey(aaiAnswer.get(i).get(j)))
                {
                    mii.put(aaiAnswer.get(i).get(j), 1);
                    mif.put(aaiAnswer.get(i).get(j), 1.0f/ Word.aiCountSet.get(aaiAnswer.get(i).get(j)-1));
                }
                else
                {
                    mii.put(aaiAnswer.get(i).get(j), mii.get(aaiAnswer.get(i).get(j))+1);
                    mif.put(aaiAnswer.get(i).get(j),
                            mif.get(aaiAnswer.get(i).get(j))+1.0f/ Word.aiCountSet.get(aaiAnswer.get(i).get(j)-1));
                }
            }
        }
        float max = 0.0f;
        int max_index = 0;
        Set<Map.Entry<Integer, Float>> sets = mif.entrySet();
        for (Map.Entry<Integer, Float> p : sets)
        {
            if (Math.abs(p.getValue() - max) < 0.01 && mii.get(p.getKey()) > mii.get(max_index))//比例相同时，比较出现次数
            {
                max = p.getValue();
                max_index = p.getKey();
                continue;
            }
            if (p.getValue() > max)
            {
                max = p.getValue();
                max_index = p.getKey();
            }
        }
        return new Pair<Integer,Float>(max_index, max);
    }

    private static int TypeInference(ArrayList<ArrayList<Integer>> typeResult)
    {
        int i_song = 0;
        int i_story = 0;
        int i_question = 0;
        int i_english = 0;
        for(ArrayList<Integer> v : typeResult)
        {
            switch (v.get(0))
            {
                case -1:
                    i_song ++;
                    break;
                case -2:
                    i_song += 3;
                    break;
                case -3:
                    i_song += 2;
                    break;
                case -4:
                    i_story +=3;
                    break;
                case -5:
                    i_story ++;
                    break;
                case -6:
                case -7:
                case -8:
                    i_question++;
                    break;
                case -9:
                    i_english++;
                    break;
                case -10:
                    i_english+=3;
                default:
                    break;
            }
        }
        if (i_question+i_song+i_story+i_english == 0)
            return Status.LOW_MATCH;
        if(i_question > i_song && i_question > i_story && i_question > i_english)
            return Status.RECOMMEND_QUESTION;
        if (i_song >= i_story && i_song >= i_english)
            return Status.RECOMMEND_SONG;
        if (i_english>=i_story)
            return Status.RECOMMEND_ENGLISH;
        return Status.RECOMMEND_STORY;
    }

    public static int beibei(StatusPerRobot spr)
    {
        //Log l = Log();
        String testLine = spr.input;

        ArrayList<String> xiao = new ArrayList<String>();
        xiao.add("贝");
        xiao.add("妹");
        xiao.add("背");
        xiao.add("呗");
        ArrayList<String> tong = new ArrayList<String>();
        tong.add("贝");
        tong.add("妹");
        tong.add("背");
        tong.add("呗");

        int length1 = testLine.length();
        int length2 = xiao.size();
        int length3 = tong.size();
        boolean flag = false;
        for(int i = 0; i < length1-1; i++)
        {
            for(int j = 0; j < length2; j++)
            {
                if (testLine.charAt(i) == xiao.get(j).charAt(0))
                {
                    for(int k = 0; k < length3; k++ )
                    {
                        if(testLine.charAt(i+1) == tong.get(k).charAt(0))
                        {
                            flag = true;
                            break;
                        }
                    }
                }
                if (flag)
                    break;
            }
            if (flag)
                break;
        }
        if (flag)
        {
            spr.isSleep = false;
            //l.WriteLog("#唤醒贝贝");
            return Status.WAKE;
        }
        return -1;
    }

    public static int sleep(StatusPerRobot spr)
    {
        //Log l = Log();
        String testLine = spr.input;

        String s_sleep = "你去睡觉";

        int length1 = testLine.length();
        int length2 = s_sleep.length();
        boolean flag = false;
        for(int i = 0; i <= length1-length2; i++)
        {
            String s = testLine.substring(i,length2+i);
            if(s.equals(s_sleep))
            {
                flag = true;
                break;
            }
        }
        if (flag)
        {
            spr.isSleep = true;
            //l.WriteLog("#贝贝睡觉了");
            spr.input = "";
            //Status.notMatchTime = 3;
            return Status.SLEEP;
        }
        return -1;
    }

    public static boolean hasNo(StatusPerRobot spr)
    {
        ArrayList<String> bu = new ArrayList<String>();
        bu.add("不");
        bu.add("部");
        bu.add("步");
        bu.add("布");
        bu.add("换");

        int length1 = spr.input.length();
        int length2 = bu.size();
        boolean no = false;
        for(int i = 0; i < length1; i++)
        {
            for(int j = 0; j < length2; j++)
            {
                if (spr.input.charAt(i) == bu.get(j).charAt(0))
                {
                    no = true;
                    break;
                }
            }
            if (no)
                break;
        }
        return no;
    }

    public static boolean isOK(StatusPerRobot spr)
    {
        ArrayList<String> ok = new ArrayList<String>();
        ok.add("好");
        ok.add("行");
        ok.add("可以");

        int length1 = spr.input.length();
        int length2 = ok.size();
        boolean o = false;
        for(int i = 0; i < length1; i++)
        {
            for(int j = 0; j < length2; j++)
            {
                if (spr.input.charAt(i) == ok.get(j).charAt(0))
                {
                    o = true;
                    break;
                }
            }
            if (o)
                break;
        }
        return o;
    }

    public static boolean silence(StatusPerRobot spr)
    {
        if (spr.input.length() == 0)//判断是否有结果（即是否有语音输入）
            return true;
        return false;
    }

    public static boolean weather(StatusPerRobot spr)
    {
        boolean f_weather = false;
        for (int i = 0; i < spr.input.length()-1; i++)
        {
            String tmp = spr.input.substring(i,i+2);
//            for (String ii : Word.asWeatherAsk)
//                if (ii.equals(tmp))
//                    f_weather = true;
            if (Word.asWeatherAsk.contains(tmp))
                f_weather = true;
        }
        if (!f_weather)
            return false;

        spr.weather_city = "";//当前城市

        for (int i = 0; i < spr.input.length()-1; i++)
        {
            String tmp = spr.input.substring(i,i+2);
            for (int j = 0; j < Word.asWeatherTime.size(); j++)
            {
                if (Word.asWeatherTime.get(j).equals(tmp))
                {
                    switch(j)
                    {
                        case 0:
                            spr.weather_time = -2;
                            break;
                        case 1:
                            spr.weather_time = -1;
                            break;
                        case 2:
                        case 3:
                            spr.weather_time = 0;
                            break;
                        case 4:
                            spr.weather_time = 1;
                            break;
                        case 5:
                            spr.weather_time = 2;
                            break;
                    }
                    break;
                }
            }
        }
        for (int i = 0; i < spr.input.length(); i++)
        {
            for (int l = 2; l < 5; l++)
            {
                int b = Math.min(i+l, spr.input.length());
                String tmp = spr.input.substring(i,b);
                if (Word.asWeatherCity.contains(tmp))
                {
                    spr.weather_city=tmp;
                    break;
                }
            }
        }
        if(spr.weather_time==-3)
            return false;
        System.out.println(spr.weather_city+spr.weather_time);
        return true;
    }

    public static boolean translate(StatusPerRobot spr)
    {
        String s = "用英语怎么说";
        for (int i = 0; i < spr.input.length(); i++)
        {
            String tmp = spr.input.substring(i,spr.input.length());
            if (tmp.startsWith(s)) {
                spr.input = spr.input.substring(0, i);
                return true;
            }
        }
        return false;
    }

    public static int match(StatusPerRobot spr)
    {
        int type = Status.LOW_MATCH;
        Pair<Integer,Float> p;
        ArrayList<ArrayList<Integer>> result1 = new ArrayList<ArrayList<Integer>>();//歌、故事
        ArrayList<ArrayList<Integer>> result2 = new ArrayList<ArrayList<Integer>>();//问题

        ArrayList<ArrayList<Integer>> typeResult = SplitWords.GetSplitResult(spr.input, Word.asTypeSet, Word.aaiTypeIndex);//计算type
        if (typeResult.size() != 0)//可能含有类型
            type = TypeInference(typeResult);//区分是歌还是故事或问题或英语

        if (type == Status.RECOMMEND_SONG)//匹配歌
            result1 = SplitWords.GetSplitResult(spr.input, Word.asSongSet, Word.aaiSongIndex);
        else if(type == Status.RECOMMEND_STORY)//匹配故事
            result1 = SplitWords.GetSplitResult(spr.input, Word.asStorySet, Word.aaiStoryIndex);
        else if (type == Status.RECOMMEND_ENGLISH)
            return Status.RECOMMEND_ENGLISH;
//        else if (type == Status.LOW_MATCH)
//            type = Status.RECOMMEND_QUESTION;

        result2 = SplitWords.GetSplitResult(spr.input, Word.asQuestionSet, Word.aaiQuestionIndex);

        if (result1.size() == 0 && result2.size() == 0)//没有找到匹配内容
            return type;
        else if (type == Status.RECOMMEND_QUESTION)//匹配问题
        {
            p = GetAnswerIndex(result2);
            if (p.getValue() + 0.1 < Status.match_per)
                return Status.RECOMMEND_QUESTION;
            else
                return p.getKey();
        }
        else if (type == Status.LOW_MATCH)
        {
            p = GetAnswerIndex(result2);
            if (p.getValue() < Status.match_per)
                return Status.LOW_MATCH;
            else
                return p.getKey();
        }
        else
        {
            Pair<Integer,Float> p1 = GetAnswerIndex(result1);
            Pair<Integer,Float> p2 = GetAnswerIndex(result2);
            if (p1.getValue()+0.7 >= p2.getValue())
                p = p1;
            else
                p = p2;

            if (p.getValue()+0.31 < Status.match_per)//低匹配度，转为推荐
                return type;
            else
               return p.getKey();
        }
    }

    public static int getNLPResult(StatusPerRobot spr)
    {
        //判断是否有效
        if (silence(spr))
            return Status.SILENCE;

        if (spr.isSleep)
            //判断是否是唤醒
            if (beibei(spr) == Status.WAKE)
                return Status.WAKE;
            else
                return Status.SILENCE;

        //判断是否是让去睡觉
        if(sleep(spr) == Status.SLEEP)
            return Status.SLEEP;

        //判断是否是让翻译
        if (translate(spr))
            return Status.TRANSLATE;

        //判断是否是询问天气
        if (weather(spr))
            return Status.WEATHER;

        //判断是否是二次应答
        if (spr.waitNext)
            if (hasNo(spr))
                return Status.NO;
            else if (isOK(spr))
                return Status.OK;
            else
                return Status.NO;

        //判断是否是完整匹配
        return match(spr);
    }
}
