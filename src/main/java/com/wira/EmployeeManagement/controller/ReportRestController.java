package com.wira.EmployeeManagement.controller;

import com.wira.EmployeeManagement.model.Reports;
import com.wira.EmployeeManagement.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportRestController {

    @Autowired
    private ReportRepository reportRepository;

    @GetMapping("/findreport")
    public Reports createFindOne(@RequestParam("reportId") Long reportId) {
        Reports r = new Reports();
        Reports rp = reportRepository.getOne(reportId);

        //init
        r.getReportId();
        r.setReportName(rp.getReportName());
        r.setKategoriId(rp.getKategoriId());
        r.setReportDetail(rp.getReportDetail());
        r.setReportTime(rp.getReportTime());
        r.setEmployeeId(rp.getEmployeeId());

        return r;
    }

}


