package org.example.marketplace.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.marketplace.service.GenerateSlug;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue
    @Column(updatable = false)
    private long id;

    @Column(nullable = false, unique = true, length = 50)
    private String name;

    @ManyToOne
    @JoinColumn(updatable = false, name = "user_id")
    private User seller;

    @Column(length = 500)
    private String description;

    @Column(nullable = false, length = 7)
    private Double price;

    @Column(length = 2)
    private int discount;

    @Column(length = 1000)
    private String image;

    @Column(length = 6)
    private int quantity;

    @Column(length = 1000)
    private String url;

    @ManyToOne
    @JoinColumn(updatable = false, name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product")
    private Set<Review> reviews;

    @Column(nullable = false, unique = true, length = 150)
    private String slug;
    @PrePersist
    public void generateSlug() {
        this.slug = GenerateSlug.generateSlug(this.name);
    }
}
