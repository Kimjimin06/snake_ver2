package com.project.SnakeProject.controller;

import com.project.SnakeProject.service.MemberService;
import com.project.SnakeProject.service.StudyInInfo;
import com.project.SnakeProject.service.impl.StudyGImgImpl;
import com.project.SnakeProject.service.impl.StudyGInfoImpl;
import com.project.SnakeProject.vo.MemberVo;
import com.project.SnakeProject.vo.StudyGImgVo;
import com.project.SnakeProject.vo.StudyGInfoVo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import com.project.SnakeProject.service.impl.StudyInInfoImpl;
import com.project.SnakeProject.vo.StudyInInfoVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class HomeController {

    @Autowired
    private StudyInInfoImpl studyInInfoImpl;
    @Autowired
    private StudyGInfoImpl studyGInfoImpl;
    @Autowired
    private StudyGImgImpl studyGImgImpl;
    @Autowired
    private MemberService memberService;

//    @RequestMapping(value = "/")
//    public String home(Model model){
//        List<StudyInInfoVo> tables = new ArrayList<>();
//        tables.addAll(studyInInfoImpl.ViewStudyInInfo());
//
//        model.addAttribute("ViewStudyInInfo", tables);
//        return "content/home";
//    }

    @RequestMapping(value = "/")
    public String home(Model model) {
        List<StudyInInfoVo> SIItables = studyInInfoImpl.ViewStudyInInfo();
        List<StudyGInfoVo> SGItables = studyGInfoImpl.ViewStudyGInfo();
        List<StudyGImgVo> SGImgtables = studyGImgImpl.ViewStudyGImg();

        List<List<StudyInInfoVo>> groupedSIItables = new ArrayList<>();
        for (int i = 0; i < SIItables.size(); i += 6) {
            int end = Math.min(i + 6, SIItables.size());
            groupedSIItables.add(SIItables.subList(i, end));
        }

        model.addAttribute("ViewStudyInInfo", groupedSIItables);
        model.addAttribute("ViewStudyGInfo", SGItables);
        model.addAttribute("ViewStudyGImg", SGImgtables);
        return "content/home";
    }

    @PostMapping("/updateSeat")
    @ResponseBody
    public ResponseEntity<Integer> updateSeat(Integer SIINum, String starttime, String endtime,
                                              String MuseTime, HttpServletRequest request) throws ParseException {
        ResponseEntity<Integer> r = null;
        HttpSession session = request.getSession();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startdate = sdf.parse(starttime);
        Date enddate = sdf.parse(endtime);

        String MemberId = (String) session.getAttribute("userid");

        // selectTime , UpdateInTime
        HashMap<String, Object> param3 = new HashMap<>();
        param3.put("MemberId", MemberId);
        param3.put("MuseTime", MuseTime);

        int result, result1, result2, result3, result4 = 0;

        result1 = studyInInfoImpl.selectTime(param3);
        System.out.println(result1);

        // 개인 중복 예약 막음 -> 예약된 자리가 있으면 막아주기 위해 확인하는 select
        if(studyInInfoImpl.selectStudyInInfo(MemberId) > 0) return new ResponseEntity<Integer>(5, HttpStatus.OK);
        // 회원이 선택한 시간이 충전한 금액만큼 존재하고 있을 때
        if(studyInInfoImpl.selectTime(param3) <= 0) return new ResponseEntity<Integer>(4, HttpStatus.OK);

        // 회원이 선택한 시간을 충전한 금액에서 뺌
        if(studyInInfoImpl.UpdateInTime(param3) <= 0) return new ResponseEntity<Integer>(3, HttpStatus.OK);
        // 최종 자리를 업데이트 하는 곳 studyininfo 에서 해당 자리를 예약 처리
        if(studyInInfoImpl.UpdateStudyInInfo(starttime, endtime, SIINum) <= 0) return new ResponseEntity<Integer>(2, HttpStatus.OK);
        // memberininfo에서 각 멤버마다 어느 자리를 예약했는지를 update
        if(studyInInfoImpl.UpdateMemberInInfo(MemberId, SIINum) > 0) {
            result = 1;
        } else {
            result = 0;
        }

        return new ResponseEntity<Integer>(result, HttpStatus.OK);
    }


    @PostMapping("/login")
    public String home(MemberVo memberVo, Model model, HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        String name = memberService.login(memberVo, session);
        if(name != null) {
            session.setAttribute("userid", memberVo.getMemberId());
            session.setAttribute("username", name);

            model.addAttribute("msg", name + "님 로그인이 완료되었습니다.");
            model.addAttribute("url", "/");
            // testtt
            return "content/alert";
        } else {
            model.addAttribute("msg", "아이디가 맞지 않거나 회원정보가 없습니다.");
            model.addAttribute("url", "/");
            return "content/alert";
        }
    }

    @RequestMapping(value="logout.do", method=RequestMethod.GET)
    public String logout(HttpServletRequest request, Model model) throws Exception {
        HttpSession session = request.getSession();
        session.invalidate();

        model.addAttribute("msg", "로그아웃 되었습니다.");
        model.addAttribute("url", "/");
        return "content/alert";
    }

}