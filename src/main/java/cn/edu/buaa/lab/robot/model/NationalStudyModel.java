package cn.edu.buaa.lab.robot.model;

/**
 * @program: buaa-robot-api
 * @description: 国学实体类
 * @author: zhongshibo
 * @create: 2018-12-01 14:41
 **/
public class NationalStudyModel {


    /**
     * 编号
     */
    private String id;
    /**
     * 成语名称
     */
    private String name;
    /**
     * mp3 文件描述
     */
    private String desc;

    /**
     * mp3 文件地址
     */
    private String mp3Path;

    /**
     * 图片地址
     */
    private String imgPath;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getMp3Path() {
        return mp3Path;
    }

    public void setMp3Path(String mp3Path) {
        this.mp3Path = mp3Path;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    @Override
    public String toString() {
        return "NationalStudyModel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", mp3Path='" + mp3Path + '\'' +
                ", imgPath='" + imgPath + '\'' +
                '}';
    }
}
