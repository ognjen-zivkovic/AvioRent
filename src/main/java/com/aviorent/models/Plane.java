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

    @OneToMany( cascade = CascadeType.ALL)
    @JoinColumn(name = "crewMemberId")
    private Set<CrewMember> crewMembers;

    @OneToMany// (mappedBy = "plane")
    private Set<Pilot> pilots;


    /*@OneToMany( cascade = CascadeType.ALL)
    @JoinColumn(name = "pilotId")
    private Set<Pilot> pilots;*/

    @OneToMany( cascade = CascadeType.ALL)
    @JoinColumn(name = "reviewId")
    private Set<Review> reviews;
}
