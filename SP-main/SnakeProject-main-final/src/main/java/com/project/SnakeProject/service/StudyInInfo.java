package com.project.SnakeProject.service;

import com.project.SnakeProject.vo.StudyInInfoVo;

import java.util.HashMap;
import java.util.List;

public interface StudyInInfo {
  public List<StudyInInfoVo> ViewStudyInInfo();

  public int selectStudyInInfo(String MemberId);
  public int UpdateStudyInInfo(String SeatStartTime, String SeatEndTime, int SIINum);
  public int UpdateMemberInInfo(String MemberId, int SIINum);
  public int UpdateLiveInfo();
  public int selectTime(HashMap<String, Object> param3);
  public int UpdateInTime(HashMap<String, Object> param3);
}

