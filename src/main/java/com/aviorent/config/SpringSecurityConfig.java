package com.aviorent.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.concurrent.ExecutionException;

import javax.sql.DataSource;


@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
                http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/resources/**").permitAll()
                .antMatchers("/user").permitAll()
                .antMatchers("/", "/home").permitAll()
                .antMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
                .and()
               .formLogin()
               .loginPage("/login").defaultSuccessUrl("/default", true)
              .permitAll()
              .and()
              .logout().logoutSuccessUrl("/home")
              .permitAll();

    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

}

