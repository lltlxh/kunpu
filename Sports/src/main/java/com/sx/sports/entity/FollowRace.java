package com.sx.sports.entity;

public class FollowRace {
    private String userName;
    private String raceCode;

    public String getUserName(){return userName;}
    public void setUserName(String userName){
        this.userName=userName;
    }
    public String getRaceCode(){return raceCode;}
    public void setRaceCode(String raceCode){
        this.raceCode=raceCode;
    }

    @Override
    public String toString() {
        return "FollowRace{" +
                "userName=" + userName +'\'' +
                ", raceCode='" + raceCode +'\'' +
                '}';
    }
}
