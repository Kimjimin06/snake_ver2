package com.project.SnakeProject.mapper;

import com.project.SnakeProject.vo.StudyGInfoVo;
import com.project.SnakeProject.vo.StudyGOrderVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudyGInfoMapper {
  List<StudyGInfoVo> ViewStudyGInfo();

  StudyGInfoVo selectGInfo(@Param("SGINum") int SGINum);

  //  public boolean InsertGOrder(@Param("SGIdx") Integer SGIdx, @Param("MemberId") String MemberId,
//                              @Param("SGONum") String SGONum, @Param("SGORegDate") String SGORegDate,
//                              @Param("SGOStartDate") String SGOStartDate, @Param("SGOEndDate") String SGOEndDate,
//                              @Param("SGOTotal") Integer SGOTotal);
  public boolean InsertGOrder(StudyGOrderVo studyGOrderVo);

  public List<StudyGOrderVo> selectDay(@Param("selectedDay") int selectedDay,
                                       @Param("SGINum") int SGINum);
}
