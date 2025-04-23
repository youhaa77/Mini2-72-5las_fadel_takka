package com.example.demo.services;

import com.example.demo.models.Rating;
import com.example.demo.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingService {

    private final RatingRepository ratingRepository;

    @Autowired
    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    // Add a new rating
    public Rating addRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    // Update an existing rating
    public Rating updateRating(String id, Rating updatedRating) {
        Optional<Rating> existing = ratingRepository.findById(id);
        if (existing.isPresent()) {
            Rating r = existing.get();
            r.setScore(updatedRating.getScore());
            r.setComment(updatedRating.getComment());
            r.setRatingDate(updatedRating.getRatingDate());
            return ratingRepository.save(r);
        } else {
            throw new RuntimeException("Rating not found");
        }
    }

    // Delete rating
    public void deleteRating(String id) {
        ratingRepository.deleteById(id);
    }

    // Get ratings for a specific entity (by ID and type)
    public List<Rating> getRatingsByEntity(Long entityId, String entityType) {
        return ratingRepository.findByEntityIdAndEntityType(entityId, entityType);
    }

    // Get ratings with score above a threshold
    public List<Rating> findRatingsAboveScore(int minScore) {
        return ratingRepository.findByScoreGreaterThan(minScore);
    }
}

