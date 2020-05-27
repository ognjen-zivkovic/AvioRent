package com.aviorent.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Client")
public class Client {
    @Id
    private int clientId;
    @Column
    private String userName;
    @Column
    private String email;
    @Column
    private String password;
    @Column
    private String passport;


}
