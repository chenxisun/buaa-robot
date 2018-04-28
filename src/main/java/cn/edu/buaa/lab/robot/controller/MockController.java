package cn.edu.buaa.lab.robot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/mock")
@RestController
public class MockController {


    @GetMapping("/{word}")
    public ResponseEntity<?> list(@PathVariable final String word) throws
            Exception {
        Map<String, Map<String, Object>> result = new HashMap<>();

        Map<String, String> imgUrl = new HashMap<>();
        imgUrl.put("img1", "");
        imgUrl.put("img2", "");
        imgUrl.put("img3", "");
        Map<String, Object> a = new HashMap<>();
        a.put("wordVoice", "englishVideo的path");
        a.put("chineseIntroduction", "A的中文解释");
        a.put("englishVoice", "englishVideo的path");
        a.put("englishIntroduction", "A的英文解释");
        a.put("chineseVoice", "chineseVideo的path");
        a.put("imgUrl", imgUrl);
        result.put("A",a);

        Map<String, Object> b = new HashMap<>();
        a.put("wordVoice", "englishVideo的path");
        b.put("chineseIntroduction", "B的中文解释");
        b.put("englishVoice", "englishVideo的path");
        b.put("englishIntroduction", "B的英文解释");
        b.put("chineseVoice", "chineseVideo的path");
        b.put("imgUrl", imgUrl);
        result.put("B",b);


        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
