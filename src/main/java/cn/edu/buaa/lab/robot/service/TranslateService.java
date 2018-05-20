package cn.edu.buaa.lab.robot.service;

import cn.edu.buaa.lab.robot.common.util.HttpUtils;
//import cn.edu.buaa.lab.robot.common.util.KedaVoiceUtils;
import com.google.gson.Gson;
import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


@Service
public class TranslateService {

    private static final Logger logger = LoggerFactory.getLogger("TranslateService");

    @Value("${out.translateUrl}")
    private String outTranslateUrl;

    public String getEnglish(String word) throws Exception {
        String url = outTranslateUrl + word;
        String jsonString = HttpUtils.get(url);
        Gson gson = new Gson();
        Map<String, Object> map = new HashMap<String, Object>();
        map = gson.fromJson(jsonString, map.getClass());
        ArrayList<String> translation = (ArrayList<String>) map.get("translation");
        return  translation.get(0);
    }

//    public String getVoice(String input) throws Exception{
//        String name = "";
//        Random rand = new Random();
//        while(name.length() < 16)
//        {
//            int tmp = rand.nextInt(10000);
//            name+=String.valueOf(tmp);
//        }
//        name+=".pcm";
//
//        KedaVoiceUtils.generateAndSave(input,"/home/vsftp/smartbeibei/translateVoice/"+name);
//        return "/translateVoice/"+name;
//    }
}
