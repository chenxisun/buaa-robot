package cn.edu.buaa.lab.robot.service;

import cn.edu.buaa.lab.robot.common.util.HttpUtils;
//import cn.edu.buaa.lab.robot.common.util.KedaVoiceUtils;
import cn.edu.buaa.lab.robot.common.util.KedaVoiceUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Random;


@Service
public class TranslateService {

    private static final Logger logger = LoggerFactory.getLogger("TranslateService");

    @Value("${out.translateUrl}")
    private String outTranslateUrl;

    public String getEnglish(String word) throws Exception {
        String url = outTranslateUrl + word;
        String result = HttpUtils.get(url);
        return  result;
    }

    public String getVoice(String input) throws Exception{
        String name = "";
        Random rand = new Random();
        while(name.length() < 16)
        {
            int tmp = rand.nextInt(10000);
            name+=String.valueOf(tmp);
        }
        name+=".pcm";
        KedaVoiceUtils.generateAndSave(input,"/translateVoice/"+name);
        return "/translateVoice/"+name;
    }
}
