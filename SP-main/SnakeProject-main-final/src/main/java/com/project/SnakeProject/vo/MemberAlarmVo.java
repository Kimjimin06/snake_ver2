package com.project.SnakeProject.vo;

public class MemberAlarmVo {
  int MAIdx, MIdx;
  String MATitle, MAContent;

  String MADate;

  public MemberAlarmVo(int MAIdx, int MIdx, String MATitle, String MAContent, String MADate) {
    this.MAIdx = MAIdx;
    this.MIdx = MIdx;
    this.MATitle = MATitle;
    this.MAContent = MAContent;
    this.MADate = MADate;
  }

  public int getMAIdx() {
    return MAIdx;
  }

  public void setMAIdx(int MAIdx) {
    this.MAIdx = MAIdx;
  }

  public int getMIdx() {
    return MIdx;
  }

  public void setMIdx(int MIdx) {
    this.MIdx = MIdx;
  }

  public String getMATitle() {
    return MATitle;
  }

  public void setMATitle(String MATitle) {
    this.MATitle = MATitle;
  }

  public String getMAContent() {
    return MAContent;
  }

  public void setMAContent(String MAContent) {
    this.MAContent = MAContent;
  }

  public String getMADate() {
    return MADate;
  }

  public void setMADate(String MADate) {
    this.MADate = MADate;
  }

}
