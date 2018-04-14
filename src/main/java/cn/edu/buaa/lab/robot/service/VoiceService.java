package cn.edu.buaa.lab.robot.service;

import cn.edu.buaa.lab.robot.common.util.NLP.Match;
import cn.edu.buaa.lab.robot.common.util.NLP.Recommend;
import cn.edu.buaa.lab.robot.common.util.NLP.Status;
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

//    public static void main(String[] args) {
//        VoiceService vs = new VoiceService();
//        NLPUtils.Match m = new NLPUtils.Match();
//        NLPUtils.SplitWords sw = new NLPUtils.SplitWords();
//        if (NLPUtils.Word.asStorySet == null)
//            NLPUtils.Word.init();
//
//        NLPUtils.Status.isSleep = false;
//        NLPUtils.Status.isGetResult = true;
//        NLPUtils.Status.input = "请讲白雪公主的故事";
//        System.out.println(m.match()+","+ NLPUtils.Status.recommend);
//
//        NLPUtils.Status.input = "呼和浩特后天..0？多少度";
//        m.weather();
//
//        return  ;
//    }
}
