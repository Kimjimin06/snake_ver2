package com.project.SnakeProject.mapper;

import com.project.SnakeProject.vo.CommunityVo;
import com.project.SnakeProject.vo.MemberInInfoVo;
import com.project.SnakeProject.vo.MemberVo;
import com.project.SnakeProject.vo.StudyInPareVo;
import jakarta.servlet.http.HttpSession;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.lang.reflect.Member;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Mapper
public interface MemberMapper {
    // 회원가입
    public int addMember(MemberVo memberVo);
    // 중복확인
    public boolean selectId(String Id);
    // 로그인
    public String login(MemberVo memberVo);
    // 개인정보수정 이동시 나오는 정보들
    public MemberVo selectInfo(String id);
    // 개인정보 수정
    public int updateInfo(MemberVo memberVo);
    // 개인이 작성한 게시글
    List<CommunityVo> MyPageCommunity(String id);
    // 회원 탈퇴를 위한 비밀번호 체크
    public boolean selectPass(@Param("MemberId") String MemberId, @Param("MemberPw") String MemberPw);
    // 회원 정보 삭제
    public boolean deleteInfo(@Param("MemberId") String MemberId);
    // 개인 시간 충전할 때 나오는 list 정보
    public List<StudyInPareVo> selectPareInfo();
    // 개인 충전
    public boolean inupdate(HashMap<String, Object> params);

    public MemberInInfoVo selectPareInInfo(String id);
}
