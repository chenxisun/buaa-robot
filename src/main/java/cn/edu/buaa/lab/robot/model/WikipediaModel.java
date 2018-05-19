package cn.edu.buaa.lab.robot.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "r_wikipedia")
public class WikipediaModel extends BaseModel {

    @Column(name = "name")
    private String name;

    @Column(name = "img1_path")
    private String img1Path;

    @Column(name = "img2_path")
    private String img2Path;

    @Column(name = "img3_path")
    private String img3Path;

    @Column(name = "img4_path")
    private String img4Path;

    @Column(name = "voice_path")
    private String voicePath;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getImg3Path() {
        return img3Path;
    }

    public void setImg3Path(String img3Path) {
        this.img3Path = img3Path;
    }

    public String getImg4Path() {
        return img4Path;
    }

    public void setImg4Path(String img4Path) {
        this.img4Path = img4Path;
    }

    public String getVoicePath() {
        return voicePath;
    }

    public void setVoicePath(String voicePath) {
        this.voicePath = voicePath;
    }

}
