package com.wira.EmployeeManagement.service;

import com.wira.EmployeeManagement.model.Project;
import com.wira.EmployeeManagement.model.Reports;

import java.io.ByteArrayInputStream;
import java.util.List;

public interface ProjectFileService {
    ByteArrayInputStream export(List<Project> projects);
}
