package org.example.marketplace.service;

import lombok.RequiredArgsConstructor;
import org.example.marketplace.model.Role;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Primary
public class PermissionService {

    private final RoleService roleService;

    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    public Role getRoleById(long id) {
        return roleService.getRoleById(id);
    }

    public Role saveRole(Role role) {
        return roleService.saveRole(role);
    }

    public void deleteRoleById(long id) {
        roleService.deleteRoleById(id);
    }
}
