package org.example.marketplace.service;

import lombok.RequiredArgsConstructor;
import org.example.marketplace.repository.CartProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Primary
public class CartProductService {

    private final CartProductRepository cartProductRepository;

}
