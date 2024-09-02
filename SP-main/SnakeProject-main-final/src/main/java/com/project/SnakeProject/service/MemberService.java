package com.project.SnakeProject.service;

import com.project.SnakeProject.vo.*;
import jakarta.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.List;

public interface MemberService {
    public int addMember(MemberVo memberVo);
    // 중복확인
    public boolean selectId(String Id);
    // 로그인
    public String login(MemberVo memberVo, HttpSession session);
    // 개인정보수정 이동시 나오는 정보들
    public MemberVo selectInfo(String id);
    // 개인정보 수정
    public int updateInfo(MemberVo memberVo);
    // 개인이 작성한 글 확인
    List<CommunityVo> MyPageCommunity(String id);
    // 비밀번호 체크 / 회원탈퇴
    public boolean selectPass(String MemberId, String MemberPw);
    public boolean deleteInfo(String MemberId);

    public List<StudyInPareVo> selectPareInfo();
    public boolean inupdate(HashMap<String, Object> params);
    public MemberInInfoVo selectPareInInfo(String id);

    public MemberAlarmVo memberAlarm(String MIdx);
}
