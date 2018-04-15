package cn.edu.buaa.lab.robot.service;

import cn.edu.buaa.lab.robot.common.util.NLP.Match;
import cn.edu.buaa.lab.robot.common.util.NLP.Recommend;
import cn.edu.buaa.lab.robot.common.util.NLP.Status;
import cn.edu.buaa.lab.robot.common.util.NLPUtils;
import org.springframework.stereotype.Service;

@Service
public class VoiceService {

    private String outTranslateUrl;

//    public int getNLPResult(String input)
//    {
//        MatchService ms = new MatchService();
//
//        //判断是否有效
//        if (ms.isSilence())
//            return StatusService.SILENCE;
//
//        //判断是否是让去睡觉
//        if(ms.sleep() == StatusService.SLEEP)
//            return StatusService.SLEEP;
//
//        //判断是否是唤醒
//        if (ms.Beibei() == StatusService.WAKE)
//            return StatusService.WAKE;
//
//        //判断是否是让翻译
//        if (ms.translate())
//            return StatusService.TRANSLATE;
//
//        //判断是否是询问天气
//        if (ms.weather())
//            return StatusService.WEATHER;
//
//        //判断是否是二次应答
//        if (StatusService.waitNext)
//            if (ms.hasNo())
//                return StatusService.NO;
//            else
//                return StatusService.OK;
//
//        //判断是否是完整匹配
//        //int lastType = StatusService.recommend;
//        int answer = ms.isIntegrity(lastType);
//
//        if (answer > 0)//有完整性匹配
//        {
//            //l.WriteLog(tmps,answer);
//            return answer;
//        }
//
//        if (answer == StatusService.RECOMMEND)//不完整，但有状态
//        {
//
//            RecommendService r = new RecommendService();
//            if(StatusService.recommend == StatusService.RECOMMEND_QUESTION)
//            {
//                //l.WriteLog(tmps,Status.CHANGE_TO_QUESTION);
//                r.changeToQuestion();
//                return StatusService.CHANGE_TO_QUESTION;
//            }
//            if (StatusService.recommend == StatusService.RECOMMEND_SONG)
//            {
//                //l.WriteLog(tmps,Status.CHANGE_TO_SONG);
//                r.changeToSong();
//                return StatusService.CHANGE_TO_SONG;
//            }
//            if (StatusService.recommend == StatusService.RECOMMEND_STORY)
//            {
//                //l.WriteLog(tmps,Status.CHANGE_TO_STORY);
//                r.changeToStory();
//                return StatusService.CHANGE_TO_STORY;
//            }
//            if (StatusService.recommend == StatusService.RECOMMEND_ENGLISH)
//            {
//                //l.WriteLog(tmps,Status.CHANGE_TO_STORY);
//                return StatusService.CHANGE_TO_ENGLISH;
//            }
//        }
//
//        return StatusService.LOW_MATCH;
//    }

    public String getResult(String input) {

        return "";

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

    public int getNLPResult()
    {
        Match ms = new Match();

        //判断是否有效
        if (ms.isSilence())
            return Status.SILENCE;

        //判断是否是让去睡觉
        if(ms.sleep() == Status.SLEEP)
            return Status.SLEEP;

        //判断是否是唤醒
        if (ms.Beibei() == Status.WAKE)
            return Status.WAKE;

        //判断是否是让翻译
        if (ms.translate())
            return Status.TRANSLATE;

        //判断是否是询问天气
        if (ms.weather())
            return Status.WEATHER;

        //判断是否是二次应答
        if (Status.waitNext)
            if (ms.hasNo())
                return Status.NO;
            else
                return Status.OK;

        //判断是否是完整匹配
        return ms.match();
    }

//    public String getResult(String input){
//
//        int nlpres = getNLPResult();
//        //TODO:
//
//
//
//        return Status.LOW_MATCH;
//    }
//
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
