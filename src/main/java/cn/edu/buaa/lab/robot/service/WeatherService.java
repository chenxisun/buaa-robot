package cn.edu.buaa.lab.robot.service;

import cn.edu.buaa.lab.robot.common.util.DateUtils;
import cn.edu.buaa.lab.robot.common.util.GsonUtils;
import cn.edu.buaa.lab.robot.common.util.HttpUtils;
//import cn.edu.buaa.lab.robot.common.util.KedaVoiceUtils;
import cn.edu.buaa.lab.robot.model.WeatherModel;
import cn.edu.buaa.lab.robot.repository.WeatherRepository;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;


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
            wlist = weatherRepository.findAllByDeletedAndDateAndCityContains(0, date, city);
            if (null == wlist || wlist.isEmpty()) {
                String url = outWeatherUrl + city;
                String result = HttpUtils.get(url);

                // deal weather result
                saveWeatherInfo(DateUtils.today(), result);

                wlist = weatherRepository.findAllByDeletedAndDateAndCity(0, date, city);
                if (null == wlist || wlist.isEmpty()) {
                    return "对不起，我没有听清楚。";
                }
            }
        }
        //解析weather数据
        String jsonString =  wlist.get(0).getResult();
        Gson gson = new Gson();
        Map<String, Object> map = new HashMap<String, Object>();
        map = gson.fromJson(jsonString, map.getClass());
        String weather_date = (String)map.get("date");
        String weather_high = (String)map.get("high");
        String weather_low = (String)map.get("low");
        String weather_fengxiang = (String)map.get("fengxiang");
        String weather_type = (String)map.get("type");

        String result = weather_type+","+weather_high+","+weather_low+","+weather_fengxiang;
        return result;
    }

    // {"data":{"yesterday":{"date":"9日星期三","high":"高温 25℃","fx":"东风","low":"低温 15℃","fl":"<![CDATA[<3级]]>","type":"晴"},"city":"苏州","aqi":"44","forecast":[{"date":"10日星期四","high":"高温 25℃","fengli":"<![CDATA[<3级]]>","low":"低温 15℃","fengxiang":"东风","type":"晴"},{"date":"11日星期五","high":"高温 24℃","fengli":"<![CDATA[3-4级]]>","low":"低温 17℃","fengxiang":"东南风","type":"多云"},{"date":"12日星期六","high":"高温 27℃","fengli":"<![CDATA[3-4级]]>","low":"低温 20℃","fengxiang":"东南风","type":"多云"},{"date":"13日星期天","high":"高温 29℃","fengli":"<![CDATA[3-4级]]>","low":"低温 22℃","fengxiang":"西南风","type":"雷阵雨"},{"date":"14日星期一","high":"高温 31℃","fengli":"<![CDATA[3-4级]]>","low":"低温 22℃","fengxiang":"北风","type":"多云"}],"ganmao":"各项气象条件适宜，无明显降温过程，发生感冒机率较低。","wendu":"14"},"status":1000,"desc":"OK"}
    // date: 2018-05-10; src: {"data":{"yesterday":{"date":"9日星期三","high":"高温 25℃","fx":"东风","low":"低温 15℃","fl":"<![CDATA[<3级]]>","type":"晴"},"city":"苏州","aqi":"44","forecast":[{"date":"10日星期四","high":"高温 25℃","fengli":"<![CDATA[<3级]]>","low":"低温 15℃","fengxiang":"东风","type":"晴"},{"date":"11日星期五","high":"高温 24℃","fengli":"<![CDATA[3-4级]]>","low":"低温 17℃","fengxiang":"东南风","type":"多云"},{"date":"12日星期六","high":"高温 27℃","fengli":"<![CDATA[3-4级]]>","low":"低温 20℃","fengxiang":"东南风","type":"多云"},{"date":"13日星期天","high":"高温 29℃","fengli":"<![CDATA[3-4级]]>","low":"低温 22℃","fengxiang":"西南风","type":"雷阵雨"},{"date":"14日星期一","high":"高温 31℃","fengli":"<![CDATA[3-4级]]>","low":"低温 22℃","fengxiang":"北风","type":"多云"}],"ganmao":"各项气象条件适宜，无明显降温过程，发生感冒机率较低。","wendu":"14"},"status":1000,"desc":"OK"}
    private void saveWeatherInfo(String date, String src) {
        try {
            Map weatherData = ((Map) GsonUtils.gToObject(src, Map.class).get("data"));
            Map yesterdayMap = (Map) weatherData.get("yesterday");
            yesterdayMap.put("fengli", yesterdayMap.get("fl"));
            yesterdayMap.put("fengxiang", yesterdayMap.get("fx"));
            List<Map> forecastList = (List<Map>) weatherData.get("forecast");
            String city = (String) weatherData.get("city");
            forecastList.add(yesterdayMap);
            List<WeatherModel> wmList = new ArrayList<>(7);
            for (Map o : forecastList) {
                WeatherModel wm = new WeatherModel();
                wm.setCity(city);
                wm.setDate(DateUtils.toDate(date, (String) o.get("date")));
                wm.setResult(GsonUtils.gToJson(o));
                wmList.add(wm);
//                weatherRepository.save(wm);
            }
            weatherRepository.save(wmList);
        } catch (Exception e) {
            logger.error(src, e);
        }
    }

//    public String getVoice(String input) throws Exception{
//
//        String name = "";
//        Random rand = new Random();
//        while(name.length() < 16)
//        {
//            int tmp = rand.nextInt(10000);
//            name+=String.valueOf(tmp);
//        }
//        name+=".pcm";
//        KedaVoiceUtils.generateAndSave(input,"/home/vsftp/smartbeibei/weatherVoice/"+name);
//        return "/weatherVoice/"+name;
//    }
}
