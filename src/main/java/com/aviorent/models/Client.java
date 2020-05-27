package com.aviorent.models;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Client {
    @Id
    private int clientId;
    private String userName;
    private String email;
    private String password;
    private String passport;
}
