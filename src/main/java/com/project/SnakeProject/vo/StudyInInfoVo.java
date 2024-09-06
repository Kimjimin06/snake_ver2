package com.project.SnakeProject.vo;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class StudyInInfoVo {
  int  SCIdx, SIINum;
  String SeatUseState;
  String SeatStartTime;
  String SeatEndTime;

  int differnce;

  public StudyInInfoVo(String seatUseState, int differnce) {
    SeatUseState = seatUseState;
    this.differnce = differnce;
  }

  public StudyInInfoVo(int SCIdx, int SIINum, String seatUseState, String seatStartTime, String seatEndTime) {
    this.SCIdx = SCIdx;
    this.SIINum = SIINum;
    SeatUseState = seatUseState;
    SeatStartTime = seatStartTime;
    SeatEndTime = seatEndTime;
  }

  public StudyInInfoVo(int SCIdx, int SIINum, String SeatUseState) {
    this.SCIdx = SCIdx;
    this.SIINum = SIINum;
    this.SeatUseState = SeatUseState;
  }


  public int getSCIdx() {
    return SCIdx;
  }

  public void setSCIdx(int SCIdx) {
    this.SCIdx = SCIdx;
  }

  public int getSIINum() {
    return SIINum;
  }

  public void setSIINum(int SIINum) {
    this.SIINum = SIINum;
  }

  public String getSeatUseState() {
    return SeatUseState;
  }

  public void setSeatUseState(String seatUseState) {
    SeatUseState = seatUseState;
  }

  public String getSeatStartTime() {
    return SeatStartTime;
  }

  public void setSeatStartTime(String seatStartTime) {
    SeatStartTime = seatStartTime;
  }

  public String getSeatEndTime() {
    return SeatEndTime;
  }

  public void setSeatEndTime(String seatEndTime) {
    SeatEndTime = seatEndTime;
  }

  public int getDiffernce() {
    return differnce;
  }

  public void setDiffernce(int differnce) {
    this.differnce = differnce;
  }
}
