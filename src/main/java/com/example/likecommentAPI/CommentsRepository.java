package com.example.likecommentAPI;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CommentsRepository extends MongoRepository<Comments, ObjectId> {
    
    List<Comments> findByCourseId(String courseId);
    

}