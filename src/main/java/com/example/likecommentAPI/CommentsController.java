package com.example.likecommentAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentsController {

    @Autowired
    private CommentsRepository commentsRepository;

    @GetMapping
    public ResponseEntity<List<Comments>> allComments() {
        List<Comments> commentsList = commentsRepository.findAll();
        return ResponseEntity.ok(commentsList);
    }

    @GetMapping
public ResponseEntity<List<Object>> allComments() {
    List<Comments> commentsList = commentsRepository.findAll();
    List<Object> response = commentsList.stream()
        .map(comments -> {
            Map<String, Object> map = new HashMap<>();
            map.put("id", comments.getId());
            map.put("courseId", comments.getCourseId());
            map.put("comments", comments.getParsedComments());
            return map;
        })
        .collect(Collectors.toList());
    return ResponseEntity.ok(response);
}
}
