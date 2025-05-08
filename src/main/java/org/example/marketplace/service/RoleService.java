package org.example.marketplace.service;

import lombok.RequiredArgsConstructor;
import org.example.marketplace.model.Role;
import org.example.marketplace.repository.RoleRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Primary
public class RoleService {

    private final RoleRepository roleRepository;

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Role getRoleById(long id) {
        return roleRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Role not found")
        );
    }

    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    public void deleteRoleById(long id) {
        roleRepository.deleteById(id);
    }
}
