package com.aviorent.models;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Set;

@Entity
@Table (name = "plane")
public class Plane {
    @GeneratedValue
    @Id
    private int planeId;

    @NotBlank
    @Size(max = 25)
    @Column (name = "model")
    private String model;

    @NotNull
    @Positive
    @Column (name = "seats")
    private int seats;

    @NotBlank
    @Column  (name = "image")
    private String image;

    @NotNull
    @Positive
    @Column  (name = "maxSpeed")
    private int maxSpeed;

    @NotNull
    @Positive
    @Column  (name = "range")
    private int range;

    @OneToMany( cascade = CascadeType.ALL, mappedBy = "plane")
    private Set<CrewMember> crewMembers;

    @OneToMany( cascade = CascadeType.ALL, mappedBy = "plane")
    private Set<Pilot> pilots;


    @OneToMany( cascade = CascadeType.ALL, mappedBy = "plane")
    private Set<Review> reviews;

    @OneToMany( cascade = CascadeType.ALL, mappedBy = "plane")
    private Set<Rent> allRents;
}
