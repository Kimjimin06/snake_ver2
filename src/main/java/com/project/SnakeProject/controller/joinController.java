package com.project.SnakeProject.controller;

import com.project.SnakeProject.service.MemberService;
import com.project.SnakeProject.vo.MemberVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class joinController {
    @Autowired
    private MemberService memberService;
    @GetMapping("join")
    public String join(Model model){
        model.addAttribute("title", "개인약관동의");
        return "content/join";
    }

    @GetMapping("/join2")
    public String join2(Model model) {
        model.addAttribute("title", "회원가입");

        return "content/join2";
    }

    @PostMapping("/join2")
    public String join2(MemberVo memberVo, Model model) {
        if(memberService.addMember(memberVo) > 0) {
            model.addAttribute("msg", "회원가입이 완료되었습니다.");
            model.addAttribute("url", "/");
            return "content/alert";
        } else {
            model.addAttribute("msg", "회원가입에 실패했습니다.");
            model.addAttribute("url", "/join2");
            return "content/alert";
        }
//        return "content/join2";
    }

    @PostMapping("/ConfirmId")
    @ResponseBody
    public ResponseEntity<Boolean> confirmId(String id) {
        boolean result = true;

        if(id.trim().isEmpty()) {
            result = false;
        } else {
            if (memberService.selectId(id)) {
                result = false;
            } else {
                result = true;
            }
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}




