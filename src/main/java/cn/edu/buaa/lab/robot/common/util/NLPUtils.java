package cn.edu.buaa.lab.robot.common.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class NLPUtils {

//    public static class Word {
//        public static ArrayList<String> asTypeSet = null;
//        public static ArrayList<ArrayList<Integer>> aaiTypeIndex = null;
//        public static ArrayList<String> asQuestionSet = null;
//        public static ArrayList<ArrayList<Integer>> aaiQuestionIndex = null;
//        public static ArrayList<String> asStorySet = null;
//        public static ArrayList<ArrayList<Integer>> aaiStoryIndex = null;
//        public static ArrayList<String> asSongSet = null;
//        public static ArrayList<ArrayList<Integer>> aaiSongIndex = null;
//        public static ArrayList<Integer> aiCountSet = null;
//        public static HashMap<Integer,String> mName = null;
//        public static final Integer[] question_valid = {1,2,3,4,5,6,7,8,9,10,
//                11,12,13,14,15,16,17,18,19,20,
//                21,22,23,24,25,26,27,28,29,30,
//                31,32,33,34,35,36,37,38,39,40,
//                41,42,43,44,45,46,47,48,49,50,
//                51,52,53,54,55,56,57,58,59,60,
//                61,62,63,64,65,66,67,68,70,71,
//                72,73,74,75,76,77,78,79,80,81,
//                82,83,84,85,86,87,88,89,90,91,
//                92,94,95,96,97,98,99,100,116,120,
//                121,122,123,124,125,126,128,129,130,131,
//                132,133,134,137,140,141,142,143,144,145,
//                146,147,148,149,150,151,152,153,154,155,
//                156,157,163,165,169,171,172,173,174,175,
//                176,177,178,179};
//        public static ArrayList<String> asWeatherAsk = null;
//        public static ArrayList<String> asWeatherCity = null;
//        public static ArrayList<String> asWeatherTime = null;
//
//        private static void readIntoList(ArrayList<String> asQuestionSet, ArrayList<ArrayList<Integer>> aaiQuestionIndex,
//                                         String sDicFileName, String sIndexFileName)
//        {
//            File fDic = new File(sDicFileName);
//            File fIndex = new File(sIndexFileName);
//            BufferedReader reader = null;
//            try {
//                reader = new BufferedReader(new FileReader(fDic));
//                String tempString = null;
//                while ((tempString = reader.readLine()) != null) {
//                    asQuestionSet.add(tempString);
//                }
//                reader.close();
//                reader = new BufferedReader(new FileReader(fIndex));
//                tempString = null;
//                while ((tempString = reader.readLine()) != null) {
//                    String[] sQuestionIndex = tempString.split(",");
//                    ArrayList<Integer> aiQuestionIndex = new ArrayList<Integer>();
//                    for (String sTmp: sQuestionIndex)
//                        aiQuestionIndex.add(Integer.parseInt(sTmp));
//                    aaiQuestionIndex.add(aiQuestionIndex);
//                }
//                reader.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            } finally {
//                if (reader != null) {
//                    try {
//                        reader.close();
//                    } catch (IOException e1) {
//                    }
//                }
//            }
//
//            return;
//        }
//
//        private static void readIntoList(ArrayList<Integer> aiCountSet, String sCountFileName)
//        {
//            File fCount = new File(sCountFileName);
//            BufferedReader reader = null;
//            try {
//                reader = new BufferedReader(new FileReader(fCount));
//                String tempString = null;
//                while ((tempString = reader.readLine()) != null) {
//                    aiCountSet.add(Integer.parseInt(tempString));
//                }
//                reader.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            } finally {
//                if (reader != null) {
//                    try {
//                        reader.close();
//                    } catch (IOException e1) {
//                    }
//                }
//            }
//
//            return;
//        }
//
//        private static void readIntoListS(ArrayList<String> as, String sCountFileName)
//        {
//            File fCount = new File(sCountFileName);
//            BufferedReader reader = null;
//            try {
//                reader = new BufferedReader(new FileReader(fCount));
//                String tempString = null;
//                while ((tempString = reader.readLine()) != null) {
//                    as.add(tempString);
//                }
//                reader.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            } finally {
//                if (reader != null) {
//                    try {
//                        reader.close();
//                    } catch (IOException e1) {
//                    }
//                }
//            }
//            return;
//        }
//
//        private static void readIntoMap(HashMap<Integer,String> mName, String sMapFileName, int iStart)
//        {
//            File fmap = new File(sMapFileName);
//            BufferedReader reader = null;
//            try {
//                reader = new BufferedReader(new FileReader(fmap));
//                String tempString = null;
//                while ((tempString = reader.readLine()) != null) {
//                    mName.put(iStart++, tempString);
//                }
//                reader.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            } finally {
//                if (reader != null) {
//                    try {
//                        reader.close();
//                    } catch (IOException e1) {
//                    }
//                }
//            }
//
//            return;
//        }
//
//        public static void init()
//        {
//            asTypeSet = new ArrayList<String>();
//            aaiTypeIndex = new ArrayList<ArrayList<Integer>>();
//            asQuestionSet = new ArrayList<String>();
//            aaiQuestionIndex = new ArrayList<ArrayList<Integer>>();
//            asStorySet = new ArrayList<String>();
//            aaiStoryIndex = new ArrayList<ArrayList<Integer>>();
//            asSongSet = new ArrayList<String>();
//            aaiSongIndex = new ArrayList<ArrayList<Integer>>();
//            aiCountSet = new ArrayList<Integer>();
//            asWeatherAsk = new ArrayList<String>();
//            asWeatherCity = new ArrayList<String>();
//            asWeatherTime = new ArrayList<String>();
//            mName = new HashMap<Integer,String>();
//
//            readIntoList(asTypeSet,aaiTypeIndex,"src/main/resources/txt/type.txt","src/main/resources/txt/type_index.txt");
//            readIntoList(asQuestionSet,aaiQuestionIndex,"src/main/resources/txt/question.txt","src/main/resources/txt/question_index.txt");
//            readIntoList(asStorySet,aaiStoryIndex,"src/main/resources/txt/story.txt","src/main/resources/txt/story_index.txt");
//            readIntoList(asSongSet,aaiSongIndex,"src/main/resources/txt/song.txt","src/main/resources/txt/song_index.txt");
//            readIntoList(aiCountSet, "src/main/resources/txt/count.txt");
//            readIntoMap(mName,"src/main/resources/txt/question_name.txt",1);
//            readIntoMap(mName,"src/main/resources/txt/song_name.txt",201);
//            readIntoMap(mName,"src/main/resources/txt/story_name.txt",301);
//            readIntoListS(asWeatherAsk,"src/main/resources/txt/weather_ask.txt");
//            readIntoListS(asWeatherCity,"src/main/resources/txt/weather_city.txt");
//            readIntoListS(asWeatherTime,"src/main/resources/txt/weather_time.txt");
////		System.out.println("word init.");
//        }
//
//    }

//    public static class Status {
//
//        public static boolean isSleep = false;
//        public static boolean isGetResult = false;
//        public static char rsn = '0';
//        public static int notMatchTime = 0;
//        public static int lowMatchTime = 0;
//        public static String input = "";
//        public static final float match_per = 0.8f;
//        public static boolean waitNext = false;
//        public static int recommendIndex = -1;
//        public static int recommend = 0;
//        public static final int RECOMMEND_QUESTION = 1;
//        public static final int RECOMMEND_SONG = 2;
//        public static final int RECOMMEND_STORY = 3;
//        public static final int RECOMMEND_ENGLISH = 4;
//        public static final int SILENCE = -1;
//        public static final int LOW_MATCH = -2;
//        public static final int RECOMMEND = -3;
//        public static final int NO = -4;
//        public static final int OK = -5;
//        public static final int LOW_MATCH_AND_RECOMMEND = -6;
//        public static final int CHANGE_TO_QUESTION = -11;
//        public static final int CHANGE_TO_SONG = -12;
//        public static final int CHANGE_TO_STORY = -13;
//        public static final int CHANGE_TO_ENGLISH = -14;
//        public static String weather_city = "";
//        public static String weather_time = "";
//
//        public void resetAll() {
//            isGetResult = false;
//            notMatchTime = 0;
//            lowMatchTime = 0;
//            input = "";
//            waitNext = false;
//            recommendIndex = -1;
//        }
//
//        public void reset() {
//            isGetResult = false;
//            input = "";
//            notMatchTime = 0;
//            lowMatchTime = 0;
//            recommendIndex = -1;
//        }
//
//    }

//    public static class Match {
//
//        public Pair<Integer, Float> GetAnswerIndex(ArrayList<ArrayList<Integer>> aaiAnswer)
//        {
//            HashMap<Integer, Integer> mii = new HashMap<Integer, Integer>();
//            HashMap<Integer, Float> mif = new HashMap<Integer, Float>();
//
//            for (int i = 0; i < aaiAnswer.size(); i++)
//            {
//                for (int j = 0; j < aaiAnswer.get(i).size(); j++)
//                {
//                    if (!mii.containsKey(aaiAnswer.get(i).get(j)))
//                    {
//                        mii.put(aaiAnswer.get(i).get(j), 1);
//                        mif.put(aaiAnswer.get(i).get(j), 1.0f/Word.aiCountSet.get(aaiAnswer.get(i).get(j)-1));
//                    }
//                    else
//                    {
//                        mii.put(aaiAnswer.get(i).get(j), mii.get(aaiAnswer.get(i).get(j))+1);
//                        mif.put(aaiAnswer.get(i).get(j),
//                                mif.get(aaiAnswer.get(i).get(j))+1.0f/Word.aiCountSet.get(aaiAnswer.get(i).get(j)-1));
//                    }
//                }
//            }
//            float max = 0.0f;
//            int max_index = 0;
//            Set<Entry<Integer, Float>> sets = mif.entrySet();
//            for (Entry<Integer, Float> p : sets)
//            {
//                if (Math.abs(p.getValue() - max) < 0.01 && mii.get(p.getKey()) > mii.get(max_index))//比例相同时，比较出现次数
//                {
//                    max = p.getValue();
//                    max_index = p.getKey();
//                    continue;
//                }
//                if (p.getValue() > max)
//                {
//                    max = p.getValue();
//                    max_index = p.getKey();
//                }
//            }
//            return new Pair<Integer,Float>(max_index, max);
//        }
//
//        public int SongOrStory(ArrayList<ArrayList<Integer>> typeResult)
//        {
//            int i_song = 0;
//            int i_story = 0;
//            int i_question = 0;
//            int i_english = 0;
//            for(ArrayList<Integer> v : typeResult)
//            {
//                switch (v.get(0))
//                {
//                    case -1:
//                        i_song ++;
//                        break;
//                    case -2:
//                        i_song += 3;
//                        break;
//                    case -3:
//                        i_song += 2;
//                        break;
//                    case -4:
//                        i_story +=3;
//                        break;
//                    case -5:
//                        i_story ++;
//                        break;
//                    case -6:
//                    case -7:
//                    case -8:
//                        i_question++;
//                        break;
//                    case -9:
//                        i_english++;
//                        break;
//                    case -10:
//                        i_english+=3;
//                    default:
//                        break;
//                }
//            }
//            if(i_question > i_song && i_question > i_story && i_question > i_english)
//                return 1;
//            if (i_song >= i_story && i_song >= i_english)
//                return 2;
//            if (i_english>=i_story)
//                return 4;
//            return 3;
//        }
//
//
//        public boolean Beibei()
//        {
//            //Log l = Log();
//            String testLine = Status.input;
//
//            ArrayList<String> xiao = new ArrayList<String>();
//            xiao.add("贝");
//            xiao.add("妹");
//            xiao.add("背");
//            xiao.add("呗");
//            ArrayList<String> tong = new ArrayList<String>();
//            tong.add("贝");
//            tong.add("妹");
//            tong.add("背");
//            tong.add("呗");
//
//            int length1 = testLine.length();
//            int length2 = xiao.size();
//            int length3 = tong.size();
//            boolean flag = false;
//            for(int i = 0; i < length1-1; i++)
//            {
//                for(int j = 0; j < length2; j++)
//                {
//                    if (testLine.charAt(i) == xiao.get(j).charAt(0))
//                    {
//                        for(int k = 0; k < length3; k++ )
//                        {
//                            if(testLine.charAt(i+1) == tong.get(k).charAt(0))
//                            {
//                                flag = true;
//                                break;
//                            }
//                        }
//                    }
//                    if (flag)
//                        break;
//                }
//                if (flag)
//                    break;
//            }
//            if (flag)
//            {
//                Status.isSleep = false;
//                //l.WriteLog("#唤醒贝贝");
//            }
//            Status.input = "";
//            return !Status.isSleep;
//        }
//
//        public int sleep()
//        {
//            //Log l = Log();
//            String testLine = Status.input;
//
//            String s_sleep = "你去睡觉";
//
//            int length1 = testLine.length();
//            int length2 = s_sleep.length();
//            boolean flag = false;
//            for(int i = 0; i <= length1-length2; i++)
//            {
//                String s = testLine.substring(i,length2+i);
//                if(s.equals(s_sleep))
//                {
//                    flag = true;
//                    break;
//                }
//            }
//            if (flag)
//            {
//                Status.isSleep = true;
//                //l.WriteLog("#贝贝睡觉了");
//                Status.input = "";
//                Status.notMatchTime = 3;
//                return Status.SILENCE;
//            }
//            return 0;
//        }
//
//        public boolean hasNo(){
//            ArrayList<String> bu = new ArrayList<String>();
//            bu.add("不");
//            bu.add("部");
//            bu.add("步");
//            bu.add("布");
//            bu.add("换");
//
//            int length1 = Status.input.length();
//            int length2 = bu.size();
//            boolean no = false;
//            for(int i = 0; i < length1; i++)
//            {
//                for(int j = 0; j < length2; j++)
//                {
//                    if (Status.input.charAt(i) == bu.get(i).charAt(0))
//                    {
//                        no = true;
//                        break;
//                    }
//                }
//                if (no)
//                    break;
//            }
//            return no;
//        }
//
//        public boolean isSilence()
//        {
//            if (Status.isGetResult == false)//判断是否有结果（即是否有语音输入）
//            {
//                Status.notMatchTime++;
//                return true;
//            }
//            Status.isGetResult = false;
//            return false;
//        }
//
//        public int isIntegrity(int type)
//        {
//            //进行匹配
//            SplitWords sw = new SplitWords();
//            Pair<Integer,Float> p;
//            int answer = Status.LOW_MATCH;
//            ArrayList<ArrayList<Integer>> result1 = new ArrayList<ArrayList<Integer>>();//歌故事
//            ArrayList<ArrayList<Integer>> result2 = new ArrayList<ArrayList<Integer>>();//问题
//
//            ArrayList<ArrayList<Integer>> typeResult = sw.GetSplitResult(Status.input, Word.asTypeSet, Word.aaiTypeIndex);//计算type
//            if (typeResult.size() != 0)//归结为歌或故事或问题
//                type = SongOrStory(typeResult);//区分是歌还是故事或问题
//
//            if (type == 2)//匹配歌
//                result1 = sw.GetSplitResult(Status.input, Word.asSongSet, Word.aaiSongIndex);
//            else if(type == 3)//匹配故事
//                result1 = sw.GetSplitResult(Status.input, Word.asStorySet, Word.aaiStoryIndex);
//            else if (type == 4)
//            {
//                Status.recommend = Status.CHANGE_TO_ENGLISH;
//                return Status.recommend;
//            }
//            result2 = sw.GetSplitResult(Status.input, Word.asQuestionSet, Word.aaiQuestionIndex);
//
//            if (result1.size() == 0 && result2.size() == 0 && type == 0)//什么都不匹配，噪音
//            {
//                Status.lowMatchTime++;
//                answer = Status.LOW_MATCH;
//            }
//            else if (type <= 1)//匹配问题
//            {
//                p = GetAnswerIndex(result2);
//                if (type == 0 && p.getValue() < Status.match_per)//没有关键词且，匹配率不足0.8
//                {
//                    Status.lowMatchTime++;
//                    answer = Status.LOW_MATCH;
//                }
//                else if (type == 1 && p.getValue() + 0.1 < Status.match_per)//出现关键词但匹配率不足0.5
//                {
//                    answer = Status.RECOMMEND;
//                    Status.recommend = Status.RECOMMEND_QUESTION;
//                }
//                else
//                    answer = p.getKey();
//            }
//            else
//            {
//                Pair<Integer,Float> p1 = GetAnswerIndex(result1);
//                Pair<Integer,Float> p2 = GetAnswerIndex(result2);
//                if (p1.getValue()+0.7 >= p2.getValue())
//                    p = p1;
//                else
//                    p = p2;
//
//                if (p.getValue()+0.31 < Status.match_per)//低匹配度，转为推荐
//                {
//                    if (type == 2)
//                        Status.recommend = Status.RECOMMEND_SONG;
//                    else
//                        Status.recommend = Status.RECOMMEND_STORY;
//                    answer = Status.RECOMMEND;
//                }
//                else
//                    answer = p.getKey();
//            }
//            return answer;
//        }
//
//        public boolean weather()
//        {
//            boolean f_weather = false;
//            for (int i = 0; i < Status.input.length()-1;i++)
//            {
//                String tmp = Status.input.substring(i,i+2);
//                if (Word.asWeatherAsk.contains(tmp))
//                {
//                    f_weather = true;
//                }
//            }
//            if (!f_weather)
//                return false;
//            int time = 0;
//            String city = "当前城市";//当前城市
//
//            for (int i = 0; i < Status.input.length()-1;i++)
//            {
//                String tmp = Status.input.substring(i,i+2);
//                for (int j = 0; j < Word.asWeatherTime.size(); j++)
//                {
//                    if (Word.asWeatherTime.get(j).equals(tmp))
//                    {
//                        switch(j)
//                        {
//                            case 0:
//                                time = -2;
//                                break;
//                            case 1:
//                                time = -1;
//                                break;
//                            case 2:
//                            case 3:
//                                time = 0;
//                                break;
//                            case 4:
//                                time = 1;
//                                break;
//                            case 5:
//                                time = 2;
//                                break;
//                        }
//                        break;
//                    }
//                }
//            }
//            for (int i = 0; i < Status.input.length();i++)
//            {
//                for (int l = 2; l < 5; l++)
//                {
//                    int b = Math.min(i+l,Status.input.length());
//                    String tmp = Status.input.substring(i,b);
//                    if (Word.asWeatherCity.contains(tmp))
//                    {
//                        city=tmp;
//                        break;
//                    }
//                }
//            }
//            System.out.println(city+time);
//            return false;
//        }
//
////        public int match()
////        {
////            //Log l = new Log();
////            //String tmps = Status.input;
////            if (isSilence())
////            {
////                //l.WriteLog("#沉默");
////                return Status.SILENCE;
////            }
////            if(sleep() == Status.SILENCE)
////                return Status.SILENCE;
////
////            Status.notMatchTime = 0;
////            int lastType = Status.recommend;
////            int answer = isIntegrity(lastType);
////
////            if (answer > 0)//有完整性匹配
////            {
////                //l.WriteLog(tmps,answer);
////                return answer;
////            }
////
////            if (answer == Status.RECOMMEND)//不完整，但有状态
////            {
////                //检测有无状态转变
////                if (lastType == Status.recommend)//无状态转变
////                {
////                    if (Status.waitNext)//检测是否在回答问题
////                    {
////                        Status.waitNext = false;
////                        if (hasNo())//否定回答
////                        {
////                            //l.WriteLog(tmps,Status.NO);
////                            return Status.NO;
////                        }
////                        else//肯定回答
////                        {
////                            if (Status.recommendIndex > 0)//检测是否已经推荐
////                            {
////                                //l.WriteLog(tmps,Status.recommendIndex);
////                                return Status.recommendIndex;
////                            }
////                            else//同意推荐
////                            {
////                                //l.WriteLog(tmps,Status.OK);
////                                return Status.OK;
////                            }
////                        }
////                    }
////                    else//仍在这个状态中，继续下个随机，（先回答还得想一下）
////                    {
////                        //l.WriteLog(tmps,Status.LOW_MATCH_AND_RECOMMEND);
////                        return Status.LOW_MATCH_AND_RECOMMEND;
////                    }
////                }
////                else//有状态转变
////                {
////                    Recommend r = new Recommend();
////                    if(Status.recommend == Status.RECOMMEND_QUESTION)
////                    {
////                        //l.WriteLog(tmps,Status.CHANGE_TO_QUESTION);
////                        r.changeToQuestion();
////                        return Status.CHANGE_TO_QUESTION;
////                    }
////                    if (Status.recommend == Status.RECOMMEND_SONG)
////                    {
////                        //l.WriteLog(tmps,Status.CHANGE_TO_SONG);
////                        r.changeToSong();
////                        return Status.CHANGE_TO_SONG;
////                    }
////                    if (Status.recommend == Status.RECOMMEND_STORY)
////                    {
////                        //l.WriteLog(tmps,Status.CHANGE_TO_STORY);
////                        r.changeToStory();
////                        return Status.CHANGE_TO_STORY;
////                    }
////                    if (Status.recommend == Status.RECOMMEND_ENGLISH)
////                    {
////                        //l.WriteLog(tmps,Status.CHANGE_TO_STORY);
////                        return Status.CHANGE_TO_ENGLISH;
////                    }
////                }
////            }
////            else if (Status.waitNext)//不完整，且无状态 //检测是否在回答问题
////            {
////                Status.waitNext = false;
////                if (hasNo())//否定回答
////                {
////                    //l.WriteLog(tmps,Status.NO);
////                    return Status.NO;
////                }
////                else//肯定回答
////                {
////                    if (Status.recommendIndex > 0)//检测是否已经推荐
////                    {
////                        //l.WriteLog(tmps,Status.recommendIndex);
////                        return Status.recommendIndex;
////                    }
////                    else//同意推荐
////                    {
////                        //l.WriteLog(tmps,Status.OK);
////                        return Status.OK;
////                    }
////                }
////            }
////
////            //l.WriteLog(tmps,Status.LOW_MATCH);
////            return Status.LOW_MATCH;
////        }
//
//    }

//    public static class SplitWords {
//        private String RemoveEnglishSymbol(String s)
//        {
//            String r = "";
//            for (int i = 0; i < s.length(); i++)
//            {
//                char c = s.charAt(i);
//                if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')
//                        || c == '.' || c == ',' || c == '?' || c == '!' || c == ' ')
//                    continue;
//                else
//                    r+=c;
//            }
//            return r;
//        }
//
//        public ArrayList<ArrayList<Integer>> GetSplitResult(String sInputLine, ArrayList<String> asSet, ArrayList<ArrayList<Integer>> aaiIndex)
//        {
//            sInputLine = RemoveEnglishSymbol(sInputLine);//去掉数字
//
//            final int maxlength = 6;
//            ArrayList<ArrayList<Integer>> aaiResult = new ArrayList<ArrayList<Integer>>();
//            ArrayList<String> asRecord = new ArrayList<String>();     //去重
//            int len = 0;            		//已解析分词的总长度
//            int i = sInputLine.length() - maxlength; //用来获取字字符串的偏移量
//
//            while (true)
//            {
//                String sWord;
//                int j = 0;
//                if (i < 0)                //如果i小于0，则读取的字符串的长度是小于maxlength的
//                    sWord = sInputLine.substring(0, maxlength + i);
//                else
//                    sWord = sInputLine.substring(i, maxlength + i);  //读取这一行从i开始的长度为maxlength的子字字符串
//
//                for (; j < sWord.length(); j++)
//                {
//                    String sCharacter = sWord.substring(j);//求得这个子字符串的字符串
//                    if (asSet.contains(sCharacter))
//                    {
//                        if (asRecord.contains(sCharacter))
//                            continue;
//                        asRecord.add(sCharacter);
//                        aaiResult.add(aaiIndex.get(asSet.indexOf(sCharacter)));
//                        len += sCharacter.length();
//                        i -= sCharacter.length();
//                        break;
//                    }
//                    if (sCharacter.length() == 1)
//                    {
//                        len += 1;
//                        i -= 1;
//                        break;
//                    }
//                }
//                if (len == sInputLine.length())           //如果这一行的分词长度等于这行字符串的长度，则这一行分词结束.跳出这个循环，进行下一行的分词
//                    break;
//            }
//            return aaiResult;
//        }
//
//    }

//    public static class Recommend {
//        public void changeToQuestion() {
//            Random random = new Random();
//            Status.recommendIndex = Word.question_valid[random.nextInt() % 144];
//            String answer_str = Word.mName.get(Status.recommendIndex);
//            String ss = "我给你讲" + answer_str + "吧，好不好？";
//            KedaVoiceUtils kv = new KedaVoiceUtils();
//            kv.generateAndSave(ss,"tts_test.pcm");
//            //TODO:
//            //地址
//        }
//
//        public void changeToSong() {
//            Random random = new Random();
//            Status.recommendIndex = random.nextInt() % 100 + 201;
//            String answer_str = Word.mName.get(Status.recommendIndex);
//            String ss = "我给你唱" + answer_str + "吧，好不好？";
//            KedaVoiceUtils kv = new KedaVoiceUtils();
//            kv.generateAndSave(ss,"tts_test.pcm");
//            //TODO:
//            //地址
//        }
//
//        public void changeToStory() {
//            Random random = new Random();
//            Status.recommendIndex = random.nextInt() % 100 + 301;
//            String answer_str = Word.mName.get(Status.recommendIndex);
//            String ss = "我给你讲" + answer_str + "的故事吧，好不好？";
//            KedaVoiceUtils kv = new KedaVoiceUtils();
//            kv.generateAndSave(ss,"tts_test.pcm");
//            //TODO:
//            //地址
//        }
//    }

//    public static void main(String[] args) {
//        Match m = new Match();
//        SplitWords sw = new SplitWords();
//        if (Word.asStorySet == null)
//            Word.init();
//        ArrayList<ArrayList<Integer>> asTmp = sw.GetSplitResult("魔术师和老鼠",Word.asStorySet,Word.aaiStoryIndex);
//        Pair<Integer, Float> hm = m.GetAnswerIndex(asTmp);
//        System.out.println(hm.toString());
//
//        Status.input = "贝贝";
//        Status.isSleep = true;
//        System.out.println(m.Beibei());
//
//        Status.isSleep = false;
//        Status.isGetResult = true;
//        Status.input = "请讲白雪公主的故事";
//        System.out.println(m.match()+","+Status.recommend);
//
//        Status.input = "呼和浩特后天..0？多少度";
//        m.weather();
//        return;
//    }

}
