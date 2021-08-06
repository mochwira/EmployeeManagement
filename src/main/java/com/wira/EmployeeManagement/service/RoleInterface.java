package com.wira.EmployeeManagement.service;

import com.wira.EmployeeManagement.model.Role;

import java.util.Optional;

public interface RoleInterface {
    void save(Role role);
    Iterable<Role> getAll();
    public Optional<Role> getRoleById(Long roleId);
}
