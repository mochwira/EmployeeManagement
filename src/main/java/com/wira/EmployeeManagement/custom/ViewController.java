package com.wira.EmployeeManagement.custom;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    @RequestMapping("/viewproduct")
    public String viewProducts() {
        return "/product/viewproduct.html";
    }
    @RequestMapping("/addproduct")
    public String addProducts() {
        return "/product/addproduct.html";
    }
}
