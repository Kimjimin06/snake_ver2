package com.project.SnakeProject.service;

import com.project.SnakeProject.vo.StudyGPareVo;
import com.project.SnakeProject.vo.StudyInPareVo;

import java.util.List;

public interface StudyPareService {
    public List<StudyInPareVo> typeList();
    public List<StudyInPareVo> selectList1();
    public List<StudyInPareVo> selectList2();
    public List<StudyGPareVo> selectList3();
}
