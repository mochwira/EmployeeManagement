package com.wira.EmployeeManagement.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class NewUserDetail implements UserDetails{

    private String email;
    private String password;
    private List<GrantedAuthority> authorities; //type dari coolection memungkinkan untuk menggunakan lebih dari satu role user

    public NewUserDetail(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.authorities = Arrays.asList(new SimpleGrantedAuthority("ROLE_" + name));// di custom dsini jadi hanya bisa memakai satu role
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
