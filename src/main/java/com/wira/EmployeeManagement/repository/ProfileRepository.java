package com.wira.EmployeeManagement.repository;

import com.wira.EmployeeManagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<User, Long> {
}
