package com.project.SnakeProject.mapper;

import com.project.SnakeProject.vo.StudyReviewImgVo;
import com.project.SnakeProject.vo.StudyReviewVo;
import com.project.SnakeProject.vo.StudyGInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReviewMapper {
    public int addReview(StudyReviewVo studyReviewVo);
    public List<StudyReviewVo> reviewall();

    public List<StudyGInfoVo> contentall();

    public int selectReviewIdx();
    public int addReviewImg(@Param("SRIImgSrc") String SRIImgSrc,
                            @Param("SRIImgName") String SRIImgName);

    public List<StudyReviewVo> reviewDetail(@Param("SRIdx") String SRIdx);
}
