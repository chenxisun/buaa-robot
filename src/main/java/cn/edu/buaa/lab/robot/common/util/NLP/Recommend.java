package cn.edu.buaa.lab.robot.common.util.NLP;

import cn.edu.buaa.lab.robot.common.util.KedaVoiceUtils;

import java.util.Random;

public class Recommend {
    public static String changeToQuestion(StatusPerRobot spr) {
        Random random = new Random();
        spr.recommendIndex = Word.question_valid[random.nextInt(144)];
        String answer_str = Word.mName.get(spr.recommendIndex);
        String ss = "我给你讲" + answer_str + "吧，好不好？";

        String name = "";
        while(name.length() < 16)
        {
            int tmp = random.nextInt(10000);
            name+=String.valueOf(tmp);
        }
        name+=".pcm";
        String path = "/recommend/"+name;
        KedaVoiceUtils.generateAndSave(ss,"/home/vsftp/smartbeibei"+path);
        return path;
    }

    public static String changeToSong(StatusPerRobot spr) {
        Random random = new Random();
        spr.recommendIndex = random.nextInt(100) + 201;
        String answer_str = Word.mName.get(spr.recommendIndex);
        String ss = "我给你唱" + answer_str + "吧，好不好？";

        String name = "";
        while(name.length() < 16)
        {
            int tmp = random.nextInt(10000);
            name+=String.valueOf(tmp);
        }
        name+=".pcm";
        String path = "/recommend/"+name;
        KedaVoiceUtils.generateAndSave(ss,"/home/vsftp/smartbeibei"+path);
        return path;
    }

    public static String changeToStory(StatusPerRobot spr) {
        Random random = new Random();
        spr.recommendIndex = random.nextInt(100)+ 301;
        String answer_str = Word.mName.get(spr.recommendIndex);
        String ss = "我给你讲" + answer_str + "的故事吧，好不好？";

        String name = "";
        while(name.length() < 16)
        {
            int tmp = random.nextInt(10000);
            name+=String.valueOf(tmp);
        }
        name+=".pcm";
        String path = "/recommend/"+name;
        KedaVoiceUtils.generateAndSave(ss,"/home/vsftp/smartbeibei"+path);
        return path;
    }
}
