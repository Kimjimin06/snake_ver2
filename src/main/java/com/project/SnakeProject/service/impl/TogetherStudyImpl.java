package com.project.SnakeProject.service.impl;

import com.project.SnakeProject.mapper.TogetherStudyMapper;
import com.project.SnakeProject.service.TogetherStudy;
import com.project.SnakeProject.vo.TogetherStudyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TogetherStudyImpl implements TogetherStudy {

  @Autowired
  private TogetherStudyMapper mapper;

  @Override
  public List<TogetherStudyVo> ViewTogetherStudy() {
    return mapper.ViewTogetherStudy();
  }

}
