package com.project.SnakeProject.mapper;

import com.project.SnakeProject.service.TogetherStudy;
import com.project.SnakeProject.vo.TogetherStudyVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TogetherStudyMapper {
  List<TogetherStudyVo> ViewTogetherStudy();
}
