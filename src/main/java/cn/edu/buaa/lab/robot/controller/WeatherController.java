package cn.edu.buaa.lab.robot.controller;

import cn.edu.buaa.lab.robot.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/weather")
@RestController
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/{city}")
    public ResponseEntity<?> list(@PathVariable final String city) throws
            Exception {
        String result = weatherService.getWeatherByCity(city);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


}
