package com.example.likecommentAPI.dto;

public class NewCommentRequest {
    private String courseId;
    private String userId;
    private String content;

    // Constructors
    public NewCommentRequest() {
    }

    public NewCommentRequest(String courseId, String userId, String content) {
        this.courseId = courseId;
        this.userId = userId;
        this.content = content;
    }

    // Getters and Setters
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
