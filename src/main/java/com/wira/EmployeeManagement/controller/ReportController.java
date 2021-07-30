package com.wira.EmployeeManagement.controller;

import com.wira.EmployeeManagement.model.Kategori;
import com.wira.EmployeeManagement.model.Reports;
import com.wira.EmployeeManagement.repository.KategoriRepository;
import com.wira.EmployeeManagement.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReportController {

    @Autowired
    private ReportRepository reportRepository;

    @GetMapping("/report")
    public String createIndex(Model model, @RequestParam(defaultValue = "0", name = "page") int page) {
        //model.addAttribute("kategoris", kategoriRepositoryJpa.findAll(new PageRequest(page, 4)));
        model.addAttribute("reports", reportRepository.findAll(PageRequest.of(page, 8)));
        model.addAttribute("buatPageReport", page);
        model.addAttribute ( "buatReport", new Reports());
        return "/report/report.html";
    }

    @PostMapping("/save")
    public String save( Reports reports) {


        reportRepository.save(reports);

        return "redirect:/report";
    }

    @GetMapping("/delete")
    public String deleteReport(@RequestParam("reportId") int reportId) {
        reportRepository.deleteById(reportId);

        return "redirect:/report";
    }
}
