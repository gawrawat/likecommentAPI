package com.example.likecommentAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentsController {

    @Autowired
    private CommentService commentService;

    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> getAllComments() {
        List<Map<String, Object>> response = commentService.getAllCommentsWithParsedContent();
        return ResponseEntity.ok(response);
    }

        @GetMapping("/{id}")
    public Comments getCommentById(@PathVariable String id) {
        return commentService.getCommentById(id);
    }

    @GetMapping("/course/{courseId}")
    public List<Comments> getCommentsByCourseId(@PathVariable String courseId) {
        return commentService.getCommentsByCourseId(courseId);
    }
}
