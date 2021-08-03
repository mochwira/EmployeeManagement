package com.wira.EmployeeManagement.controller;

import com.wira.EmployeeManagement.model.Reports;
import com.wira.EmployeeManagement.repository.EmployeeRepository;
import com.wira.EmployeeManagement.repository.ProjectRepository;
import com.wira.EmployeeManagement.repository.ReportRepository;
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
public class ReportFileController {

    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private ReportService reportService;

    @GetMapping("/report")
    public String index() {
        return "/report/reportfile.html";
    }

    @GetMapping("/userfile")
    public void downloadExcelFile(HttpServletResponse response) throws IOException {
        List<Reports> reports = (List<Reports>)reportRepository.findAll();
        ByteArrayInputStream byteArrayInputStream = reportService.export(reports);
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=reports.xlsx");
        IOUtils.copy(byteArrayInputStream, response.getOutputStream());

    }
}
