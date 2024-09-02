package com.project.SnakeProject.mapper;

import com.project.SnakeProject.vo.StudyInInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface StudyInInfoMapper {
  List<StudyInInfoVo> ViewStudyInInfo();

  public int selectStudyInInfo(String MemberId);

  public int selectTime(HashMap<String, Object> param3);

  public int UpdateInTime(HashMap<String, Object> param3);

  public int UpdateStudyInInfo(@Param("SeatStartTime") String SeatStartTime,
                               @Param("SeatEndTime") String SeatEndTime,
                               @Param("SIINum") int SIINum);

  public int UpdateMemberInInfo(@Param("MemberId") String MemberId,
                                @Param("SIINum") int SIINum);

  public int UpdateLiveInfo();


}
