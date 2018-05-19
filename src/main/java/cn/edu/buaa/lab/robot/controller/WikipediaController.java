package cn.edu.buaa.lab.robot.controller;

import cn.edu.buaa.lab.robot.service.SongService;
import cn.edu.buaa.lab.robot.service.WikipediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/wikipedia")
@RestController
public class WikipediaController {

    @Autowired
    private WikipediaService wikipediaService;

    @GetMapping("/list")
    public ResponseEntity<?> list(@RequestParam(value = "pageNo", defaultValue = "0") final Integer pageNo,
                                  @RequestParam(value = "pageSize", defaultValue = "10") final Integer pageSize
    ) throws Exception {
        return new ResponseEntity<>(wikipediaService.getList(pageNo,pageSize), HttpStatus.OK);
    }

}
