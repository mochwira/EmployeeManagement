package com.wira.EmployeeManagement.controller;

import com.wira.EmployeeManagement.model.Departement;
import com.wira.EmployeeManagement.repository.DepartementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartementRestController {

    @Autowired
    private DepartementRepository departementRepository;

    @GetMapping("/finddepartement")
    public Departement createFindOne(@RequestParam("departementId") Integer departementId) {
        Departement d = new Departement();
        Departement dp = departementRepository.getOne(departementId);

        //init
        d.setDepartementId(dp.getDepartementId());
        d.setDepartementName(dp.getDepartementName());

        return d;
    }
}
