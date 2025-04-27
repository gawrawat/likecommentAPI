package com.example.likecommentAPI;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.stream.Collectors;

@Document(collection = "comments")
public class Comments {
    @Id
    private ObjectId id;
    private String courseId;
    private List<String> comments;

    @Transient
    private List<Object> parsedComments;

    // Constructors
    public Comments() {}

    public Comments(ObjectId id, String courseId, List<String> comments) {
        this.id = id;
        this.courseId = courseId;
        this.comments = comments;
    }

    // Getters and Setters
    public ObjectId getId() { return id; }
    public void setId(ObjectId id) { this.id = id; }
    public String getCourseId() { return courseId; }
    public void setCourseId(String courseId) { this.courseId = courseId; }
    public List<String> getComments() { return comments; }
    public void setComments(List<String> comments) { this.comments = comments; }

    public List<Object> getParsedComments() {
        if (this.parsedComments != null) {
            return this.parsedComments;
        }
        
        if (this.comments == null) return null;
        
        ObjectMapper mapper = new ObjectMapper();
        this.parsedComments = this.comments.stream()
            .map(comment -> {
                try {
                    return mapper.readValue(comment, Object.class);
                } catch (Exception e) {
                    return comment; // fallback to string if parsing fails
                }
            })
            .collect(Collectors.toList());
        
        return this.parsedComments;
    }
        
    public void addComment(String newComment) {
            this.comments.add(newComment);
        }
}