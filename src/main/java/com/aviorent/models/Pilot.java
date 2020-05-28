package com.aviorent.models;

import javax.persistence.*;

@Entity
@Table
public class Pilot {
    @Id
    private int pilotId;
    @Column(name = "firstName")
    private String firstName;
    @Column (name = "lastName")
    private  String lastName;
    @Column (name = "flightTime")
    private int flightTime;

    @ManyToOne
    private  Plane plane;
}
