package cn.edu.buaa.lab.robot.service;

import cn.edu.buaa.lab.robot.model.MusicModel;
import cn.edu.buaa.lab.robot.repository.MusicRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
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

    public Page<MusicModel> getList(String topic, Integer pageNo, Integer pageSize) {
        PageRequest pageRequest = new PageRequest(pageNo, pageSize);
        Page<MusicModel> muList = musicRepository.findAllByDeletedOrderByIdAsc(0, pageRequest);
        return muList;

//        List<MusicModel> mlist = musicRepository.findByDeleted(0);
//        Integer pn = Integer.parseInt(pageNo);
//        Integer ps = Integer.parseInt(pageSize);
//        Integer start = ps * (pn - 1);
//        Integer end = ps * pn - 1;
//        List<MusicModel> result = new ArrayList<MusicModel>();
//        for(int i = 0; i < pn; i++)
//        {
//            result.add(mlist.get(start+i));
//            if (mlist.size() == start+i+1)
//                break;
//        }
//        return result;
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
