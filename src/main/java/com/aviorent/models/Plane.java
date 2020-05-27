package com.aviorent.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Plane {
    @Id
    private int planeId;
    private String model;
    private int seats;
    private String image;
    private int maxSpeed;
    private int range;
}
