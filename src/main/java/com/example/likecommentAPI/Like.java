package com.example.likecommentAPI;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "likes")
public class Like {

    @Id
    private ObjectId id;
    private String courseId;
    private String title;
    private int likeCount;

    // Constructors
    public Like() {}

    public Like(ObjectId id, String courseId, String title, int likeCount) {
        this.id = id;
        this.courseId = courseId;
        this.title = title;
        this.likeCount = likeCount;
    }

    // Getters and Setters
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }
}
