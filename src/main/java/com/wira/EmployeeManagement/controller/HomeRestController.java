package com.wira.EmployeeManagement.controller;


import com.wira.EmployeeManagement.model.*;

import com.wira.EmployeeManagement.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeRestController {
    @Autowired
    private KategoriRepository kategoriRepository;

    @Autowired
    private DepartementRepository departementRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping("/findhome")
    public Kategori createFindOne(@RequestParam("kategoriId") Integer kategoriId) {
        Kategori k = new Kategori();
        Kategori tmp = kategoriRepository.getOne(kategoriId);

        //init
        k.setKategoriId(tmp.getKategoriId());
        k.setNamaKategori(tmp.getNamaKategori());

        return k;
    }

    @GetMapping("/finddept")
    public Departement createFindDept(@RequestParam("departementId") Integer departementId) {
        Departement dp = new Departement();
        Departement dpr = departementRepository.getOne(departementId);

        //init
        dp.setDepartementId(dpr.getDepartementId());
        dp.setDepartementName(dpr.getDepartementName());

        return dp;
    }

    @GetMapping("/findrolers")
    public Role createFindRoles(@RequestParam("roleId") Long roleId) {
        Role re = new Role();
        Role rlo =  roleRepository.getOne(roleId);

        //init
        re.setRoleId(rlo.getRoleId());
        re.setName(rlo.getName());

        return re;
    }

    @GetMapping("/findusers")
    public User createFindUsers(@RequestParam("userId") Long userId) {
        User us = new User();
        User usr =  userRepository.getOne(userId);

        //init
        us.setUserId(usr.getUserId());
        us.setFirstName(usr.getFirstName());
        us.setLastName(usr.getLastName());
        us.setEmail(usr.getEmail());

        return us;
    }

    @GetMapping("/findprojects")
    public Project createFindProject(@RequestParam("projectId") Long projectId) {
        Project po = new Project();
        Project pjr =  projectRepository.getOne(projectId);

        //init
        po.setNamaProject(pjr.getNamaProject());
        po.setKeteranganProject(pjr.getKeteranganProject());
        po.setAsalProject(pjr.getAsalProject());
        po.setDurasiProject(pjr.getDurasiProject());

        return po;
    }
}
