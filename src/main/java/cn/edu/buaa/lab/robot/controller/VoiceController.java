package cn.edu.buaa.lab.robot.controller;

import cn.edu.buaa.lab.robot.service.VoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/voice")
@RestController
public class VoiceController {

    @Autowired
    private VoiceService voiceService;

    @GetMapping("/get")
    public ResponseEntity<?> list(@RequestParam(value = "isSleep", defaultValue = "false") final boolean isSleep,
                                  @RequestParam(value = "waitNext", defaultValue = "false") final boolean waitNext,
                                  @RequestParam(value = "voiceInput", defaultValue = "") final String voiceInput
    ) throws Exception {

        return new ResponseEntity<>(voiceService.getResult(isSleep,waitNext,voiceInput), HttpStatus.OK);
    }

//    @PostMapping()
//    public ResponseEntity<?> list(@PathVariable final String word) throws
//            Exception {
//        String result = "123";
//        return new ResponseEntity<>(result, HttpStatus.OK);
//    }


}
