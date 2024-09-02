package com.project.SnakeProject.vo;

public class CommunityCategoryVo {
  int ComCateIdx;
  String ComCateName, ComCateUseState;

  public CommunityCategoryVo() {
    // 기본 생성자
  }

  // CommunityVo에서 사용할 카테고리 이름 하나만 정의
  public CommunityCategoryVo(String comCateName) {
    ComCateName = comCateName;
  }

  public CommunityCategoryVo(int ComCateIdx, String ComCateName, String ComCateUseState) {
    this.ComCateIdx = ComCateIdx;
    this.ComCateName = ComCateName;
    this.ComCateUseState = ComCateUseState;
  }

  public int getComCateIdx() {
    return ComCateIdx;
  }

  public void setComCateIdx(int comCateIdx) {
    ComCateIdx = comCateIdx;
  }

  public String getComCateName() {
    return ComCateName;
  }

  public void setComCateName(String comCateName) {
    ComCateName = comCateName;
  }

  public String getComCateUseState() {
    return ComCateUseState;
  }

  public void setComCateUseState(String comCateUseState) {
    ComCateUseState = comCateUseState;
  }
}
