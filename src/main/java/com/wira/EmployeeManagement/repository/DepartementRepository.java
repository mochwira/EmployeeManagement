package com.wira.EmployeeManagement.repository;

import com.wira.EmployeeManagement.model.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartementRepository extends JpaRepository<Departement, Integer> {
}
