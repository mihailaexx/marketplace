package org.example.marketplace.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "cart_products")
public class CartProduct {
    @Id
    @GeneratedValue
    @Column(updatable = false)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(updatable = false, nullable = false, name = "cart_id")
    private UserCart userCart;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(updatable = false, nullable = false, name = "product_id")
    private Product product;

    @Column(nullable = false)
    private int quantity;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime addedAt;
}
