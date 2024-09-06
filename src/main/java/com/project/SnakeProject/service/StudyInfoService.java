package com.project.SnakeProject.service;

import com.project.SnakeProject.vo.StudyGImgVo;
import com.project.SnakeProject.vo.StudyGInfoVo;
import com.project.SnakeProject.vo.StudyInInfoVo;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudyInfoService {
    public List<StudyInInfoVo> ViewStudyInInfo();

    public int UpdateStudyInInfo(int num);

    public List<StudyGInfoVo> ViewStudyGInfo();

    public List<StudyGImgVo> ViewStudyGImg();
}
