package com.wira.EmployeeManagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class AboutController {

    @GetMapping("/about")
    public String getAbout(Model model) {

        System.out.println("ini About");
        return "about/about.html";
    }
}
