package org.example.marketplace.controller;

import lombok.RequiredArgsConstructor;
import org.example.marketplace.model.Review;
import org.example.marketplace.service.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("")
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @GetMapping("/{id}")
    public Review getReviewById(@PathVariable long id) {
        return reviewService.getReviewById(id);
    }

    @PostMapping("")
    public Review saveReview(@RequestBody Review review) {
        return reviewService.saveReview(review);
    }

    @DeleteMapping("/{id}")
    public void deleteReviewById(@PathVariable long id) {
        reviewService.deleteReviewById(id);
    }
}

