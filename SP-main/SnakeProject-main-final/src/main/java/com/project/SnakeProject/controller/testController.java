package com.project.SnakeProject.controller;

import com.project.SnakeProject.service.BoardService;
import com.project.SnakeProject.vo.BoardVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class testController {

    @Autowired
    private BoardService boardService;

    @RequestMapping(value = "test")
    public String test(Model model){
        List<BoardVo> tables = new ArrayList<>();
        tables.addAll(boardService.viewAll());

        model.addAttribute("viewAll", tables);
        return "content/test";
    }
}
