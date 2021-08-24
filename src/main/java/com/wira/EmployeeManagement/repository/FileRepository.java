package com.wira.EmployeeManagement.repository;

import com.wira.EmployeeManagement.model.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<File, Integer> {
}
