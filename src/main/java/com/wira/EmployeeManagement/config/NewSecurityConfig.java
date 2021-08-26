package com.wira.EmployeeManagement.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalAuthentication
public class NewSecurityConfig  extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

    //ini lama
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService); //To change body of generated methods, choose Tools | Templates.
    }

    @Override //mengatur map kemana
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()

                .antMatchers("/").permitAll()
                //.antMatchers("/report").hasRole("admin")
                //.antMatchers("/User").permitAll()
                .antMatchers("/password/forgot").permitAll()
                .antMatchers(HttpMethod.POST, "/password/forgot/request").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                //.successHandler(customSuccessHandler)
                .usernameParameter("email")
                .passwordParameter("password")
                //.failureUrl("/department")
                .permitAll()
                .and().csrf()
                .and()
                .exceptionHandling()
                .accessDeniedPage("/accsess_denied")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                //.addLogoutHandler(new SecurityLogout())
                .logoutSuccessUrl("/");
        ;
    }

    //ini bean default
    @Bean
    public PasswordEncoder getPasswordEncoder(){

        return NoOpPasswordEncoder.getInstance();
    }
}
