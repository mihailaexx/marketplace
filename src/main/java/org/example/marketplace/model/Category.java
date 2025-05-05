package org.example.marketplace.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.marketplace.service.GenerateSlug;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue
    @Column(updatable = false)
    private long id;

    @Column(updatable = false, unique = true, nullable = false, length = 50)
    private String name;

    @Column(length = 500)
    private String description;

    @Column(nullable = false, unique = true, length = 150)
    private String slug;
    @PrePersist
    public void generateSlug() {
        this.slug = GenerateSlug.generateSlug(this.name);
    }
}
