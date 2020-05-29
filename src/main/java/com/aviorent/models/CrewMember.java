package com.aviorent.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table (name = "crewMember")
public class CrewMember {
    @GeneratedValue
    @Id
    private int crewMemberId;

    @NotBlank(message = "First name is required.")
    @Size(max = 30, message = " name must not exceed 30 characters.")
    @Column (name = "firstName")
    private String firstName;

    @NotBlank(message = "Last name is required.")
    @Size(max = 35, message = "Last name must not exceed 35 characters.")
    @Column (name = "lastName")
    private String lastName;

    @ManyToOne
    @JoinColumn( name = "planeId")
    private Plane plane;

    @ManyToOne
    @JoinColumn( name = "crewMemberTypeId")
    private CrewMemberType crewMemberType;

}
