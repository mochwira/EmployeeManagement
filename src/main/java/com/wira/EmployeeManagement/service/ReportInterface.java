package com.wira.EmployeeManagement.service;


import com.wira.EmployeeManagement.model.Reports;

public interface ReportInterface {
    void save(Reports reports);
    Iterable<Reports> getAll();
}
