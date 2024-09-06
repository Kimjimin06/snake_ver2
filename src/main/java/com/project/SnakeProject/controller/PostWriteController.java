package com.project.SnakeProject.controller;

import com.project.SnakeProject.service.impl.CommunityCategoryImpl;
import com.project.SnakeProject.service.impl.CommunityImpl;
import com.project.SnakeProject.service.impl.StudyGInfoImpl;
import com.project.SnakeProject.vo.CommunityCategoryVo;
import com.project.SnakeProject.vo.CommunityVo;
import com.project.SnakeProject.vo.MemberVo;
import com.project.SnakeProject.vo.StudyGInfoVo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PostWriteController {

    @Autowired
    private CommunityImpl communityImpl;
    @Autowired
    private CommunityCategoryImpl communityCategory;
    @Autowired
    private StudyGInfoImpl studyGInfo;

    @GetMapping("/postWrite")
    public String postWrite(Model model, HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession();
        String sessionId = (String) session.getAttribute("userid");

        if(sessionId != null && !sessionId.isEmpty()) {
            List<CommunityCategoryVo> categoryTable = communityCategory.ViewCommunityCategory();
            List<StudyGInfoVo> groupTable =  studyGInfo.ViewStudyGInfo();



            model.addAttribute("categoryTable", categoryTable);
            model.addAttribute("groupTable", groupTable);

            return "content/postWrite";
        }

        model.addAttribute("msg", "잘못된 접근방식입니다.");
        model.addAttribute("url", "/messageBoard?category=0&pageGroup=1&groupCommunity=1");

        return "content/alert";
    }

    @PostMapping("/postWriteSV")
    public String postWriteSV(CommunityVo communityVo, Model model, HttpServletRequest httpServletRequest) {

        HttpSession session = httpServletRequest.getSession();
        String sessionId = (String) session.getAttribute("userid");

        if(sessionId != null && !sessionId.isEmpty()) {
            String ComStartDate = communityVo.getComStartDate().replace("T", " ");
            String ComEndDate = communityVo.getComEndDate().replace("T", " ");
            communityVo.setComStartDate(ComStartDate);
            communityVo.setComEndDate(ComEndDate);

            String RbuttonRS =  httpServletRequest.getParameter("inlineRadioOptions");
            String roomRbuttonRS = httpServletRequest.getParameter("studyroomSelection");


            if(RbuttonRS.contains("온라인")) {
                communityVo.setComAddress(RbuttonRS);
                communityVo.setComplace("");
                communityVo.setComZipcode("");
            }else if(RbuttonRS.contains("스터디룸")) {
                communityVo.setComAddress(roomRbuttonRS);
                communityVo.setComplace("^" + RbuttonRS + "^");
                communityVo.setComZipcode("");
            }

            communityVo.setSessionId(sessionId);

            int rs = communityImpl.insertContent(communityVo);

            if(rs > 0) {
                model.addAttribute("msg", "게시글이 작성되었습니다.");
                model.addAttribute("url", "/messageBoard?category=0&pageGroup=1&groupCommunity=1");
            }else{
                model.addAttribute("msg", "다시시도해주세요");
                model.addAttribute("url", "/messageBoard?category=0&pageGroup=1&groupCommunity=1");
            }

            return "content/alert";

        }else{
            model.addAttribute("msg", "다시시도해주세요.");
            model.addAttribute("url", "/messageBoard?category=0&pageGroup=1&groupCommunity=1");
        }

        return "content/alert";
    }
}