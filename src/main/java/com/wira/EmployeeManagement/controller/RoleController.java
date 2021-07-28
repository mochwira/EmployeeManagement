package com.wira.EmployeeManagement.controller;

import com.wira.EmployeeManagement.model.Kategori;
import com.wira.EmployeeManagement.model.Role;
import com.wira.EmployeeManagement.repository.KategoriRepository;
import com.wira.EmployeeManagement.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class RoleController {
    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/role")
    public String createIndex(Model model, @RequestParam(defaultValue = "0", name = "page") int page) {
        //model.addAttribute("kategoris", kategoriRepositoryJpa.findAll(new PageRequest(page, 4)));
        model.addAttribute("roles", roleRepository.findAll(PageRequest.of(page, 8)));
        model.addAttribute("buatPageRole", page);
        model.addAttribute ( "buatRole", new Role());
        return "/role/role.html";
    }

    @PostMapping("/save")
    //@Valid BindingResult bindingResult
    public String save( Role role) {
//        if(bindingResult.hasErrors()){
//            return "redirect:/kategori";
//        }

        roleRepository.save(role);

        return "redirect:/role";
    }

    @GetMapping("/delete")
    public String deleteRole(@RequestParam("roleId") int roleId) {
        //something problem in here
        roleRepository.deleteById((long) roleId);

        return "redirect:/kategori";
    }
}
