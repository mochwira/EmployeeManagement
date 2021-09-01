package com.wira.EmployeeManagement.repository;


import com.wira.EmployeeManagement.model.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employees, Integer> {
}
