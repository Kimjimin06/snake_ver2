package com.project.SnakeProject.vo;

import lombok.NoArgsConstructor;

public class StudyReviewImgVo {
    int SRIdx;
    String SRIImgSrc;
    String SRIImgName;

    public StudyReviewImgVo() {
    }

    public StudyReviewImgVo(String SRIImgSrc, String SRIImgName) {
        this.SRIImgSrc = SRIImgSrc;
        this.SRIImgName = SRIImgName;
    }

    public int getSRIdx() {
        return SRIdx;
    }

    public void setSRIdx(int SRIdx) {
        this.SRIdx = SRIdx;
    }

    public String getSRIImgSrc() {
        return SRIImgSrc;
    }

    public void setSRIImgSrc(String SRIImgSrc) {
        this.SRIImgSrc = SRIImgSrc;
    }

    public String getSRIImgName() {
        return SRIImgName;
    }

    public void setSRIImgName(String SRIImgName) {
        this.SRIImgName = SRIImgName;
    }
}
