package com.project.SnakeProject.service.impl;

import com.project.SnakeProject.mapper.StudyInInfoMapper;
import com.project.SnakeProject.service.StudyInInfo;
import com.project.SnakeProject.vo.StudyInInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class StudyInInfoImpl implements StudyInInfo {

  @Autowired
  private StudyInInfoMapper mapper;

  @Override
  public List<StudyInInfoVo> ViewStudyInInfo() {
    return mapper.ViewStudyInInfo();
  }

  @Override
  public int selectStudyInInfo(String MemberId) {
    return mapper.selectStudyInInfo(MemberId);
  }

  @Override
  public int selectTime(HashMap<String, Object> param3) {
    return mapper.selectTime(param3);
  }

  @Override
  public int UpdateInTime(HashMap<String, Object> param3) {
    return mapper.UpdateInTime(param3);
  }

  @Override
  public int UpdateStudyInInfo(String SeatStartTime, String SeatEndTime, int SIINum) {
    return mapper.UpdateStudyInInfo(SeatStartTime, SeatEndTime, SIINum);
  }

  @Override
  public int UpdateMemberInInfo(String MemberId, int SIINum) {
    return mapper.UpdateMemberInInfo(MemberId, SIINum);
  }

  @Override
  public int UpdateLiveInfo() {
    return mapper.UpdateLiveInfo();
  }
}
