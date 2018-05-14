package cn.edu.buaa.lab.robot.controller;

import cn.edu.buaa.lab.robot.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/song")
@RestController
public class SongController {

    @Autowired
    private SongService songService;

    @GetMapping("/list")
    public ResponseEntity<?> list(@RequestParam(value = "topic", defaultValue = "") final String topic,
                                  @RequestParam(value = "pageNo", defaultValue = "0") final Integer pageNo,
                                  @RequestParam(value = "pageSize", defaultValue = "10") final Integer pageSize
    ) throws Exception {
//        SongService ss = new SongService();
        return new ResponseEntity<>(songService.getList(topic,pageNo,pageSize), HttpStatus.OK);
    }

    @GetMapping("/version")
    public ResponseEntity<?> version(@RequestParam(value = "songVersion", defaultValue = "") final String songVersion
    ) throws Exception {
//        SongService ss = new SongService();
        return new ResponseEntity<>(songService.checkVersion(songVersion), HttpStatus.OK);
    }

}
