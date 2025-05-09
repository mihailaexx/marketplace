package org.example.marketplace.repository;

import org.example.marketplace.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PermissionRepository extends JpaRepository<Permission, Long> {

    @Query("SELECT DISTINCT p FROM User u JOIN u.roles r JOIN r.permissions p WHERE u.id = :userId")
    List<Permission> findPermissionByUserId(@Param("userId") long userId);

    @Query("SELECT DISTINCT p FROM Role r JOIN r.permissions p WHERE r.id = :roleId")
    List<Permission> findPermissionByRoleId(@Param("roleId") long roleId);
}