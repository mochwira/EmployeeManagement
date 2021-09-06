package com.wira.EmployeeManagement.controller;

import com.wira.EmployeeManagement.model.Kategori;
import com.wira.EmployeeManagement.repository.*;
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

    @Autowired
    private DepartementRepository departementRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProjectRepository projectRepository;

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
        model.addAttribute("departements", departementRepository.findAll(PageRequest.of(page, 8)));
        model.addAttribute("rolers", roleRepository.findAll());
        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("projects", projectRepository.findAll());

        return "home/home.html";
    }
}
