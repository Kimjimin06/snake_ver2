package com.project.SnakeProject.controller;

import com.project.SnakeProject.service.impl.StudyPareServiceImpl;
import com.project.SnakeProject.vo.StudyGPareVo;
import com.project.SnakeProject.vo.StudyInPareVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class detailController {

    @Autowired
    private StudyPareServiceImpl studyPareService;

    @RequestMapping(value="/detail", method = RequestMethod.GET)
    public String detail(Model model) throws Exception {
        List<StudyInPareVo> typeList = new ArrayList<>();
        List<StudyInPareVo> selectList1 = new ArrayList<>();
        List<StudyInPareVo> selectList2 = new ArrayList<>();
        List<StudyGPareVo> selectList3 = new ArrayList<>();

        typeList.addAll(studyPareService.typeList());
        selectList1.addAll(studyPareService.selectList1());
        selectList2.addAll(studyPareService.selectList2());
        selectList3.addAll(studyPareService.selectList3());

        String type1 = typeList.get(0).getSIPName();
        String type2 = typeList.get(1).getSIPName();

        model.addAttribute("type1", type1);
        model.addAttribute("type2", type2);
        model.addAttribute("selectList1", selectList1);
        model.addAttribute("selectList2", selectList2);
        model.addAttribute("selectList3", selectList3);

        model.addAttribute("title", "요금정보");
        return "content/detail";
    }
}
