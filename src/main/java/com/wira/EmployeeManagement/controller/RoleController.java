package com.wira.EmployeeManagement.controller;


import com.wira.EmployeeManagement.model.Role;
import com.wira.EmployeeManagement.repository.RoleRepository;
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

    @PostMapping("/saverole")
    //@Valid BindingResult bindingResult
    public String saveRole(@Valid Role role, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "redirect:/role";
        }

        roleRepository.save(role);

        return "redirect:/role";
    }

    @GetMapping("/deleterole")
    public String deleteRole(@RequestParam("roleId") Long roleId) {
        //something problem in here
        roleRepository.deleteById((Long) roleId);

        return "redirect:/role";
    }
}
