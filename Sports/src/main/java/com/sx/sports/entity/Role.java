package com.sx.sports.entity;
import java.util.Date;
public class Role {

    private String userName;
    private String pwd;
    private String sex;
    private Integer grade;
    private String intro;
    private Integer privilege;

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName=userName;
    }

    public String getPwd() {
        return pwd;
    }
    public void setPwd(String pwd) {
        this.pwd=pwd;
    }

    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex=sex;
    }

    public Integer getGrade() {
        return grade;
    }
    public void setGrade(Integer grade) {
        this.grade=grade;
    }
    public String getIntro() {
        return intro;
    }
    public void setIntro(String intro) {
        this.intro=intro;
    }

    public Integer getPrivilege() {
        return privilege;
    }
    public void setPrivilege(Integer privilege) {
        this.privilege=privilege;
    }

    @Override
    public String toString() {
        return "Role{" +
                "userName=" + userName +'\'' +
                ", pwd='" + pwd + '\'' +
                ", sex='" + sex + '\'' +
                ", grade='" + grade +
                ", intro='" + intro + '\'' +
                ", privilege=" + privilege +
                '}';
    }
}
