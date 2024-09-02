package com.project.SnakeProject.vo;

public class StudyInPareVo {
    int SCIdx;
    String SIPName;
    String SIPName2;
    int SIPPrice;

    public StudyInPareVo(String SIPName) {
        this.SIPName = SIPName;
    }

    // 충전하기 위한 개인 시간 정보 보여주는 vo
    public StudyInPareVo(int SCIdx, String SIPName, String SIPName2, int SIPPrice) {
        this.SCIdx = SCIdx;
        this.SIPName = SIPName;
        this.SIPName2 = SIPName2;
        this.SIPPrice = SIPPrice;
    }

    public StudyInPareVo(String SIPName, int SIPPrice) {
        this.SIPName = SIPName;
        this.SIPPrice = SIPPrice;
    }

    public int getSCIdx() {
        return SCIdx;
    }

    public void setSCIdx(int SCIdx) {
        this.SCIdx = SCIdx;
    }

    public String getSIPName() {
        return SIPName;
    }

    public void setSIPName(String SIPName) {
        this.SIPName = SIPName;
    }

    public int getSIPPrice() {
        return SIPPrice;
    }

    public void setSIPPrice(int SIPPrice) {
        this.SIPPrice = SIPPrice;
    }

    public String getSIPName2() {
        return SIPName2;
    }

    public void setSIPName2(String SIPName2) {
        this.SIPName2 = SIPName2;
    }
}
