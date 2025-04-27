package com.example.likecommentAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
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
}