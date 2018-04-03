package cn.edu.buaa.lab.robot.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "r_en_video_voice")
public class EnVideoVoiceModel extends BaseModel {

    @Column(name = "name")
    private String name;

    @Column(name = "src_path")
    private String srcPath;

    @Column(name = "src_type")
    private Integer srcType;

    @Column(name = "r_type")
    private Integer type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSrcPath() {
        return srcPath;
    }

    public void setSrcPath(String srcPath) {
        this.srcPath = srcPath;
    }

    public Integer getSrcType() {
        return srcType;
    }

    public void setSrcType(Integer srcType) {
        this.srcType = srcType;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
