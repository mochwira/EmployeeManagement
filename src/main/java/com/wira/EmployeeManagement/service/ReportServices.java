package com.wira.EmployeeManagement.service;

import com.wira.EmployeeManagement.model.Reports;
import com.wira.EmployeeManagement.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.util.List;

@Service
public class ReportServices implements ReportInterface {

    @Autowired
    private ReportRepository reportRepository;

    @Override
    public void save(Reports reports) {
         reportRepository.save(reports);
    }

    @Override
    public Iterable<Reports> getAll() {
        return reportRepository.findAll();
    }
}
