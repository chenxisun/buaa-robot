package cn.edu.buaa.lab.robot.service;

import java.util.ArrayList;

public class SongService {
    public ArrayList<String> getList(String topic){
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
