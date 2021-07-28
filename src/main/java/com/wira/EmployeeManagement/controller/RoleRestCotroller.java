package com.wira.EmployeeManagement.controller;

import com.wira.EmployeeManagement.model.Kategori;
import com.wira.EmployeeManagement.model.Role;
import com.wira.EmployeeManagement.repository.KategoriRepository;
import com.wira.EmployeeManagement.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleRestCotroller {
    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/findone")
    public Role createFindOne(@RequestParam("roleId") Integer roleId) {
        Role r = new Role();
        Role rl = roleRepository.getOne(Long.valueOf(roleId));

        //init
        r.setRoleId(rl.getRoleId());
        r.setName(rl.getName());

        return r;
    }
}
