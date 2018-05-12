package cn.edu.buaa.lab.robot.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "r_question_answer")
public class QAModel extends BaseModel {

    @Column(name = "old_index")
    private String oldIndex;

    @Column(name = "content")
    private String content;

    @Column(name = "voice_path")
    private String voicePath;

    @Column(name = "video_path")
    private String videoPath;

    public String getOldIndex() {
        return oldIndex;
    }

    public void setOldIndex(String oldIndex) {
        this.oldIndex = oldIndex;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
