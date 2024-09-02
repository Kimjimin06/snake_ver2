package com.project.SnakeProject.vo;

public class TogetherStudyVo {
  int MIdx, ComIdx;

  public TogetherStudyVo(int MIdx, int comIdx) {
    this.MIdx = MIdx;
    ComIdx = comIdx;
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
}
