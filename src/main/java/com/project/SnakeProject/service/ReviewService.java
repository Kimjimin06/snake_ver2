package com.project.SnakeProject.service;

import com.project.SnakeProject.vo.StudyReviewImgVo;
import com.project.SnakeProject.vo.StudyReviewVo;
import com.project.SnakeProject.vo.StudyGInfoVo;

import java.util.List;

public interface ReviewService {
    public int addReview(StudyReviewVo studyReviewVo);
    public List<StudyReviewVo> reviewall();
    public List<StudyGInfoVo> contentall();
    public int selectReviewIdx();
    public int addReviewImg(String SRIImgSrc, String SRIImgName);
    public List<StudyReviewVo> reviewDetail(String SRIdx);
}
