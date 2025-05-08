package org.example.marketplace.service;

import lombok.RequiredArgsConstructor;
import org.example.marketplace.repository.UserOrderRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Primary
public class UserOrderService {

    private final UserOrderRepository userOrderRepository;

}
