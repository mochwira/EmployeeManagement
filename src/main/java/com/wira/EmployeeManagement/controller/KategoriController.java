package com.wira.EmployeeManagement.controller;

import com.wira.EmployeeManagement.model.Kategori;
import com.wira.EmployeeManagement.repository.KategoriRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class KategoriController {

    @Autowired
    private KategoriRepository kategoriRepository;

    @GetMapping("/kategori")
    public String createIndex(Model model, @RequestParam(defaultValue = "0", name = "page") int page) {
        //model.addAttribute("kategoris", kategoriRepositoryJpa.findAll(new PageRequest(page, 4)));
        model.addAttribute("kategoris", kategoriRepository.findAll(PageRequest.of(page, 8)));
        model.addAttribute("buatPageKategori", page);
        model.addAttribute ( "buatKategori", new Kategori());
        return "/kategori/kategori.html";
    }

    @PostMapping("/save")
    //@Valid BindingResult bindingResult
    public String save( Kategori kategori) {
//        if(bindingResult.hasErrors()){
//            return "redirect:/kategori";
//        }

        kategoriRepository.save(kategori);

        return "redirect:/kategori";
    }

    @GetMapping("/delete")
    public String deleteKategori(@RequestParam("kategoriId") int kategoriId) {
        kategoriRepository.deleteById(kategoriId);

        return "redirect:/kategori";
    }
}
