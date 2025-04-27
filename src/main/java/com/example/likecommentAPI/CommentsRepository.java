package com.example.likecommentAPI;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsRepository extends MongoRepository<Comments, ObjectId> {

    
    Optional<Comments> findById(ObjectId id);
    List<Comments> findByCourseId(String courseId);
}
