package com.sx.sports.entity;
import java.util.Date;
public class Match {
    private String matchCode;
    private String matchName;
    private Date matchTime;
    private Integer raceCode;


    public String getMatchCode(){return matchCode;}
    public void setMatchCode(String matchCode){
        this.matchCode=matchCode;
    }
    public String getMatchName(){
        return matchName;
    }
    public void setMatchName(String matchName){
        this.matchName=matchName;
    }
    public Date getMatchTime(){
        return matchTime;
    }
    public void setMatchTime(Date matchTime){
        this.matchTime=matchTime;
    }
    public Integer getRaceCode(){return raceCode;}
    public void setRaceCode(Integer raceCode){
        this.raceCode=raceCode;
    }

    @Override
    public String toString() {
        return "Member{" +
                "matchCode=" + matchCode +'\'' +
                ", matchName='" + matchName + '\'' +
                ", matchTime='" + matchTime +
                ", raceCode='" + raceCode +
                '}';
    }
}
