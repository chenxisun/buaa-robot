package cn.edu.buaa.lab.robot.service;

import cn.edu.buaa.lab.robot.common.util.NLP.*;
import cn.edu.buaa.lab.robot.model.MusicModel;
import cn.edu.buaa.lab.robot.model.StoryModel;
import cn.edu.buaa.lab.robot.repository.MusicRepository;
import cn.edu.buaa.lab.robot.repository.QARepository;
import cn.edu.buaa.lab.robot.repository.StoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class VoiceService {

    private static final Logger logger = LoggerFactory.getLogger("VoiceService");

    @Value("${out.resourceUrl}")
    private String outResourceUrl;

    @Autowired
    private TranslateService translateService;

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private SongService songService;

    @Autowired
    private StoryService storyService;


    private Integer getNLPResult(StatusPerRobot spr) throws Exception {
        if (Word.asStorySet == null)
            Word.init();

        return Match.getNLPResult(spr);
    }

    public Map<String, String> getResult(boolean isSleep, boolean waitNext, String input) throws Exception {

        StatusPerRobot spr = new StatusPerRobot(isSleep,waitNext,input);

        int nlpResult = getNLPResult(spr);

        Map<String, String> result = new HashMap<>();
        result.put("needWaitNext","NO");
        result.put("command",String.valueOf(Status.SILENCE));
        result.put("voicePath","");
        result.put("content","");
        result.put("voiceIndex","-1");
        result.put("forFangSheng_size","");
        result.put("forFangSheng_time","");
        result.put("forFangSheng_name","");

        switch (nlpResult)
        {
            case Status.SILENCE:
                result.put("voicePath",outResourceUrl+"/common/silence.wav");
                break;
            case Status.LOW_MATCH://TODO:实际上应该分出他当前在作什么
                result.put("command",String.valueOf(Status.LOW_MATCH));
                result.put("voicePath",outResourceUrl+"/common/silence.wav");
                break;
            case Status.NO://TODO:实际上应该问他想听什么问题、歌、故事
                result.put("command",String.valueOf(Status.NO));
                result.put("voicePath",outResourceUrl+"/common/what_do_you_want_to_talk.wav");
                break;
            case Status.OK://TODO:这里不返回语音链接了，客户端应当保留之前推荐的语音链接和命令
                result.put("command",String.valueOf(Status.OK));
                break;
            case Status.WEATHER:
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date date = new Date();
                Calendar rightNow = Calendar.getInstance();
                rightNow.setTime(date);
                rightNow.add(Calendar.DAY_OF_YEAR,spr.weather_time);//日期加10天
                date=rightNow.getTime();
                String content = weatherService.getWeatherByDateAndCity(sdf.format(date),spr.weather_city);
                String voice = spr.weather_city;
                if (spr.weather_time == -2)
                    voice += "前天";
                else if(spr.weather_time == -1)
                    voice += "昨天";
                else if(spr.weather_time == 0)
                    voice += "今天";
                else if(spr.weather_time == 1)
                    voice += "明天";
                else if(spr.weather_time == 2)
                    voice += "后天";
                voice += "气温：";
                voice += content;
                result.put("command",String.valueOf(Status.WEATHER));
                result.put("content",voice);
                //result.put("voicePath",outResourceUrl+""+weatherService.getVoice(voice));
                break;
            case Status.TRANSLATE:
                result.put("command",String.valueOf(Status.TRANSLATE));
                result.put("content",translateService.getEnglish(spr.input));
                //result.put("voicePath",outResourceUrl+""+translateService.getVoice(spr.input));
                break;
            case Status.SLEEP:
                result.put("command",String.valueOf(Status.SLEEP));
                break;
            case Status.WAKE:
                result.put("command",String.valueOf(Status.WAKE));
                result.put("voicePath",outResourceUrl+"/common/beibei.wav");
                break;
            case Status.RECOMMEND_ENGLISH:
                result.put("command",String.valueOf(Status.RECOMMEND_ENGLISH));
                break;
            case Status.RECOMMEND_QUESTION:
                if (spr.recommendIndex != -1)
                    break;
                result.put("needWaitNext","YES");
                result.put("command",String.valueOf(Status.RECOMMEND_QUESTION));
                result.put("content",String.valueOf(Recommend.changeToQuestion(spr)));
                result.put("voiceIndex",String.valueOf(spr.recommendIndex));
                result.put("voicePath",outResourceUrl+"/question/"+String.valueOf(spr.recommendIndex)+".wav");
                break;
            case Status.RECOMMEND_SONG:
                if (spr.recommendIndex != -1)
                    break;
                result.put("needWaitNext","YES");
                result.put("command",String.valueOf(Status.RECOMMEND_SONG));
                result.put("content",String.valueOf(Recommend.changeToSong(spr)));
                result.put("voiceIndex",String.valueOf(spr.recommendIndex));
                result.put("voicePath",outResourceUrl+"/songs/voice/"+String.valueOf(spr.recommendIndex)+".wav");
                MusicModel musci_tmp = songService.getMusicByIndex(spr.recommendIndex);
                result.put("forFangSheng_size",String.valueOf(musci_tmp.getSize()));
                result.put("forFangSheng_time",String.valueOf(musci_tmp.getTimeLength()));
                result.put("forFangSheng_name",String.valueOf(musci_tmp.getName()));
                break;
            case Status.RECOMMEND_STORY:
                if (spr.recommendIndex != -1)
                    break;
                result.put("needWaitNext","YES");
                result.put("command",String.valueOf(Status.RECOMMEND_STORY));
                result.put("content",String.valueOf(Recommend.changeToStory(spr)));
                result.put("voiceIndex",String.valueOf(spr.recommendIndex));
                result.put("voicePath",outResourceUrl+"/stories/voice/"+String.valueOf(spr.recommendIndex)+".wav");
                StoryModel story_tmp = storyService.getStoryByIndex(spr.recommendIndex);
                result.put("forFangSheng_size",String.valueOf(story_tmp.getSize()));
                result.put("forFangSheng_time",String.valueOf(story_tmp.getTimeLength()));
                result.put("forFangSheng_name",String.valueOf(story_tmp.getName()));
                break;
            default:
                break;
        }
        if (nlpResult <= 200 && nlpResult >= 1)//直接请求某个问题
        {
            result.put("command",String.valueOf(Status.RECOMMEND_QUESTION));
            result.put("voicePath",outResourceUrl+"/question/"+String.valueOf(nlpResult)+".wav");
            result.put("voiceIndex",String.valueOf(nlpResult));
        } else if (nlpResult >= 201 && nlpResult <= 300)//直接请求某首歌
        {
            result.put("command",String.valueOf(Status.RECOMMEND_SONG));
            result.put("voicePath",outResourceUrl+"/songs/voice/"+String.valueOf(nlpResult)+".wav");
            result.put("voiceIndex",String.valueOf(nlpResult));
            MusicModel tmp = songService.getMusicByIndex(nlpResult);
            result.put("forFangSheng_size",String.valueOf(tmp.getSize()));
            result.put("forFangSheng_time",String.valueOf(tmp.getTimeLength()));
            result.put("forFangSheng_name",String.valueOf(tmp.getName()));
        } else if (nlpResult >= 301 && nlpResult <= 400)//直接请求某个故事
        {
            result.put("command",String.valueOf(Status.RECOMMEND_STORY));
            result.put("voicePath",outResourceUrl+"/stories/voice/"+String.valueOf(nlpResult)+".wav");
            result.put("voiceIndex",String.valueOf(nlpResult));
            StoryModel tmp = storyService.getStoryByIndex(nlpResult);
            result.put("forFangSheng_size",String.valueOf(tmp.getSize()));
            result.put("forFangSheng_time",String.valueOf(tmp.getTimeLength()));
            result.put("forFangSheng_name",String.valueOf(tmp.getName()));
        }
        return result;
    }

}
