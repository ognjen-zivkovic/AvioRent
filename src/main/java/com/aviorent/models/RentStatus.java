package com.aviorent.models;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "RentStatus")
public class RentStatus {
    @Id
    private int rentStatusId;
    @Column
    private String status;
    @OneToMany(mappedBy = "rentStatus")
    private Set<Rent> rents;

    public RentStatus() {
    }
}
