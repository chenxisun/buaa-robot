package cn.edu.buaa.lab.robot.controller;

import cn.edu.buaa.lab.robot.common.util.NLP.Status;
import cn.edu.buaa.lab.robot.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/weather")
@RestController
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

//    @GetMapping("/{city}")
//    public ResponseEntity<?> list(@PathVariable final String city) throws
//            Exception {
//        String result = weatherService.getWeatherByCity(city);
//        return new ResponseEntity<>(result, HttpStatus.OK);
//    }

    //@GetMapping("/{date}/{city}")
    public ResponseEntity<?> list(@PathVariable final String date, @PathVariable final String city) throws
            Exception {
        String content = weatherService.getWeatherByDateAndCity(date, city);
        //String path = weatherService.getVoice(content);
        Map<String ,String > result = new HashMap<>();
        result.put("result", content);
        //result.put("voicePath",path);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
