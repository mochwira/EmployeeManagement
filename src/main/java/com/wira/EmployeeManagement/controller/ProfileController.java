package com.wira.EmployeeManagement.controller;

import com.wira.EmployeeManagement.model.Kategori;
import com.wira.EmployeeManagement.model.User;
import com.wira.EmployeeManagement.repository.KategoriRepository;
import com.wira.EmployeeManagement.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class ProfileController {

    @Autowired
    private ProfileRepository profileRepository;

    @GetMapping("/profile")
    public String createIndex(Model model, @RequestParam(defaultValue = "0", name = "page") int page) {
        model.addAttribute("profiles", profileRepository.findAll(PageRequest.of(page, 8)));
        model.addAttribute("buatPageProfile", page);
        model.addAttribute ( "buatProfile", new User());
        return "/profile/profile.html";
    }

    @PostMapping("/save")
    //@Valid BindingResult bindingResult
    public String save(@Valid User user, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "redirect:/profile";
        }

        profileRepository.save(user);

        return "redirect:/profile";
    }

    @GetMapping("/delete")
    public String deleteProfile(@RequestParam("userId") Long userId) {
        profileRepository.deleteById(userId);

        return "redirect:/profile";
    }
}
