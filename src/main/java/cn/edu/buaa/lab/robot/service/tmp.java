package cn.edu.buaa.lab.robot.service;

import javax.sound.sampled.AudioFormat;

public class tmp {
    public static void main(String[] args) throws Exception {
        for(int i = 201;i <=300; i++) {
            javax.sound.sampled.AudioInputStream audio_file = javax.sound.sampled.AudioSystem.getAudioInputStream(
                    new java.io.File("D:\\Coding\\C++\\voiceDemo\\voice\\"+String.valueOf(i)+".wav"));
            audio_file.getFrameLength();
            AudioFormat format = audio_file.getFormat();
            System.out.println("format.toString() :" + format.toString());
            System.out.println("channels :" + format.getChannels());//1 : mono  2:stereo  //声道
            System.out.println("frameSize :" + format.getFrameSize());//2 bytes/frame  //每帧字节数
            System.out.println("size in bits :" + format.getSampleSizeInBits());//16bit  //帧数
            System.out.println("samplerate :" + format.getSampleRate()); //采样速率
            System.out.println("frameRate  :" + format.getFrameRate());
        }
    }
}