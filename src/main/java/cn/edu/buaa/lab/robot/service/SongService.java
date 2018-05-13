package cn.edu.buaa.lab.robot.service;

import cn.edu.buaa.lab.robot.model.MusicModel;
import cn.edu.buaa.lab.robot.repository.MusicRepository;
import cn.edu.buaa.lab.robot.repository.WeatherRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class SongService {
    private static final Logger logger = LoggerFactory.getLogger("SongService");

    @Autowired
    private MusicRepository musicRepository;

//    public ArrayList<String> getList(String topic) throws Exception {
//        if (topic.length() == 0)
//            return null;
//
//        ArrayList<String> topics = new ArrayList<String>();
//        // topic从数据库读取
//        topics.add("erge");
//        topics.add("qingyinyue");
//        return topics;
//    }

    public List<MusicModel> getList(String topic, String pageNo, String pageSize){
        List<MusicModel> mlist = musicRepository.findByDeleted(0);
        Integer pn = Integer.parseInt(pageNo);
        Integer ps = Integer.parseInt(pageSize);
        Integer start = ps * (pn - 1);
        Integer end = ps * pn - 1;
        List<MusicModel> result = new ArrayList<MusicModel>();
        for(int i = 0; i < pn; i++)
        {
            result.add(mlist.get(start+i));
            if (mlist.size() == start+i+1)
                break;
        }
        return result;
//        if (topic.length() == 0)
//            return null;
//        Integer pn = Integer.parseInt(pageNo);
//        Integer ps = Integer.parseInt(pageSize);
//        Integer start = ps * (pn - 1) + 1;
//        Integer end = ps * pn;
//
//        ArrayList<String> topics = new ArrayList<String>();
//        // topic从数据库读取
//        topics.add("erge");
//        topics.add("qingyinyue");
    }

    public MusicModel getMusicByIndex(int index)
    {
        return musicRepository.findByDeletedAndOldIndex(0,index).get(0);
    }

    public boolean checkVersion(String songVersion){
        //TODO:
        String curVersion = "1.0";

        return curVersion.equals(songVersion);
    }
}
