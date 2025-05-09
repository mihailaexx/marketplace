package org.example.marketplace.service;

import lombok.RequiredArgsConstructor;
import org.example.marketplace.model.Permission;
import org.example.marketplace.repository.PermissionRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Primary
public class PermissionService {

    private final PermissionRepository permissionRepository;

    public List<Permission> getAllPermissions() {
        return permissionRepository.findAll();
    }

    public Permission getPermissionById(long id) {
        return permissionRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Permission not found")
        );
    }

    public Permission savePermission(Permission permission) {
        return permissionRepository.save(permission);
    }

    public void deletePermissionById(long id) {
        permissionRepository.deleteById(id);
    }
}
