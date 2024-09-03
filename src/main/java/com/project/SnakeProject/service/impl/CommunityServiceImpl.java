package com.project.SnakeProject.service.impl;

import com.project.SnakeProject.mapper.CommunityMapper;
import com.project.SnakeProject.service.CommunityService;
import com.project.SnakeProject.vo.CommunityCategoryVo;
import com.project.SnakeProject.vo.CommunityVo;
import com.project.SnakeProject.vo.TogetherStudyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommunityServiceImpl implements CommunityService {

  @Autowired
  CommunityMapper mapper;

  @Override
  public List<CommunityVo> ViewCommunity() {
    return mapper.ViewCommunity();
  }
  @Override
  public List<CommunityCategoryVo> ViewCommunityCategory() {
    return mapper.ViewCommunityCategory();
  }

  @Override
  public List<TogetherStudyVo> ViewTogetherStudy() {
    return mapper.ViewTogetherStudy();
  }

}
