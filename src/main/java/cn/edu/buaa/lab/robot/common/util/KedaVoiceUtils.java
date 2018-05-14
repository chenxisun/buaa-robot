package cn.edu.buaa.lab.robot.common.util;

import com.iflytek.cloud.speech.LexiconListener;
import com.iflytek.cloud.speech.RecognizerListener;
import com.iflytek.cloud.speech.RecognizerResult;
import com.iflytek.cloud.speech.SpeechConstant;
import com.iflytek.cloud.speech.SpeechError;
import com.iflytek.cloud.speech.SpeechRecognizer;
import com.iflytek.cloud.speech.SpeechSynthesizer;
import com.iflytek.cloud.speech.SpeechUtility;
import com.iflytek.cloud.speech.SynthesizeToUriListener;
import com.iflytek.cloud.speech.SynthesizerListener;

import java.util.ArrayList;

public class KedaVoiceUtils {

    private static SynthesizerListener mSynListener = new SynthesizerListener(){
        //会话结束回调接口，没有错误时，error为null
        public void onCompleted(SpeechError error) {}
        //缓冲进度回调
        //percent为缓冲进度0~100，beginPos为缓冲音频在文本中开始位置，endPos表示缓冲音频在文本中结束位置，info为附加信息。
        public void onBufferProgress(int percent, int beginPos, int endPos, String info) {}
        //开始播放
        public void onSpeakBegin() {}
        //暂停播放
        public void onSpeakPaused() {}
        //播放进度回调
        //percent为播放进度0~100,beginPos为播放音频在文本中开始位置，endPos表示播放音频在文本中结束位置.
        public void onSpeakProgress(int percent, int beginPos, int endPos) {}
        //恢复播放回调接口
        public void onSpeakResumed() {}
        public void onEvent(int arg0, int arg1, int arg2, int arg3,
                            Object arg4, Object arg5) {
            // TODO Auto-generated method stub
        }
    };

    private static SynthesizeToUriListener synthesizeToUriListener = new SynthesizeToUriListener() {
        //progress为合成进度0~100
        public void onBufferProgress(int progress) {}
        //会话合成完成回调接口
        //uri为合成保存地址，error为错误信息，为null时表示合成会话成功
        public void onSynthesizeCompleted(String uri, SpeechError error) {}
        public void onEvent(int arg0, int arg1, int arg2, int arg3,
                            Object arg4, Object arg5) {
            // TODO Auto-generated method stub

        }
    };

    private static RecognizerListener mRecoListener = new RecognizerListener() {
        //听写结果回调接口(返回Json格式结果，用户可参见附录)；
        //一般情况下会通过onResults接口多次返回结果，完整的识别内容是多次结果的累加；
        //关于解析Json的代码可参见MscDemo中JsonParser类；
        //isLast等于true时会话结束。
        public void onResult(RecognizerResult results, boolean isLast){
            //DebugLog.Log("Result:"+results.getResultString ());
        }
        //会话发生错误回调接口
        public void onError(SpeechError error) {
            error.getErrorDescription(true); //获取错误码描述
        }
        //开始录音
        public void onBeginOfSpeech() {}
        //音量值0~30
        public void onVolumeChanged(int volume){}
        //结束录音
        public void onEndOfSpeech() {}
        //扩展用接口
        public void onEvent(int eventType,int arg1,int arg2,String msg) {}

    };

    private static void uploadUserWords() {
        SpeechUtility.createUtility(SpeechConstant.APPID +"=59cb691f");
        SpeechRecognizer recognizer = SpeechRecognizer.getRecognizer();
//		UserWords userwords = new UserWords(USER_WORDS);
//		recognizer.setParameter( SpeechConstant.DATA_TYPE, "userword" );
//		recognizer.updateLexicon("userwords", userwords.toString(), lexiconListener);
    }

    public static void generateAndPlay(String input)
    {
        SpeechUtility.createUtility(SpeechConstant.APPID +"=59cb691f");
        //1.创建SpeechSynthesizer对象
        SpeechSynthesizer mTts= SpeechSynthesizer.createSynthesizer( );
        //2.合成参数设置，详见《MSC Reference Manual》SpeechSynthesizer 类
        mTts.setParameter(SpeechConstant.VOICE_NAME, "xiaoyan");//设置发音人
        mTts.setParameter(SpeechConstant.SPEED, "50");//设置语速
        mTts.setParameter(SpeechConstant.VOLUME, "80");//设置音量，范围0~100
        //设置合成音频保存位置（可自定义保存位置），保存在“./tts_test.pcm”
        //如果不需要保存合成音频，注释该行代码
        mTts.setParameter(SpeechConstant.TTS_AUDIO_PATH, "./tts_test.pcm");
        //3.开始合成
        mTts.startSpeaking(input, mSynListener);
    }

