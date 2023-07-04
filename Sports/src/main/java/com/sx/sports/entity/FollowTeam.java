package com.sx.sports.entity;

public class FollowTeam {
    private String userName;
    private String teamCode;
    public String getUserName(){return userName;}
    public void setUserName(String userName){
        this.userName=userName;
    }
    public String getTeamCode(){return teamCode;}
    public void setTeamCode(String teamCode){
        this.teamCode=teamCode;
    }
    @Override
    public String toString() {
        return "FollowTeam{" +
                "userName=" + userName +'\'' +
                ", teamCode='" + teamCode+ '\'' +
                '}';
    }
}
