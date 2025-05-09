package org.example.marketplace.repository;

import org.example.marketplace.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query("SELECT r FROM Role r JOIN r.users u WHERE u.id = :userId")
    List<Role> findRolesByUserId(@Param("userId") long userId);

    @Query("SELECT r FROM Role r JOIN r.permissions p WHERE p.id = :permissionId")
    List<Role> findRolesByPermissionId(@Param("permissionId") long permissionId);
}