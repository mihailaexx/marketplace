package org.example.marketplace.repository;

import org.example.marketplace.model.UserCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCartRepository extends JpaRepository<UserCart, Long> {
}