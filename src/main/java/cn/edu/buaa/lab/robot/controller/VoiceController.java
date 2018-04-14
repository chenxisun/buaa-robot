package cn.edu.buaa.lab.robot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/voice")
@RestController
public class VoiceController {

    @GetMapping("/hello")
    public ResponseEntity<?> list(@RequestParam(value = "team", defaultValue = "") final String team,
                                  @RequestParam(value = "pageNo", defaultValue = "0") final int pageNo,
                                  @RequestParam(value = "pageSize", defaultValue = "10") final int pageSize) throws
            Exception {
        return new ResponseEntity<>("hello", HttpStatus.OK);
    }


    @PostMapping()
    public ResponseEntity<?> list(@PathVariable final String word) throws
            Exception {
        String result = "123";
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
