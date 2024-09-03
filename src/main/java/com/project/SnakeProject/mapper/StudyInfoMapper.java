package com.project.SnakeProject.mapper;

import com.project.SnakeProject.vo.StudyGImgVo;
import com.project.SnakeProject.vo.StudyGInfoVo;
import com.project.SnakeProject.vo.StudyInInfoVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudyInfoMapper {
    // 개인좌석 info
    List<StudyInInfoVo> ViewStudyInInfo();
    // 개인좌석 선택시 예약 완료 처리
    public int UpdateStudyInInfo(int num);
    //
    List<StudyGInfoVo> ViewStudyGInfo();
    List<StudyGImgVo> ViewStudyGImg();

}
