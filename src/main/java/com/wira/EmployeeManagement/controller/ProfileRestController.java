package com.wira.EmployeeManagement.controller;

import com.wira.EmployeeManagement.model.Kategori;
import com.wira.EmployeeManagement.model.User;
import com.wira.EmployeeManagement.repository.KategoriRepository;
import com.wira.EmployeeManagement.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileRestController {

    @Autowired
    private ProfileRepository profileRepository;

    @GetMapping("/findprofile")
    public User createFindOne(@RequestParam("userId") Long userId) {
        User up = new User();
        User usp = profileRepository.getOne(userId);

        //init
        up.setUserId(usp.getUserId());
        up.setFirstName(usp.getFirstName());
        up.setLastName(usp.getLastName());
        up.setEmail(usp.getEmail());
        up.setPassword(usp.getPassword());

        return up;
    }
}
