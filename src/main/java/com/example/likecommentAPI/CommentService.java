package com.example.likecommentAPI;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.likecommentAPI.dto.NewCommentRequest;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentService {
    @Autowired
    private CommentsRepository commentsRepository;

    public List<Map<String, Object>> getAllCommentsWithParsedContent() {
        List<Comments> commentsList = commentsRepository.findAll();
        
        return commentsList.stream()
            .map(comments -> {
                Map<String, Object> map = new HashMap<>();
                map.put("id", comments.getId());
                map.put("courseId", comments.getCourseId());
                map.put("comments", comments.getParsedComments());
                return map;
            })
            .collect(Collectors.toList());
    }

    public Map<String, Object> getCommentById(String id) {
        Optional<Comments> comment = commentsRepository.findById(new ObjectId(id));
        if (comment.isEmpty()) {
            System.out.println("Comment not found with id: " + id);  // Changed print to System.out.println
            return null;  // Added return null when comment not found
        }
        
        Map<String, Object> response = new HashMap<>();
        response.put("id", comment.get().getId());
        response.put("courseId", comment.get().getCourseId());
        response.put("comments", comment.get().getParsedComments());
        
        return response;
    }

    public List<Map<String, Object>> getCommentsByCourseId(String courseId) {
        List<Comments> comments = commentsRepository.findByCourseId(courseId);
        return comments.stream()
            .map(comment -> {
                Map<String, Object> map = new HashMap<>();
                map.put("id", comment.getId());
                map.put("courseId", comment.getCourseId());
                map.put("comments", comment.getParsedComments());
                return map;
            })
            .collect(Collectors.toList());
    }
    

    public Comments addNewComment(NewCommentRequest newCommentRequest) {
        List<Comments> existingComments = commentsRepository.findByCourseId(newCommentRequest.getCourseId());
    
        if (!existingComments.isEmpty()) {
            Comments existing = existingComments.get(0);
            existing.addComment(newCommentRequest.getContent());
            return commentsRepository.save(existing);
        } else {
            Comments newComments = new Comments();
            newComments.setCourseId(newCommentRequest.getCourseId());
            newComments.setComments(List.of(newCommentRequest.getContent()));
            return commentsRepository.save(newComments);
        }
    }
    

}