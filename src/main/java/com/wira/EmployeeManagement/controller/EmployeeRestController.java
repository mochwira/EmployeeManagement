package com.wira.EmployeeManagement.controller;

import com.wira.EmployeeManagement.model.Departement;
import com.wira.EmployeeManagement.model.Employees;
import com.wira.EmployeeManagement.model.Reports;
import com.wira.EmployeeManagement.repository.DepartementRepository;
import com.wira.EmployeeManagement.repository.EmployeeRepository;
import com.wira.EmployeeManagement.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeRestController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    public DepartementRepository departementRepository;

    @GetMapping("/findemployee")
    public Employees createFindOne(@RequestParam("employeeId") Integer employeeId, Integer departementId) {
        Employees e = new Employees();

//        Departement de = new Departement();

        Employees em = employeeRepository.getOne(employeeId);

//        Departement dpm = departementRepository.getOne(departementId);
        //init
        e.setEmployeeId(em.getEmployeeId());
        e.setFirstName(em.getFirstName());
        e.setLastName(em.getLastName());
        e.setEmail(em.getEmail());
        e.setUserId(em.getUserId());
        //e.setDepartementId(em.getDepartementId());
//        de.setDepartementId(dpm.getDepartementId());
//        de.setDepartementName(dpm.getDepartementName());



        return e;
    }
}
