package com.wira.EmployeeManagement.service;


import com.wira.EmployeeManagement.model.Role;
import com.wira.EmployeeManagement.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService implements RoleInterface{

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void save(Role role) {
        roleRepository.save(role);
    }

    @Override
    public Iterable<Role> getAll() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> getRoleById(Long roleId) {
        return Optional.empty();
    }
}
