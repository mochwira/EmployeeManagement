package com.wira.EmployeeManagement.service;



import com.wira.EmployeeManagement.model.User;
import com.wira.EmployeeManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServices implements UserInterface{

    @Autowired
    private UserRepository userRepository;


    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public Iterable<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getEmail(String email) {
        return userRepository.getEmail(email);
    }

    @Override
    public User getPassword(String password) {
        return userRepository.getPassword(password);
    }

}
