package com.project.SnakeProject.vo;

import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
public class MemberInInfoVo {
    int MIdx;
    int SeatNum;
    int MuseTime;
    Date MStateInDate;
    Date MEndInDate;
    String differnce;

    public MemberInInfoVo(int museTime, String differnce) {
        MuseTime = museTime;
        this.differnce = differnce;
    }

    public int getMIdx() {
        return MIdx;
    }

    public void setMIdx(int MIdx) {
        this.MIdx = MIdx;
    }

    public int getSeatNum() {
        return SeatNum;
    }

    public void setSeatNum(int seatNum) {
        SeatNum = seatNum;
    }

    public int getMuseTime() {
        return MuseTime;
    }

    public void setMuseTime(int museTime) {
        MuseTime = museTime;
    }

    public Date getMStateInDate() {
        return MStateInDate;
    }

    public void setMStateInDate(Date MStateInDate) {
        this.MStateInDate = MStateInDate;
    }

    public Date getMEndInDate() {
        return MEndInDate;
    }

    public void setMEndInDate(Date MEndInDate) {
        this.MEndInDate = MEndInDate;
    }

    public String getDiffernce() {
        return differnce;
    }

    public void setDiffernce(String differnce) {
        this.differnce = differnce;
    }
}
