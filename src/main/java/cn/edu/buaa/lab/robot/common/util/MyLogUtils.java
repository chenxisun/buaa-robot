//package cn.edu.buaa.lab.robot.common.util;
//
//import java.io.FileWriter;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//public class MyLogUtils {
//    static final String  fileName="/home/vsftp/smartbeibei/log_for_fansheng.txt";
//    static final String fileEncode = System.getProperty("file.encoding");
//    static void writeLogForVoice(){
//        try{
//            //使用这个构造函数时，如果存在kuka.txt文件，则直接往kuka.txt中追加字符串
//            FileWriter writer=new FileWriter(fileName,true);
//            SimpleDateFormat format=new SimpleDateFormat();
//            String time=format.format(new Date());
//            String s = "client"+"\t"+time+"\t"+"isSleep:"+isSleep+"waitNext"+waitNext+"voiceInput"+voiceInput+"\n";
//            writer.write(new String(s.getBytes("UTF-8"), fileEncode));
//            writer.close();
//        } catch (IOException e){
//            e.printStackTrace();
//        }
//    }
//
//
//
//}
