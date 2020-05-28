package com.aviorent.models;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "rentStatus")
public class RentStatus {
    @Id
    private int rentStatusId;

    @Column (name = "status")
    private String status;

    @OneToMany(mappedBy = "rentStatus")
    private Set<Rent> rents;
    /*@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "rentId")
    private Set<Rent> rents;*/
}
