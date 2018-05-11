package cn.edu.buaa.lab.robot.common.util.NLP;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Word {
    public static ArrayList<String> asTypeSet = null;
    public static ArrayList<ArrayList<Integer>> aaiTypeIndex = null;
    public static ArrayList<String> asQuestionSet = null;
    public static ArrayList<ArrayList<Integer>> aaiQuestionIndex = null;
    public static ArrayList<String> asStorySet = null;
    public static ArrayList<ArrayList<Integer>> aaiStoryIndex = null;
    public static ArrayList<String> asSongSet = null;
    public static ArrayList<ArrayList<Integer>> aaiSongIndex = null;
    public static ArrayList<Integer> aiCountSet = null;
    public static HashMap<Integer,String> mName = null;
    public static final Integer[] question_valid = {1,2,3,4,5,6,7,8,9,10,
            11,12,13,14,15,16,17,18,19,20,
            21,22,23,24,25,26,27,28,29,30,
            31,32,33,34,35,36,37,38,39,40,
            41,42,43,44,45,46,47,48,49,50,
            51,52,53,54,55,56,57,58,59,60,
            61,62,63,64,65,66,67,68,70,71,
            72,73,74,75,76,77,78,79,80,81,
            82,83,84,85,86,87,88,89,90,91,
            92,94,95,96,97,98,99,100,116,120,
            121,122,123,124,125,126,128,129,130,131,
            132,133,134,137,140,141,142,143,144,145,
            146,147,148,149,150,151,152,153,154,155,
            156,157,163,165,169,171,172,173,174,175,
            176,177,178,179};
    public static ArrayList<String> asWeatherAsk = null;
    public static ArrayList<String> asWeatherCity = null;
    public static ArrayList<String> asWeatherTime = null;

    private static void readIntoList(ArrayList<String> asQuestionSet, ArrayList<ArrayList<Integer>> aaiQuestionIndex,
                                     String sDicFileName, String sIndexFileName)
    {
        File fDic = new File(sDicFileName);
        File fIndex = new File(sIndexFileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fDic));
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                if (tempString.startsWith(String.valueOf('\uFEFF')))
                    tempString = tempString.substring(1,tempString.length());
                asQuestionSet.add(tempString);
            }
            reader.close();
            reader = new BufferedReader(new FileReader(fIndex));
            tempString = null;
            while ((tempString = reader.readLine()) != null) {
                String[] sQuestionIndex = tempString.split(",");
                ArrayList<Integer> aiQuestionIndex = new ArrayList<Integer>();
                for (String sTmp: sQuestionIndex)
                    aiQuestionIndex.add(Integer.parseInt(sTmp));
                aaiQuestionIndex.add(aiQuestionIndex);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }

        return;
    }

    private static void readIntoList(ArrayList<Integer> aiCountSet, String sCountFileName)
    {
        File fCount = new File(sCountFileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fCount));
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                aiCountSet.add(Integer.parseInt(tempString));
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }

        return;
    }

    private static void readIntoListS(ArrayList<String> as, String sCountFileName)
    {
        File fCount = new File(sCountFileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fCount));
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                if (tempString.startsWith(String.valueOf('\uFEFF')))
                    tempString = tempString.substring(1,tempString.length());
                as.add(tempString);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return;
    }

    private static void readIntoMap(HashMap<Integer,String> mName, String sMapFileName, int iStart)
    {
        File fmap = new File(sMapFileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fmap));
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                if (tempString.startsWith(String.valueOf('\uFEFF')))
                    tempString = tempString.substring(1,tempString.length());
                mName.put(iStart++, tempString);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }

        return;
    }

    public static void init()
    {
        asTypeSet = new ArrayList<String>();
        aaiTypeIndex = new ArrayList<ArrayList<Integer>>();
        asQuestionSet = new ArrayList<String>();
        aaiQuestionIndex = new ArrayList<ArrayList<Integer>>();
        asStorySet = new ArrayList<String>();
        aaiStoryIndex = new ArrayList<ArrayList<Integer>>();
        asSongSet = new ArrayList<String>();
        aaiSongIndex = new ArrayList<ArrayList<Integer>>();
        aiCountSet = new ArrayList<Integer>();
        asWeatherAsk = new ArrayList<String>();
        asWeatherCity = new ArrayList<String>();
        asWeatherTime = new ArrayList<String>();
        mName = new HashMap<Integer,String>();

        readIntoList(asTypeSet,aaiTypeIndex,"src/main/resources/txt/type.txt","src/main/resources/txt/type_index.txt");
        readIntoList(asQuestionSet,aaiQuestionIndex,"src/main/resources/txt/question.txt","src/main/resources/txt/question_index.txt");
        readIntoList(asStorySet,aaiStoryIndex,"src/main/resources/txt/story.txt","src/main/resources/txt/story_index.txt");
        readIntoList(asSongSet,aaiSongIndex,"src/main/resources/txt/song.txt","src/main/resources/txt/song_index.txt");
        readIntoList(aiCountSet, "src/main/resources/txt/count.txt");
        readIntoMap(mName,"src/main/resources/txt/question_name.txt",1);
        readIntoMap(mName,"src/main/resources/txt/song_name.txt",201);
        readIntoMap(mName,"src/main/resources/txt/story_name.txt",301);
        readIntoListS(asWeatherAsk,"src/main/resources/txt/weather_ask.txt");
        readIntoListS(asWeatherCity,"src/main/resources/txt/weather_city.txt");
        readIntoListS(asWeatherTime,"src/main/resources/txt/weather_time.txt");
//		System.out.println("word init.");
    }
}
