package org.example.marketplace.repository;

import org.example.marketplace.model.LikeProducts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeProductsRepository extends JpaRepository<LikeProducts, Long> {
}