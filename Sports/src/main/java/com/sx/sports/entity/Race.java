package com.sx.sports.entity;
import java.util.Date;
public class Race {
    private String raceCode;
    private  String raceName;
    private  String genre;
    public String getRaceCode(){return raceCode;}
    public void setRaceCoed(String raceCode){
        this.raceCode=raceCode;
    }
    public String getRaceName(){
        return raceName;
    }
    public void setRaceName(String matchName){
        this.raceName=raceName;
    }
    public String getGenre(){
        return genre;
    }
    public void setGenre(String genre){
        this.genre=genre;
    }
    @Override
    public String toString() {
        return "Race{" +
                "raceCode=" + raceName +'\'' +
                ", raceName='" + raceName + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
