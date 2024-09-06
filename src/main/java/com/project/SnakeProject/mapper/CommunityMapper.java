package com.project.SnakeProject.mapper;

import com.project.SnakeProject.vo.CommunityCategoryVo;
import com.project.SnakeProject.vo.CommunityVo;
import com.project.SnakeProject.vo.TogetherStudyVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface CommunityMapper {
  List<CommunityVo> ViewCommunity(int categoryID);
  List<CommunityVo> ViewContent(int postNum);

  public int insertTogether(int parameterPostNum, String sessionId);

  public int updatePost(int parameterPostNum ,CommunityVo communityVo);

  public int DeleteToMember(HashMap<String, Object> parameters);

  public int DelelteContent(int postNum);

  public int insertContent(CommunityVo communityVo);

  List<CommunityVo> ViewCommunity();
  List<CommunityCategoryVo> ViewCommunityCategory();
  List<TogetherStudyVo> ViewTogetherStudy();



}
