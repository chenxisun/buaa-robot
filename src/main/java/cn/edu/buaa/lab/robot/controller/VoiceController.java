package cn.edu.buaa.lab.robot.controller;

import cn.edu.buaa.lab.robot.service.VoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;


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
        String fileName="/home/vsftp/smartbeibei/log_for_fansheng.txt";
//        String fileName="E:/doctorM/workspace/buaa-robot/src/main/resources/log_for_fansheng.txt";
        String fileEncode = System.getProperty("file.encoding");
        try{
            //使用这个构造函数时，如果存在kuka.txt文件，则直接往kuka.txt中追加字符串
            FileWriter writer=new FileWriter(fileName,true);
            SimpleDateFormat format=new SimpleDateFormat();
            String time=format.format(new Date());
            String s = "client"+"\t"+time+"\t"+"isSleep:"+isSleep+"waitNext"+waitNext+"voiceInput"+voiceInput+"\n";
            writer.write(new String(s.getBytes("UTF-8"), fileEncode));
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        Map<String, String> result = voiceService.getResult(isSleep,waitNext,voiceInput);
        try{
            //使用这个构造函数时，如果存在kuka.txt文件，则直接往kuka.txt中追加字符串
            FileWriter writer=new FileWriter(fileName,true);
            SimpleDateFormat format=new SimpleDateFormat();
            String time=format.format(new Date());
            String s = "server"+"\t"+time+"\t"+result.toString()+"\n";
            writer.write(new String(s.getBytes("UTF-8"), fileEncode));
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

//    @PostMapping()
//    public ResponseEntity<?> list(@PathVariable final String word) throws
//            Exception {
//        String result = "123";
//        return new ResponseEntity<>(result, HttpStatus.OK);
//    }


}
