package com.example.likecommentAPI;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class LikeService {
    @Autowired
    private LikeRepository likeRepository;

    public List<Like> getAllLikes() {
        return likeRepository.findAll();
    }

    public Optional<Like> singleLike(ObjectId id) {
        return likeRepository.findById(id);
    }

    public Like singleLikeByCourseId(String courseId) {
        return likeRepository.findByCourseId(courseId);
    }

    public Like addLike(String courseId) {
        Like like = likeRepository.findByCourseId(courseId);
    
        if (like != null) {
            like.setLikeCount(like.getLikeCount() + 1);
            return likeRepository.save(like);
        } else {
            throw new RuntimeException("Course with id " + courseId + " not found");
        }
    }

    public Like deleteLike(String courseId) {
        Like like = likeRepository.findByCourseId(courseId);
    
        if (like != null) {
            if (like.getLikeCount() > 0) {
                like.setLikeCount(like.getLikeCount() - 1);
                return likeRepository.save(like);
            } else {
                throw new RuntimeException("Like count is already 0 for course: " + courseId);
            }
        } else {
            throw new RuntimeException("Course with id " + courseId + " not found");
        }
    }
    
    
}
