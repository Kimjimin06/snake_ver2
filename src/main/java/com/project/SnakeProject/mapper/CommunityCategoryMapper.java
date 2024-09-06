package com.project.SnakeProject.mapper;

import com.project.SnakeProject.vo.CommunityCategoryVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommunityCategoryMapper {
  List<CommunityCategoryVo> ViewCommunityCategory();
}
