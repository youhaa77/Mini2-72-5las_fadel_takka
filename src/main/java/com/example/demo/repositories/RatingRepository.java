package com.example.demo.repositories;

import com.example.demo.models.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends MongoRepository<Rating, String> {

    // Find ratings by entity ID and type
    List<Rating> findByEntityIdAndEntityType(Long entityId, String entityType);

    // Find ratings with a score above a threshold
    List<Rating> findByScoreGreaterThan(int minScore);
}
