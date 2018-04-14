package cn.edu.buaa.lab.robot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/test")
@RestController
public class VoiceController {

    @GetMapping("/get")
    public ResponseEntity<?> list(@RequestParam(value = "team", defaultValue = "") final String team,
                                  @RequestParam(value = "pageNo", defaultValue = "0") final int pageNo,
                                  @RequestParam(value = "pageSize", defaultValue = "10") final int pageSize) throws
            Exception {
        int t = Integer.parseInt(team);
        Map<String, String> result = new HashMap<>();
        result.put("data", "hello");
        result.put("value", String.valueOf(t*pageNo));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> list(@PathVariable final String word) throws
            Exception {
        String result = "123";
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


}
