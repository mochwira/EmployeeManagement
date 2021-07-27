package com.wira.EmployeeManagement.service;


import com.wira.EmployeeManagement.model.Employees;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeService {
    List<Employees> getAllEmployees();
    void saveEmployee(Employees employee);
    Employees getEmployeeById(long id);
    void deleteEmployeeById(long id);
    Page<Employees> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

}
