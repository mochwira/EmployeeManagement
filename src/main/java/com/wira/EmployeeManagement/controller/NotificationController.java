package com.wira.EmployeeManagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class NotificationController {
    @GetMapping("/notification")
    public String getNotification(Model model) {

        System.out.println("notice");
        return "notification/notification.html";
    }
}
