package com.wira.EmployeeManagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class HelpController {

    @GetMapping("/help")
    public String getHelp(Model model) {

        System.out.println("ini Help");
        return "help/help.html";
    }
}
