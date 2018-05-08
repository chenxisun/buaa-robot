package cn.edu.buaa.lab.robot.service;

import java.util.ArrayList;

public class SongService {
    public ArrayList<String> getList(String topic){
        if (topic.length() == 0)
            return null;

        ArrayList<String> topics = new ArrayList<String>();
        //TODO:
        // topic从数据库读取
        topics.add("erge");
        topics.add("qingyinyue");
        return topics;
    }

    public ArrayList<String> getList(String topic, String pageNo, String pageSize){
        if (topic.length() == 0)
            return null;
        Integer pn = Integer.parseInt(pageNo);
        Integer ps = Integer.parseInt(pageSize);
        Integer start = ps * (pn - 1) + 1;
        Integer end = ps * pn;

        ArrayList<String> topics = new ArrayList<String>();
        //TODO:
        // topic从数据库读取
        topics.add("erge");
        topics.add("qingyinyue");
        return topics;
    }

    public boolean checkVersion(String songVersion){
        //TODO:
        String curVersion = "";

        return curVersion.equals(songVersion);
    }
}
