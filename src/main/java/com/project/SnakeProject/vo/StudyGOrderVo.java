package com.project.SnakeProject.vo;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class StudyGOrderVo {
    int SGIdx;
    String MemberId;
    String SGONum;
    String SGORegDate;
    String SGOStartDate;
    String SGOEndDate;
    int SGOTotal;

    int day, starthour, endhour;

    private MemberVo memberVo;

    public StudyGOrderVo(int SGIdx, int day, int starthour, int endhour) {
        this.SGIdx = SGIdx;
        this.day = day;
        this.starthour = starthour;
        this.endhour = endhour;
    }

    public StudyGOrderVo(int SGIdx, String memberId, String SGONum, String SGORegDate, String SGOStartDate, String SGOEndDate, int SGOTotal) {
        this.SGIdx = SGIdx;
        this.MemberId = memberId;
        this.SGONum = SGONum;
        this.SGORegDate = SGORegDate;
        this.SGOStartDate = SGOStartDate;
        this.SGOEndDate = SGOEndDate;
        this.SGOTotal = SGOTotal;
    }

    public int getSGIdx() {
        return SGIdx;
    }

    public void setSGIdx(int SGIdx) {
        this.SGIdx = SGIdx;
    }

    public String getSGONum() {
        return SGONum;
    }

    public void setSGONum(String SGONum) {
        this.SGONum = SGONum;
    }

    public String getMemberId() {
        return MemberId;
    }

    public void setMemberId(String memberId) {
        MemberId = memberId;
    }

    public String getSGORegDate() {
        return SGORegDate;
    }

    public void setSGORegDate(String SGORegDate) {
        this.SGORegDate = SGORegDate;
    }

    public String getSGOStartDate() {
        return SGOStartDate;
    }

    public void setSGOStartDate(String SGOStartDate) {
        this.SGOStartDate = SGOStartDate;
    }

    public String getSGOEndDate() {
        return SGOEndDate;
    }

    public void setSGOEndDate(String SGOEndDate) {
        this.SGOEndDate = SGOEndDate;
    }

    public int getSGOTotal() {
        return SGOTotal;
    }

    public void setSGOTotal(int SGOTotal) {
        this.SGOTotal = SGOTotal;
    }

    public MemberVo getMemberVo() {
        return memberVo;
    }

    public void setMemberVo(MemberVo memberVo) {
        this.memberVo = memberVo;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getStarthour() {
        return starthour;
    }

    public void setStarthour(int starthour) {
        this.starthour = starthour;
    }

    public int getEndhour() {
        return endhour;
    }

    public void setEndhour(int endhour) {
        this.endhour = endhour;
    }
}
