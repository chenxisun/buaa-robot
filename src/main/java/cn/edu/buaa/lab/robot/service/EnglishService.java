package cn.edu.buaa.lab.robot.service;

import cn.edu.buaa.lab.robot.common.util.HttpUtils;
import cn.edu.buaa.lab.robot.model.MusicEnglishModel;
import cn.edu.buaa.lab.robot.model.TopicModel;
import cn.edu.buaa.lab.robot.model.TopicWordModel;
import cn.edu.buaa.lab.robot.model.WeatherModel;
import cn.edu.buaa.lab.robot.repository.MusicEnglishRepository;
import cn.edu.buaa.lab.robot.repository.TopicRepository;
import cn.edu.buaa.lab.robot.repository.TopicWordRepository;
import cn.edu.buaa.lab.robot.repository.WeatherRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EnglishService {

    private static final Logger logger = LoggerFactory.getLogger("EnglishService");

    @Autowired
    private TopicRepository topicRepository;
    @Autowired
    private TopicWordRepository topicWordRepository;
    @Autowired
    private MusicEnglishRepository musicEnglishRepository;

    public List<TopicModel> getTopics() throws Exception {
        List<TopicModel> tlist = topicRepository.findAllByDeleted(0);
        return tlist;

//        Map<String,Map<String,String>> topics = new HashMap<String,Map<String,String>>();
//        //TODO:
//        Map<String,String> m1 = new HashMap<String,String>();
//        m1.put("imgURL","");
//        m1.put("total","100");
//        topics.put("food",m1);
//        Map<String,String> m2 = new HashMap<String,String>();
//        m2.put("imgURL","");
//        m2.put("total","100");
//        topics.put("car",m1);
    }

    public List<TopicWordModel> getWords(String topic) throws Exception {
        List<TopicWordModel> twlist = topicWordRepository.findAllByDeletedAndTopic(0,topic);
        return twlist;
    }

    public  List<TopicWordModel> getWords(String topic, String pageNo, String pageSize) throws Exception {
        List<TopicWordModel> twlist = topicWordRepository.findAllByDeletedAndTopic(0,topic);
        //TODO:好像不需要排序
        Integer pn = Integer.parseInt(pageNo);
        Integer ps = Integer.parseInt(pageSize);
        Integer start = ps * (pn - 1);
        Integer end = ps * pn - 1;

        List<TopicWordModel> result = new ArrayList<TopicWordModel>();
        for(int i = 0; i < pn; i++)
        {
            result.add(twlist.get(start+i));
            if (twlist.size() == start+i+1)
                break;
        }
        return result;
    }

    public List<MusicEnglishModel> getEnglishMusic() throws Exception{
        List<MusicEnglishModel> twlist = musicEnglishRepository.findByDeleted(0);
        return twlist;
    }

//    public Map<String, Map<String, Object>> getList(String topic){
//        if (topic.length() == 0)
//            return null;
//
//        Map<String, Map<String, Object>> result = new HashMap<>();
//        //TODO:
//        // 从数据库读取以下数据
//        Map<String, String> imgUrl = new HashMap<>();
//        imgUrl.put("img1", "");
//        imgUrl.put("img2", "");
//        imgUrl.put("img3", "");
//        Map<String, Object> a = new HashMap<>();
//        a.put("wordVoice", "englishVideo的path");
//        a.put("chineseIntroduction", "A的中文解释");
//        a.put("englishVoice", "englishVideo的path");
//        a.put("englishIntroduction", "A的英文解释");
//        a.put("chineseVoice", "chineseVideo的path");
//        a.put("imgUrl", imgUrl);
//        result.put("A",a);
//
//        Map<String, Object> b = new HashMap<>();
//        b.put("wordVoice", "englishVideo的path");
//        b.put("chineseIntroduction", "B的中文解释");
//        b.put("englishVoice", "englishVideo的path");
//        b.put("englishIntroduction", "B的英文解释");
//        b.put("chineseVoice", "chineseVideo的path");
//        b.put("imgUrl", imgUrl);
//        result.put("B",a);
//
//        return result;
//    }

//    public Map<String, Map<String, Object>> getList(String topic, String pageNo, String pageSize){
//        if (topic.length() == 0)
//            return null;
//        Integer pn = Integer.parseInt(pageNo);
//        Integer ps = Integer.parseInt(pageSize);
//        Integer start = ps * (pn - 1) + 1;
//        Integer end = ps * pn;
//
//        Map<String, Map<String, Object>> result = new HashMap<>();
//        //TODO:
//        // 从数据库读取以下数据
//        Map<String, String> imgUrl = new HashMap<>();
//        imgUrl.put("img1", "");
//        imgUrl.put("img2", "");
//        imgUrl.put("img3", "");
//        Map<String, Object> a = new HashMap<>();
//        a.put("wordVoice", "englishVideo的path");
//        a.put("chineseIntroduction", "A的中文解释");
//        a.put("englishVoice", "englishVideo的path");
//        a.put("englishIntroduction", "A的英文解释");
//        a.put("chineseVoice", "chineseVideo的path");
//        a.put("imgUrl", imgUrl);
//        result.put("A",a);
//
//        Map<String, Object> b = new HashMap<>();
//        b.put("wordVoice", "englishVideo的path");
//        b.put("chineseIntroduction", "B的中文解释");
//        b.put("englishVoice", "englishVideo的path");
//        b.put("englishIntroduction", "B的英文解释");
//        b.put("chineseVoice", "chineseVideo的path");
//        b.put("imgUrl", imgUrl);
//        result.put("B",a);
//
//        return result;
//    }

}
