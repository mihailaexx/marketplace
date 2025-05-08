package org.example.marketplace.service;

import lombok.RequiredArgsConstructor;
import org.example.marketplace.model.UserCart;
import org.example.marketplace.repository.UserCartRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Primary
public class UserCartService {

    private final UserCartRepository userCartRepository;

    public UserCart getUserCartById(long id) {
        return userCartRepository.findById(id).orElseThrow(
                () -> new RuntimeException("UserCart not found")
        );
    }

    public UserCart saveUserCart(UserCart userCart) {
        return userCartRepository.save(userCart);
    }

    public void deleteUserCartById(long id) {
        userCartRepository.deleteById(id);
    }
}
