package com.wira.EmployeeManagement.controller;

import com.wira.EmployeeManagement.model.Kategori;
import com.wira.EmployeeManagement.model.Reports;
import com.wira.EmployeeManagement.repository.KategoriRepository;
import com.wira.EmployeeManagement.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportRestController {

    @Autowired
    private ReportRepository reportRepository;

    @GetMapping("/findone")
    public Reports createFindOne(@RequestParam("reportId") Integer reportId) {
        Reports r = new Reports();
        Reports rp = reportRepository.getOne(reportId);

        //init
        r.getReportId();
        r.setReportName(rp.getReportName());

        return r;
    }

}


