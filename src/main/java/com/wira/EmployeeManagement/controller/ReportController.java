package com.wira.EmployeeManagement.controller;

import com.wira.EmployeeManagement.model.Kategori;
import com.wira.EmployeeManagement.model.Project;
import com.wira.EmployeeManagement.model.Reports;

import com.wira.EmployeeManagement.repository.KategoriRepository;
import com.wira.EmployeeManagement.repository.ProjectRepository;
import com.wira.EmployeeManagement.repository.ReportRepository;
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
public class ReportController {

    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    public KategoriRepository kategoriRepository;

    @Autowired
    public ProjectRepository projectRepository;


    @GetMapping("/report")
    public String createIndex(Model model, @RequestParam(defaultValue = "0", name = "page") int page) {

        model.addAttribute("reports", reportRepository.findAll(PageRequest.of(page, 8)));
        model.addAttribute("buatPageReport", page);
        model.addAttribute ( "buatReport", new Reports());
        model.addAttribute("kategoris", kategoriRepository.findAll());
        model.addAttribute("projects", projectRepository.findAll());
        return "/report/report.html";
    }

    @PostMapping("/savereport")
    public String save(@Valid Reports reports, Kategori kategori, Project project, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "redirect:/report";
        }

        reportRepository.save(reports);
        kategoriRepository.save(kategori);
        projectRepository.save(project);

        return "redirect:/report";
    }

    @GetMapping("/deletereport")
    public String deleteReport(@RequestParam("reportId") Long reportId, Integer kategoriId, Long projectId) {
        reportRepository.deleteById(reportId);
        kategoriRepository.deleteById(kategoriId);
        projectRepository.deleteById(projectId);

        return "redirect:/report";
    }
}
