package com.wira.EmployeeManagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class ProfileController {

    @GetMapping("/profile")
    public String getProfile(Model model) {

        System.out.println("ini notification");
        return "profile/profile.html";
    }
}
