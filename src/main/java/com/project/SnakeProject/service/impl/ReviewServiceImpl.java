package com.project.SnakeProject.service.impl;

import com.project.SnakeProject.mapper.ReviewMapper;
import com.project.SnakeProject.service.ReviewService;
import com.project.SnakeProject.vo.StudyReviewImgVo;
import com.project.SnakeProject.vo.StudyReviewVo;
import com.project.SnakeProject.vo.StudyGInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    ReviewMapper mapper;

    @Override
    public int addReview(StudyReviewVo studyReviewVo){
        return mapper.addReview(studyReviewVo);
    }

    @Override
    public List<StudyReviewVo> reviewall() {
        return mapper.reviewall();
    }

    @Override
    public List<StudyGInfoVo> contentall() {
        return mapper.contentall();
    }

    @Override
    public int selectReviewIdx() {
        return mapper.selectReviewIdx();
    }

    @Override
    public int addReviewImg(String SRIImgSrc, String SRIImgName) {
        return mapper.addReviewImg(SRIImgSrc, SRIImgName);
    }

    @Override
    public List<StudyReviewVo> reviewDetail(String SRIdx) {
        return mapper.reviewDetail(SRIdx);
    }
}

