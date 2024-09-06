package com.project.SnakeProject.mapper;

import com.project.SnakeProject.vo.StudyGImgVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudyGImgMapper {
  List<StudyGImgVo> ViewStudyGImg();
}
