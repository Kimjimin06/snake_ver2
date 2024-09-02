package com.project.SnakeProject.vo;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class StudyGInfoVo {
  int SGIIdx, SCIdx, SGINum;
  String SGIUseState, SGIContent1, SGIContent2, SGIContent3, SGIContent4;

  private StudyGImgVo studyGImgVo; // 사진 값 가져오기 위한 vo 선언
  private StudyGPareVo studyGPareVo; // 해당 룸의 가격들 가져오기 위한 vo 선언

  public StudyGInfoVo(Integer SGINum, String SGIContent1) {
    this.SGINum = SGINum;
    this.SGIContent1 = SGIContent1;
  }

  // 조인해서 가져오는 vo
  public StudyGInfoVo(int SGINum, String SGIUseState, String SGIContent1, String SGIContent2, String SGIContent3, String SGIContent4, StudyGImgVo studyGImgVo, StudyGPareVo studyGPareVo) {
    this.SGINum = SGINum;
    this.SGIUseState = SGIUseState;
    this.SGIContent1 = SGIContent1;
    this.SGIContent2 = SGIContent2;
    this.SGIContent3 = SGIContent3;
    this.SGIContent4 = SGIContent4;
    this.studyGImgVo = studyGImgVo;
    this.studyGPareVo = studyGPareVo;
  }

  public StudyGInfoVo(int SGIIdx, int SCIdx, int SGINum, String SGIUseState, String SGIContent1, String SGIContent2, String SGIContent3, String SGIContent4) {
    this.SGIIdx = SGIIdx;
    this.SCIdx = SCIdx;
    this.SGINum = SGINum;
    this.SGIUseState = SGIUseState;
    this.SGIContent1 = SGIContent1;
    this.SGIContent2 = SGIContent2;
    this.SGIContent3 = SGIContent3;
    this.SGIContent4 = SGIContent4;
  }

  public int getSGIIdx() {
    return SGIIdx;
  }

  public void setSGIIdx(int SGIIdx) {
    this.SGIIdx = SGIIdx;
  }

  public int getSCIdx() {
    return SCIdx;
  }

  public void setSCIdx(int SCIdx) {
    this.SCIdx = SCIdx;
  }

  public int getSGINum() {
    return SGINum;
  }

  public void setSGINum(int SGINum) {
    this.SGINum = SGINum;
  }

  public String getSGIUseState() {
    return SGIUseState;
  }

  public void setSGIUseState(String SGIUseState) {
    this.SGIUseState = SGIUseState;
  }

  public String getSGIContent1() {
    return SGIContent1;
  }

  public void setSGIContent1(String SGIContent1) {
    this.SGIContent1 = SGIContent1;
  }

  public String getSGIContent2() {
    return SGIContent2;
  }

  public void setSGIContent2(String SGIContent2) {
    this.SGIContent2 = SGIContent2;
  }

  public String getSGIContent3() {
    return SGIContent3;
  }

  public void setSGIContent3(String SGIContent3) {
    this.SGIContent3 = SGIContent3;
  }

  public String getSGIContent4() {
    return SGIContent4;
  }

  public void setSGIContent4(String SGIContent4) {
    this.SGIContent4 = SGIContent4;
  }

  public StudyGImgVo getStudyGImgVo() {
    return studyGImgVo;
  }

  public void setStudyGImgVo(StudyGImgVo studyGImgVo) {
    this.studyGImgVo = studyGImgVo;
  }

  public StudyGPareVo getStudyGPareVo() {
    return studyGPareVo;
  }

  public void setStudyGPareVo(StudyGPareVo studyGPareVo) {
    this.studyGPareVo = studyGPareVo;
  }
}
