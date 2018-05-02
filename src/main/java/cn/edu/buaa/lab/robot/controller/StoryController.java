package cn.edu.buaa.lab.robot.controller;

import cn.edu.buaa.lab.robot.service.StoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/story")
@RestController
public class StoryController {
    @GetMapping("/list")
    public ResponseEntity<?> list(@RequestParam(value = "topic", defaultValue = "") final String topic
    ) throws Exception {
        StoryService ss = new StoryService();
        return new ResponseEntity<>(ss.getList(topic), HttpStatus.OK);
    }

    @GetMapping("/version")
    public ResponseEntity<?> version(@RequestParam(value = "songVersion", defaultValue = "") final String songVersion
    ) throws Exception {
        StoryService ss = new StoryService();
        return new ResponseEntity<>(ss.checkVersion(songVersion), HttpStatus.OK);
    }
}
