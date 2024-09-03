package com.project.SnakeProject.service.impl;

import com.project.SnakeProject.mapper.StudyPareMapper;
import com.project.SnakeProject.service.StudyPareService;
import com.project.SnakeProject.vo.StudyGPareVo;
import com.project.SnakeProject.vo.StudyInPareVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudyPareServiceImpl implements StudyPareService {

    @Autowired
    private StudyPareMapper mapper;

    @Override
    public List<StudyInPareVo> typeList() {
        return mapper.typeList();
    }
    @Override
    public List<StudyInPareVo> selectList1() {
        return mapper.selectList1();
    }
    @Override
    public List<StudyInPareVo> selectList2() {
        return mapper.selectList2();
    }
    @Override
    public List<StudyGPareVo> selectList3() {
        return mapper.selectList3();
    }
}
