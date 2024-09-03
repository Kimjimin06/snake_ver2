package com.project.SnakeProject.controller;

import com.project.SnakeProject.service.CommunityCategory;
import com.project.SnakeProject.service.impl.CommunityCategoryImpl;
import com.project.SnakeProject.service.impl.CommunityImpl;
import com.project.SnakeProject.vo.CommunityCategoryVo;
import com.project.SnakeProject.vo.CommunityVo;
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

import java.util.ArrayList;
import java.util.List;

@Controller
public class MessageBoardController {

    @Autowired
    private CommunityCategoryImpl communityCategoryImpl;
    @Autowired
    private CommunityImpl communityImpl;

    @GetMapping("/messageBoard")
    public String messageBoard(@RequestParam("groupCommunity") int parameterCommunity,
                               @RequestParam("pageGroup") int parameterPageGroup,
                               @RequestParam("category") int parameterCategory, Model model,
                               HttpServletRequest httpServletRequest) {

        HttpSession session = httpServletRequest.getSession();
        String sessionId = (String) session.getAttribute("userid");

        if(sessionId != null && !sessionId.isEmpty()) {
            model.addAttribute("sessionId", sessionId);
        }

        List<CommunityCategoryVo> CCtables = communityCategoryImpl.ViewCommunityCategory();
        List<CommunityVo> Ctables = communityImpl.ViewCommunity(parameterCategory);

        List<List<CommunityCategoryVo>> groupedCCtables = new ArrayList<>();
        for(int i = 0; i < CCtables.size(); i += 6) {
            int end = Math.min(i + 6, CCtables.size());
            groupedCCtables.add(CCtables.subList(i, end));
        }

        List<List<CommunityVo>> groupedCtables = new ArrayList<>();
        for(int i = 0; i < Ctables.size(); i += 3) {
            int end = Math.min(i + 3, Ctables.size());
            groupedCtables.add(Ctables.subList(i, end));
        }

        List<List<List<CommunityVo>>> pageTables = new ArrayList<>();
        for(int i = 0; i < groupedCtables.size(); i += 3) {
            int end = Math.min(i + 3, groupedCtables.size());
            pageTables.add(groupedCtables.subList(i, end));
        }


        model.addAttribute("ViewCommunityCategory", groupedCCtables);
        model.addAttribute("ViewCommunity", groupedCtables);
        model.addAttribute("ViewpageTables", pageTables);
        model.addAttribute("parameterCommunity", parameterCommunity);
        model.addAttribute("parameterPageGroup", parameterPageGroup);
        model.addAttribute("parameterCategory", parameterCategory);

        return "content/messageBoard";
    }

}
