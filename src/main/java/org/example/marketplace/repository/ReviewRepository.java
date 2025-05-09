package org.example.marketplace.repository;

import org.example.marketplace.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query("select r from Review r where r.product.id = :productId")
    List<Review> findReviewsByProductId(@Param("productId") long productId);

    @Query("select r from Review r where r.user.id = :userId")
    List<Review> findReviewsByUserId(@Param("userId") long userId);

}