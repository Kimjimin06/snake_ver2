package com.project.SnakeProject.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@Data
public class MemberVo {
    private String MemberId;
    private String MemberPw;
    private String MemberName;
    int MemberSex;
    String MemberPhone;
    Date MregDate;

    // CommunityVo에서 사용할 회원 이름 하나만 정의
    public MemberVo(String memberName) {
        MemberName = memberName;
    }

    public MemberVo(String memberId, String memberName) {
        MemberId = memberId;
        MemberName = memberName;
    }


    // 회원 탈퇴 비밀번호 vo
//    public MemberVo(String memberId, String memberPw) {
//        this.MemberId = memberId;
//        this.MemberPw = memberPw;
//    }

    public MemberVo(String memberPw, String memberName, String memberPhone) {
        MemberPw = memberPw;
        MemberName = memberName;
        MemberPhone = memberPhone;
    }

    public MemberVo(String memberId, String memberPw, String memberName, int memberSex, String memberPhone) {
        this.MemberId = memberId;
        this.MemberPw = memberPw;
        this.MemberName = memberName;
        this.MemberSex = memberSex;
        this.MemberPhone = memberPhone;
    }

    public MemberVo(String memberId, String memberPw, String memberName, int memberSex, String memberPhone, Date mregDate) {
        MemberId = memberId;
        MemberPw = memberPw;
        MemberName = memberName;
        MemberSex = memberSex;
        MemberPhone = memberPhone;
        MregDate = mregDate;
    }

    public String getMemberId() {
        return MemberId;
    }

    public void setMemberId(String memberId) {
        MemberId = memberId;
    }

    public String getMemberPw() {
        return MemberPw;
    }

    public void setMemberPw(String memberPw) {
        MemberPw = memberPw;
    }

    public String getMemberName() {
        return MemberName;
    }

    public void setMemberName(String memberName) {
        MemberName = memberName;
    }
    public int getMemberSex() {
        return MemberSex;
    }

    public void setMemberSex(int memberSex) {
        MemberSex = memberSex;
    }

    public String getMemberPhone() {
        return MemberPhone;
    }

    public void setMemberPhone(String memberPhone) {
        MemberPhone = memberPhone;
    }

    public Date getMregDate() {
        return MregDate;
    }

    public void setMregDate(Date mregDate) {
        MregDate = mregDate;
    }
}
