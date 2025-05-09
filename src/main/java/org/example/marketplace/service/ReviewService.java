package org.example.marketplace.service;

import lombok.RequiredArgsConstructor;
import org.example.marketplace.model.Review;
import org.example.marketplace.repository.ReviewRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Primary
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

//    public List<Review> getReviewsOnProductByProductId(long productId) {
//        return reviewRepository.findReviewsByProductId(productId);
//    }

    public Review getReviewById(long id) {
        return reviewRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Review not found")
        );
    }

    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }

    public void deleteReviewById(long id) {
        reviewRepository.deleteById(id);
    }
}
