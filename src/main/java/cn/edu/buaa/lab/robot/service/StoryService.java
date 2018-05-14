package cn.edu.buaa.lab.robot.service;

import cn.edu.buaa.lab.robot.model.MusicModel;
import cn.edu.buaa.lab.robot.model.StoryModel;
import cn.edu.buaa.lab.robot.repository.MusicRepository;
import cn.edu.buaa.lab.robot.repository.StoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class StoryService {
    private static final Logger logger = LoggerFactory.getLogger("StoryService");

    @Autowired
    private StoryRepository storyRepository;

    public List<StoryModel> getList(String topic,String pageNo, String pageSize){
        List<StoryModel> slist = storyRepository.findByDeleted(0);
        Integer pn = Integer.parseInt(pageNo);
        Integer ps = Integer.parseInt(pageSize);
        Integer start = ps * (pn - 1);
        Integer end = ps * pn - 1;
        List<StoryModel> result = new ArrayList<StoryModel>();
        for(int i = 0; i < pn; i++)
        {
            result.add(slist.get(start+i));
            if (slist.size() == start+i+1)
                break;
        }
        return result;
    }

    public StoryModel getStoryByIndex(int index)
    {
        return storyRepository.findByDeletedAndOldIndex(0,index).get(0);
    }

    public boolean checkVersion(String songVersion){
        String curVersion = "1.0";
        return curVersion.equals(songVersion);
    }
}
