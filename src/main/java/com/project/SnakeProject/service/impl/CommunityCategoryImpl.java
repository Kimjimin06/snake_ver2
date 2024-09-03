package com.project.SnakeProject.service.impl;

import com.project.SnakeProject.mapper.CommunityCategoryMapper;
import com.project.SnakeProject.service.CommunityCategory;
import com.project.SnakeProject.vo.CommunityCategoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommunityCategoryImpl implements CommunityCategory {

  @Autowired
  private CommunityCategoryMapper mapper;

  @Override
  public List<CommunityCategoryVo> ViewCommunityCategory() {
    return mapper.ViewCommunityCategory();
  }

}
