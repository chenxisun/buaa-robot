package cn.edu.buaa.lab.robot.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "r_keyword")
public class KeywordModel extends BaseModel {

    @Column(name = "content")
    private String content;

    @Column(name = "keyword_re_index")
    private String keywordReverseIndex;

    @Column(name = "keyword_type")
    private Integer keywordType;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getKeywordReverseIndex() {
        return keywordReverseIndex;
    }

    public void setKeywordReverseIndex(String keywordReverseIndex) {
        this.keywordReverseIndex = keywordReverseIndex;
    }

    public Integer getKeywordType() {
        return keywordType;
    }

    public void setKeywordType(Integer keywordType) {
        this.keywordType = keywordType;
    }
}
