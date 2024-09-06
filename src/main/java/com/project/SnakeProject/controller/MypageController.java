package com.project.SnakeProject.controller;

import com.project.SnakeProject.service.MemberService;
import com.project.SnakeProject.service.impl.CommunityServiceImpl;
import com.project.SnakeProject.service.impl.MemberServiceImpl;
import com.project.SnakeProject.vo.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MypageController {
    @Autowired
    private MemberServiceImpl memberService;

    @RequestMapping(value="/mypage", method = RequestMethod.GET)
    public String mypage(Model model, HttpServletRequest request,
                        @RequestParam("pageGroup") int parameterPageGroup,
                        @RequestParam("groupCommunity") int parameterCommnuity,
                        @RequestParam("id") String id) throws Exception {
        HttpSession session = request.getSession();
        if(session.getAttribute("userid") != null) {
            // 개인정보 가져오는 service
            MemberVo member = memberService.selectInfo(id);
            model.addAttribute("data", member);

            // 개인 좌석 시간 및 룸 시간 충전
            List<StudyInPareVo> selectPareInfo = new ArrayList<>();
            selectPareInfo.addAll(memberService.selectPareInfo());

            MemberInInfoVo studyInInfoVo = memberService.selectPareInInfo(id);
            model.addAttribute("studyInInfo", studyInInfoVo);

            // 개인이 작성한 글 보여주는 게시판
            List<CommunityVo> community = memberService.MyPageCommunity(id);

            List<List<CommunityVo>> twoList = new ArrayList<>();
            for(int i = 0; i < community.size(); i += 4) {
                int end = Math.min(i + 4, community.size());
                twoList.add(community.subList(i, end));
            }

            List<List<List<CommunityVo>>> threeList = new ArrayList<>();
            for(int i = 0; i < twoList.size(); i += 4) {
                int end = Math.min(i + 4, twoList.size());
                threeList.add(twoList.subList(i, end));
            }

            model.addAttribute("viewCommunity", twoList); // 2차원
            model.addAttribute("ViewpageTables", threeList); // 3차원
            model.addAttribute("parameterPageGroup", parameterPageGroup);
            model.addAttribute("parameterCommnuity", parameterCommnuity);
            model.addAttribute("selectPareInfo", selectPareInfo);
            model.addAttribute("title", "마이페이지");
            return "content/mypage";
        } else {
            model.addAttribute("msg", "비정상 접근입니다.");
            model.addAttribute("url", "/");
            return "content/alert";

        }
    }

    @GetMapping("/ShowContent")
    @ResponseBody
    public List<List<List<CommunityVo>>> ShowContent(String id) {
//        List<CommunityVo> Ctables = new ArrayList<CommunityVo>();
//        Ctables.addAll(memberService.MyPageCommunity(id));
        List<CommunityVo> Ctables = memberService.MyPageCommunity(id);
//        List<CommunityVo> community = new ArrayList<>();

        List<List<CommunityVo>> twoList = new ArrayList<>();
        for(int i = 0; i < Ctables.size(); i += 3) {
            int end = Math.min(i + 3, Ctables.size());
            twoList.add(Ctables.subList(i, end));
        }

        List<List<List<CommunityVo>>> threeList = new ArrayList<>();
        for(int i = 0; i < twoList.size(); i += 3) {
            int end = Math.min(i + 3, twoList.size());
            threeList.add(twoList.subList(i, end));
        }

//        model.addAttribute("twoList", twoList);
//        model.addAttribute("threeList", threeList);
//        model.addAttribute("pageGroup", parameterPageGroup);
//        model.addAttribute("groupCommunity", parameterCommunity);

        return threeList;
    }

    @PostMapping("/MemberUpdate")
//    @RequestMapping(value="/MemberUpdate/{id}", method = RequestMethod.POST)
    public String updateInfo(@RequestParam(value="id") String id, MemberVo member, Model model, HttpServletRequest request) throws Exception {
        member.setMemberId(id);
        
        // 업데이트 후 session에 닉네임 업데이트
        HttpSession session = request.getSession();
        session.setAttribute("username", member.getMemberName());

        if(memberService.updateInfo(member) > 0) {
            model.addAttribute("msg", "개인정보가 수정되었습니다.");
            model.addAttribute("url", "/mypage?id=" + id + "&pageGroup=1&groupCommunity=1");
            return "content/alert";
        } else {
            model.addAttribute("msg", "개인정보 수정에 실패하였습니다.");
            model.addAttribute("url", "/mypage");
            return "content/alert";
        }
    }

    @PostMapping("/PassWordCheck")
    @ResponseBody
    public ResponseEntity<Boolean> PassWordCheck(String MemberId,
                                                 String MemberPw) throws Exception {
        boolean result = true;
        if(MemberId.trim().isEmpty() && MemberPw.trim().isEmpty()) {
            result = false;
        } else {
            if(memberService.selectPass(MemberId, MemberPw)) {
                result = true;
            } else {
                result = false;
            }
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/deleteMember")
    @ResponseBody
    public ResponseEntity<Boolean> deleteMember(String MemberId, HttpServletRequest request) throws Exception {
        boolean result = true;
        HttpSession session = request.getSession();
        if(MemberId.trim().isEmpty()) {
            result = false;
        } else {
            if(memberService.deleteInfo(MemberId)) {
                result = true;
                session.invalidate();
            } else {
                result = false;
            }
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    // 지금 데이터 들어가는데 midx(멤버아이디)랑 sgiidx(방이름) 이 임의로 1씩 들어가잖아?
    // midx에 현재 로그인중인 아이디 넘겨서 넣는거랑, sgiidx 가져와서 넣는거랑 해봐바
    //

    @PostMapping("/inupdate")
    @ResponseBody
    public ResponseEntity<Boolean> inupdate(String siptime,
                                            String MemberId) throws Exception {
        boolean result = true;
        HashMap<String, Object> params = new HashMap<>();
        params.put("MemberId", MemberId);
        params.put("SIPName", siptime);

        System.out.println(siptime);
        System.out.println(MemberId);
        System.out.println(params);

        if(MemberId.trim().isEmpty()) {
            result = false;
        } else {
            if(memberService.inupdate(params)) {
                result = true;
            } else {
                result = false;
            }
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
