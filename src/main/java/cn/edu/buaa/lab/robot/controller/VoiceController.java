package cn.edu.buaa.lab.robot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/voice")
@RestController
public class VoiceController {

    @GetMapping("/get")
    public ResponseEntity<?> list(@RequestParam(value = "isSleep", defaultValue = "false") final boolean isSleep,
                                  @RequestParam(value = "voiceInput", defaultValue = "") final String voiceInput,
                                  @RequestParam(value = "waitNext", defaultValue = "false") final boolean waitNext,
                                  @RequestParam(value = "curActType", defaultValue = "") final int curActType,
                                  @RequestParam(value = "curActIndex", defaultValue = "") final int curActIndex,
                                  @RequestParam(value = "macId", defaultValue = "") final String macId

    ) throws Exception {
//        int t = Integer.parseInt(team);
//        Map<String, String> result = new HashMap<>();
//        result.put("data", "hello");
//        result.put("value", String.valueOf(t*pageNo));
        return new ResponseEntity<>("123", HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> list(@PathVariable final String word) throws
            Exception {
        String result = "123";
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


}
