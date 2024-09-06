package com.project.SnakeProject.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.SnakeProject.service.impl.StudyGInfoImpl;
import com.project.SnakeProject.vo.StudyGImgVo;
import com.project.SnakeProject.vo.StudyGInfoVo;
import com.project.SnakeProject.vo.StudyGOrderVo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.springframework.util.StringUtils.split;

@Controller
public class teamdetailController {
  @Autowired
  private StudyGInfoImpl studyGService;

  @RequestMapping(value = "/teamdetail", method = RequestMethod.GET)
  public String teamdetail(Model model,
                           @RequestParam("SGINum")  int SGINum){

    ObjectMapper objectMapper = new ObjectMapper();
    try {
      InputStream inputStream = getClass().getResourceAsStream("/static/info.json");
      Map<String, Object> jsonMap = objectMapper.readValue(inputStream, new TypeReference<Map<String, Object>>() {});
      model.addAttribute("info", jsonMap);
    } catch (IOException e) {
      e.printStackTrace();
    }

    StudyGInfoVo studyGInfoVo = studyGService.selectGInfo(SGINum);
    String[] studyGImg;
    studyGImg = studyGInfoVo.getStudyGImgVo().getSGImg().split(",");
//    System.out.println(studyGImg);

    model.addAttribute("studyGInfoVo", studyGInfoVo);
    model.addAttribute("studyGImg", studyGImg);
    return "content/teamdetail";
  }

  @PostMapping("/TeamOrder")
  public ResponseEntity<Boolean> teamOrder(StudyGOrderVo studyGOrderVo){
    boolean result = true;
    if(studyGService.InsertGOrder(studyGOrderVo)) {
      result = true;
    } else {
      result = false;
    }
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @GetMapping("/selectHour")
  @ResponseBody
  public List<StudyGOrderVo> selectHour(@RequestParam int selectedDay,
                                        @RequestParam int SGINum)  {
    List<StudyGOrderVo> List1 = new ArrayList<>();
    List1.addAll(studyGService.selectDay(selectedDay, SGINum));

    if(List1.size() > 0) {
      return List1;
    } else {
      return null;
    }
//    System.out.println(List1.get(0));

  }
}