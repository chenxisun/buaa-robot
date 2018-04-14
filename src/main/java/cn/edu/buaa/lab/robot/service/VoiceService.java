package cn.edu.buaa.lab.robot.service;

import cn.edu.buaa.lab.robot.common.util.HttpUtils;
import cn.edu.buaa.lab.robot.common.util.NLPUtils;
import cn.edu.buaa.lab.robot.common.util.Pair;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class VoiceService {

    private String outTranslateUrl;

    public int getNLPResult(String input)
    {
        MatchService ms = new MatchService();
        //Log l = new Log();

        //判断是否有效
        if (ms.isSilence())
            return StatusService.SILENCE;

        //判断是否是让去睡觉
        if(ms.sleep() == StatusService.SLEEP)
            return StatusService.SLEEP;

        //判断是否是唤醒
        if (ms.Beibei() == StatusService.WAKE)
            return StatusService.WAKE;

        //判断是否是让翻译
        //TODO:
        //if (ms.translate())
        //    return StatusService.TRANSLATE;

        //判断是否是询问天气
        if (ms.weather())
            return StatusService.WEATHER;

        //判断是否是二次应答
        if (StatusService.waitNext)
            if (ms.hasNo())
                return StatusService.NO;
            else
                return StatusService.OK;


        //StatusService.notMatchTime = 0;
        int lastType = StatusService.recommend;
        int answer = ms.isIntegrity(lastType);

        if (answer > 0)//有完整性匹配
        {
            //l.WriteLog(tmps,answer);
            return answer;
        }

        if (answer == StatusService.RECOMMEND)//不完整，但有状态
        {
            //检测有无状态转变
            if (lastType == StatusService.recommend)//无状态转变
            {
                if (StatusService.waitNext)//检测是否在回答问题
                {
                    StatusService.waitNext = false;
                }
                else//仍在这个状态中，继续下个随机，（先回答还得想一下）
                {
                    //l.WriteLog(tmps,Status.LOW_MATCH_AND_RECOMMEND);
                    return StatusService.LOW_MATCH_AND_RECOMMEND;
                }
            }
            else//有状态转变
            {
                RecommendService r = new RecommendService();
                if(StatusService.recommend == StatusService.RECOMMEND_QUESTION)
                {
                    //l.WriteLog(tmps,Status.CHANGE_TO_QUESTION);
                    r.changeToQuestion();
                    return StatusService.CHANGE_TO_QUESTION;
                }
                if (StatusService.recommend == StatusService.RECOMMEND_SONG)
                {
                    //l.WriteLog(tmps,Status.CHANGE_TO_SONG);
                    r.changeToSong();
                    return StatusService.CHANGE_TO_SONG;
                }
                if (StatusService.recommend == StatusService.RECOMMEND_STORY)
                {
                    //l.WriteLog(tmps,Status.CHANGE_TO_STORY);
                    r.changeToStory();
                    return StatusService.CHANGE_TO_STORY;
                }
                if (StatusService.recommend == StatusService.RECOMMEND_ENGLISH)
                {
                    //l.WriteLog(tmps,Status.CHANGE_TO_STORY);
                    return StatusService.CHANGE_TO_ENGLISH;
                }
            }
        }
        else if (StatusService.waitNext)//不完整，且无状态 //检测是否在回答问题
        {
            StatusService.waitNext = false;
        }

        //l.WriteLog(tmps,Status.LOW_MATCH);
        return StatusService.LOW_MATCH;
    }

    public String getResult(String input){



    }

    public static void main(String[] args) {
        VoiceService vs = new VoiceService();
        NLPUtils.Match m = new NLPUtils.Match();
        NLPUtils.SplitWords sw = new NLPUtils.SplitWords();
        if (NLPUtils.Word.asStorySet == null)
            NLPUtils.Word.init();

        NLPUtils.Status.isSleep = false;
        NLPUtils.Status.isGetResult = true;
        NLPUtils.Status.input = "请讲白雪公主的故事";
        System.out.println(m.match()+","+ NLPUtils.Status.recommend);

        NLPUtils.Status.input = "呼和浩特后天..0？多少度";
        m.weather();

        return  ;
    }
}
