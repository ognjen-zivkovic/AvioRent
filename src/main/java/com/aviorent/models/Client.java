package com.aviorent.models;


import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Set;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue
    private int clientId;

    @NotBlank(message = "User name is required")
    @Size(max = 30, message = "User name must not exceed 30 characters.")
    @Column(name = "userName")
    private String userName;

    @Email(message = "Email not valid.")
    @NotBlank(message = "Email is required.")
    @Column(name = "email")
    private String email;

    @NotBlank(message = "Password can't be empty.")
    @Size(min = 8, max = 40)
    @Column(name = "password")
    private String password;

    @Size(min = 9, max = 9, message = "Invalid passport length.")
    @NotBlank(message = "Passport is required.")
    @Column(name = "passport")
    private String passport;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="client")
    private Set<Rent> allRents;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "madeByClient")
    private Set<Review> clientReviews;



}
