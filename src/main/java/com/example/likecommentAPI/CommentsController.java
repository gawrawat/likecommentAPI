package com.example.likecommentAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
