package com.example.likecommentAPI;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "comments")
public class Comments {

    @Id
    private ObjectId id;
    private String courseId;
    private List<String> comments;

    // Constructors
    public Comments() {}

    public Comments(ObjectId id, String courseId, List<String> comments) {
        this.id = id;
        this.courseId = courseId;
        this.comments = comments;
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

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }
}
