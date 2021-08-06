package com.wira.EmployeeManagement.repository;

import com.wira.EmployeeManagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT * FROM user JOIN role user.role_id = role.role_id WHERE user_id = :userId", nativeQuery = true)
    List<User> getUserById(@Param(value="userId") String userId);

    @Query(value = "SELECT * FROM user WHERE email= :email", nativeQuery = true)
    public User getEmail(@Param("email") String email);

    @Query(value = "SELECT u.password FROM user u WHERE password = :password", nativeQuery = true)
    public User getPassword(@Param("password") String password);

    User findByEmail(String email);

}
