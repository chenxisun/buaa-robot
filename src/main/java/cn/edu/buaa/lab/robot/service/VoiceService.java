package cn.edu.buaa.lab.robot.service;

import cn.edu.buaa.lab.robot.common.util.NLP.Match;
import cn.edu.buaa.lab.robot.common.util.NLP.Recommend;
import cn.edu.buaa.lab.robot.common.util.NLP.Status;
import cn.edu.buaa.lab.robot.common.util.NLPUtils;
import org.springframework.stereotype.Service;

@Service
public class VoiceService {

    private String outTranslateUrl;

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

    public String getResult(String input){

        int nlpres = getNLPResult();
        //TODO:



        return Status.LOW_MATCH;
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
