package org.example.marketplace.repository;

import org.example.marketplace.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByUsername(@Param("username") String username);
    Boolean existsUserByUsername(@Param("username") String username);

    Optional<User> findUserByEmail(@Param("email") String email);
    Boolean existsUserByEmail(@Param("email") String email);

}