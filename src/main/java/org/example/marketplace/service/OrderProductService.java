package org.example.marketplace.service;


import lombok.RequiredArgsConstructor;
import org.example.marketplace.repository.OrderProductsRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Primary
public class OrderProductService {

    private final OrderProductsRepository orderProductsRepository;

}
