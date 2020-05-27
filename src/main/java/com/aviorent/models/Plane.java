package com.aviorent.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table (name = "Plane")
public class Plane {
    @Id
    private int planeId;
    @Column
    private String model;
    @Column
    private int seats;
    @Column
    private String image;
    @Column
    private int maxSpeed;
    @Column
    private int range;

    @OneToMany(mappedBy = "plane")
    private Set<CrewMember> crewMembers;
}
