package com.wira.EmployeeManagement.controller;

import com.wira.EmployeeManagement.model.User;
import com.wira.EmployeeManagement.repository.RoleRepository;
import com.wira.EmployeeManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public RoleRepository roleRepository;

    @GetMapping("/finduser")
    public User createFindOne(@RequestParam("userId") Long userId, Long roleId) {
        User u = new User();
         User up = userRepository.getOne(userId);

        //init
        u.getUserId();
        u.setFirstName(up.getFirstName());
        u.setLastName(up.getLastName());
        u.setEmail(up.getEmail());
        u.setPassword(up.getPassword());
        u.setRoleId(up.getRoleId());

        return u;
    }
}
