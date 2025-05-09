package org.example.marketplace.controller;

import lombok.RequiredArgsConstructor;
import org.example.marketplace.model.Permission;
import org.example.marketplace.service.PermissionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/permissions")
@RequiredArgsConstructor
public class PermissionController {

    private final PermissionService permissionService;

    @GetMapping("")
    public List<Permission> getPermissions() {
        return permissionService.getAllPermissions();
    }

    @GetMapping("/{id}")
    public Permission getPermissionById(@PathVariable long id) {
        return permissionService.getPermissionById(id);
    }

    @PostMapping("")
    public Permission savePermission(@RequestBody Permission permission) {
        return permissionService.savePermission(permission);
    }

    @DeleteMapping("/{id}")
    public void deletePermissionById(@PathVariable long id) {
        permissionService.deletePermissionById(id);
    }
}

