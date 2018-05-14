package cn.edu.buaa.lab.robot.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "r_topic_word")
public class TopicWordModel extends BaseModel {

    @Column(name = "topic_id")
    private Integer topicId;

    @Column(name = "topic_name")
    private String topicName;

    @Column(name = "word_id")
    private Integer wordId;

    @Column(name = "english_content")
    private String englishContent;

    @Column(name = "chinese_content")
    private String chineseContent;

    @Column(name = "english_voice_path")
    private String englishVoicePath;

    @Column(name = "chinese_voice_path")
    private String chineseVoicePath;

    @Column(name = "img1_path")
    private String img1Path;

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public Integer getWordId() {
        return wordId;
    }

    public void setWordId(Integer wordId) {
        this.wordId = wordId;
    }

    public String getEnglishContent() {
        return englishContent;
    }

    public void setEnglishContent(String englishContent) {
        this.englishContent = englishContent;
    }

    public String getChineseContent() {
        return chineseContent;
    }

    public void setChineseContent(String chineseContent) {
        this.chineseContent = chineseContent;
    }

    public String getEnglishVoicePath() {
        return englishVoicePath;
    }

    public void setEnglishVoicePath(String englishVoicePath) {
        this.englishVoicePath = englishVoicePath;
    }

    public String getChineseVoicePath() {
        return chineseVoicePath;
    }

    public void setChineseVoicePath(String chineseVoicePath) {
        this.chineseVoicePath = chineseVoicePath;
    }

    public String getImg1Path() {
        return img1Path;
    }

    public void setImg1Path(String img1Path) {
        this.img1Path = img1Path;
    }
}
