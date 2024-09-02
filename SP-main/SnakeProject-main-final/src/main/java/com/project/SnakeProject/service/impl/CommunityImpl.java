package com.project.SnakeProject.service.impl;

import com.project.SnakeProject.mapper.CommunityMapper;
import com.project.SnakeProject.service.Community;
import com.project.SnakeProject.vo.CommunityCommentVo;
import com.project.SnakeProject.vo.CommunityVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommunityImpl implements Community {

  @Autowired
  private CommunityMapper mapper;

  @Override
  public List<CommunityVo> ViewCommunity(int categoryID) {
    return mapper.ViewCommunity(categoryID);
  }

  @Override
  public List<CommunityVo> ViewContent(int postNum) {
    return mapper.ViewContent(postNum);
  }

  @Override
  public List<CommunityCommentVo> ViewCommunityComment(int postNum) {
    return mapper.ViewCommunityComment(postNum);
  }

  @Override
  public int insertTogether(int parameterPostNum, String sessionId) {
    return mapper.insertTogether(parameterPostNum, sessionId);
  }

  @Override
  public int updatePost(int parameterPostNum ,CommunityVo communityVo) {
    return mapper.updatePost(parameterPostNum ,communityVo);
  }

  @Override
  public int DeleteToMember(HashMap<String, Object> parameters) {
    return mapper.DeleteToMember(parameters);
  }

  @Override
  public int DelelteContent(int postNum) {
    return mapper.DelelteContent(postNum);
  }

  @Override
  public int insertContent(CommunityVo communityVo) {
    return mapper.insertContent(communityVo);
  }
}
