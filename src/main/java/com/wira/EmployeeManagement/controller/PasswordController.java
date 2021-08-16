package com.wira.EmployeeManagement.controller;


import com.wira.EmployeeManagement.model.User;
import com.wira.EmployeeManagement.service.SpringMailService;
import com.wira.EmployeeManagement.service.UserService;
import com.wira.EmployeeManagement.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping
public class PasswordController {

    @Autowired
    private UserServices userServices;
    @Autowired
    private SpringMailService springMailService;


    @GetMapping("/password/forgot")
    public String forgotPassword() {

        return "password/forgot.html";
    }

    @GetMapping("/password/reset")
    public String resetPassword() {

        return "password/resetpassword.html";
    }

    @PostMapping("/password/forgot/request")
    public String requestForgotPassword(
            @RequestParam(value = "email", required = true) String email){
        {
            User getUser = userServices.getEmail(email);
            String sender = getUser.getFirstName();

            //BISA ENCRYPT PAKAI IF ELSE
            String key = UUID.randomUUID().toString();

            String subject = "Password Reset";
            String content = "Use Code: " + key + ", or click on button bellow";
            String link = "http://localhost:8082/password/reset/";

            System.out.println("send mail running");

            Map<String, Object> model = new HashMap<>();
            model.put("title", subject);
            model.put("name", sender);
            model.put("message", content);
            model.put("tiketId", link);

            springMailService.sendMail(model, subject, email);
            return "redirect:/password/reset";
        }
    }
}
