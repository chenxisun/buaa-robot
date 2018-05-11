package cn.edu.buaa.lab.robot.model;

import cn.edu.buaa.lab.robot.model.BaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "r_music_english")
public class MusicEnglishModel extends BaseModel {

    @Column(name = "name")
    private String name;

    @Column(name = "img1_path")
    private String img1Path;

    @Column(name = "voice_path")
    private String voicePath;

    public String getImg1Path() {
        return img1Path;
    }

    public void setImg1Path(String img1Path) {
        this.img1Path = img1Path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVoicePath() {
        return voicePath;
    }

    public void setVoicePath(String voicePath) {
        this.voicePath = voicePath;
    }

}
