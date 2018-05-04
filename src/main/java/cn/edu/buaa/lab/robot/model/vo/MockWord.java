package cn.edu.buaa.lab.robot.model.vo;

import java.io.Serializable;
import java.util.Map;

public class MockWord implements Serializable {
//  "B": {
//        "imgUrl": {
//            "img3": "",
//                    "img2": "",
//                    "img1": ""
//        },
//        "chineseIntroduction": "B的中文解释",
//                "englishVoice": "englishVideo的path",
//                "chineseVoice": "chineseVideo的path",
//                "englishIntroduction": "B的英文解释"
//    }

    public Map<String, String> imgUrl;
    public String englishIntroduction;
    public String chineseIntroduction;
    public String englishVoice;
    public String chineseVoice;

    public Map<String, String> getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(Map<String, String> imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getEnglishIntroduction() {
        return englishIntroduction;
    }

    public void setEnglishIntroduction(String englishIntroduction) {
        this.englishIntroduction = englishIntroduction;
    }

    public String getChineseIntroduction() {
        return chineseIntroduction;
    }

    public void setChineseIntroduction(String chineseIntroduction) {
        this.chineseIntroduction = chineseIntroduction;
    }

    public String getEnglishVoice() {
        return englishVoice;
    }

    public void setEnglishVoice(String englishVoice) {
        this.englishVoice = englishVoice;
    }

    public String getChineseVoice() {
        return chineseVoice;
    }

    public void setChineseVoice(String chineseVoice) {
        this.chineseVoice = chineseVoice;
    }
}
