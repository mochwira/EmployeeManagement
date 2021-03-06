package com.wira.EmployeeManagement.controller;

import com.wira.EmployeeManagement.model.Reports;
import com.wira.EmployeeManagement.model.Role;
import com.wira.EmployeeManagement.model.User;
import com.wira.EmployeeManagement.repository.ReportRepository;
import com.wira.EmployeeManagement.repository.RoleRepository;
import com.wira.EmployeeManagement.repository.UserRepository;
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
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public RoleRepository roleRepository;

    @GetMapping("/user")
    public String createIndex(Model model, @RequestParam(defaultValue = "0", name = "page") int page) {
        //model.addAttribute("kategoris", kategoriRepositoryJpa.findAll(new PageRequest(page, 4)));
        model.addAttribute("users", userRepository.findAll(PageRequest.of(page, 8)));
        model.addAttribute("buatPageUser", page);
        model.addAttribute ( "buatUser", new User());
        model.addAttribute("rolers", roleRepository.findAll());
        return "/user/user.html";
    }

    @PostMapping("/saveuser")
    public String save(@Valid User user, Role role, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "redirect:/user";
        }

        userRepository.save(user);
        roleRepository.save(role);

        return "redirect:/user";
    }

    @GetMapping("/deleteuser")
    public String deleteUser(@RequestParam("usertId") Long userId, Long roleId) {
        userRepository.deleteById(userId);
        roleRepository.deleteById(roleId);

        return "redirect:/user";
    }
}
