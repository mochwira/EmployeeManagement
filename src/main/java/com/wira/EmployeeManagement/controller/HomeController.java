package com.wira.EmployeeManagement.controller;

import com.wira.EmployeeManagement.model.Kategori;
import com.wira.EmployeeManagement.repository.KategoriRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    private KategoriRepository kategoriRepository;

//    @GetMapping("/home")
//    public String getHome(Model model) {
//
//        System.out.println("home");
//        return "home/home.html";
//    }



    @GetMapping("/home")
    public String createIndex(Model model, @RequestParam(defaultValue = "0", name = "page") int page) {
        model.addAttribute("kategoris", kategoriRepository.findAll(PageRequest.of(page, 8)));
        model.addAttribute("buatPageKategori", page);
        model.addAttribute ( "buatKategori", new Kategori());
        return "home/home.html";
    }
}
