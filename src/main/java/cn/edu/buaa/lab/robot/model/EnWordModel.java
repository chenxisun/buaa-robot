package cn.edu.buaa.lab.robot.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "r_en_word")
public class EnWordModel extends BaseModel {

    @Column(name = "en_content")
    private String enContent;

    @Column(name = "en_ch_content")
    private String enChContent;

    @Column(name = "en_en_content")
    private String enEnContent;

    @Column(name = "img_path")
    private String imgPath;

    @Column(name = "voice_path")
    private String voicePath;

    public String getEnContent() {
        return enContent;
    }

    public void setEnContent(String enContent) {
        this.enContent = enContent;
    }

    public String getEnChContent() {
        return enChContent;
    }

    public void setEnChContent(String enChContent) {
        this.enChContent = enChContent;
    }

    public String getEnEnContent() {
        return enEnContent;
    }

    public void setEnEnContent(String enEnContent) {
        this.enEnContent = enEnContent;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getVoicePath() {
        return voicePath;
    }

    public void setVoicePath(String voicePath) {
        this.voicePath = voicePath;
    }
}
