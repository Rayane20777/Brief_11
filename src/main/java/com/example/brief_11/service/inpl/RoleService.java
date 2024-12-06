package com.example.brief_11.service;

import com.example.brief_11.entity.Role;
import com.example.brief_11.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public void addDefaultRoles() {
        addRoleIfNotExists("USER");
        addRoleIfNotExists("ADMIN");
    }

    private void addRoleIfNotExists(String roleName) {
        if (roleRepository.findByName(roleName) == null) {
            Role role = new Role();
            role.setName(roleName);
            roleRepository.save(role);
        }
    }
}