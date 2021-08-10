package com.wira.EmployeeManagement.service;

import com.wira.EmployeeManagement.model.NewUserDetail;
import com.wira.EmployeeManagement.model.Role;
import com.wira.EmployeeManagement.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailServiceCustome implements UserDetailsService {

    @Autowired
    private UserServices userServices;

    @Autowired
    private RoleService roleService;

//    @Autowired
//    private RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userServices.getEmail(email);


//        TblRole rolee = roleService.getRoleById(roleid);

        String emails = user.getEmail();
        System.out.println("email " + emails);
        //getpasswords
        String password = user.getPassword();
        System.out.println("password " +password);
        Long roleid = user.getRoleId().getRoleId();
        System.out.println("role " +roleid);

        Optional<Role> rolee = roleService.getRoleById(roleid);
        //Optional<TblRole> rolee = roleRepository.findById(roleid);
        String role = rolee.get().getName();
        System.out.println("role " +role);

        //cek pemanggilan ini mungkin pakai emailS
        return new NewUserDetail(emails, password, role);
    }

}
