package com.project.SnakeProject.controller;

import com.project.SnakeProject.service.ReviewService;
import com.project.SnakeProject.service.impl.ReviewServiceImpl;
import com.project.SnakeProject.vo.StudyReviewImgVo;
import com.project.SnakeProject.vo.StudyReviewVo;
import com.project.SnakeProject.vo.StudyGInfoVo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.sql.Types.NULL;

@Controller
public class ReviewController {

    @Autowired
    private ReviewServiceImpl reviewService;

//    private String UPLOAD_DIR = System.getProperty("user.dir") + "/img/review/";
//    @Value("classpath:static/assets/img/review/")
//    private String UPLOAD_DIR;

    private static final String UPLOAD_DIR = System.getProperty("user.dir") +  "/src/main/resources/static/assets/img/review/";


    @GetMapping("/review")
    public String review(Model model) {
        List<StudyReviewVo> reviewall = reviewService.reviewall();
        List<StudyGInfoVo> contentall = reviewService.contentall();
//        model.addAttribute("dir", UPLOAD_DIR);
        model.addAttribute("review", reviewall);
        model.addAttribute("content", contentall);
        return "content/review";
    }

    @GetMapping("/getReviewDetail")
    @ResponseBody
    public List<StudyReviewVo> getReviewDetail(@RequestParam("SRIdx") String SRIdx) {

        List<StudyReviewVo> reviewDetail = new ArrayList<>();
        reviewDetail.addAll(reviewService.reviewDetail(SRIdx));

        if(reviewDetail.size() > 0) {
            return reviewDetail;
        } else {
            return null;
        }
    }

    @PostMapping("/postReview")
    public ResponseEntity<Integer> addReview(@RequestParam("SRTitle") String SRTitle,
                                             @RequestParam("SRcontent") String SRcontent,
                                             @RequestParam("SRStar") int SRStar,
                                             @RequestParam("SGIIdx") int SGIIdx,
                                             @RequestParam("MemberId") String MemberId,
                                             @RequestParam(value = "image[]", required = false) List<MultipartFile> uploadFiles) {
        StudyReviewVo studyReviewVo = new StudyReviewVo();
        studyReviewVo.setSRTitle(SRTitle);
        studyReviewVo.setSRcontent(SRcontent);
        studyReviewVo.setSRStar(SRStar);
        studyReviewVo.setSGIIdx(SGIIdx);
        studyReviewVo.setMemberId(MemberId);

        System.out.println(uploadFiles);

        int result = 0;
        int check = 0;
        try {
            if(uploadFiles == null){
                if(reviewService.addReview(studyReviewVo) > 0) {
                    result = 1;
                }
            } else {
                Path uploadPath = Paths.get(UPLOAD_DIR);
                if (!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath);
                }
                File dirfile = new File(UPLOAD_DIR + MemberId);
                Files.createDirectories(Paths.get(UPLOAD_DIR));
                String SRIImgSrc =  "/assets/img/review/" + MemberId + '/';
                String SRIImgName = "";
                if(reviewService.addReview(studyReviewVo) > 0) {
                    for(MultipartFile file : uploadFiles) {
                        int randomFourDigitNumber = (int)(Math.random() * 8999) + 1000;
                        if(!file.isEmpty()) {
                            if(!dirfile.exists()) {
                                try {
                                    dirfile.mkdir();
                                    File dest = new File(UPLOAD_DIR  + MemberId + '/' +  MemberId + '_' +  randomFourDigitNumber + file.getOriginalFilename());
                                    file.transferTo(dest);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            } else {
                                File dest = new File(UPLOAD_DIR  + MemberId + '/' +  MemberId + '_' +  randomFourDigitNumber + file.getOriginalFilename());
                                file.transferTo(dest);
                            }
                            SRIImgName = MemberId + '_' + randomFourDigitNumber + file.getOriginalFilename();
                            System.out.println(SRIImgSrc);
                            System.out.println(SRIImgName);
                            if(reviewService.addReviewImg(SRIImgSrc, SRIImgName) > 0) {
                                result = 1;
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<Integer>(0, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Integer>(result, HttpStatus.OK);
    }
}
