package com.project.SnakeProject.service.impl;

import com.project.SnakeProject.mapper.MemberMapper;
import com.project.SnakeProject.service.MemberService;
import com.project.SnakeProject.vo.CommunityVo;
import com.project.SnakeProject.vo.MemberInInfoVo;
import com.project.SnakeProject.vo.MemberVo;
import com.project.SnakeProject.vo.StudyInPareVo;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberMapper memberMapper;

    @Override
    public int addMember(MemberVo memberVo) {
        return memberMapper.addMember(memberVo);
    }

    @Override
    public boolean selectId(String id) {
        return memberMapper.selectId(id);
    }

    @Override
    public String login(MemberVo memberVo, HttpSession session) {
        return memberMapper.login(memberVo);
    }

    @Override
    public MemberVo selectInfo(String id) {
        return memberMapper.selectInfo(id);
    }

    @Override
    public int updateInfo(MemberVo memberVo) {
        return memberMapper.updateInfo(memberVo);
    }

    @Override
    public List<CommunityVo> MyPageCommunity(String id) {
        return memberMapper.MyPageCommunity(id);
    }

    @Override
    public boolean selectPass(String MemberId, String MemberPw) {
        return memberMapper.selectPass(MemberId, MemberPw);
    }

    @Override
    public boolean deleteInfo(String MemberId) {
        return memberMapper.deleteInfo(MemberId);
    }

    @Override
    public List<StudyInPareVo> selectPareInfo() {
        return memberMapper.selectPareInfo();
    }

    @Override
    public boolean inupdate(HashMap<String, Object> params) {
        return memberMapper.inupdate(params);
    }

    @Override
    public MemberInInfoVo selectPareInInfo(String id) {
        return memberMapper.selectPareInInfo(id);
    }
}
