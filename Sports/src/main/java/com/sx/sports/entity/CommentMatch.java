package com.sx.sports.entity;
import java.util.Date;
public class CommentMatch {
    private String commentCode;
    private String content;
    private String matchCode;
    private String userName;
    private Integer Likes;

    public String getCommentCode(){return commentCode;}
    public void setCommentCode(String commentCode){
        this.commentCode=commentCode;
    }
    public String getContent(){return content;}
    public void setContent(String content){
        this.content=content;
    }
    public String getMatchCode(){return matchCode;}
    public void setMatchCode(String matchCode){
        this.matchCode=matchCode;
    }
    public String getUserName(){return userName;}
    public void setUserName(String userName){
        this.userName=userName;
    }
    public Integer getLikes(){return Likes;}
    public void setLikes(Integer Likes ){
        this.Likes= Likes;
    }
    @Override
    public String toString() {
        return "CommentMatch{" +
                "commentCode=" + commentCode +'\'' +
                ", content='" + content +'\'' +
                ", matchCode='" + matchCode + '\'' +
                ", userName='" + userName +'\'' +
                ", Likes='" + Likes +
                '}';
    }
}
