package com.wira.EmployeeManagement.controller;

import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Reference
public class SettingController {

    @GetMapping("/setting")
    public String getSetting(Model model) {

        System.out.println("ini Setting");
        return "setting/setting.html";
    }
}
