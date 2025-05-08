package org.example.marketplace.service;

import lombok.RequiredArgsConstructor;
import org.example.marketplace.model.UserLike;
import org.example.marketplace.repository.UserLikeRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Primary
public class UserLikeService {

    private final UserLikeRepository userLikeRepository;

    public UserLike getUserLikeById(long id) {
        return userLikeRepository.findById(id).orElseThrow(
                () -> new RuntimeException("UserLike not found")
        );
    }

    public UserLike saveUserLike(UserLike userLike) {
        return userLikeRepository.save(userLike);
    }

    public void deleteUserLikeById(long id) {
        userLikeRepository.deleteById(id);
    }
}
