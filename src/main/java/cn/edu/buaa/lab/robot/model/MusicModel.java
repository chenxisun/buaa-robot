package cn.edu.buaa.lab.robot.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "r_music")
public class MusicModel extends BaseModel {

    @Column(name = "name")
    private String name;

    @Column(name = "voice_path")
    private String voicePath;

    @Column(name = "video_path")
    private String videoPath;

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

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }
}
