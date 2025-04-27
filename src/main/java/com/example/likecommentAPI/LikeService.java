package com.example.likecommentAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class LikeService {
    @Autowired
    private LikeRepository likeRepository;

    public List<Like> getAllLikes() {
        return likeRepository.findAll();
    }
}
