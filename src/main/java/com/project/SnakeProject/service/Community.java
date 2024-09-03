package com.project.SnakeProject.service;

import com.project.SnakeProject.vo.CommunityVo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface Community {
  public List<CommunityVo> ViewCommunity(int categoryID);

  public List<CommunityVo> ViewContent(int postNum);

  public int insertTogether(int parameterPostNum, String sessionId);

  public int updatePost(int parameterPostNum ,CommunityVo communityVo);

  public int DeleteToMember(HashMap<String, Object> parameters);

  public int DelelteContent(int postNum);

  public int insertContent(CommunityVo communityVo);
}
