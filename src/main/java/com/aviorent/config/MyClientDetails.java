package com.aviorent.config;

import com.aviorent.models.Client;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MyClientDetails implements UserDetails {


    private String userName;
    private String password;
    private String email;
    private String phone;
    private List<SimpleGrantedAuthority> authorities;

    public MyClientDetails(Client client){
        this.userName = client.getUserName();
        this.password = client.getPassword();
        this.email = client.getEmail();
        this.phone = client.getPhone();
        authorities = new ArrayList<>();
        this.authorities.add(new SimpleGrantedAuthority(client.getRoles()));
    }


    @Override
    public Collection<? extends SimpleGrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
