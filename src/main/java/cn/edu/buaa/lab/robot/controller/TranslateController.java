package cn.edu.buaa.lab.robot.controller;

import cn.edu.buaa.lab.robot.service.TranslateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/translate")
@RestController
public class TranslateController {

    @Autowired
    private TranslateService translateService;

    @GetMapping("/{word}")
    public ResponseEntity<?> list(@PathVariable final String word) throws
            Exception {
        String result = translateService.getChinese(word);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


}
