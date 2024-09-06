package com.project.SnakeProject.service;

import com.project.SnakeProject.vo.CommunityCategoryVo;
import com.project.SnakeProject.vo.CommunityVo;
import com.project.SnakeProject.vo.TogetherStudyVo;

import java.util.List;

public interface CommunityService {
  public List<CommunityVo> ViewCommunity();
  public List<CommunityCategoryVo> ViewCommunityCategory();
  List<TogetherStudyVo> ViewTogetherStudy();
}
