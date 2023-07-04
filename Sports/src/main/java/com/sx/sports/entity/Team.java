package com.sx.sports.entity;

public class Team {
    private String teamCode;
    private String teamName;
    public String getCTeamCode(){return teamCode;}
    public void setTeamCode(String teamCode){
        this.teamCode=teamCode;
    }
    public String getTeamName(){return teamName;}
    public void setTeamName(String teamName){
        this.teamName=teamName;
    }
    @Override
    public String toString() {
        return "Team{" +
                "teamCode=" + teamCode +'\'' +
                ", teamName='" + teamName + '\'' +
                '}';
    }
}
