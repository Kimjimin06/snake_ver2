package com.project.SnakeProject.controller;

import com.project.SnakeProject.service.TogetherStudy;
import com.project.SnakeProject.service.impl.CommunityImpl;
import com.project.SnakeProject.service.impl.TogetherStudyImpl;
import com.project.SnakeProject.vo.CommunityVo;
import com.project.SnakeProject.vo.MemberVo;
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
import java.util.Objects;

@Controller
public class PostController {

    @Autowired
    private CommunityImpl communityImpl;

    @GetMapping("/post")
    public String home(@RequestParam("postNum") int parameterPostNum, Model model, HttpServletRequest request) {

        HttpSession session = request.getSession();
        String sessionId = (String) session.getAttribute("userid");

        List<CommunityVo> content_tables =  communityImpl.ViewContent(parameterPostNum);

        Object content_table = content_tables.get(0);
        String TogetherMembersId = ((CommunityVo) content_table).getTogetherMemberId();

        MemberVo rs = ((CommunityVo) content_table).getMemberVo();
        String content_creator = rs.getMemberId();

        Boolean isMember = false;

        if(TogetherMembersId != null && !TogetherMembersId.isEmpty()) {
            String[] TogetherMemberId =  TogetherMembersId.split(", ");

            //sessionid랑 (게시글작성자id || 모임에 참여한 사람들의 id)랑 비교후 같은 값이 있으면 true 없으면 false
            if(sessionId != null && !sessionId.isEmpty()) {
                isMember = content_creator.equals(sessionId);
                for(String togethermemberid : TogetherMemberId) {
                    if(sessionId.equals(togethermemberid)) {
                        isMember = true;
                        break;
                    }
                }
            }else{
                isMember = false;
            }
        }else {
            //sessionid랑 게시글작성자id랑 비교후 같은 값이 있으면 true 없으면 false
            if(sessionId != null && !sessionId.isEmpty()) {
                isMember = content_creator.equals(sessionId);
            }
        }

        //해당 post에 모임을 참여한 사람들을 배열로 가져온것
        String TogetherMembersName = ((CommunityVo) content_table).getTogetherMemberName();
        if(TogetherMembersName != null && !TogetherMembersName.isEmpty()) {
            String[] TogetherMemberName = TogetherMembersName.split(", ");
            model.addAttribute("TogetherMemberName", TogetherMemberName);
        }


        model.addAttribute("ViewContent", content_tables);
        model.addAttribute("isMember", isMember);
        model.addAttribute("parameterPostNum", parameterPostNum);


        return "content/post1";
    }

    @PostMapping("/insertTogether")
    public ResponseEntity<Integer> insertTogether(Integer parameterPostNum, String sessionId) {
        int rs =0;

        if(communityImpl.insertTogether(parameterPostNum, sessionId) > 0) {
            rs = 1;
        }else {
            rs = 0;
        }
        return new ResponseEntity<Integer>(rs, HttpStatus.OK);
    }

    @GetMapping("/postDelete")
    public String postDelete(@RequestParam("postNum") int parameterPostNum, Model model, HttpServletRequest request) {


        HttpSession session = request.getSession();
        String sessionId = (String) session.getAttribute("userid");

        if(sessionId != null && !sessionId.isEmpty()) {
            int rs = communityImpl.DelelteContent(parameterPostNum);

            if(rs > 0) {
                model.addAttribute("msg", "게시글삭제가 완료되었습니다.");
                model.addAttribute("url", "/messageBoard?category=0&pageGroup=1&groupCommunity=1");
            }else {
                model.addAttribute("msg", "게시글 삭제중 문제가 발생했습니다 다시 시도해주세요.");
                model.addAttribute("url", "/messageBoard?category=0&pageGroup=1&groupCommunity=1");
            }
            return "content/alert";
        }else {
            model.addAttribute("msg", "게시글 삭제중 문제가 발생했습니다 다시 시도해주세요.");
            model.addAttribute("url", "/messageBoard?category=0&pageGroup=1&groupCommunity=1");

            return "content/alert";
        }

    }
}