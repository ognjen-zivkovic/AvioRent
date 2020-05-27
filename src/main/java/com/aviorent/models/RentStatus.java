package com.aviorent.models;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class RentStatus {
    @Id
    private int rentStatusId;
    private String status;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "rentId")
    private Set<Rent> rents;
}
