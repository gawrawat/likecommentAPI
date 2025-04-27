package com.example.likecommentAPI;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@RestController
@RequestMapping("/api/v1/likes")
public class LikeController {

    @Autowired
    private LikeService likeService;

    @GetMapping
    public ResponseEntity<List<Like>> getAllLikes() {
        List<Like> likes = likeService.getAllLikes();
        return new ResponseEntity<>(likes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Like> getSingleLike(@PathVariable ObjectId id) {
        return likeService.singleLike(id)
                .map(like -> new ResponseEntity<>(like, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @GetMapping("/course/{courseId}")
    public ResponseEntity<Like> getLikeByCourseId(@PathVariable String courseId) {
        Like like = likeService.singleLikeByCourseId(courseId);
        if (like != null) {
            return new ResponseEntity<>(like, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/addLike/{courseId}")
    public ResponseEntity<Like> addLike(@PathVariable String courseId) {
        Like updatedLike = likeService.addLike(courseId);
        return new ResponseEntity<>(updatedLike, HttpStatus.OK);
    }

    @DeleteMapping("/deleteLike/{courseId}")
    public ResponseEntity<Like> deleteLike(@PathVariable String courseId) {
        Like updatedLike = likeService.deleteLike(courseId);
        return new ResponseEntity<>(updatedLike, HttpStatus.OK);
    }
}
