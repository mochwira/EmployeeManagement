package com.wira.EmployeeManagement.controller;

import com.wira.EmployeeManagement.model.Departement;
import com.wira.EmployeeManagement.repository.DepartementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class DepartementController {
    @Autowired
    private DepartementRepository departementRepository;

    @GetMapping("/departement")
    public String createIndex(Model model, @RequestParam(defaultValue = "0", name = "page") int page) {
        //model.addAttribute("kategoris", kategoriRepositoryJpa.findAll(new PageRequest(page, 4)));
        model.addAttribute("departements", departementRepository.findAll(PageRequest.of(page, 8)));
        model.addAttribute("buatPageDepartement", page);
        model.addAttribute ( "buatDepartement", new Departement());
        return "/departement/departement.html";
    }

    @PostMapping("/savedepartement")
    //@Valid BindingResult bindingResult
    public String save(@Valid Departement departement, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "departement";
        }

        departementRepository.save(departement);

        return "redirect:/departement";
    }

    @GetMapping("/deletedepartement")
    public String deleteDepartement(@RequestParam("departementId") int departementId) {
        departementRepository.deleteById(departementId);

        return "redirect:/kategori";
    }
}
