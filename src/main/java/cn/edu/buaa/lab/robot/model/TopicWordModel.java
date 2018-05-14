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
    private Integer topicName;

    @Column(name = "word_id")
    private Integer wordId;

    @Column(name = "english_content")
    private Integer englishContent;

    @Column(name = "chinese_content")
    private Integer chineseContent;

    @Column(name = "english_voice_path")
    private Integer englishVoicePath;

    @Column(name = "chinese_voice_path")
    private Integer chineseVoicePath;

    @Column(name = "img1_path")
    private Integer img1Path;

    public Integer getTopicName() {
        return topicName;
    }

    public void setTopicName(Integer topicName) {
        this.topicName = topicName;
    }

    public Integer getEnglishContent() {
        return englishContent;
    }

    public void setEnglishContent(Integer englishContent) {
        this.englishContent = englishContent;
    }

    public Integer getChineseContent() {
        return chineseContent;
    }

    public void setChineseContent(Integer chineseContent) {
        this.chineseContent = chineseContent;
    }

    public Integer getEnglishVoicePath() {
        return englishVoicePath;
    }

    public void setEnglishVoicePath(Integer englishVoicePath) {
        this.englishVoicePath = englishVoicePath;
    }

    public Integer getChineseVoicePath() {
        return chineseVoicePath;
    }

    public void setChineseVoicePath(Integer chineseVoicePath) {
        this.chineseVoicePath = chineseVoicePath;
    }

    public Integer getImg1Path() {
        return img1Path;
    }

    public void setImg1Path(Integer img1Path) {
        this.img1Path = img1Path;
    }

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public Integer getWordId() {
        return wordId;
    }

    public void setWordId(Integer wordId) {
        this.wordId = wordId;
    }
}
