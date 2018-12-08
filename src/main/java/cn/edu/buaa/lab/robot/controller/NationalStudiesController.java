package cn.edu.buaa.lab.robot.controller;

import cn.edu.buaa.lab.robot.model.NationalStudyModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 国学controller
 */
@RequestMapping("/nationalStudy")
@RestController
public class NationalStudiesController {

    private static final String pathPre = "/home/vsftp/smartbeibei/";
    private static final String MP3_PATH = "/home/vsftp/smartbeibei/question/idiom/voice";
    private static final String IMG_PATH = "/home/vsftp/smartbeibei/question/idiom/img";

    private static final List<NationalStudyModel> nationalStudyModels = parseMULU(new File(pathPre + "txt/mulu.txt"));


    @GetMapping("/fileList")
    public ResponseEntity<?> list(){
        return new ResponseEntity<>(nationalStudyModels, HttpStatus.OK);
    }

    public static void main(String[] args) {
        List<NationalStudyModel> nationalStudyModels = parseMULU(new File(pathPre + "txt/mulu.txt"));
        for(NationalStudyModel model: nationalStudyModels) {
            System.out.println(model);
        }
    }

    /**
     * 解析目录文件
     * @param file
     * @return
     */
    public static List<NationalStudyModel> parseMULU(File file) {
        List<NationalStudyModel> list = new ArrayList<>();
        NationalStudyModel model = null;
        if(file == null ){
            return null;
        }
        String alineString = null;
        BufferedReader bufferedReader = null;
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new  BufferedReader(fileReader);
            alineString = bufferedReader.readLine();                //读取第一行数据
            while (alineString != null && !"NNN".equals(alineString)) {                              //判断文件是否为空
                String[] readArray = alineString.split(" ");        //拆分读取的数据
                if(readArray!=null && readArray.length == 4){  //判断文件格式是否符合
                    model = new NationalStudyModel();
                    model.setId(readArray[1]);
                    model.setName(readArray[2]);
                    model.setDesc(readArray[3].substring(0, readArray[3].lastIndexOf(".")));
                    model.setMp3Path(MP3_PATH + File.separator + readArray[1] + ".mp3");
                    model.setImgPath(IMG_PATH + File.separator + readArray[1] + ".img");
                    list.add(model);
                }
                alineString = bufferedReader.readLine();
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {
            try{
                if(null != bufferedReader)
                    bufferedReader.close();
            }catch(Exception e){
                e.printStackTrace();
            }
            try{
                if(null != fileReader)
                    fileReader.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return list;
    }


}
