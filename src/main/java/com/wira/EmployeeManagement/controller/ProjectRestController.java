package com.wira.EmployeeManagement.controller;

import com.wira.EmployeeManagement.model.Project;
import com.wira.EmployeeManagement.model.Reports;
import com.wira.EmployeeManagement.repository.ProjectRepository;
import com.wira.EmployeeManagement.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectRestController {

    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping("/findone")
    public Project createFindOne(@RequestParam("projectId") Long projectId) {
        Project p = new Project();
        Project pj = projectRepository.getOne(projectId);

        //init
        p.getProjectId();
        p.setNamaProject(pj.getNamaProject());
        p.setKeteranganProject(pj.getKeteranganProject());
        p.setAsalProject(pj.getAsalProject());
        p.setDurasiProject(pj.getDurasiProject());

        return p;
    }
}
