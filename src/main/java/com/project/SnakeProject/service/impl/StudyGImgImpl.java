package com.project.SnakeProject.service.impl;

import com.project.SnakeProject.mapper.StudyGImgMapper;
import com.project.SnakeProject.service.StudyGImg;
import com.project.SnakeProject.vo.StudyGImgVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudyGImgImpl implements StudyGImg {

  @Autowired
  private StudyGImgMapper mapper;

  @Override
  public List<StudyGImgVo> ViewStudyGImg() {
    return mapper.ViewStudyGImg();
  }
}
