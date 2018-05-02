package cn.edu.buaa.lab.robot.controller;

import cn.edu.buaa.lab.robot.service.SongService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/song")
@RestController
public class SongController {
    @GetMapping("/list")
    public ResponseEntity<?> list(@RequestParam(value = "topic", defaultValue = "") final String topic
    ) throws Exception {
        SongService ss = new SongService();
        return new ResponseEntity<>(ss.getList(topic), HttpStatus.OK);
    }

    @GetMapping("/version")
    public ResponseEntity<?> version(@RequestParam(value = "songVersion", defaultValue = "") final String songVersion
    ) throws Exception {
        SongService ss = new SongService();
        return new ResponseEntity<>(ss.checkVersion(songVersion), HttpStatus.OK);
    }

}
