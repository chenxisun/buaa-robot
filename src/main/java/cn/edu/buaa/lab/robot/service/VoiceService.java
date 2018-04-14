package cn.edu.buaa.lab.robot.service;

import cn.edu.buaa.lab.robot.common.util.NLP.*;
import cn.edu.buaa.lab.robot.common.util.NLPUtils;
import org.springframework.stereotype.Service;

@Service
public class VoiceService {

    //private String outTranslateUrl;

    public String getResult(){
        Match m = new Match();
        int nlpres = m.getNLPResult();
        //TODO:
        if (nlpres > 0)
            return "点播";

        switch(nlpres)
        {
            case Status.LOW_MATCH:
                break;
            case Status.NO:
                break;
            case Status.OK:
                break;
            case Status.RECOMMEND_ENGLISH:
                break;
            case Status.RECOMMEND_QUESTION:
                break;
            case Status.RECOMMEND_SONG:
                break;
            case Status.RECOMMEND_STORY:
                break;
            case Status.SILENCE:
                break;
            case Status.SLEEP:
                break;
            case Status.TRANSLATE:
                break;
            case Status.WAKE:
                break;
            case Status.WEATHER:
                break;
        }
        return "123";
    }

    public static void main(String[] args) {
        if (Word.asStorySet == null)
            Word.init();

        Status.isSleep = false;
        Status.input = "请讲白雪公主的故事";
        System.out.println(Match.match()+","+ Status.recommendIndex);

        Status.input = "呼和浩特后天..0？多少度";
        Match.weather();

    }
}
