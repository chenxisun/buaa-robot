package cn.edu.buaa.lab.robot.service;

import cn.edu.buaa.lab.robot.common.util.NLP.*;
import cn.edu.buaa.lab.robot.common.util.NLPUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class VoiceService {

    private String outTranslateUrl;

    public String getResult(boolean isSleep,boolean waitNext,String input) {
        if (Word.asStorySet == null)
            Word.init();
        Status.isSleep = isSleep;
        Status.waitNext = waitNext;
        Status.input = input;

        int nlpResult = Match.getNLPResult();
        System.out.println(nlpResult);
        System.out.println(Status.input);
        return "";
    }

    public static void main(String[] args) {
        VoiceService vs = new VoiceService();
        vs.getResult(false,false,"好d");

    }
}
