package com.aviorent.models;


import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Date;

@Entity
@Table(name = "rent")
public class Rent {
    @GeneratedValue
    @Id
    private int rentId;

    @FutureOrPresent
    @NotBlank
    @Column(name = "dateStart")
    private Date dateStart;

    @FutureOrPresent
    @NotBlank
    @Column(name = "dateEnd")
    private Date dateEnd;

    @NotNull
    @Positive
    @Column (name = "price")
    private double price;

    @NotBlank
    @Column  (name = "createdAt")
    private Date createdAt;

    @NotNull
    @Positive
    @Column (name = "passengers")
    private int passengers;

    @ManyToOne
    @JoinColumn(name = "rentStatusId")
    private RentStatus rentStatus;


    @ManyToOne
    @JoinColumn(name = "clientId")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "planeId")
    private Plane plane;

}