    public static void generateAndSave()
    {
        SpeechUtility.createUtility(SpeechConstant.APPID +"=59cb691f");
        //1.创建SpeechSynthesizer对象
        SpeechSynthesizer mTts= SpeechSynthesizer.createSynthesizer( );
        //2.合成参数设置，详见《MSC Reference Manual》SpeechSynthesizer 类
        mTts.setParameter(SpeechConstant.VOICE_NAME, "xiaoyan");//设置发音人
        mTts.setParameter(SpeechConstant.SPEED, "50");//设置语速，范围0~100
        mTts.setParameter(SpeechConstant.PITCH, "50");//设置语调，范围0~100
        mTts.setParameter(SpeechConstant.VOLUME, "50");//设置音量，范围0~100
        //3.开始合成
        //设置合成音频保存位置（可自定义保存位置），默认保存在“./tts_test.pcm”
        mTts.synthesizeToUri("语音合成测试程序", "./tts_test.pcm",synthesizeToUriListener);
    }

    public static void generateAndSave(String content, String path)
    {
        SpeechUtility.createUtility(SpeechConstant.APPID +"=59cb691f");
        //1.创建SpeechSynthesizer对象
        SpeechSynthesizer mTts= SpeechSynthesizer.createSynthesizer( );
        //2.合成参数设置，详见《MSC Reference Manual》SpeechSynthesizer 类
        mTts.setParameter(SpeechConstant.VOICE_NAME, "xiaoyan");//设置发音人
        mTts.setParameter(SpeechConstant.SPEED, "50");//设置语速，范围0~100
        mTts.setParameter(SpeechConstant.PITCH, "50");//设置语调，范围0~100
        mTts.setParameter(SpeechConstant.VOLUME, "80");//设置音量，范围0~100
        //3.开始合成
        //设置合成音频保存位置（可自定义保存位置），默认保存在“./tts_test.pcm”
        mTts.synthesizeToUri(content, path,synthesizeToUriListener);

        //TODO:检索是否生成
    }

    public static void dictationByMicrophone()
    {
        SpeechUtility.createUtility(SpeechConstant.APPID +"=59cb691f");
        //1.创建SpeechRecognizer对象
        SpeechRecognizer mIat= SpeechRecognizer.createRecognizer( );
        //2.设置听写参数，详见《MSC Reference Manual》SpeechConstant类
        mIat.setParameter(SpeechConstant.DOMAIN, "iat");
        mIat.setParameter(SpeechConstant.LANGUAGE, "zh_cn");
        mIat.setParameter(SpeechConstant.ACCENT, "mandarin ");
        //3.开始听写
        mIat.startListening(mRecoListener);
        //听写监听器
    }

    public static void dictationByFile()
    {
        SpeechUtility.createUtility(SpeechConstant.APPID +"=59cb691f");
        //1.创建SpeechRecognizer对象
        SpeechRecognizer mIat= SpeechRecognizer.createRecognizer( );
        //2.设置听写参数，详见《MSC Reference Manual》SpeechConstant类
        mIat.setParameter(SpeechConstant.DOMAIN, "iat");
        mIat.setParameter(SpeechConstant.LANGUAGE, "zh_cn");
        mIat.setParameter (SpeechConstant.ACCENT, "mandarin ");
        mIat.setParameter(SpeechConstant.AUDIO_SOURCE, "-1");
        //3.开始听写
        mIat.startListening(mRecoListener);

        //voiceBuffer为音频数据流，splitBuffer为自定义分割接口，将其以4.8k字节分割成数组
//		ArrayList<byte[]> buffers = splitBuffer(voiceBuffer,voiceBuffer.length, 4800);
//		for (int i = 0; i < buffers.size(); i++) {
//			// 每次写入msc数据4.8K,相当150ms录音数据
//			mIat.writeAudio(buffers.get(i), 0, buffers.get(i).length);
//		}
//		mIat.stopListening();
    }

    public static LexiconListener lexiconListener = new LexiconListener() {
        @Override
        public void onLexiconUpdated(String lexiconId, SpeechError error) {
//			if (error == null)
//				DebugLog.Log("*************上传成功*************");
//			else
//				DebugLog.Log("*************" + error.getErrorCode()+ "*************");
        }
    };

    public static void main(String[] args) {
        KedaVoiceUtils t = new KedaVoiceUtils();
//        t.generateAndPlay("123");
        t.generateAndSave("123","tts_test.pcm");
        PlayPcmUtils pp = new PlayPcmUtils();
        pp.playPCM("tts_test.pcm");
    }

}
