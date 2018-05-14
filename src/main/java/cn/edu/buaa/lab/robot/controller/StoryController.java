package cn.edu.buaa.lab.robot.controller;

import cn.edu.buaa.lab.robot.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/story")
@RestController
public class StoryController {

    @Autowired
    private StoryService storyService;

    @GetMapping("/list")
    public ResponseEntity<?> list(@RequestParam(value = "topic", defaultValue = "") final String topic,
                                  @RequestParam(value = "pageNo", defaultValue = "") final String pageNo,
                                  @RequestParam(value = "pageSize", defaultValue = "") final String pageSize
    ) throws Exception {
//        StoryService ss = new StoryService();
        return new ResponseEntity<>(storyService.getList(topic,pageNo,pageSize), HttpStatus.OK);
    }

    @GetMapping("/version")
    public ResponseEntity<?> version(@RequestParam(value = "storyVersion", defaultValue = "") final String storyVersion
    ) throws Exception {
//        StoryService ss = new StoryService();
        return new ResponseEntity<>(storyService.checkVersion(storyVersion), HttpStatus.OK);
    }
}
