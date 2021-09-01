package com.wira.EmployeeManagement.controller;

import com.wira.EmployeeManagement.model.Employees;
import com.wira.EmployeeManagement.repository.EmployeeRepository;
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
public class EmployeeListController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employeelist")
    public String createIndex(Model model, @RequestParam(defaultValue = "0", name = "page") int page) {

        model.addAttribute("employeel", employeeRepository.findAll(PageRequest.of(page, 8)));
        model.addAttribute("buatPageEmployee", page);
        model.addAttribute ( "buatEmployee", new Employees());
        return "/employee/employeelist.html";
    }

    @PostMapping("/saveemployee")
    //@Valid BindingResult bindingResult
    public String saveEmployee(@Valid Employees employees, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "redirect:/employeelist";
        }

        employeeRepository.save(employees);

        return "redirect:/employeelist";
    }

    @GetMapping("/deleteemployee")
    public String deleteEmployee(@RequestParam("employeeId") Integer employeeId) {
        //something problem in here
        employeeRepository.deleteById((Integer) employeeId);

        return "redirect:/employeelist";
    }
}
