package cn.edu.buaa.lab.robot.service;

import cn.edu.buaa.lab.robot.common.util.DateUtils;
import cn.edu.buaa.lab.robot.common.util.GsonUtils;
import cn.edu.buaa.lab.robot.common.util.HttpUtils;
import cn.edu.buaa.lab.robot.common.util.KedaVoiceUtils;
import cn.edu.buaa.lab.robot.model.WeatherModel;
import cn.edu.buaa.lab.robot.repository.WeatherRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


@Service
public class WeatherService {
    private static final Logger logger = LoggerFactory.getLogger("WeatherService");

    @Value("${out.weatherUrl}")
    private String outWeatherUrl;

    @Autowired
    private WeatherRepository weatherRepository;

    public String getWeatherByCity(String city) throws Exception {
        String url = outWeatherUrl + city;
        String result = HttpUtils.get(url);
        return  result;
    }

    /**
     *
     * @param date eg: 2018-05-08
     * @param city eg: 北京
     * @return
     * @throws Exception
     */
    public String getWeatherByDateAndCity(String date, String city) throws Exception {
        date = date.trim();
        city = city.trim();

        List<WeatherModel> wlist = weatherRepository.findAllByDeletedAndDateAndCity(0, date, city);
        if (null == wlist || wlist.isEmpty()) {
            wlist = weatherRepository.findAllByDeletedAndDateAndCityLike(0, date, city);
            if (null == wlist || wlist.isEmpty()) {
                String url = outWeatherUrl + city;
                String result = HttpUtils.get(url);

                // deal weather result
                System.out.println(result);

            }
        }
        return wlist.get(0).getResult();


//        String url = outWeatherUrl + city;
//        String result = HttpUtils.get(url);
//        return  result;
    }

    // {"data":{"yesterday":{"date":"9日星期三","high":"高温 25℃","fx":"东风","low":"低温 15℃","fl":"<![CDATA[<3级]]>","type":"晴"},"city":"苏州","aqi":"44","forecast":[{"date":"10日星期四","high":"高温 25℃","fengli":"<![CDATA[<3级]]>","low":"低温 15℃","fengxiang":"东风","type":"晴"},{"date":"11日星期五","high":"高温 24℃","fengli":"<![CDATA[3-4级]]>","low":"低温 17℃","fengxiang":"东南风","type":"多云"},{"date":"12日星期六","high":"高温 27℃","fengli":"<![CDATA[3-4级]]>","low":"低温 20℃","fengxiang":"东南风","type":"多云"},{"date":"13日星期天","high":"高温 29℃","fengli":"<![CDATA[3-4级]]>","low":"低温 22℃","fengxiang":"西南风","type":"雷阵雨"},{"date":"14日星期一","high":"高温 31℃","fengli":"<![CDATA[3-4级]]>","low":"低温 22℃","fengxiang":"北风","type":"多云"}],"ganmao":"各项气象条件适宜，无明显降温过程，发生感冒机率较低。","wendu":"14"},"status":1000,"desc":"OK"}
    // date: 2018-05-10; src: {"data":{"yesterday":{"date":"9日星期三","high":"高温 25℃","fx":"东风","low":"低温 15℃","fl":"<![CDATA[<3级]]>","type":"晴"},"city":"苏州","aqi":"44","forecast":[{"date":"10日星期四","high":"高温 25℃","fengli":"<![CDATA[<3级]]>","low":"低温 15℃","fengxiang":"东风","type":"晴"},{"date":"11日星期五","high":"高温 24℃","fengli":"<![CDATA[3-4级]]>","low":"低温 17℃","fengxiang":"东南风","type":"多云"},{"date":"12日星期六","high":"高温 27℃","fengli":"<![CDATA[3-4级]]>","low":"低温 20℃","fengxiang":"东南风","type":"多云"},{"date":"13日星期天","high":"高温 29℃","fengli":"<![CDATA[3-4级]]>","low":"低温 22℃","fengxiang":"西南风","type":"雷阵雨"},{"date":"14日星期一","high":"高温 31℃","fengli":"<![CDATA[3-4级]]>","low":"低温 22℃","fengxiang":"北风","type":"多云"}],"ganmao":"各项气象条件适宜，无明显降温过程，发生感冒机率较低。","wendu":"14"},"status":1000,"desc":"OK"}
    private void saveWeatherInfo(String date, String src) {
        Map weatherMap = toMap(src);
        if (null == weatherMap) {
            return;
        }


        String today = DateUtils.today();


//        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    private Map toMap(String src) {
        try {
            return GsonUtils.gToObject(src, Map.class);
        } catch (Exception e) {
            logger.error(src, e);
        }
        return null;
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
        KedaVoiceUtils.generateAndSave(input,"/weatherVoice/"+name);
        return "/weatherVoice/"+name;
    }
}
