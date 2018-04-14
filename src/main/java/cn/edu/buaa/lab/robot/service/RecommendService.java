package cn.edu.buaa.lab.robot.service;

import cn.edu.buaa.lab.robot.common.util.KedaVoiceUtils;
import cn.edu.buaa.lab.robot.model.WordModel;

import java.util.Random;

public class RecommendService {
    public void changeToQuestion() {
        Random random = new Random();
        StatusService.recommendIndex = WordModel.question_valid[random.nextInt() % 144];
        String answer_str = WordModel.mName.get(StatusService.recommendIndex);
        String ss = "我给你讲" + answer_str + "吧，好不好？";
        KedaVoiceUtils kv = new KedaVoiceUtils();
        kv.generateAndSave(ss,"tts_test.pcm");
        //TODO:
        //地址
    }

    public void changeToSong() {
        Random random = new Random();
        StatusService.recommendIndex = random.nextInt() % 100 + 201;
        String answer_str = WordModel.mName.get(StatusService.recommendIndex);
        String ss = "我给你唱" + answer_str + "吧，好不好？";
        KedaVoiceUtils kv = new KedaVoiceUtils();
        kv.generateAndSave(ss,"tts_test.pcm");
        //TODO:
        //地址
    }

    public void changeToStory() {
        Random random = new Random();
        StatusService.recommendIndex = random.nextInt() % 100 + 301;
        String answer_str = WordModel.mName.get(StatusService.recommendIndex);
        String ss = "我给你讲" + answer_str + "的故事吧，好不好？";
        KedaVoiceUtils kv = new KedaVoiceUtils();
        kv.generateAndSave(ss,"tts_test.pcm");
        //TODO:
        //地址
    }
}
