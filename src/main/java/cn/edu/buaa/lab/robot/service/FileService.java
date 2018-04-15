package cn.edu.buaa.lab.robot.service;

import org.springframework.stereotype.Service;

import java.io.File;
import java.util.HashMap;
import java.util.Map;


@Service
public class FileService {
    private static final Integer[] questionValid = {1,2,3,4,5,6,7,8,9,10,
            11,12,13,14,15,16,17,18,19,20,
            21,22,23,24,25,26,27,28,29,30,
            31,32,33,34,35,36,37,38,39,40,
            41,42,43,44,45,46,47,48,49,50,
            51,52,53,54,55,56,57,58,59,60,
            61,62,63,64,65,66,67,68,70,71,
            72,73,74,75,76,77,78,79,80,81,
            82,83,84,85,86,87,88,89,90,91,
            92,94,95,96,97,98,99,100,116,120,
            121,122,123,124,125,126,128,129,130,131,
            132,133,134,137,140,141,142,143,144,145,
            146,147,148,149,150,151,152,153,154,155,
            156,157,163,165,169,171,172,173,174,175,
            176,177,178,179};

    private static final Map<Integer, Integer> questionValidMap = new HashMap<>();
    static {
        for (Integer i : questionValid) {
            questionValidMap.put(i,i);
        }
    }


    public static void scanFile(String filePath) {
        if (null == filePath || filePath.isEmpty()) {
            return;
        }

        File root = new File(filePath);
        File[] files = root.listFiles(); // 获取目录下的所有文件或文件夹
        if (null == files) {
            return;
        }

        for (File f : files) {
            if (f.isDirectory()) {
                continue;
            }

            String fName = f.getName();
            if (null != questionValidMap.get(fName)) {

            }
        }
    }

    public static void main(String[] args) {
        File directory = new File("");//设定为当前文件夹
        try{
            System.out.println(directory.getCanonicalPath());//获取标准的路径
            System.out.println(directory.getAbsolutePath());//获取绝对路径
            FileService.scanFile(directory.getAbsolutePath());
        } catch (Exception e){

        }
    }
}
