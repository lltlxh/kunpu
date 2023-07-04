package com.sx.sports.entity;
import java.util.Date;
public class CommentPost {
    private String commentID;
    private String content;
    private String userName;
    private Integer Likes;
    public String getCommentID(){return commentID;}
    public void setCommentID(String commentID){
        this.commentID=commentID;
    }
    public String getContent(){return content;}
    public void setContent(String content){
        this.content=content;
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
        return "CommentPost{" +
                "commentID=" + commentID +'\'' +
                ", content='" + content +'\'' +
                ", userName='" + userName + '\'' +
                ", Likes='" + Likes+'\'' +
                '}';
    }
}
