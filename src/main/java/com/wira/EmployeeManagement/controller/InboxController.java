package com.wira.EmployeeManagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class InboxController {
    @GetMapping("/inbox")
    public String getInbox(Model model) {

        System.out.println("ini Inbox");
        return "inbox/inbox.html";
    }
}
