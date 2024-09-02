package com.project.SnakeProject.vo;

public class CommunityCommentVo {
    int CCIdx, MIdx, ComIdx; 
    int CCRefNum, CCNum, CCGroupNum;
    String CCContent;
    String CCRegDate, CCUpDate, CCDelDate;

    String MemberName;

    public CommunityCommentVo(int CCIdx, int comIdx, int CCRefNum, int CCNum, int CCGroupNum, String CCContent, String CCRegDate, String CCUpDate, String CCDelDate, String memberName) {
        this.CCIdx = CCIdx;
        ComIdx = comIdx;
        this.CCRefNum = CCRefNum;
        this.CCNum = CCNum;
        this.CCGroupNum = CCGroupNum;
        this.CCContent = CCContent;
        this.CCRegDate = CCRegDate;
        this.CCUpDate = CCUpDate;
        this.CCDelDate = CCDelDate;
        MemberName = memberName;
    }

    public int getCCIdx() {
        return CCIdx;
    }

    public void setCCIdx(int CCIdx) {
        this.CCIdx = CCIdx;
    }

    public int getMIdx() {
        return MIdx;
    }

    public void setMIdx(int MIdx) {
        this.MIdx = MIdx;
    }

    public int getComIdx() {
        return ComIdx;
    }

    public void setComIdx(int comIdx) {
        ComIdx = comIdx;
    }

    public int getCCRefNum() {
        return CCRefNum;
    }

    public void setCCRefNum(int CCRefNum) {
        this.CCRefNum = CCRefNum;
    }

    public int getCCNum() {
        return CCNum;
    }

    public void setCCNum(int CCNum) {
        this.CCNum = CCNum;
    }

    public int getCCGroupNum() {
        return CCGroupNum;
    }

    public void setCCGroupNum(int CCGroupNum) {
        this.CCGroupNum = CCGroupNum;
    }

    public String getCCContent() {
        return CCContent;
    }

    public void setCCContent(String CCContent) {
        this.CCContent = CCContent;
    }

    public String getCCRegDate() {
        return CCRegDate;
    }

    public void setCCRegDate(String CCRegDate) {
        this.CCRegDate = CCRegDate;
    }

    public String getCCUpDate() {
        return CCUpDate;
    }

    public void setCCUpDate(String CCUpDate) {
        this.CCUpDate = CCUpDate;
    }

    public String getCCDelDate() {
        return CCDelDate;
    }

    public void setCCDelDate(String CCDelDate) {
        this.CCDelDate = CCDelDate;
    }

    public String getMemberName() {
        return MemberName;
    }

    public void setMemberName(String memberName) {
        MemberName = memberName;
    }
}
