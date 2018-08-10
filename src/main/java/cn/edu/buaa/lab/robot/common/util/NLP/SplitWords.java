package cn.edu.buaa.lab.robot.common.util.NLP;

import java.util.ArrayList;

public class SplitWords {
    private static String RemoveEnglishSymbol(String s)
    {
        String r = "";
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')
                    || c == '.' || c == ',' || c == '?' || c == '!' || c == ' ')
                continue;
            else
                r+=c;
        }
        return r;
    }

    public static ArrayList<ArrayList<Integer>> GetSplitResult(String sInputLine, ArrayList<String> asSet, ArrayList<ArrayList<Integer>> aaiIndex)
    {
        sInputLine = RemoveEnglishSymbol(sInputLine);//去掉数字

        final int maxlength = 6;
        ArrayList<ArrayList<Integer>> aaiResult = new ArrayList<ArrayList<Integer>>();
        ArrayList<String> asRecord = new ArrayList<String>();     //去重
        int len = 0;            		//已解析分词的总长度
        int i = sInputLine.length() - maxlength; //用来获取字字符串的偏移量

        while (true)
        {
            String sWord;
            int j = 0;
            if (i < 0)                //如果i小于0，则读取的字符串的长度是小于maxlength的
                sWord = sInputLine.substring(0, maxlength + i);
            else
                sWord = sInputLine.substring(i, maxlength + i);  //读取这一行从i开始的长度为maxlength的子字字符串

            for (; j < sWord.length(); j++)
            {
                String sCharacter = sWord.substring(j);//求得这个子字符串的字符串
                if (asSet.contains(sCharacter) && !asRecord.contains(sCharacter))
                {
                    asRecord.add(sCharacter);
                    aaiResult.add(aaiIndex.get(asSet.indexOf(sCharacter)));
                    len += sCharacter.length();
                    i -= sCharacter.length();
                    break;
                }
                if (sCharacter.length() == 1)
                {
                    len += 1;
                    i -= 1;
                    break;
                }
            }
            if (len == sInputLine.length())           //如果这一行的分词长度等于这行字符串的长度，则这一行分词结束.跳出这个循环，进行下一行的分词
                break;
        }
        return aaiResult;
    }
}
