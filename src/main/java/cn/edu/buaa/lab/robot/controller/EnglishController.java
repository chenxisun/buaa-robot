package cn.edu.buaa.lab.robot.controller;

import cn.edu.buaa.lab.robot.service.EnglishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/english")
@RestController
public class EnglishController {

    @Autowired
    private EnglishService englishService;

    @GetMapping("/words/topics")
    public ResponseEntity<?> wordTopic() throws Exception {
//        EnglishService es = new EnglishService();
        return new ResponseEntity<>(englishService.getTopics(), HttpStatus.OK);
    }

    @GetMapping("/words/list")
    public ResponseEntity<?> wordList(@RequestParam(value = "topic", defaultValue = "") final String topic,
                                      @RequestParam(value = "pageNo", defaultValue = "0") final Integer pageNo,
                                      @RequestParam(value = "pageSize", defaultValue = "10") final Integer pageSize
    ) throws Exception {
//        EnglishService es = new EnglishService();
        return new ResponseEntity<>(englishService.getWords(topic,pageNo,pageSize), HttpStatus.OK);
    }

}
