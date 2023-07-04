package com.sx.sports.entity;

public class AttendMatch {
    private String teamCode;
    private String matchCode;
    private Integer result;
    public String getTeamCode(){return teamCode;}
    public void setTeamCode(String teamCode){
        this.teamCode=teamCode;
    }
    public String getMatchCode(){return matchCode;}
    public void setMatchCode(String matchCode){
        this.matchCode=matchCode;
    }
    public Integer getResult(){return result;}
    public void setLikes(Integer result){
        this.result= result;
    }
    @Override
    public String toString() {
        return "AttendMatch{" +
                "teamCode=" + teamCode +'\'' +
                ", matchCode='" + matchCode +'\'' +
                ", result='" + result +
                '}';
    }
}
