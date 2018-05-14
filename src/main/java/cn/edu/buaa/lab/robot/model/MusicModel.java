package cn.edu.buaa.lab.robot.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "r_music")
public class MusicModel extends BaseModel {

    @Column(name = "old_index")
    private Integer oldIndex;

    @Column(name = "name")
    private String name;

    @Column(name = "img1_path")
    private String img1Path;

    @Column(name = "img2_path")
    private String img2Path;

    @Column(name = "voice_path")
    private String voicePath;

    @Column(name = "video_path")
    private String videoPath;

    public Integer getOldIndex() {
        return oldIndex;
    }

    public void setOldIndex(Integer oldIndex) {
        this.oldIndex = oldIndex;
    }

    public String getImg1Path() {
        return img1Path;
    }

    public void setImg1Path(String img1Path) {
        this.img1Path = img1Path;
    }

    public String getImg2Path() {
        return img2Path;
    }

    public void setImg2Path(String img2Path) {
        this.img2Path = img2Path;
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

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }
}
