package com.aviorent.models;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "rentStatus")
public class RentStatus {
    @GeneratedValue
    @Id
    private int rentStatusId;

    @NotBlank
    @Column (name = "status")
    private String status;

    @OneToMany(mappedBy = "rentStatus")
    private Set<Rent> rents;

}
