package com.wira.EmployeeManagement.service;

import com.wira.EmployeeManagement.model.User;

public interface UserInterface {
    void save(User user);
    Iterable<User> getAll();

    User getEmail(String email);
    User getPassword(String password);
}
