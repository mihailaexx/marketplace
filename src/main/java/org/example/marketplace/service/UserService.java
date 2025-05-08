package org.example.marketplace.service;

import lombok.RequiredArgsConstructor;
import org.example.marketplace.model.User;
import org.example.marketplace.model.UserCart;
import org.example.marketplace.model.UserLike;
import org.example.marketplace.repository.UserRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Primary
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("User not found")
        );
    }

    public User saveUser(User user) {
        if (user.getUserCart() == null) {
            UserCart userCart = new UserCart();
            userCart.setUser(user);
            user.setUserCart(userCart);
        } else if (user.getUserCart().getUser() == null) {
            user.getUserCart().setUser(user);
        }
        
        if (user.getUserLike() == null) {
            UserLike userLike = new UserLike();
            userLike.setUser(user);
            user.setUserLike(userLike);
        } else if (user.getUserLike().getUser() == null) {
            user.getUserLike().setUser(user);
        }

        return userRepository.save(user);
    }

    public User updateUser(User user) {
        User existingUser = getUserById(user.getId());

        if (user.getUserCart() == null) {
            user.setUserCart(existingUser.getUserCart());
        } else if (user.getUserCart().getUser() == null) {
            user.getUserCart().setUser(user);
        }
        
        if (user.getUserLike() == null) {
            user.setUserLike(existingUser.getUserLike());
        } else if (user.getUserLike().getUser() == null) {
            user.getUserLike().setUser(user);
        }
        
        return userRepository.save(user);
    }

    public void deleteUserById(long id) {
        userRepository.deleteById(id);
    }
}