package com.sx.sports.entity;

public class FollowMatch {
    private String userName;
    private String matchCode;
    public String getUserName(){return userName;}
    public void setUserName(String userName){
        this.userName=userName;
    }
    public String getMatchCode(){return matchCode;}
    public void setMatchCode(String matchCode){
        this.matchCode=matchCode;
    }

    @Override
    public String toString() {
        return "FollowMatch{" +
                "userName=" + userName +'\'' +
                ", matchCode='" + matchCode +'\'' +
                '}';
    }

}
