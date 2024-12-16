package com.book.Library.service;

import com.book.Library.model.Review;
import com.book.Library.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Optional<Review> getReviewById(Long id) {
        return reviewRepository.findById(id);
    }

    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }

    public Review updateReview(Long id, Review review) {
        Optional<Review> existingReview = reviewRepository.findById(id);
        if (existingReview.isPresent()) {
            Review updatedReview = existingReview.get();
            updatedReview.setUser(review.getUser());
            updatedReview.setBook(review.getBook());
            updatedReview.setReviewText(review.getReviewText());
            updatedReview.setRating(review.getRating());
            return reviewRepository.save(updatedReview);
        } else {
            throw new RuntimeException("Review not found with id " + id);
        }
    }

    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }
}
