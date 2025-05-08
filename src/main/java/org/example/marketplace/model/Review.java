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
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue
    @Column(updatable = false)
    private long id;

    @ManyToOne
    @JoinColumn(updatable = false, name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(updatable = false, name = "product_id")
    private Product product;

    @Column(nullable = false)
    private int rating;

    @Column(nullable = false, length = 300)
    private String text;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
