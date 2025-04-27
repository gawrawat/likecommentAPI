package com.example.likecommentAPI.dto;

public class NewCommentRequest {
    private String courseId;
    private String comment;

    // Getters and Setters
    public String getCourseId() { return courseId; }
    public String getComment() { return comment; }
    
    public void setCourseId(String courseId) { this.courseId = courseId; }
    public void setComment(String comment) { this.comment = comment; }
}