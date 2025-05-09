package org.example.marketplace.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "permissions")
public class Permission {
    @Id
    @GeneratedValue
    @Column(updatable = false)
    private long id;

    @Column(updatable = false, unique = true, nullable = false, length = 25)
    private String name;

    @ManyToMany(mappedBy = "permissions")
    private Set<Role> roles;
}
