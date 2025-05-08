package org.example.marketplace.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "user_like")
public class UserLike {
    @Id
    @GeneratedValue
    @Column(updatable = false)
    private long id;

    @JsonBackReference("user-like")
    @OneToOne
    @JoinColumn(updatable = false, nullable = false, name = "user_id")
    private User user;

    @OneToMany(mappedBy = "userLike", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<LikeProducts> likeProducts = new HashSet<>();

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime addedAt;
}