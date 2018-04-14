package cn.edu.buaa.lab.robot.service;

import cn.edu.buaa.lab.robot.common.util.NLPUtils;
import cn.edu.buaa.lab.robot.common.util.Pair;
import cn.edu.buaa.lab.robot.model.WordModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MatchService {

    public Pair<Integer, Float> GetAnswerIndex(ArrayList<ArrayList<Integer>> aaiAnswer)
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
                    mif.put(aaiAnswer.get(i).get(j), 1.0f/ WordModel.aiCountSet.get(aaiAnswer.get(i).get(j)-1));
                }
                else
                {
                    mii.put(aaiAnswer.get(i).get(j), mii.get(aaiAnswer.get(i).get(j))+1);
                    mif.put(aaiAnswer.get(i).get(j),
                            mif.get(aaiAnswer.get(i).get(j))+1.0f/ WordModel.aiCountSet.get(aaiAnswer.get(i).get(j)-1));
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

    public int SongOrStory(ArrayList<ArrayList<Integer>> typeResult)
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
        if(i_question > i_song && i_question > i_story && i_question > i_english)
            return 1;
        if (i_song >= i_story && i_song >= i_english)
            return 2;
        if (i_english>=i_story)
            return 4;
        return 3;
    }

    public int Beibei()
    {
        //Log l = Log();
        String testLine = StatusService.input;

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
            StatusService.isSleep = false;
            StatusService.input = "";
            //l.WriteLog("#唤醒贝贝");
            return StatusService.WAKE;
        }
        StatusService.input = "";
        return -1;
    }

    public int sleep()
    {
        //Log l = Log();
        String testLine = StatusService.input;

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
            StatusService.isSleep = true;
            //l.WriteLog("#贝贝睡觉了");
            StatusService.input = "";
            //StatusService.notMatchTime = 3;
            return StatusService.SLEEP;
        }
        return -1;
    }

    public boolean hasNo()
    {
        ArrayList<String> bu = new ArrayList<String>();
        bu.add("不");
        bu.add("部");
        bu.add("步");
        bu.add("布");
        bu.add("换");

        int length1 = StatusService.input.length();
        int length2 = bu.size();
        boolean no = false;
        for(int i = 0; i < length1; i++)
        {
            for(int j = 0; j < length2; j++)
            {
                if (StatusService.input.charAt(i) == bu.get(i).charAt(0))
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

    public boolean isSilence()
    {
        if (StatusService.input.length() == 0)//判断是否有结果（即是否有语音输入）
            return true;
        return false;
    }

    public boolean weather()
    {
        boolean f_weather = false;
        for (int i = 0; i < StatusService.input.length()-1; i++)
        {
            String tmp = StatusService.input.substring(i,i+2);
            if (WordModel.asWeatherAsk.contains(tmp))
                f_weather = true;
        }
        if (!f_weather)
            return false;

        String city = StatusService.weather_city;//当前城市

        for (int i = 0; i < StatusService.input.length()-1; i++)
        {
            String tmp = StatusService.input.substring(i,i+2);
            for (int j = 0; j < WordModel.asWeatherTime.size(); j++)
            {
                if (WordModel.asWeatherTime.get(j).equals(tmp))
                {
                    switch(j)
                    {
                        case 0:
                            StatusService.weather_time = -2;
                            break;
                        case 1:
                            StatusService.weather_time = -1;
                            break;
                        case 2:
                        case 3:
                            StatusService.weather_time = 0;
                            break;
                        case 4:
                            StatusService.weather_time = 1;
                            break;
                        case 5:
                            StatusService.weather_time = 2;
                            break;
                    }
                    break;
                }
            }
        }
        for (int i = 0; i < StatusService.input.length(); i++)
        {
            for (int l = 2; l < 5; l++)
            {
                int b = Math.min(i+l, StatusService.input.length());
                String tmp = StatusService.input.substring(i,b);
                if (WordModel.asWeatherCity.contains(tmp))
                {
                    city=tmp;
                    break;
                }
            }
        }

        if(StatusService.weather_time==-3)
            return false;
        //System.out.println(city+time);
        return true;
    }

    public int isIntegrity(int type)
    {
        //进行匹配
        SplitWordsService sw = new SplitWordsService();
        Pair<Integer,Float> p;
        int answer = StatusService.LOW_MATCH;
        ArrayList<ArrayList<Integer>> result1 = new ArrayList<ArrayList<Integer>>();//歌故事
        ArrayList<ArrayList<Integer>> result2 = new ArrayList<ArrayList<Integer>>();//问题

        ArrayList<ArrayList<Integer>> typeResult = sw.GetSplitResult(StatusService.input, WordModel.asTypeSet, WordModel.aaiTypeIndex);//计算type
        if (typeResult.size() != 0)//归结为歌或故事或问题
            type = SongOrStory(typeResult);//区分是歌还是故事或问题

        if (type == 2)//匹配歌
            result1 = sw.GetSplitResult(StatusService.input, WordModel.asSongSet, WordModel.aaiSongIndex);
        else if(type == 3)//匹配故事
            result1 = sw.GetSplitResult(StatusService.input, WordModel.asStorySet, WordModel.aaiStoryIndex);
        else if (type == 4)
        {
            StatusService.recommend = StatusService.CHANGE_TO_ENGLISH;
            return StatusService.recommend;
        }
        result2 = sw.GetSplitResult(StatusService.input, WordModel.asQuestionSet, WordModel.aaiQuestionIndex);

        if (result1.size() == 0 && result2.size() == 0 && type == 0)//什么都不匹配，噪音
        {
            //StatusService.lowMatchTime++;
            answer = StatusService.LOW_MATCH;
        }
        else if (type <= 1)//匹配问题
        {
            p = GetAnswerIndex(result2);
            if (type == 0 && p.getValue() < StatusService.match_per)//没有关键词且，匹配率不足0.8
            {
                //StatusService.lowMatchTime++;
                answer = StatusService.LOW_MATCH;
            }
            else if (type == 1 && p.getValue() + 0.1 < StatusService.match_per)//出现关键词但匹配率不足0.5
            {
                answer = StatusService.RECOMMEND;
                StatusService.recommend = StatusService.RECOMMEND_QUESTION;
            }
            else
                answer = p.getKey();
        }
        else
        {
            Pair<Integer,Float> p1 = GetAnswerIndex(result1);
            Pair<Integer,Float> p2 = GetAnswerIndex(result2);
            if (p1.getValue()+0.7 >= p2.getValue())
                p = p1;
            else
                p = p2;

            if (p.getValue()+0.31 < StatusService.match_per)//低匹配度，转为推荐
            {
                if (type == 2)
                    StatusService.recommend = StatusService.RECOMMEND_SONG;
                else
                    StatusService.recommend = StatusService.RECOMMEND_STORY;
                answer = StatusService.RECOMMEND;
            }
            else
                answer = p.getKey();
        }
        return answer;
    }



//        public int match()
//        {
//            //Log l = new Log();
//            //String tmps = Status.input;
//            if (isSilence())
//            {
//                //l.WriteLog("#沉默");
//                return Status.SILENCE;
//            }
//            if(sleep() == Status.SILENCE)
//                return Status.SILENCE;
//
//            Status.notMatchTime = 0;
//            int lastType = Status.recommend;
//            int answer = isIntegrity(lastType);
//
//            if (answer > 0)//有完整性匹配
//            {
//                //l.WriteLog(tmps,answer);
//                return answer;
//            }
//
//            if (answer == Status.RECOMMEND)//不完整，但有状态
//            {
//                //检测有无状态转变
//                if (lastType == Status.recommend)//无状态转变
//                {
//                    if (Status.waitNext)//检测是否在回答问题
//                    {
//                        Status.waitNext = false;
//                        if (hasNo())//否定回答
//                        {
//                            //l.WriteLog(tmps,Status.NO);
//                            return Status.NO;
//                        }
//                        else//肯定回答
//                        {
//                            if (Status.recommendIndex > 0)//检测是否已经推荐
//                            {
//                                //l.WriteLog(tmps,Status.recommendIndex);
//                                return Status.recommendIndex;
//                            }
//                            else//同意推荐
//                            {
//                                //l.WriteLog(tmps,Status.OK);
//                                return Status.OK;
//                            }
//                        }
//                    }
//                    else//仍在这个状态中，继续下个随机，（先回答还得想一下）
//                    {
//                        //l.WriteLog(tmps,Status.LOW_MATCH_AND_RECOMMEND);
//                        return Status.LOW_MATCH_AND_RECOMMEND;
//                    }
//                }
//                else//有状态转变
//                {
//                    Recommend r = new Recommend();
//                    if(Status.recommend == Status.RECOMMEND_QUESTION)
//                    {
//                        //l.WriteLog(tmps,Status.CHANGE_TO_QUESTION);
//                        r.changeToQuestion();
//                        return Status.CHANGE_TO_QUESTION;
//                    }
//                    if (Status.recommend == Status.RECOMMEND_SONG)
//                    {
//                        //l.WriteLog(tmps,Status.CHANGE_TO_SONG);
//                        r.changeToSong();
//                        return Status.CHANGE_TO_SONG;
//                    }
//                    if (Status.recommend == Status.RECOMMEND_STORY)
//                    {
//                        //l.WriteLog(tmps,Status.CHANGE_TO_STORY);
//                        r.changeToStory();
//                        return Status.CHANGE_TO_STORY;
//                    }
//                    if (Status.recommend == Status.RECOMMEND_ENGLISH)
//                    {
//                        //l.WriteLog(tmps,Status.CHANGE_TO_STORY);
//                        return Status.CHANGE_TO_ENGLISH;
//                    }
//                }
//            }
//            else if (Status.waitNext)//不完整，且无状态 //检测是否在回答问题
//            {
//                Status.waitNext = false;
//                if (hasNo())//否定回答
//                {
//                    //l.WriteLog(tmps,Status.NO);
//                    return Status.NO;
//                }
//                else//肯定回答
//                {
//                    if (Status.recommendIndex > 0)//检测是否已经推荐
//                    {
//                        //l.WriteLog(tmps,Status.recommendIndex);
//                        return Status.recommendIndex;
//                    }
//                    else//同意推荐
//                    {
//                        //l.WriteLog(tmps,Status.OK);
//                        return Status.OK;
//                    }
//                }
//            }
//
//            //l.WriteLog(tmps,Status.LOW_MATCH);
//            return Status.LOW_MATCH;
//        }
}
