package cn.edu.buaa.lab.robot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/english")
@RestController
public class EnglishController {
    @GetMapping("/get")
    public ResponseEntity<?> list(@RequestParam(value = "isSleep", defaultValue = "false") final boolean isSleep
    ) throws Exception {
//        int t = Integer.parseInt(team);
//        Map<String, String> result = new HashMap<>();
//        result.put("data", "hello");
//        result.put("value", String.valueOf(t*pageNo));
        return new ResponseEntity<>("123", HttpStatus.OK);
    }

}
