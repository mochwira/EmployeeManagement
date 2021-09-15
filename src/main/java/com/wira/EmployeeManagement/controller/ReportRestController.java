package com.wira.EmployeeManagement.controller;

import com.wira.EmployeeManagement.model.Kategori;
import com.wira.EmployeeManagement.model.Reports;

import com.wira.EmployeeManagement.repository.KategoriRepository;
import com.wira.EmployeeManagement.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class ReportRestController {

    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    public KategoriRepository kategoriRepository;

    @GetMapping("/findreport")
    public Reports createFindOne(@RequestParam("reportId") Long reportId,
                                 @RequestParam("kategoriId") Integer kategoriId,
                                 @RequestParam("reportTime") Date reportTime,
                                 @RequestParam("reportName") String reportName,
                                 @RequestParam("employeeId") Integer employeeId,
                                 @RequestParam("projectId") Long projectId,
                                 @RequestParam("reportDetail") String reportDetail
                                 ) {
        Reports r = new Reports();

        Reports rp = reportRepository.getOne(reportId);


        //init
        r.getReportId();
        r.setReportName(rp.getReportName());
        r.setKategoriId(rp.getKategoriId());
        r.setEmployeeId(rp.getEmployeeId());
        r.setProjectId(rp.getProjectId());
        r.setReportDetail(rp.getReportDetail());
        r.setReportTime(rp.getReportTime());

        return r;
    }

}


