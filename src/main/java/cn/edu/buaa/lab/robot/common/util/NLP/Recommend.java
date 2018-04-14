package cn.edu.buaa.lab.robot.common.util.NLP;

import cn.edu.buaa.lab.robot.common.util.KedaVoiceUtils;

import java.util.Random;

public class Recommend {
    public static void changeToQuestion() {
        Random random = new Random();
        Status.recommendIndex = Word.question_valid[random.nextInt() % 144];
        String answer_str = Word.mName.get(Status.recommendIndex);
        String ss = "我给你讲" + answer_str + "吧，好不好？";
        KedaVoiceUtils kv = new KedaVoiceUtils();
        kv.generateAndSave(ss,"tts_test.pcm");
        //TODO:
        //地址
    }

    public static void changeToSong() {
        Random random = new Random();
        Status.recommendIndex = random.nextInt() % 100 + 201;
        String answer_str = Word.mName.get(Status.recommendIndex);
        String ss = "我给你唱" + answer_str + "吧，好不好？";
        KedaVoiceUtils kv = new KedaVoiceUtils();
        kv.generateAndSave(ss,"tts_test.pcm");
        //TODO:
        //地址
    }

    public static void changeToStory() {
        Random random = new Random();
        Status.recommendIndex = random.nextInt() % 100 + 301;
        String answer_str = Word.mName.get(Status.recommendIndex);
        String ss = "我给你讲" + answer_str + "的故事吧，好不好？";
        KedaVoiceUtils kv = new KedaVoiceUtils();
        kv.generateAndSave(ss,"tts_test.pcm");
        //TODO:
        //地址
    }
}
