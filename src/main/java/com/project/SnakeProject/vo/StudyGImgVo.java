package com.project.SnakeProject.vo;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class StudyGImgVo {
  int SGImgIdx, SGIIdx;
  String SGImg;

  public StudyGImgVo(String SGImg) {
    this.SGImg = SGImg;
  }

  public StudyGImgVo(int SGImgIdx, int SGIIdx, String SGImg) {
    this.SGImgIdx = SGImgIdx;
    this.SGIIdx = SGIIdx;
    this.SGImg = SGImg;
  }

  public int getSGImgIdx() {
    return SGImgIdx;
  }

  public void setSGImgIdx(int SGImgIdx) {
    this.SGImgIdx = SGImgIdx;
  }

  public int getSGIIdx() {
    return SGIIdx;
  }

  public void setSGIIdx(int SGIIdx) {
    this.SGIIdx = SGIIdx;
  }

  public String getSGImg() {
    return SGImg;
  }

  public void setSGImg(String SGImg) {
    this.SGImg = SGImg;
  }
}
