package org.example.marketplace.service;

import lombok.RequiredArgsConstructor;
import org.example.marketplace.repository.LikeProductsRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Primary
public class LikeProductService {

    private final LikeProductsRepository likeProductsRepository;

}
