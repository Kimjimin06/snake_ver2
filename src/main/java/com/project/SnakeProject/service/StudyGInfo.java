package com.project.SnakeProject.service;

import com.project.SnakeProject.vo.StudyGInfoVo;
import com.project.SnakeProject.vo.StudyGOrderVo;

import java.util.List;

public interface StudyGInfo {
  public List<StudyGInfoVo> ViewStudyGInfo();
  public StudyGInfoVo selectGInfo(int SGINum);
  //  public boolean InsertGOrder(Integer SGIdx, String MemberId,
//                              String SGONum, String SGORegDate,
//                              String SGOStartDate, String SGOEndDate,
//                              Integer SGOTotal);
  public boolean InsertGOrder(StudyGOrderVo studyGOrderVo);

  public List<StudyGOrderVo> selectDay(int selectedDay, int SGINum);
}
