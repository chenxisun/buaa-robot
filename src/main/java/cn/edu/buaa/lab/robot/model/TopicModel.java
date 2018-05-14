package cn.edu.buaa.lab.robot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "r_topic")
public class TopicModel extends BaseModel {

    @Column(name = "content")
    private String content;

    @Column(name = "size")
    private Integer size;

    @Column(name = "english_voice_path")
    private String englishVoicePath;

    @Column(name = "chinese_voice_path")
    private String chineseVoicePath;

    @Column(name = "img1_path")
    private String img1Path;

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
