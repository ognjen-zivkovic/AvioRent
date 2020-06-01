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

    @FutureOrPresent(message = "Selected date is not valid")
    @NotBlank(message = "Start date is required")
    @Column(name = "dateStart")
    private Date dateStart;

    @FutureOrPresent(message = "Selected date is not valid")
    @NotBlank(message = "End date is required")
    @Column(name = "dateEnd")
    private Date dateEnd;


    @NotBlank(message = "Create date is required")
    @Column  (name = "createdAt")
    private Date createdAt;

    @NotNull(message = "Number of passengers is not valid")
    @Positive(message = "Passengers value must be positive")
    @Column (name = "passengers")
    private int passengers;

    @NotBlank(message = "Star destination is required")
    @Column (name = "destinationFrom")
    private String destinationFrom;

    @NotBlank(message = "End destination is required")
    @Column (name = "destinationTo")
    private String destinationTo;


    @Column (name = "isRoundTrip")
    private boolean isRoundTrip;

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
