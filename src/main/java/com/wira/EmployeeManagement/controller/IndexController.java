package com.wira.EmployeeManagement.controller;


import com.wira.EmployeeManagement.custom.EventCustom;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping({ "/", "/event" })
public class IndexController {

    @GetMapping
    public String main(Model model) {
        model.addAttribute("event", new EventCustom());
        return "/event.html";
    }

    @PostMapping
    public String save(EventCustom event, Model model) {
        model.addAttribute("event", event);
        return "/saved.html";
    }
}
