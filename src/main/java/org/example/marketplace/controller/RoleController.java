package org.example.marketplace.controller;

import lombok.RequiredArgsConstructor;
import org.example.marketplace.model.Role;
import org.example.marketplace.service.RoleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @GetMapping("")
    public List<Role> getRoles() {
        return roleService.getAllRoles();
    }

    @GetMapping("/{id}")
    public Role getRoleById(@PathVariable long id) {
        return roleService.getRoleById(id);
    }

    @PostMapping("")
    public Role saveRole(@RequestBody Role role) {
        return roleService.saveRole(role);
    }

    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable long id) {
        roleService.deleteRoleById(id);
    }
}

