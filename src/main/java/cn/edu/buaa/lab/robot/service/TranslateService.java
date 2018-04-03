package cn.edu.buaa.lab.robot.service;

import cn.edu.buaa.lab.robot.common.util.HttpUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class TranslateService {

    @Value("${out.translateUrl}")
    private String outTranslateUrl;

    public String getChinese(String word) throws Exception {
        String url = outTranslateUrl + word;
        String result = HttpUtils.get(url);
        return  result;
    }
}
