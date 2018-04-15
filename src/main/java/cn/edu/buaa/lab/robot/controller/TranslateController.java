package cn.edu.buaa.lab.robot.controller;

import cn.edu.buaa.lab.robot.service.TranslateService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/translate")
@RestController
public class TranslateController {

    @Autowired
    private TranslateService translateService;

    @GetMapping("/{word}")
    public ResponseEntity<?> list(@PathVariable final String word) throws
            Exception {
        String jsonString = translateService.getEnglish(word);
        Gson gson = new Gson();
        Map<String, Object> map = new HashMap<String, Object>();
        map = gson.fromJson(jsonString, map.getClass());
        ArrayList<String> as = new ArrayList<>();
        as =(ArrayList<String>) map.get("translation");
        translateService.getVoice(as.get(0));
        return new ResponseEntity<>(jsonString, HttpStatus.OK);
    }


}
