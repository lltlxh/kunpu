package com.sx.sports.entity;

public class AttendRace {
    private String teamCode;
    private String raceCode;
    private Integer credit;
    public String getTeamCode(){return teamCode;}
    public void setTeamCode(String teamCode){
        this.teamCode=teamCode;
    }
    public String getRaceCode(){return raceCode;}
    public void setRaceCode(String raceCode){
        this.raceCode=raceCode;
    }
    public Integer getCredit(){return credit;}
    public void setCredit(Integer credit){
        this.credit= credit;
    }
    @Override
    public String toString() {
        return "AttendRace{" +
                "teamCode=" + teamCode +'\'' +
                ", raceCode='" + raceCode +'\'' +
                ", credit='" + credit +
                '}';
    }
}
