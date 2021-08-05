package com.wira.EmployeeManagement.controller;

import com.wira.EmployeeManagement.model.Project;
import com.wira.EmployeeManagement.model.Reports;
import com.wira.EmployeeManagement.repository.ProjectRepository;
import com.wira.EmployeeManagement.repository.ReportRepository;
import com.wira.EmployeeManagement.service.ProjectFileService;
import com.wira.EmployeeManagement.service.ReportService;
import org.apache.commons.compress.utils.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@Controller
public class ProjectFileController {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProjectFileService projectFileService;

    @GetMapping("/project")
    public String index() {
        return "/project/reportfile.html";
    }

    @GetMapping("/projectfile")
    public void downloadExcelFile(HttpServletResponse response) throws IOException {
        List<Project> projects = (List<Project>)projectRepository.findAll();
        ByteArrayInputStream byteArrayInputStream = projectFileService.export(projects);
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=reports.xlsx");
        IOUtils.copy(byteArrayInputStream, response.getOutputStream());

    }
}
