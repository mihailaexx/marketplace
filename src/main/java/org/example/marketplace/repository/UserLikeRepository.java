package org.example.marketplace.repository;

import org.example.marketplace.model.UserLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLikeRepository extends JpaRepository<UserLike, Long> {
}