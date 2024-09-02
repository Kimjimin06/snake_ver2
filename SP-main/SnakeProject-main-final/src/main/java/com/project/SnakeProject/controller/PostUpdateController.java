package com.project.SnakeProject.controller;

import com.project.SnakeProject.service.impl.CommunityCategoryImpl;
import com.project.SnakeProject.service.impl.CommunityImpl;
import com.project.SnakeProject.service.impl.StudyGInfoImpl;
import com.project.SnakeProject.vo.CommunityCategoryVo;
import com.project.SnakeProject.vo.CommunityVo;
import com.project.SnakeProject.vo.StudyGInfoVo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.sql.rowset.serial.SerialJavaObject;
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PostUpdateController {

  @Autowired
  private CommunityImpl communityimpl;
  @Autowired
  private CommunityCategoryImpl communityCategoryimpl;
  @Autowired
  private StudyGInfoImpl studyGInfo;

  @GetMapping("/postUpdate")
  public String home(@RequestParam("postNum") int parameterPostNum, Model model, HttpServletRequest request){

    List<CommunityVo> communityTable = communityimpl.ViewContent(parameterPostNum);
    List<CommunityCategoryVo> categoryTable = communityCategoryimpl.ViewCommunityCategory();
    List<StudyGInfoVo> groupTable = studyGInfo.ViewStudyGInfo();

    Object Ctable = communityTable.get(0);
    String TogetherMemberName = ((CommunityVo) Ctable).getTogetherMemberName();
    String TogetherMemberId = ((CommunityVo) Ctable).getTogetherMemberId();
    String comPlaceRs = ((CommunityVo) Ctable).getComplace();
    String comAddressRs = ((CommunityVo) Ctable).getComAddress();
    String comZipCodeRs = ((CommunityVo) Ctable).getComZipcode();


    if(TogetherMemberName != null && !TogetherMemberName.isEmpty()) {
      String[] MemberName = TogetherMemberName.split(", ");
      model.addAttribute("MemberName", MemberName);
    }

    if(TogetherMemberId != null && !TogetherMemberId.isEmpty()) {
      String[] MemberId = TogetherMemberId.split(", ");
      model.addAttribute("MemberId", MemberId);
    }

    HttpSession session = request.getSession();
    String sessionId = (String) session.getAttribute("userid");

    model.addAttribute("parameterPostNum", parameterPostNum);
    model.addAttribute("communityTable", communityTable);
    model.addAttribute("categoryTable", categoryTable);
    model.addAttribute("groupTable", groupTable);
    model.addAttribute("comPlaceRs",comPlaceRs);
    model.addAttribute("comAddressRs", comAddressRs);
    model.addAttribute("comZipCodeRs", comZipCodeRs);


    if(sessionId != null && !sessionId.isEmpty()) {
      return "content/postUpdate";
    }
    else{
      return "content/postAlert";
    }
  }

  @PostMapping("/postRewrite")
  public String postRewrite(@RequestParam("postNum") int parameterPostNum,
                            @RequestParam(name = "MemberIdList", required = false) List<String> MemberIdList,
                            @RequestParam("MemberId") List<String> MemberId,
                            CommunityVo communityVo,
                            HttpServletRequest httpServletRequest, Model model) {

    //가져오는 날짜값을 sql적용시키기위해서 조금 변형한 것
    communityVo.setComStartDate((communityVo.getComStartDate().replace("T", " ")));
    communityVo.setComEndDate((communityVo.getComEndDate().replace("T", " ")));

//    //MemberId는 기존에 같이 스터디하는 사람들
//    System.out.println(MemberId);
//    //MemberIdList는 삭제되지 않을 사람들
//    System.out.println(MemberIdList);


    if(MemberIdList != null && !MemberIdList.isEmpty()) {
      for(int i=0; i<MemberId.size(); i++) {
        for(int j=0; j<MemberIdList.size(); j++) {
          if(MemberId.get(i).equals(MemberIdList.get(j))) {
            MemberId.remove(i);
          }
        }
      }
    }


//    String[] TogetherMemberId =  communityVo.getTogetherMemberId().split(", ");
//    System.out.println(TogetherMemberId);


    String RbuttonRS =  httpServletRequest.getParameter("inlineRadioOptions");
    String roomRbuttonRS = httpServletRequest.getParameter("studyroomSelection");


    if(RbuttonRS.contains("온라인")) {
      communityVo.setComAddress("");
      communityVo.setComplace(RbuttonRS);
      communityVo.setComZipcode("");
    }else if(RbuttonRS.contains("스터디룸")) {
      communityVo.setComAddress("경기도 안양시 만안구 양화로37번길 34");
      communityVo.setComplace(RbuttonRS + "(" + roomRbuttonRS + ")");
      communityVo.setComZipcode("14011");
    }


    int rs = communityimpl.updatePost(parameterPostNum, communityVo);

    HashMap<String, Object> parameters = new HashMap<>();
    parameters.put("parameterPostNum", parameterPostNum);
    parameters.put("MemberId", MemberId);


    if(rs > 0) {
      model.addAttribute("msg", "게시글수정이 완료되었습니다.");
      model.addAttribute("url", "/messageBoard?category=0&pageGroup=1&groupCommunity=1");
    }else{
      model.addAttribute("msg", "게시글수정이 실패했습니다. 다시 시도해주세요.");
      model.addAttribute("url", "/messageBoard?category=0&pageGroup=1&groupCommunity=1");
    }

    if(MemberId != null && !MemberId.isEmpty()) {
      int rs2 = communityimpl.DeleteToMember(parameters);

      if(rs2 > 0 && rs > 0) {
        model.addAttribute("msg", "게시글수정이 완료되었습니다.");
        model.addAttribute("url", "/messageBoard?category=0&pageGroup=1&groupCommunity=1");
      }else{
        model.addAttribute("msg", "게시글수정이 실패했습니다. 다시 시도해주세요.");
        model.addAttribute("url", "/messageBoard?category=0&pageGroup=1&groupCommunity=1");
      }
    }

    return "content/alert";
  }
}