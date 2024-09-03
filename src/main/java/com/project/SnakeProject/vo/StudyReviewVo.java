package com.project.SnakeProject.vo;

import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
public class StudyReviewVo {
    int SRIdx;
    int SGIIdx;
    int MIdx;
    String SRcontent;
    String SRRegDate, SRDelDate, SRUpDate;
    int SRStar;
    String SRTitle;
    String MemberId;

    private StudyGInfoVo studyGInfoVo;
    private StudyReviewImgVo studyReviewImgVo;
    private StudyGImgVo studyGImgVo;
    private MemberVo memberVo;

    public StudyReviewVo(String SRcontent, int SRStar, String SRTitle, StudyGInfoVo studyGInfoVo) {
        this.SRcontent = SRcontent;
        this.SRStar = SRStar;
        this.SRTitle = SRTitle;
        this.studyGInfoVo = studyGInfoVo;
    }

    // insert vo
    public StudyReviewVo(int SGIIdx, String SRcontent, int SRStar, String SRTitle, String memberId) {
        this.SGIIdx = SGIIdx;
        this.SRcontent = SRcontent;
        this.SRStar = SRStar;
        this.SRTitle = SRTitle;
        this.MemberId = memberId;
    }

    public StudyReviewVo(int SRIdx, int SGIIdx, int MIdx, String SRcontent, String SRRegDate, String SRDelDate, String SRUpDate, int SRStar, String SRTitle) {
        this.SRIdx = SRIdx;
        this.SGIIdx = SGIIdx;
        this.MIdx = MIdx;
        this.SRcontent = SRcontent;
        this.SRRegDate = SRRegDate;
        this.SRDelDate = SRDelDate;
        this.SRUpDate = SRUpDate;
        this.SRStar = SRStar;
        this.SRTitle = SRTitle;
    }


    //    public ReviewVo(String SRcontent, int SRStar, String SRTitle, StudyGInfoVo studyGInfoVo) {
//        this.SRcontent = SRcontent;
//        this.SRStar = SRStar;
//        this.SRTitle = SRTitle;
//        this.studyGInfoVo = studyGInfoVo;
//    }

    public String getSRTitle() {
        return SRTitle;
    }

    public void setSRTitle(String SRTitle) {
        this.SRTitle = SRTitle;
    }

    public int getSRIdx() {
        return SRIdx;
    }

    public void setSRIdx(int SRIdx) {
        this.SRIdx = SRIdx;
    }

    public int getSGIIdx() {
        return SGIIdx;
    }

    public void setSGIIdx(int SGIIdx) {
        this.SGIIdx = SGIIdx;
    }

    public int getMIdx() {
        return MIdx;
    }

    public void setMIdx(int MIdx) {
        this.MIdx = MIdx;
    }

    public String getSRcontent() {
        return SRcontent;
    }

    public void setSRcontent(String SRcontent) {
        this.SRcontent = SRcontent;
    }

    public String getSRRegDate() {
        return SRRegDate;
    }

    public void setSRRegDate(String SRRegDate) {
        this.SRRegDate = SRRegDate;
    }

    public String getSRDelDate() {
        return SRDelDate;
    }

    public void setSRDelDate(String SRDelDate) {
        this.SRDelDate = SRDelDate;
    }

    public String getSRUpDate() {
        return SRUpDate;
    }

    public void setSRUpDate(String SRUpDate) {
        this.SRUpDate = SRUpDate;
    }

    public int getSRStar() {
        return SRStar;
    }

    public void setSRStar(int SRStar) {
        this.SRStar = SRStar;
    }

    public StudyGInfoVo getStudyGInfoVo() {
        return studyGInfoVo;
    }

    public void setStudyGInfoVo(StudyGInfoVo studyGInfoVo) {
        this.studyGInfoVo = studyGInfoVo;
    }

    public String getMemberId() {
        return MemberId;
    }

    public void setMemberId(String memberId) {
        MemberId = memberId;
    }

    public StudyReviewImgVo getStudyReviewImgVo() {
        return studyReviewImgVo;
    }

    public void setStudyReviewImgVo(StudyReviewImgVo studyReviewImgVo) {
        this.studyReviewImgVo = studyReviewImgVo;
    }

    public StudyGImgVo getStudyGImgVo() {
        return studyGImgVo;
    }

    public void setStudyGImgVo(StudyGImgVo studyGImgVo) {
        this.studyGImgVo = studyGImgVo;
    }

    public MemberVo getMemberVo() {
        return memberVo;
    }

    public void setMemberVo(MemberVo memberVo) {
        this.memberVo = memberVo;
    }
}
