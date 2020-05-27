package com.aviorent.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Pilot {
    @Id
    private int pilotId;
    private String firstName;
    private  String lastName;
    private int flightTime;
}
