package com.aviorent.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table (name = "plane")
public class Plane {
    @Id
    private int planeId;
    @Column (name = "model")
    private String model;
    @Column (name = "seats")
    private int seats;
    @Column  (name = "image")
    private String image;
    @Column  (name = "maxSpeed")
    private int maxSpeed;
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
