package cn.edu.buaa.lab.robot.service;

import cn.edu.buaa.lab.robot.common.util.NLP.*;
import cn.edu.buaa.lab.robot.common.util.NLPUtils;
import cn.edu.buaa.lab.robot.repository.MusicRepository;
import cn.edu.buaa.lab.robot.repository.QARepository;
import cn.edu.buaa.lab.robot.repository.StoryRepository;
import cn.edu.buaa.lab.robot.repository.WeatherRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class VoiceService {

    private static final Logger logger = LoggerFactory.getLogger("VoiceService");

    private TranslateService translateService;
    private WeatherService weatherService;

    @Autowired
    private MusicRepository musicRepository;
    @Autowired
    private StoryRepository storyRepository;
    @Autowired
    private QARepository qaRepository;

    private Integer getNLPResult(boolean isSleep,boolean waitNext,String input) throws Exception {
        if (Word.asStorySet == null)
            Word.init();
        Status.isSleep = isSleep;
        Status.waitNext = waitNext;
        Status.input = input;
        Status.recommendIndex = -1;
        Status.weather_time = -3;
        Status.weather_city = "";
        return Match.getNLPResult();
    }

    public Map<String, String> getResult(boolean isSleep, boolean waitNext, String input) throws Exception {
        int nlpResult = getNLPResult(isSleep,waitNext,input);
        Map<String, String> result = new HashMap<>();
        result.put("needWaitNext","NO");
        result.put("command",String.valueOf(Status.SILENCE));
        result.put("voicePath","");
        result.put("content","");

        switch (nlpResult)
        {
            case Status.SILENCE:
                result.put("voicePath","http://47.94.165.157:8083/common/silence.wav");
                break;
            case Status.LOW_MATCH://TODO:实际上应该分出他当前在作什么
                result.put("command",String.valueOf(Status.LOW_MATCH));
                result.put("voicePath","http://47.94.165.157:8083/common/silence.wav");
                break;
            case Status.NO://TODO:实际上应该问他想听什么问题、歌、故事
                result.put("command","");
                result.put("voicePath","http://47.94.165.157:8083/common/what_do_you_want_to_talk.wav");
                break;
            case Status.OK://TODO:这里不返回语音链接了，客户端应当保留之前推荐的语音链接和命令
                result.put("command","OK");
                break;
            case Status.WEATHER:
                Date date = new Date();
                date.setDate(date.getDate()+Status.weather_time);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String content = weatherService.getWeatherByDateAndCity(sdf.format(date),Status.weather_city);
                String voice = Status.weather_city;
                if (Status.weather_time == -2)
                    voice += "前天";
                else if(Status.weather_time == -1)
                    voice += "昨天";
                else if(Status.weather_time == 0)
                    voice += "今天";
                else if(Status.weather_time == 1)
                    voice += "明天";
                else if(Status.weather_time == 2)
                    voice += "后天";
                voice += "气温";
                voice += content;
                result.put("command",String.valueOf(Status.WEATHER));
                result.put("content",content);
                result.put("voicePath",weatherService.getVoice(voice));
                break;
            case Status.TRANSLATE:
                result.put("command",String.valueOf(Status.TRANSLATE));
                result.put("content",translateService.getEnglish(Status.input));
                result.put("voicePath",translateService.getVoice(Status.input));
                break;
            case Status.SLEEP:
                result.put("command",String.valueOf(Status.SLEEP));
                break;
            case Status.WAKE:
                result.put("command",String.valueOf(Status.WAKE));
                result.put("voicePath","http://47.94.165.157:8083/common/beibei.wav");
                break;
            case Status.RECOMMEND_ENGLISH:
                result.put("command",String.valueOf(Status.RECOMMEND_ENGLISH));
                break;
            case Status.RECOMMEND_QUESTION:
                result.put("needWaitNext","YES");
                result.put("command",String.valueOf(Status.RECOMMEND_QUESTION));
                result.put("voicePath","http://47.94.165.157:8083"+Recommend.changeToQuestion());
                result.put("content",String.valueOf(Status.recommendIndex));
                break;
            case Status.RECOMMEND_SONG:
                result.put("needWaitNext","YES");
                result.put("command",String.valueOf(Status.RECOMMEND_SONG));
                result.put("voicePath","http://47.94.165.157:8083"+Recommend.changeToSong());
                result.put("content",String.valueOf(Status.recommendIndex));
                break;
            case Status.RECOMMEND_STORY:
                result.put("needWaitNext","YES");
                result.put("command",String.valueOf(Status.RECOMMEND_STORY));
                result.put("voicePath","http://47.94.165.157:8083"+Recommend.changeToStory());
                result.put("content",String.valueOf(Status.recommendIndex));
                break;
            default:
                break;
        }
        if (nlpResult <= 200 && nlpResult >= 1)//直接请求某个问题
        {
            result.put("command",String.valueOf(Status.RECOMMEND_QUESTION));
            result.put("voicePath","http://47.94.165.157:8083"+Recommend.changeToQuestion());
            result.put("content",String.valueOf(Status.recommendIndex));
        } else if (nlpResult >= 201 && nlpResult <= 300)//直接请求某首歌
        {
            result.put("command",String.valueOf(Status.RECOMMEND_SONG));
            result.put("voicePath","http://47.94.165.157:8083"+Recommend.changeToSong());
            result.put("content",String.valueOf(Status.recommendIndex));
        } else if (nlpResult >= 301 && nlpResult <= 400)//直接请求某个故事
        {
            result.put("command",String.valueOf(Status.RECOMMEND_STORY));
            result.put("voicePath","http://47.94.165.157:8083"+Recommend.changeToStory());
            result.put("content",String.valueOf(Status.recommendIndex));
        } else {
            //TODO:处理未知错误
            System.out.println("error?");
        }
        return result;
    }

}
