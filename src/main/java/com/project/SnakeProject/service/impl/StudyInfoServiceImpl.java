package com.project.SnakeProject.service.impl;

import com.project.SnakeProject.mapper.StudyInfoMapper;
import com.project.SnakeProject.service.StudyInfoService;
import com.project.SnakeProject.vo.StudyGImgVo;
import com.project.SnakeProject.vo.StudyGInfoVo;
import com.project.SnakeProject.vo.StudyInInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudyInfoServiceImpl implements StudyInfoService {
    @Autowired
    private StudyInfoMapper mapper;

    // 개인좌석info
    @Override
    public List<StudyInInfoVo> ViewStudyInInfo() {
        return mapper.ViewStudyInInfo();
    }
    // 개인좌석 선택시 예약 완료처리
    @Override
    public int UpdateStudyInInfo(int num) {
        return mapper.UpdateStudyInInfo(num);
    }
    // 스터디룸 정보 info
    @Override
    public List<StudyGInfoVo> ViewStudyGInfo() {
        return mapper.ViewStudyGInfo();
    }
    // 스터디룸 사진 info
    @Override
    public List<StudyGImgVo> ViewStudyGImg() {
        return mapper.ViewStudyGImg();
    }
}
