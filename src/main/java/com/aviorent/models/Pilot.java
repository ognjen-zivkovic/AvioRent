package com.aviorent.models;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table
public class Pilot {

    @GeneratedValue
    @Id
    private int pilotId;

    @NotBlank(message = "First name is required")
    @Size(max = 30, message = "First name must not exceed 30 characters.")
    @Column(name = "firstName")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(max = 35, message = "Last name must not exceed 35 characters.")
    @Column(name = "lastName")
    private String lastName;

    @NotNull(message = "Flight time is required")
    @Min(value = 2000, message = "Pilot doesn't have enough flight hours.")
    @Column(name = "flightTime")
    private int flightTime;

    @ManyToOne
    @JoinColumn(name = "planeId")
    private Plane plane;

}
