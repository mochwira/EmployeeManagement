package com.wira.EmployeeManagement.service;

import com.wira.EmployeeManagement.model.Reports;

import java.io.ByteArrayInputStream;
import java.util.List;

public interface ReportFileService {
    ByteArrayInputStream export(List<Reports> reports);
}
