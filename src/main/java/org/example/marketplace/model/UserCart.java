package org.example.marketplace.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "user_cart")
public class UserCart {
    @Id
    @GeneratedValue
    @Column(updatable = false)
    private long id;

    @JsonBackReference("user-cart")
    @OneToOne
    @JoinColumn(updatable = false, nullable = false, name = "user_id")
    private User user;

    @OneToMany(mappedBy = "userCart", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CartProduct> cartProducts = new HashSet<>();
}
