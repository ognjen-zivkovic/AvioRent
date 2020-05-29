package com.aviorent.models;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table
public class Pilot {

    @GeneratedValue
    @Id
    private int pilotId;

    @NotBlank
    @Size(max = 30)
    @Column(name = "firstName")
    private String firstName;

    @NotBlank
    @Size(max = 35)
    @Column(name = "lastName")
    private String lastName;

    @NotNull
    @Min(value = 2000)
    @Column(name = "flightTime")
    private int flightTime;

    @ManyToOne
    @JoinColumn(name = "planeId")
    private Plane plane;

}
