package cn.edu.buaa.lab.robot.service;

import cn.edu.buaa.lab.robot.common.util.HttpUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class FileService {

    @Value("${out.weatherUrl}")
    private String outWeatherUrl;

    public String getWeatherByCity(String city) throws Exception {
        String url = outWeatherUrl + city;
        String result = HttpUtils.get(url);

        return  result;
    }
}
