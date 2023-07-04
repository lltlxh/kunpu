package com.sx.sports.entity;

public class Member {
    private String memberID;
    private String mName;
    private Integer grade;
    private String position;
    private String teamCode;

    public String getMemberID(){return memberID;}
    public void setMemberID(String memberID){
        this.memberID=memberID;
    }
    public String getMName(){return mName;}
    public void setMName(String mName){
        this.mName=mName;
    }
    public Integer getGrade(){return grade;}
    public void setTeamCode(Integer grade){
        this.grade=grade;
    }
    public String getPosition(){return position;}
    public void setPosition(String position){
        this.position=position;
    }
    public String getTeamCode(){return teamCode;}
    public void setTeamCode(String teamCode){
        this.teamCode=teamCode;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberID=" + memberID +'\'' +
                ",mName='" + mName + '\'' +
                ", grade='" + grade +
                ", position='" +  position+'\'' +
                ", teamCode='" + teamCode+ '\'' +
                '}';
    }

}
