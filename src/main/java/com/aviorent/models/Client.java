package com.aviorent.models;


import org.springframework.context.annotation.Configuration;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Set;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue
    private long clientId;

    @NotBlank(message = "User name is required")
    @Size(max = 30, message = "User name must not exceed 30 characters.")
    @Column(name = "userName")
    private String userName;

    @Email(message = "Email not valid.")
    @NotBlank(message = "Email is required.")
    @Column(name = "email")
    private String email;

    @NotBlank(message = "Password can't be empty.")
    @Size(min = 8, max = 65)
    @Column(name = "password")
    private String password;

    @NotBlank(message = "Phone number is required")
    @Column(name = "phone")
    private String phone;

    //@NotBlank(message = "Role is required")
    @Column(name = "roles")
    private String roles;



    @OneToMany(cascade = CascadeType.ALL, mappedBy="client")
    private Set<Rent> allRents;


    public long getClientId() {
        return clientId;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getRoles() {
        return roles;
    }


}
