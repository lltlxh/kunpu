package com.sx.sports.entity;

public class FollowGenre {
    private String userName;
    private Integer genre;

    public String getUserName(){return userName;}
    public void setUserName(String userName){
        this.userName=userName;
    }
    public Integer getGenre(){return genre;}
    public void setGenre(Integer genre){
        this.genre=genre;
    }
    @Override
    public String toString() {
        return "FollowGenre{" +
                "userName=" + userName +'\'' +
                ", genre='" + genre +
                '}';
    }
}
