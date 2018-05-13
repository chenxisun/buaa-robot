package cn.edu.buaa.lab.robot.controller;

import cn.edu.buaa.lab.robot.service.EnglishService;
import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/english")
@RestController
public class EnglishController {

    @GetMapping("/words/topics")
    public ResponseEntity<?> wordTopic() throws Exception {
        EnglishService es = new EnglishService();
        return new ResponseEntity<>(es.getTopics(), HttpStatus.OK);
    }

    @GetMapping("/words/list")
    public ResponseEntity<?> wordList(@RequestParam(value = "topic", defaultValue = "") final String topic,
                                      @RequestParam(value = "pageNo", defaultValue = "") final String pageNo,
                                      @RequestParam(value = "pageSize", defaultValue = "") final String pageSize
    ) throws Exception {
        EnglishService es = new EnglishService();
        return new ResponseEntity<>(es.getWords(topic,pageNo,pageSize), HttpStatus.OK);
    }

}
