package com.wira.EmployeeManagement.service;

import com.wira.EmployeeManagement.dto.UserRegistrationDto;
import com.wira.EmployeeManagement.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);
}
