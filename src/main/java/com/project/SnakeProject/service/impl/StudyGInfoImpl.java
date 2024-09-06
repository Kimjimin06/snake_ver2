package com.project.SnakeProject.service.impl;

import com.project.SnakeProject.mapper.StudyGInfoMapper;
import com.project.SnakeProject.service.StudyGInfo;
import com.project.SnakeProject.vo.StudyGInfoVo;
import com.project.SnakeProject.vo.StudyGOrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudyGInfoImpl implements StudyGInfo {

  @Autowired
  private StudyGInfoMapper mapper;

  @Override
  public List<StudyGInfoVo> ViewStudyGInfo() {
    return mapper.ViewStudyGInfo();
  }

  @Override
  public StudyGInfoVo selectGInfo(int SGINum) {
    return mapper.selectGInfo(SGINum);
  }

  @Override
  public boolean InsertGOrder(StudyGOrderVo studyGOrderVo) {
    return mapper.InsertGOrder(studyGOrderVo);
  }

  @Override
  public List<StudyGOrderVo> selectDay(int selectedDay, int SGINum) {
    return mapper.selectDay(selectedDay, SGINum);
  }
}
