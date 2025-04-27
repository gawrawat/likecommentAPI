package com.example.likecommentAPI;

import com.example.likecommentAPI.dto.NewCommentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public ResponseEntity<?> getCommentById(@PathVariable String id) {
        Map<String, Object> response = commentService.getCommentById(id);
        if (response == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<Map<String, Object>>> getCommentsByCourseId(@PathVariable String courseId) {
        List<Map<String, Object>> response = commentService.getCommentsByCourseId(courseId);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Comments> addComment(@RequestBody NewCommentRequest newCommentRequest) {
        Comments savedComment = commentService.addNewComment(newCommentRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedComment);
    }
}
